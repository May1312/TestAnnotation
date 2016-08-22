package com.helian.spring.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository  
public interface SpringMapper {
	public List findDayList(String sn,String year, String month);

}
