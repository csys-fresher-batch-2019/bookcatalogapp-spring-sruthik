package com.sruthi.bookcatalogapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sruthi.bookcatalogapp.domain.Users;

@SuppressWarnings("serial")
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String usermail = request.getParameter("adminMail");
		String password = request.getParameter("adminPassword");

		Users user = new Users();
		System.out.println("Enter Mail-Id : "+usermail);
		user.setUserName(usermail);
		System.out.println("Enter Password : "+password);
		user.setConfirmPassword(password);

		if(usermail.equals("sruthi@gmail.com")&&password.equals("sru123"))
		{
		response.sendRedirect("AdminFeatures.jsp");
		}
		else
		{
			request.setAttribute("errorMessage", "Invalid credentials");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
		    dispatcher.forward(request, response);
		}
		
	}
}
	


