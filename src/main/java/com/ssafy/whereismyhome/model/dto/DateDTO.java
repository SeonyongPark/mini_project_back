package com.ssafy.whereismyhome.model.dto;


public class DateDTO {
	private String Year;
	private String Month;
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
	@Override
	public String toString() {
		return "DateDTO [Year=" + Year + ", Month=" + Month + "]";
	}
	
	
}
