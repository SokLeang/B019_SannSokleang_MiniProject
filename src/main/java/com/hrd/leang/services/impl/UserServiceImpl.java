package com.hrd.leang.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrd.leang.model.User;
import com.hrd.leang.repository.UserRepository;
import com.hrd.leang.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public boolean save(User user) {
		String user_hash=UUID.randomUUID().toString();
		user.setUser_hash(user_hash);
		return userRepository.save(user);
	}

	@Override
	public boolean delete(String user_hash) {
		// TODO Auto-generated method stub
		return userRepository.delete(user_hash);
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return userRepository.update(user);
	}

	@Override
	public User find(String user_hash) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
