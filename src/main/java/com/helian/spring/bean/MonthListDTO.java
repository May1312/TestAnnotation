package com.helian.spring.bean;

import java.io.Serializable;
import java.util.List;

public class MonthListDTO implements Serializable{

	private static final long serialVersionUID = 7592701245172005251L;
	
	private String month;
	private Long mileages;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Long getMileages() {
		return mileages;
	}
	public void setMileages(Long mileages) {
		this.mileages = mileages;
	}
	
}
