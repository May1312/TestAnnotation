package com.helian.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.helian.spring.bean.MonthListDTO;
import com.helian.spring.bean.User;
import com.helian.spring.bean.User2;
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
	public ResponseEntity<List<MonthListDTO>> run(HttpServletRequest request,
			@RequestParam(value = "year") String year,
			@RequestParam(value = "month",required=false) String month) {
		List<MonthListDTO> result = SpringService.run("CMMIOI1088",year,month);
		String version = SpringVersion.getVersion();
		System.out.println(version);
		
		//return null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", 200);
	
		return ResponseEntity.ok(result);
	}
	@RequestMapping(value = "/user2",method=RequestMethod.GET)
	public ResponseEntity<List<User2>> findUserList(){
		List<User2> result = SpringService.findUserList();
		return ResponseEntity.ok(result);
	}
	@RequestMapping(value = "/user",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<Map<String,Object>> insertUser(HttpServletRequest request){
		String string = (String) request.getParameter("user");
		System.out.println(string);
		//json字符串转对象
		User user = JSON.parseObject(string, User.class);
		System.out.println(user.toString());
		SpringService.insertUser(user);
		Map<String,Object> map = new HashMap<String,Object> ();
		map.put("result", "success");
		return ResponseEntity.ok(map);
	}
}
