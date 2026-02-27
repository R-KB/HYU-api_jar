package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.User;
import com.example.app.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper mapper;

	@Override
	public List<User> getAllUsers() {
		return mapper.selectUsers();
	}

	@Override
	public User getUserById(Integer userId) {
		return mapper.selectUserById(userId);
	}

	@Override
	public void addUser(User user) {
		mapper.insert(user);

	}

	@Override
	public void editUser(User user) {
		mapper.update(user);

	}

	@Override
	public void deleteUser(Integer userId) {
		mapper.delete(userId);

	}

}
