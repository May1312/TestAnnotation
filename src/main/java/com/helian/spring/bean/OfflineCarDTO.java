package com.helian.spring.bean;

import java.util.List;

public class OfflineCarDTO {

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
