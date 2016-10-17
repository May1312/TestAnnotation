package com.helian.spring.bean;

import java.io.Serializable;

public class DayListDTO implements Serializable{

	private static final long serialVersionUID = 1375351342107442073L;
	
	private String day;
	private long mileage;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public long getMileage() {
		return mileage;
	}
	public void setMileage(long mileage) {
		this.mileage = mileage;
	}
	private void syso() {
		// TODO aaaaaaaaaaaa

	}
}
