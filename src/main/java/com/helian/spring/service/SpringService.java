package com.helian.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.helian.spring.bean.User;
import com.helian.spring.mapper.SpringMapper;

@Service
public class SpringService {

	@Autowired
	private SpringMapper springMapper;

	public List<User> findUserList() {
		 List<User> user = springMapper.findUserList();
		return user;
	}
	public void insertUser(User user) {
		springMapper.addUser(user);
	}
}
