package com.suggetions.entity;

import com.suggestions.bean.User;
import com.suggestions.dao.UserDAO;

/**
 * This is the User Entity class
 * this class implements users service operations
 * @author User
 *
 */
public class UserEO {

	public enum UserType{
		ADMIN,
		NORMAL_USER
	}
	private User user;
	private UserType userType;
	
	public User getUser(int  userId)
	{
		return UserDAO.getUser(userId);
	}
	
}
