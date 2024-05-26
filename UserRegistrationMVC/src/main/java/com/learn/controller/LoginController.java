package com.learn.controller;

import java.io.IOException;

import com.learn.bean.UserBean;
import com.learn.service.UserService;
import com.learn.util.UserUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = UserUtil.validateRequest(request);
		HttpSession session = request.getSession();
		if (error == null) {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			UserBean userBean = new UserBean(userName, password);
			error = userService.authenticateAndPopulateUser(userBean);
			if (error == null) {
				session.setAttribute("firstName", userBean.getFirstName());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("successPage.jsp");
				requestDispatcher.forward(request, response);
				return; // Ensure that the code does not fall through to the error case
			}
		}
		session.setAttribute("error", error);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.jsp");
		requestDispatcher.forward(request, response);
	}
}
