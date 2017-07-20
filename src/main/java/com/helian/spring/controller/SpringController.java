package com.helian.spring.controller;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.helian.spring.bean.User;
import com.helian.spring.service.SpringService;

@Controller
@RequestMapping("/hang")
public class SpringController {

	@Autowired
	private SpringService SpringService;


	@RequestMapping(value = "/user/get2", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findUserList() {
		List<User> result = SpringService.findUserList();
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "/user", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ResponseEntity<Map<String, Object>> insertUser(
			HttpServletRequest request) {
		String string = (String) request.getParameter("user");
		System.out.println(string);
		// json字符串转对象
		User user = JSON.parseObject(string, User.class);
		System.out.println(user.toString());
		SpringService.insertUser(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		return ResponseEntity.ok(map);
	}

	// angularjs 上传文件
	// @ApiOperation(value = "上传文件", notes = "上传文件test", responseClass =
	// "DataVo")
	@RequestMapping(value = "/upload")
	public @ResponseBody void upload(HttpServletRequest request) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile packageFile = multipartRequest.getFile("myfile");
		try {
			//保存文件
			String name = packageFile.getOriginalFilename();
			packageFile.transferTo(new File("C:/Users/An/Desktop/"+name));
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	@Deprecated
	public Date fetchBeginOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		System.out.println("测试master分支");
		return cal.getTime();
	}
}
