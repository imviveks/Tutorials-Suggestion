package com.suggestions.bean;

/*
 * This is the Cookies bean class
 * this class contains the setter and getter method for the Cookies Class
*/

public class Cookies {
	
	private int cookieId; // cookie id
	private String cookieName; //name of cookie
	private int userId; // Id of user for whom cookie is generated
	
	public Cookies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cookies(int cookieId, String cookieName, int userId) {
		super();
		this.cookieId = cookieId;
		this.cookieName = cookieName;
		this.userId = userId;
	}

	public int getCookieId() {
		return cookieId;
	}

	public void setCookieId(int cookieId) {
		this.cookieId = cookieId;
	}

	public String getCookieName() {
		return cookieName;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
