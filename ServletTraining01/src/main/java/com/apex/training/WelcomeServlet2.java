 package com.apex.training;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


public class WelcomeServlet2 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public WelcomeServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.append("<HTML>");
		writer.append("<body>");
		writer.append("<h1>Welcome 2</h1>");
		writer.append("</body>");
		writer.append("</HTML>");
		writer.close();
	}
}
