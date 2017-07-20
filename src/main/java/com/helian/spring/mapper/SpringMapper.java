package com.helian.spring.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.helian.spring.bean.User;

@Repository  
public interface SpringMapper {

	public List<User> findUserList();

	public void addUser(User user);
}
