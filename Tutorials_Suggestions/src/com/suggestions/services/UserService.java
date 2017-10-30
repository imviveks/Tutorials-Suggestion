package com.suggestions.services;

import java.util.List;

import com.suggestions.bean.User;

public interface UserService {

	public User getUser(int userId);
	public List<User> getUsers();
	
}
