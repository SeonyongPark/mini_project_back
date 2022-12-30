package com.ssafy.whereismyhome.model.dto;

public class InterestDTO {
	private int interest_no;
	private String user_id;
	private String dongCode;
	private String register_time;
	private String ip_address;
	public int getInterest_no() {
		return interest_no;
	}
	public void setInterest_no(int interest_no) {
		this.interest_no = interest_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getRegister_time() {
		return register_time;
	}
	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	
	@Override
	public String toString() {
		return "InterestDTO [interest_no=" + interest_no + ", user_id=" + user_id + ", dongCode=" + dongCode
				+ ", register_time=" + register_time + ", ip_address=" + ip_address + "]";
	}
	
	
}
