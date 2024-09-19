package com.finalproj.Modal;

import java.util.List;

public class TreatmentRoom {
    private int roomId;
    private String roomName;
    private String roomType;
    private int capacity;
    private List<Patient> patientsList;

    public TreatmentRoom(int roomId, String roomName, String roomType, int capacity, List<Patient> patientsList) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.capacity = capacity;
        this.patientsList = patientsList;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Patient> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<Patient> patientsList) {
        this.patientsList = patientsList;
    }

    //roomFull?
    public boolean isRoomFull(){
        return patientsList.size() == capacity;
    }
}
