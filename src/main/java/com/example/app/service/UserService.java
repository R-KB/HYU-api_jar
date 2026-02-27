package com.example.app.service;

import java.util.List;

import com.example.app.domain.User;

public interface UserService {

	List<User> getAllUsers();

	User getUserById(Integer userId);

	void addUser(User user);

	void editUser(User user);

	void deleteUser(Integer userId);

}
