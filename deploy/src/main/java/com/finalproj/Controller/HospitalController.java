package com.finalproj.Controller;

import com.finalproj.JDBCConnection.PatientDAO;
import com.finalproj.JDBCConnection.TreatmentRoomDAO;
import com.finalproj.Modal.*;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HospitalController {
    private Hospital hospital;
    private static HospitalController instance;
    private PatientDAO patientDao;  // Thêm đối tượng PatientDao để tương tác với DB
    private TreatmentRoomDAO treatmentRoomDao;

    // Phương thức để lấy thể hiện
    public static HospitalController getInstance() {
        if (instance == null) {
            instance = new HospitalController();
        }
        return instance;
    }

    // Constructor khởi tạo HospitalController
    public HospitalController(Hospital hospital) {
        this.hospital = hospital;
        this.patientDao = new PatientDAO();  // Khởi tạo PatientDao
        initializePatientList();  // Lấy dữ liệu từ DB khi khởi tạo
        this.treatmentRoomDao = new TreatmentRoomDAO();
        initializeTreatmentRoomList();
        initializePatientList();
        patientClassification();
    }

    public HospitalController() {
        // Khởi tạo đối tượng bệnh viện
        this.hospital = new Hospital();
        this.patientDao = new PatientDAO();  // Khởi tạo PatientDao
        initializePatientList();  // Lấy dữ liệu từ DB khi khởi tạo
        this.treatmentRoomDao = new TreatmentRoomDAO();
        initializeTreatmentRoomList();
        initializePatientList();
        patientClassification();
    }

    // Phân loại bệnh nhân vào phòng điều trị dựa trên roomId
    public void patientClassification() {
        // Làm mới danh sách bệnh nhân trong từng phòng điều trị
        for (TreatmentRoom room : hospital.getTreatmentRoomList()) {
            // Khởi tạo danh sách bệnh nhân mới cho từng phòng
            room.setPatientsList(new ArrayList<>()); // Giả sử bạn muốn khởi tạo một danh sách mới
        }
        for (Patient patient : hospital.getPatientsList()) {
            if(patient.getRoomId() != 0) {
                for (TreatmentRoom room : hospital.getTreatmentRoomList()) {
                    if (patient.getRoomId() == room.getRoomId()) {
                        addPtientToRoomTemp(patient.getPatientId(), room.getRoomId());
                    }
                }
            }
        }
    }

    public void savePatientInfoToFile(Patient patient, TreatmentRoom room, String action) {
        String filePath = "src/main/java/com/finalproj/datafiles/hospitalPatientInfo.txt";

        try {
            // Tạo đối tượng File cho file
            File file = new File(filePath);

            // Kiểm tra xem file có tồn tại không, nếu không thì tạo file mới
            if (!file.exists()) {
                // Tạo các thư mục cha nếu chưa tồn tại
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            // Sử dụng BufferedWriter để ghi dữ liệu vào file
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) { // true để thêm vào file
                // Lấy thời gian hiện tại
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = now.format(formatter); // Định dạng thời gian

                String patientInfo = "Hành động: " + action +
                        ", Bệnh nhân: " + patient.getName() +
                        ", Mã: " + patient.getPatientId() +
                        ", Phòng: " + room.getRoomId() +
                        ", Ngày nhập viện: " + formattedDateTime;

                // Nếu là xuất viện, thêm ngày xuất viện
                if (action.equals("Xuất viện")) {
                    patientInfo += ", Ngày xuất viện: " + formattedDateTime;
                }

                bufferedWriter.write(patientInfo); // Ghi dữ liệu vào file
                bufferedWriter.newLine(); // Thêm dòng mới
            }
            // In ra thông báo để xác nhận rằng đã ghi file
            System.out.println("Dữ liệu đã được ghi vào file: " + file.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }








    public void addPtientToRoomTemp(int patientId, int roomId) {
        Patient patient = hospital.getPatientInfo(patientId);
        TreatmentRoom treatmentRoom = hospital.getRoomInfo(roomId);

        try {
            if (patient == null) {
                System.out.println("Bệnh nhân không tồn tại.");
                return;
            }

            // Kiểm tra xem bệnh nhân đã có trong danh sách của phòng chưa
            if (!treatmentRoom.getPatientsList().contains(patient)) {
                treatmentRoom.getPatientsList().add(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void initializePatientList() {
        ArrayList<Patient> patientsFromDB = patientDao.getAllPatients();  // Lấy danh sách từ DB
        hospital.setPatientsList(new ArrayList<>()); // Xóa danh sách hiện tại
        hospital.getPatientsList().addAll(patientsFromDB);  // Thêm dữ liệu mới vào danh sách của bệnh viện
    }

    public void initializeTreatmentRoomList(){
        ArrayList<TreatmentRoom> treatmentRoomsFromDB = treatmentRoomDao.getAllTreatmentRooms();
        hospital.setTreatmentRoomList(new ArrayList<>()); // Xóa danh sách hiện tại
        hospital.getTreatmentRoomList().addAll(treatmentRoomsFromDB); // Thêm dữ liệu mới vào danh sách của bệnh viện
    }




    //FindPatient by id
    public Patient findPatient(int patientId) {
        Patient patient = hospital.findPatient(patientId);
        try {
            if (patient != null) {
                System.out.println(patient.getPatientId() + "," + patient.getName() +","+ patient.getAge() +"," + patient.getGender() + "," + patient.getDiagnose() +"," + patient.getAddress() +", " + patient.getPhone());
            }else {
                System.out.println("Not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    //Find treatmentroom
    public  TreatmentRoom findTreatmentRoom(int TreatmentRoomId) {
        TreatmentRoom room = hospital.findTreatmentRoom(TreatmentRoomId);
        try {
            if (room != null) {
                System.out.println(room.getRoomId() + ", " + room.getRoomName() +", " + room.getRoomType() + ", " + room.getCapacity() + ", " + room.getPatientsList());
            }else {
                System.out.println("Not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return room;
    }

    //add new patient
    public void addPatient(String name, int age, String gender, String diagnose, Address address, String phone, int roomId) {
        try{
            Patient newPatient = new Patient(hospital.getNextPatientId(),name, age, gender, diagnose, address, phone, roomId);
            hospital.addPatient(newPatient);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    //update
    public void updatePatient(int patientId, String name, int age, String gender, String diagnose, Address address, String phone) {
        try {
            hospital.updatePatient(patientId, name, age, gender, diagnose, address, phone);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //getPatientInfo
    public void getPatientInfo(int patientId) {
        Patient patient = hospital.getPatientInfo(patientId);
        try{
            if (patient != null) {
                System.out.println("Patient ID: " + patient.getPatientId());
                System.out.println("Name: " + patient.getName());
                System.out.println("Age: " + patient.getAge());
                System.out.println("Gender: " + patient.getGender());
                System.out.println("Diagnose: " + patient.getDiagnose());
                System.out.println("Address: " + patient.getAddress());
                System.out.println("Phone: " + patient.getPhone());
            }else {
                System.out.println("Not found");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete
    public void deletePatient(int patientId) {
        try {
            hospital.deletePatient(patientId);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //add new treatmentroom
    public void addTreatmentRoom(String roomName, String roomType, int capacity) {
        try {
            TreatmentRoom newRoom = new TreatmentRoom(hospital.getNextRoomId(), roomName, roomType, capacity, new ArrayList<>());
            hospital.addTreatmentRoom(newRoom);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    //update
    public void updateTreatmentRoom(int treatmentRoomId,String roomName, String roomType, int capacity){
        try {
            hospital.updateTreatmentRoom(treatmentRoomId, roomName, roomType, capacity);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //delete
    public void deleteTreatmentRoom(int treatmentRoomId) {
        try {
            hospital.deleteTreatmentRoom(treatmentRoomId);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //assign patient to room
    public boolean assignPatientToRoom(int patientId, int treatmentRoomId) {
        Patient patient = hospital.getPatientInfo(patientId);
        TreatmentRoom treatmentRoom = hospital.getRoomInfo(treatmentRoomId);
        try {
            boolean isAssignPatientToRoom = hospital.assignPatientToRoom(patientId, treatmentRoomId);
            if (isAssignPatientToRoom) {

                // Lưu thông tin bệnh nhân vào file (vào viện)
                savePatientInfoToFile(patient, treatmentRoom, "Nhập viện");

                return isAssignPatientToRoom;
            } else {
                return false;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //remove patient from room
    public void removePatientFromRoom(int patientId) {
        Patient patient = hospital.getPatientInfo(patientId);
        TreatmentRoom treatmentRoom = hospital.getRoomInfo(patient.getRoomId());
        try {
            // Lưu thông tin bệnh nhân vào file (ra viện)
            savePatientInfoToFile(patient, treatmentRoom, "Xuất viện");
            hospital.removePatientFromRoom(patientId);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



    //getTreatmentRoomInfo
    public void getTreatmentRoomInfo(int treatmentRoomId) {
        TreatmentRoom room = hospital.getRoomInfo(treatmentRoomId);
        try {
            if (room != null) {
                System.out.println("Room ID: " + room.getRoomId());
                System.out.println("Room Name: " + room.getRoomName());
                System.out.println("Room Type: " + room.getRoomType());
                System.out.println("Room Capacity: " + room.getCapacity());
            }else {
                System.out.println("Not found");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Patient> getPatientsInRoom(int roomId) {
        patientClassification();
        List<Patient> patientsInRoom = hospital.getPatientsInRoom(roomId);

        try {
            // Kiểm tra nếu danh sách là null, khởi tạo danh sách trống
            if (patientsInRoom == null) {
                patientsInRoom = new ArrayList<>();  // Khởi tạo danh sách trống
            }
            if (patientsInRoom.isEmpty()) {
                System.out.println("Not found");
            } else {
                System.out.println("Danh sach: ");
                for (Patient patient : patientsInRoom) {
                    System.out.println("ID: " + patient.getPatientId() + ", Name: " + patient.getName() + ", Diagnose: " + patient.getDiagnose());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return patientsInRoom;
    }


    public List<TreatmentRoom> getListRoom() {
        return hospital.getTreatmentRoomList();
    }

    public List<Patient> getListPatient() {
        return hospital.getPatientsList();
    }

}
