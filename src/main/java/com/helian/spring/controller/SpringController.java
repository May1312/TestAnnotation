package com.helian.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.helian.spring.service.SpringService;

@Controller
@RequestMapping("/hang")
public class SpringController{

	@Autowired
	private SpringService SpringService;
	@RequestMapping("/run")
	public void run()
			throws ServletException, IOException {
		System.out.println(SpringService.run("雷布斯"));
	}
}
