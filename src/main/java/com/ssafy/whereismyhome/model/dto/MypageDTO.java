package com.ssafy.whereismyhome.model.dto;
;

public class MypageDTO {
	private String sidoname;
	private String gugunName;
	private String apartmentName;
	private String dealAmount;
	private String area;
	private String floor;
	private String date;
	public String getSidoname() {
		return sidoname;
	}
	public void setSidoname(String sidoname) {
		this.sidoname = sidoname;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MypageDTO [sidoname=" + sidoname + ", gugunName=" + gugunName + ", apartmentName=" + apartmentName
				+ ", dealAmount=" + dealAmount + ", area=" + area + ", floor=" + floor + ", date=" + date + "]";
	}

	
	
}
