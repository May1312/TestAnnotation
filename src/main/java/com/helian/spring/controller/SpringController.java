package com.helian.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/run", method = RequestMethod.GET)
	public void run(HttpServletRequest request,
			@RequestParam(value = "year") String year,
			@RequestParam(value = "month",required=false) String month) {
		List result = SpringService.run("CMMIOI1088",year,month);
		for (Object object : result) {
			System.out.println(object.toString());
		}
		
	}
}
