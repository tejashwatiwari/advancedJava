package com.learn.bean;

public class UserBean {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;

	// Constructor with four parameters
	public UserBean(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	// Constructor with two parameters
	public UserBean(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	// Getter and setter methods
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
