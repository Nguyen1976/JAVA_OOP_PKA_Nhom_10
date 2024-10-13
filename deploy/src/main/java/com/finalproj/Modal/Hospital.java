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
                int roomId = resultSet.getInt("roomId");
                Address address = new Address(city, district);
                return new Patient(patientId, name, age, gender, diagnose, address, phone, roomId);
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
        String query = "INSERT INTO treatmentRoom (roomName, roomType, capacity) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if (treatmentRoom != null && treatmentRoom.getRoomName() != null && treatmentRoom.getRoomName().length() < 25) {
                preparedStatement.setString(1, treatmentRoom.getRoomName());
                preparedStatement.setString(2, treatmentRoom.getRoomType());
                preparedStatement.setInt(3, treatmentRoom.getCapacity());

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



    public boolean assignPatientToRoom(int patientId, int roomId) {
        Patient patient = getPatientInfo(patientId);
        TreatmentRoom treatmentRoom = getRoomInfo(roomId);
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            if (patient == null) {
                System.out.println("Patient not found");
                return false;
            }

            if (treatmentRoom == null) {
                System.out.println("Treatment room not found");
                return false;
            }

            // Kiểm tra xem bệnh nhân đã được chỉ định vào phòng nào chưa
            if (patient.getRoomId() != 0) {
                System.out.println("Patient already assigned to a room.");
                return false;
            }

            // Kiểm tra xem phòng có đầy không và bệnh nhân đã có trong danh sách chưa
            if (!treatmentRoom.isRoomFull() && !treatmentRoom.getPatientsList().contains(patient)) {
                // Thực hiện truy vấn SQL để cập nhật roomId cho bệnh nhân
                String sql = "UPDATE patient SET roomId = ? WHERE patientId = ?";
                connection = getConnection(); // có phương thức này để lấy kết nối
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, roomId); // Đặt roomId vào tham số 1
                preparedStatement.setInt(2, patientId); // Đặt patientId vào tham số 2

                int rowsUpdated = preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    // Cập nhật roomId cho bệnh nhân
                    patient.setRoomId(roomId);
                    System.out.println("Patient assigned to treatment room successfully.");
                    return true;
                } else {
                    System.out.println("Failed to assign patient to treatment room.");
                    return false;
                }
            } else {
                System.out.println("Cannot assign patient to room.");
                System.out.println("Room full: " + treatmentRoom.isRoomFull());
                System.out.println("Patient already in room: " + treatmentRoom.getPatientsList().contains(patient));
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng các tài nguyên kết nối
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false; // Nếu có vấn đề gì xảy ra
    }



    //remove patient from room
    public void removePatientFromRoom(int patientId) {
        Patient patient = getPatientInfo(patientId);
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "UPDATE patient SET roomId = NULL WHERE patientId = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, patientId);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                // Cập nhật roomId cho bệnh nhân
                patient.setRoomId(0);
                System.out.println("Patient remove to treatment room successfully.");
            } else {
                System.out.println("Failed to remove patient to treatment room.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            // Đảm bảo đóng các tài nguyên kết nối
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
