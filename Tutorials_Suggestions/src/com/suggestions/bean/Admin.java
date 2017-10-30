package com.suggestions.bean;

public class Admin {
	
	private int adminId; //admin id
	private String adminName; //name of the admin
	private String adminPassword; //password of the admin
	
	//No param constructor admin
	public Admin() {
		super();
	}
	
	//parametrized constructor Admin
	public Admin(int adminId, String adminName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
    
	//setter and getter method of Admin Field
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	 
}//end class Admin
