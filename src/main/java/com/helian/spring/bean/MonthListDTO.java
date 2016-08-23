package com.helian.spring.bean;

import java.io.Serializable;
import java.util.List;

public class MonthListDTO implements Serializable{

	private static final long serialVersionUID = 7592701245172005251L;
	
	private String month;
	private String day;
	private Long mileage;
	private List<DayListDTO> dayList;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Long getMileage() {
		return mileage;
	}
	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}
	public List<DayListDTO> getDayList() {
		return dayList;
	}
	public void setDayList(List<DayListDTO> dayList) {
		this.dayList = dayList;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
}
