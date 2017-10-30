package com.suggestions.services;

import java.util.List;

import com.suggestions.bean.User;

/**
 * This is the User Service interface 
 * @author User
 *
 */
public interface UserService {

	public User getUser(int userId);
	public List<User> getUsers();
	
}
