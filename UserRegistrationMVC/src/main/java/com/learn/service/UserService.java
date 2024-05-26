package com.learn.service;

import com.learn.bean.UserBean;
import com.learn.dao.UserDAO;

public class UserService {

	private UserDAO userDAO = new UserDAO();

	public String authenticateAndPopulateUser(UserBean userBean) {
		UserBean authenticatedUser = userDAO.getUserBean(userBean);
		if (authenticatedUser.getFirstName() != null) {
			return null; // No error
		} else {
			return "Invalid username or password";
		}
	}

	public String registerUser(UserBean userBean) {
		if (userDAO.isUsernameExists(userBean.getUserName())) {
			return "Username already exists! Enter a different username";
		} else {
			boolean isRegistered = userDAO.registerUser(userBean);
			return isRegistered ? null : "Registration failed, please try again";
		}
	}
}
