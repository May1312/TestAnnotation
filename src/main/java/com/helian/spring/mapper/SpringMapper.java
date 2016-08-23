package com.helian.spring.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.helian.spring.bean.MonthListDTO;

@Repository  
public interface SpringMapper {
	public List<MonthListDTO> findDayList(String sn,String year, String month);

}
