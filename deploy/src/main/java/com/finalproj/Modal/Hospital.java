package com.finalproj.Modal;

import java.util.ArrayList;
import java.util.List;


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
        try{
            for (Patient patient : patientsList) {
                if (patient.getPatientId() == patientId) {
                    return patient;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //find treatmentRoom
    public TreatmentRoom findTreatmentRoom(int treatmentRoomId) {
        try{
            for (TreatmentRoom treatmentRoom : treatmentRoomList) {
                if (treatmentRoom.getRoomId() == treatmentRoomId) {
                    return treatmentRoom;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //add patient
    public void addPatient(Patient patient) {
        try {
            if(patient.getName().length() <=50){
                patient.setPatientId(nextPatientId);
                patientsList.add(patient);
                nextPatientId++;
                System.out.println("Da them benh nhan");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //modify patient
    public void updatePatient(int patientId, String newName, int age, String gender, String diagnose, Address address, String phone) {
        try{
            Patient updatePatient = findPatient(patientId);
            if(updatePatient != null) {
                updatePatient.setName(newName);
                updatePatient.setAge(age);
                updatePatient.setGender(gender);
                updatePatient.setDiagnose(diagnose);
                updatePatient.setAddress(address);
                updatePatient.setPhone(phone);
                System.out.println("Da sua benh nhan");
            }
            else {
                System.out.println("Khong tim thay benh nhan co id: " + patientId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete Patient
    public void deletePatient(int patientId) {
        try{
            Patient deletePatient = findPatient(patientId);
            if(deletePatient != null) {
                patientsList.remove(deletePatient);
                System.out.println("Da xoa");
            }
            else {
                System.out.println("Khong tim thay benh nhan co ID" + patientId);
            }
        } catch(Exception e) {
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
        try {
            if (treatmentRoom != null && treatmentRoom.getRoomName() != null && treatmentRoom.getRoomName().length() < 25) {
                treatmentRoom.setRoomId(nextRoomId);
                treatmentRoomList.add(treatmentRoom);
                nextRoomId++;
                System.out.println("Da them phong benh");
            } else {
                System.out.println("Thong tin phong benh khong hop le.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //modify treatmentRoom
    public void updateTreatmentRoom(int treatmentRoomId, String roomName, String roomType, int capacity){
        try{
            TreatmentRoom updateTreatmentRoom = findTreatmentRoom(treatmentRoomId);
            if(updateTreatmentRoom != null){
                updateTreatmentRoom.setRoomName(roomName);
                updateTreatmentRoom.setRoomType(roomType);
                updateTreatmentRoom.setCapacity(capacity);
                System.out.println("Da sua");
            }else {
                System.out.println("Khong tim thay phong benh voi id: " + treatmentRoomId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete treatmentRoom
    public void deleteTreatmentRoom(int treatmentRoomId){
        try {
            TreatmentRoom deleteTreatmentRoom = findTreatmentRoom(treatmentRoomId);
            if(deleteTreatmentRoom != null){
                treatmentRoomList.remove(deleteTreatmentRoom);
                System.out.println("Da xoa");
            }else {
                System.out.println("Khong tim thay phong benh voi id: " + treatmentRoomId);
            }
        }catch (Exception e) {
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

    public boolean assignPatientToRoom(int patientId, int roomId) {
        Patient patient = getPatientInfo(patientId);
        TreatmentRoom treatmentRoom = getRoomInfo(roomId);

        try {
            if(patient == null ) {
                System.out.println("patient Not found");
                return false;
            }
            if (treatmentRoom == null){
                System.out.println("treatment not found");
                return false;
            }
            List<Patient> listPatientInRoom = treatmentRoom.getPatientsList();

            // Kiểm tra nếu bệnh nhân đã có trong phòng
            for (Patient p : listPatientInRoom) {
                if (p.getPatientId() == patientId) {
                    System.out.println("The patient is already in the room.");
                    return false;
                }
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

        return true;
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
            return new ArrayList<>(); //danh sach rong
        }
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
