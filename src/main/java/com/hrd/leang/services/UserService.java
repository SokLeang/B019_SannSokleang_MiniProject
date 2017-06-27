package com.hrd.leang.services;

import java.util.List;

import com.hrd.leang.model.User;

public interface UserService {

	public List<User> findAll(); 
	public boolean save(User user);
	public boolean delete(String user_hash);
	public boolean update(User user);
	public User find(String user_hash);
}
