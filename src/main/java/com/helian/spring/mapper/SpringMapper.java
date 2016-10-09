package com.helian.spring.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.helian.spring.bean.MonthListDTO;
import com.helian.spring.bean.User;
import com.helian.spring.bean.User2;

@Repository  
public interface SpringMapper {
	public List<MonthListDTO> findDayList(String sn,String year, String month);

	public List<User2> findUserList();

	public void addUser(User user);
}
