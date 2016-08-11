package com.helian.spring.service;

import org.springframework.stereotype.Service;

@Service
public class SpringService {

	public String run(String name){
		return "gy "+name;
	}
}
