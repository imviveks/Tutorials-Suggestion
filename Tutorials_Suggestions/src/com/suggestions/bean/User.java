package com.suggestions.bean;

/**
 * this is the bean class for User
 * It contains the constructors and the setter and getter functions
 * @author User
 *
 */
public class User {
	
	private int userId; //user id
	private String userName; //name of the user
	private String userPassword; //password of the user
	
	//No param constructor User
	public User() {
		super();
	}
     
	//Parametrized constructor
	public User(int userId, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}
    
	public User(String userName, String userPassword) {
		// TODO Auto-generated constructor stub
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	//setter and getter method of User field
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}//end class User
