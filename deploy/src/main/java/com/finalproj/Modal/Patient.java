package com.finalproj.Modal;

import java.time.LocalDate;

public class Patient {
    private int patientId;
    private int roomId;
    private String name;
    private int age;
    private String gender;
    private String diagnose;
    private Address address;
    private String phone;

    public Patient() {
    }


    public Patient(int patientId, String name, int age, String gender, String diagnose, Address address, String phone, int roomId) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.diagnose = diagnose;
        this.address = address;
        this.phone = phone;
        this.roomId = roomId;
    }
    // Các getter và setter


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
