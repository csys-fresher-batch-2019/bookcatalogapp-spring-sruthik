package com.sruthi.bookcatalogapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sruthi.bookcatalogapp.dao.UserDAO;
import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.factory.DAOFactory;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mail = request.getParameter("usermail");
		String password = request.getParameter("password");
		boolean msg = false;
		UserDAO dao = DAOFactory.getUserDAO();
		Users u = new Users();
		System.out.println("Enter user mailId: " + mail);
		u.setUserMailId(mail);
		System.out.println("Enter password : " + password);
		u.setSetPassword(password);

		try {
			msg = dao.login(u);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (msg) {
			response.sendRedirect("sort.jsp");
		} else {
			request.setAttribute("errorMessage", "Invalid credentials");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);

		}

	}

}
