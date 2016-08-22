package com.helian.spring.bean;

import java.io.Serializable;
import java.util.List;

public class OfflineCarDTO implements Serializable{

	private static final long serialVersionUID = 2208935299735542980L;
	
	
	public OfflineCarDTO() {
		super();
	}
	private String serialNumber;
	private List<MileageTimeDTO> mileageList;
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public List<MileageTimeDTO> getMileageList() {
		return mileageList;
	}
	public void setMileageList(List<MileageTimeDTO> mileageList) {
		this.mileageList = mileageList;
	}
}
