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

    }

    //FindPatient by id
    public Patient findPatient(int patientId) {
        Patient patient = hospital.findPatient(patientId);
        if (patient != null) {
            System.out.println(patient.getPatientId() + "," + patient.getName() +","+ patient.getAge() +"," + patient.getGender() + "," + patient.getDiagnose() +"," + patient.getAddress() +", " + patient.getPhone());
        }else {
            System.out.println("Not found");
        }
        return patient;
    }

    //Find treatmentroom
    public  TreatmentRoom findTreatmentRoom(int TreatmentRoomId) {
        TreatmentRoom room = hospital.findTreatmentRoom(TreatmentRoomId);
        if (room != null) {
            System.out.println(room.getRoomId() + ", " + room.getRoomName() +", " + room.getRoomType() + ", " + room.getCapacity() + ", " + room.getPatientsList());
        }else {
            System.out.println("Not found");
        }
        return room;
    }

    //add new patient
    public void addPatient(String name, int age, String gender, String diagnose, Address address, String phone) {
        Patient newPatient = new Patient(hospital.getNextId(),name, age, gender, diagnose, address, phone);
        hospital.addPatient(newPatient);
    }


    //update
    public void updatePatient(int patientId, String name, int age, String gender, String diagnose, Address address, String phone) {
        hospital.updatePatient(patientId, name, age, gender, diagnose, address, phone);
    }

    //delete
    public void deletePatient(int patientId) {
        hospital.deletePatient(patientId);
    }

    //add new treatmentroom
    public void addTreatmentRoom(String roomName, String roomType, int capacity) {
        TreatmentRoom newRoom = new TreatmentRoom(hospital.getNextId(), roomName, roomType, capacity, new ArrayList<>());
        hospital.addTreatmentRoom(newRoom);
    }


    //update
    public void updateTreatmentRoom(int treatmentRoomId,String roomName, String roomType, int capacity){
        hospital.updateTreatmentRoom(treatmentRoomId, roomName, roomType, capacity);
    }
    //delete
    public void deleteTreatmentRoom(int treatmentRoomId) {
        hospital.deleteTreatmentRoom(treatmentRoomId);
    }

    //assign patient to room
    public  void assignPatientToRoom(int patientId, int treatmentRoomId) {
        hospital.assignPatientToRoom(patientId, treatmentRoomId);
    }

    //remove patient from room
    public void removePatientFromRoom(int patientId, int treatmentRoomId) {
        hospital.removePatientFromRoom(patientId, treatmentRoomId);
    }

    //getPatientInfo
    public void getPatientInfo(int patientId) {
        Patient patient = hospital.getPatientInfo(patientId);
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
    }

    //getTreatmentRoomInfo
    public void getTreatmentRoomInfo(int treatmentRoomId) {
        TreatmentRoom room = hospital.getRoomInfo(treatmentRoomId);
        if (room != null) {
            System.out.println("Room ID: " + room.getRoomId());
            System.out.println("Room Name: " + room.getRoomName());
            System.out.println("Room Type: " + room.getRoomType());
            System.out.println("Room Capacity: " + room.getCapacity());
        }else {
            System.out.println("Not found");
        }
    }

    public List<Patient> getListPatient(){
        List<Patient> listPatient = hospital.getPatientsList();
        return listPatient;
    }

}
