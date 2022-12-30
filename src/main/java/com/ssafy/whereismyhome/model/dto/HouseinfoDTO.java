package com.ssafy.whereismyhome.model.dto;

public class HouseinfoDTO {
    private String aptCode;
    private String user_id;
    private int no;
    private String register_time;
    private String apartmentName;

    private String lng;

    private String lat;

    public String getAptCode() {
        return aptCode;
    }

    public void setAptCode(String aptCode) {
        this.aptCode = aptCode;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "HouseinfoDTO{" +
                "aptCode='" + aptCode + '\'' +
                ", user_id='" + user_id + '\'' +
                ", no=" + no +
                ", register_time='" + register_time + '\'' +
                ", apartmentName='" + apartmentName + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}
