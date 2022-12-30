package com.ssafy.whereismyhome.model.dto;

public class ApartDTO {
	private int like_id;
	private String user_id;
	private String no;
	private String register_time;
	private String ip_address;
	
	public int getLike_id() {
		return like_id;
	}
	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
		return "ApartDTO [like_id=" + like_id + ", user_id=" + user_id + ", no=" + no + ", register_time="
				+ register_time + ", ip_address=" + ip_address + "]";
	}


	
}
