package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;

@Mapper
public interface UserMapper {
	
	List<User> selectUsers();
	
	User selectUserById(Integer userId);
	
	void insert(User user);
	
	void update(User user);
	
	void delete(Integer userId);

}
