package com.ssafy.whereismyhome.model.dto;

public class BookmarkDTO {

    private String user_id;
    private int no;
    private String aptCode;
    private String register_time;

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

    public String getAptCode() {
        return aptCode;
    }

    public void setAptCode(String aptCode) {
        this.aptCode = aptCode;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }

    @Override
    public String toString() {
        return "BookmarkDTO{" +
                "user_id='" + user_id + '\'' +
                ", no=" + no +
                ", aptCode='" + aptCode + '\'' +
                ", register_time='" + register_time + '\'' +
                '}';
    }
}
