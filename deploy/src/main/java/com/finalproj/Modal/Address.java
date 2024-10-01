package com.finalproj.Modal;

public class Address {
    private String city;
    private String district;

    public Address(String city, String district) {
        this.city = city;
        this.district = district;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return  district + " " + city;
    }
}
