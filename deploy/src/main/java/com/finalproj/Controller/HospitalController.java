package com.finalproj.Controller;

import com.finalproj.Modal.*;

import java.util.ArrayList;
import java.util.List;

public class HospitalController {
    private Hospital hospital;


    public HospitalController(Hospital hospital) {
        this.hospital = hospital;
    }

    public HospitalController() {
        // Khởi tạo đối tượng bệnh viện
        this.hospital = new Hospital();
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
    public void addPatient(String name, int age, String gender, String diagnose, Address address, String phone) {
        try{
            Patient newPatient = new Patient(hospital.getNextPatientId(),name, age, gender, diagnose, address, phone);
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
    public  void assignPatientToRoom(int patientId, int treatmentRoomId) {
        try {
            hospital.assignPatientToRoom(patientId, treatmentRoomId);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //remove patient from room
    public void removePatientFromRoom(int patientId, int treatmentRoomId) {
        try {
            hospital.removePatientFromRoom(patientId, treatmentRoomId);
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
        List<Patient> patientsInRoom = hospital.getPatientsInRoom(roomId);
        try {
            if(patientsInRoom.isEmpty()){
                System.out.println("Not found");
            }else {
                System.out.println("Danh sach: ");
                for (Patient patient : patientsInRoom) {
                    System.out.println("ID: " + patient.getPatientId() + ", Name " + patient.getName() + ", Diagnose: " + patient.getDiagnose());
                }
            }
        }catch (Exception e) {
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
