package com.helian.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.helian.spring.bean.MileageTimeDTO;
import com.helian.spring.bean.OfflineCarDTO;
import com.helian.spring.service.SpringService;

@Controller
@RequestMapping("/hang")
public class SpringController {

	/**
	 * {"serialNumber":"CMMIOI1088","mileageList":[{"time":
	 * 1470994181000,"mileage:":35680},{"time":1470995181234,"mileage:":35987}]}
	 */
	@Autowired
	private SpringService SpringService;

	@RequestMapping(value = "/run", method = RequestMethod.POST)
	public void run(@RequestBody OfflineCarDTO dto) {
		List<MileageTimeDTO> mileageList = dto.getMileageList();
		for (MileageTimeDTO mileageTimeDTO : mileageList) {
			System.out.println(dto.getSerialNumber());
			System.out.println(mileageTimeDTO.getTime());
			System.out.println(mileageTimeDTO.getMileage());
		}
	}
}
