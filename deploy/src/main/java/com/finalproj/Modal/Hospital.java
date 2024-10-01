package com.finalproj.Modal;

import java.util.ArrayList;
import java.util.List;


public class Hospital {
    List<Patient> patientsList;
    List<TreatmentRoom> treatmentRoomList;
    private int nextId;

    public Hospital() {
        this.patientsList = new ArrayList<>();
        this.treatmentRoomList = new ArrayList<>();
        this.nextId = 1;
    }

    //find Patient
    public Patient findPatient(int patientId) {
        for (Patient patient : patientsList) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    //find treatmentRoom
    public TreatmentRoom findTreatmentRoom(int treatmentRoomId) {
        for (TreatmentRoom treatmentRoom : treatmentRoomList) {
            if (treatmentRoom.getRoomId() == treatmentRoomId) {
                return treatmentRoom;
            }
        }
        return null;
    }

    //add patient
    public void addPatient(Patient patient) {
        if(patient.getName().length() <=50){
            patient.setPatientId(nextId);
            patientsList.add(patient);
            nextId++;
            System.out.println("Da them benh nhan");
        }
    }

    //modify patient
    public void updatePatient(int patientId, String newName, int age, String gender, String diagnose, Address address, String phone) {
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
    }

    //delete Patient
    public void deletePatient(int patientId) {
        Patient deletePatient = findPatient(patientId);
        if(deletePatient != null) {
            patientsList.remove(deletePatient);
            System.out.println("Da xoa");
        }
        else {
            System.out.println("Khong tim thay benh nhan co ID" + patientId);
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
    public void addTreatmentRoom(TreatmentRoom treatmentRoom){
        if (treatmentRoom.getRoomName().length() < 25){
            treatmentRoom.setRoomId(nextId);
            treatmentRoomList.add(treatmentRoom);
            nextId++;
            System.out.println("Da them phong benh");
        }
    }

    //modify treatmentRoom
    public void updateTreatmentRoom(int treatmentRoomId, String roomName, String roomType, int capacity){
        TreatmentRoom updateTreatmentRoom = findTreatmentRoom(treatmentRoomId);
        if(updateTreatmentRoom != null){
            updateTreatmentRoom.setRoomName(roomName);
            updateTreatmentRoom.setRoomType(roomType);
            updateTreatmentRoom.setCapacity(capacity);
            System.out.println("Da sua");
        }else {
            System.out.println("Khong tim thay phong benh voi id: " + treatmentRoomId);
        }
    }

    //delete treatmentRoom
    public void deleteTreatmentRoom(int treatmentRoomId){
        TreatmentRoom deleteTreatmentRoom = findTreatmentRoom(treatmentRoomId);
        if(deleteTreatmentRoom != null){
            treatmentRoomList.remove(deleteTreatmentRoom);
            System.out.println("Da xoa");
        }else {
            System.out.println("Khong tim thay phong benh voi id: " + treatmentRoomId);
        }
    }

    //Info treatmentRoom
    public TreatmentRoom getRoomInfo(int roomId){
        return treatmentRoomList.stream()
                .filter(treatmentRoom -> treatmentRoom.getRoomId() == roomId)
                .findFirst()
                .orElse(null);
    }

    public boolean comparePatientDiagnoseWithRoomType(int patientId, int roomId){
        Patient patient = getPatientInfo(patientId);
        TreatmentRoom treatmentRoom = getRoomInfo(roomId);
        if (patient != null || treatmentRoom != null) {
            System.out.println("Not found");
            return false;
        }

        return patient.getDiagnose().equalsIgnoreCase(treatmentRoom.getRoomType());
    }

    public void assignPatientToRoom(int patientId, int roomId){
        Patient patient = getPatientInfo(patientId);
        TreatmentRoom treatmentRoom = getRoomInfo(roomId);
        if(patient != null || treatmentRoom != null) {
            System.out.println("Not found");
        }

        if(!treatmentRoom.isRoomFull() && comparePatientDiagnoseWithRoomType(patientId, roomId)){
            treatmentRoom.getPatientsList().add(patient);
            System.out.println("Patient assign TreatmentRoom");
        }else {
            System.out.println("Can not assign patient to room");
        }
    }


    //remove patient from room
    public void removePatientFromRoom(int patientId, int roomId){
        Patient patient = getPatientInfo(patientId);
        TreatmentRoom treatmentRoom = getRoomInfo(roomId);

        if(patient != null || treatmentRoom != null) {
            System.out.println("Not found");
        }

        for(TreatmentRoom room : treatmentRoomList){
            if (treatmentRoom.getPatientsList().contains(patient)) {
                treatmentRoom.getPatientsList().remove(patient);
                System.out.println("Benh nhan xuat vien");
            }
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

    public int getNextId() {
        return nextId;
    }
}
