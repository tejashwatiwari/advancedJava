package com.learn.controller;

import java.io.IOException;

import com.learn.bean.UserBean;
import com.learn.service.UserService;
import com.learn.util.UserUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = UserUtil.validateRequest(request);
		HttpSession session = request.getSession();

		if (error == null) {
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String userName = request.getParameter("username");
			String password = request.getParameter("password");

			UserBean userBean = new UserBean(firstName, lastName, userName, password);
			error = userService.registerUser(userBean);

			if (error == null) {
				session.setAttribute("username", userName);
				RequestDispatcher dispatcher = request.getRequestDispatcher("registerSuccessful.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}

		session.setAttribute("error", error);
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerPage.jsp");
		dispatcher.forward(request, response);
	}
}
