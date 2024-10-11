package com.finalproj.Modal;

import com.finalproj.JDBCConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.finalproj.JDBCConnection.DBConnection.getConnection;


public class Hospital {
    List<Patient> patientsList;
    List<TreatmentRoom> treatmentRoomList;
    private int nextPatientId;
    private int nextRoomId;



    public Hospital() {
        this.patientsList = new ArrayList<>();
        this.treatmentRoomList = new ArrayList<>();
        this.nextPatientId = 1;
        this.nextRoomId = 1;

    }

    //find Patient
    public Patient findPatient(int patientId) {
        String query = "SELECT * FROM Patient WHERE patientId = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, patientId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String diagnose = resultSet.getString("diagnose");
                String city = resultSet.getString("city");
                String district = resultSet.getString("district");
                String phone = resultSet.getString("phone");

                Address address = new Address(city, district);
                return new Patient(patientId, name, age, gender, diagnose, address, phone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //find treatmentRoom
    public TreatmentRoom findTreatmentRoom(int treatmentRoomId) {
        String query = "SELECT * FROM treatmentRoom WHERE roomId = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, treatmentRoomId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                TreatmentRoom treatmentRoom = new TreatmentRoom();
                treatmentRoom.setRoomId(resultSet.getInt("roomId"));
                treatmentRoom.setRoomName(resultSet.getString("roomName"));
                treatmentRoom.setRoomType(resultSet.getString("roomType"));
                treatmentRoom.setCapacity(resultSet.getInt("capacity"));
                String patientsListString = resultSet.getString("patientsList");

                // Sử dụng split để phân chia thành mảng chuỗi
                String[] patientNamesArray = patientsListString.split(",");

                // Chuyển đổi mảng chuỗi thành List<Patient>
                List<Patient> patientsList = new ArrayList<>();
                for (String name : patientNamesArray) {
                    // Tạo đối tượng Patient cho mỗi tên (giả sử Patient chỉ có thuộc tính name)
                    Patient patient = new Patient();
                    patient.setName(name.trim()); // Trim để loại bỏ các khoảng trắng dư thừa
                    patientsList.add(patient);
                }

                // Đặt danh sách bệnh nhân vào đối tượng treatmentRoom
                treatmentRoom.setPatientsList(patientsList);

                return treatmentRoom;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //add patient
    public void addPatient(Patient patient) {
        String query = "INSERT INTO Patient (name, age, gender, diagnose, city, district, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if (patient.getName().length() <= 50) {
                preparedStatement.setString(1, patient.getName());
                preparedStatement.setInt(2, patient.getAge());
                preparedStatement.setString(3, patient.getGender());
                preparedStatement.setString(4, patient.getDiagnose());
                preparedStatement.setString(5, patient.getAddress().getCity());
                preparedStatement.setString(6, patient.getAddress().getDistrict());
                preparedStatement.setString(7, patient.getPhone());

                //tạo biến cập nhật bản ghi bị ảnh hưởng bởi SQL
                int updatedRecordsCount = preparedStatement.executeUpdate();
                if (updatedRecordsCount > 0) {
                    System.out.println("Da them benh nhan.");
                } else {
                    System.out.println("Them benh nhan that bai.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //modify patient
    public void updatePatient(int patientId, String newName, int age, String gender, String diagnose, Address address, String phone) {
        String query = "UPDATE Patient SET name = ?, age = ?, gender = ?, diagnose = ?, city = ?, district = ?, phone = ? WHERE patientId = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            Patient updatePatient = findPatient(patientId);
            if (updatePatient != null) {
                preparedStatement.setString(1, newName);
                preparedStatement.setInt(2, age);
                preparedStatement.setString(3, gender);
                preparedStatement.setString(4, diagnose);
                preparedStatement.setString(5, address.getCity());
                preparedStatement.setString(6, address.getDistrict());
                preparedStatement.setString(7, phone);
                preparedStatement.setInt(8, patientId);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Da sua benh nhan.");
                } else {
                    System.out.println("Sua benh nhan that bai.");
                }
            } else {
                System.out.println("Khong tim thay benh nhan co id: " + patientId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete Patient
    public void deletePatient(int patientId) {
        String query = "DELETE FROM Patient WHERE patientId = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            Patient deletePatient = findPatient(patientId);
            if (deletePatient != null) {
                preparedStatement.setInt(1, patientId);

                int updatedRecordsCount = preparedStatement.executeUpdate();
                if (updatedRecordsCount > 0) {
                    System.out.println("Da xoa benh nhan.");
                } else {
                    System.out.println("Xoa benh nhan that bai.");
                }
            } else {
                System.out.println("Khong tim thay benh nhan co ID " + patientId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //info patient
    public Patient getPatientInfo(int patientId) {
        return patientsList.stream()
                .filter(patient -> patient.getPatientId() == patientId)
                .findFirst()
                .orElse(null);
    }

    //add treatmentRoom
    public void addTreatmentRoom(TreatmentRoom treatmentRoom) {
        String query = "INSERT INTO treatmentRoom (roomName, roomType, capacity, patientsList) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if (treatmentRoom != null && treatmentRoom.getRoomName() != null && treatmentRoom.getRoomName().length() < 25) {
                preparedStatement.setString(1, treatmentRoom.getRoomName());
                preparedStatement.setString(2, treatmentRoom.getRoomType());
                preparedStatement.setInt(3, treatmentRoom.getCapacity());
                preparedStatement.setString(4, treatmentRoom.getPatientsList().toString());

                int affectedRowsCount = preparedStatement.executeUpdate();
                if (affectedRowsCount > 0) {
                    System.out.println("Đã thêm phòng bệnh.");
                } else {
                    System.out.println("Thêm phòng bệnh thất bại.");
                }
            } else {
                System.out.println("Thông tin phòng bệnh không hợp lệ.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //modify treatmentRoom
    public void updateTreatmentRoom(int treatmentRoomId, String roomName, String roomType, int capacity){
        String query = "UPDATE treatmentRoom SET roomName = ?, roomType = ?, capacity = ? WHERE roomId = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            TreatmentRoom updateTreatmentRoom = findTreatmentRoom(treatmentRoomId);
            if (updateTreatmentRoom != null) {
                preparedStatement.setString(1, roomName);
                preparedStatement.setString(2, roomType);
                preparedStatement.setInt(3, capacity);
                preparedStatement.setInt(4, treatmentRoomId);

                int affectedRowsCount = preparedStatement.executeUpdate();
                if (affectedRowsCount > 0) {
                    System.out.println("Đã sửa phòng bệnh.");
                } else {
                    System.out.println("Sửa phòng bệnh thất bại.");
                }
            } else {
                System.out.println("Không tìm thấy phòng bệnh với ID: " + treatmentRoomId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete treatmentRoom
    public void deleteTreatmentRoom(int treatmentRoomId){
        String query = "DELETE FROM treatmentRoom WHERE roomId = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            TreatmentRoom deleteTreatmentRoom = findTreatmentRoom(treatmentRoomId);
            if (deleteTreatmentRoom != null) {
                preparedStatement.setInt(1, treatmentRoomId);

                int affectedRowsCount = preparedStatement.executeUpdate();
                if (affectedRowsCount > 0) {
                    System.out.println("Đã xóa phòng bệnh.");
                } else {
                    System.out.println("Xóa phòng bệnh thất bại.");
                }
            } else {
                System.out.println("Không tìm thấy phòng bệnh với ID: " + treatmentRoomId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Info treatmentRoom
    public TreatmentRoom getRoomInfo(int roomId) {
        if (treatmentRoomList == null || treatmentRoomList.isEmpty()) {
            return null; // Trả về null nếu danh sách phòng chưa được khởi tạo hoặc rỗng
        }

        return treatmentRoomList.stream()
                .filter(treatmentRoom -> treatmentRoom.getRoomId() == roomId)
                .findFirst()
                .orElse(null);
    }


    public boolean comparePatientDiagnoseWithRoomType(int patientId, int roomId){

        Patient patient = getPatientInfo(patientId);
        TreatmentRoom treatmentRoom = getRoomInfo(roomId);
        if (patient == null || treatmentRoom == null) {
            System.out.println("Not found");
            return false;
        }

        return patient.getDiagnose().equalsIgnoreCase(treatmentRoom.getRoomType());
    }

    public void assignPatientToRoom(int patientId, int roomId){
        Patient patient = getPatientInfo(patientId);
        TreatmentRoom treatmentRoom = getRoomInfo(roomId);
        try {
            if(patient == null ) {
                System.out.println("patient Not found");
                return;
            }
            if (treatmentRoom == null){
                System.out.println("treatment not found");
                return;
            }

//             && comparePatientDiagnoseWithRoomType(patientId, roomId)
            if(!treatmentRoom.isRoomFull()){
                treatmentRoom.getPatientsList().add(patient);
                System.out.println("Patient assign TreatmentRoom");
            }else {
                System.out.println(!treatmentRoom.isRoomFull());
                System.out.println(comparePatientDiagnoseWithRoomType(patientId, roomId));
                System.out.println("Can not assign patient to room");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    //remove patient from room
    public void removePatientFromRoom(int patientId, int roomId){
        Patient patient = getPatientInfo(patientId);
        TreatmentRoom treatmentRoom = getRoomInfo(roomId);
        try {
            if(patient == null ) {
                System.out.println("Not found");
            }
            if(treatmentRoom == null){
                System.out.println("Not found");
            }

            for(TreatmentRoom room : treatmentRoomList){
                if (treatmentRoom.getPatientsList().contains(patient)) {
                    treatmentRoom.getPatientsList().remove(patient);
                    System.out.println("Benh nhan xuat vien");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



    //getListPatientsInRoom
    public List<Patient> getPatientsInRoom(int roomId){
        TreatmentRoom room = getRoomInfo(roomId);
        if(room != null){
            return room.getPatientsList();
        }else {
            return new ArrayList<>();
        }
    }

    public void setPatientsList(List<Patient> patientsList) {
        this.patientsList = patientsList;
    }

    public void setTreatmentRoomList(List<TreatmentRoom> treatmentRoomList) {
        this.treatmentRoomList = treatmentRoomList;
    }

    public List<Patient> getPatientsList() {
        return patientsList;
    }

    public List<TreatmentRoom> getTreatmentRoomList() {
        return treatmentRoomList;
    }

    public int getNextPatientId() {
        return nextPatientId;
    }

    public int getNextRoomId() {
        return nextRoomId;
    }
}
