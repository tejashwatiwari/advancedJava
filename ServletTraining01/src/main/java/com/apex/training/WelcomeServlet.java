package com.apex.training;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.PrintWriter;
public class WelcomeServlet extends GenericServlet {
	
	public void init() throws ServletException{
		System.out.println("Init");
		super.init();
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.append("<HTML>");
		writer.append("<body>");
		writer.append("<h1>Welcome</h1>");
		writer.append("</body>");
		writer.append("</HTML>");
		writer.close();
		
	}
	
	public void destory() {
		System.out.println("Method destroy()");
		super.destroy();
	}
}
