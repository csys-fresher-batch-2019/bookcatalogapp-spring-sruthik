package com.sruthi.bookcatalogapp.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sruthi.bookcatalogapp.dao.PublisherDAO;
import com.sruthi.bookcatalogapp.dao.UserDAO;
import com.sruthi.bookcatalogapp.domain.Publisher;
import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.factory.DAOFactory;

@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String mailId = request.getParameter("mailId");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		String phNo = request.getParameter("phNo");
		long phno = Long.valueOf(phNo);

		System.out.println("Registerservlet called");

		// System.out.println("Enter UserName : "+username);
		// System.out.println("Enter UserMailId : "+mailId);
		// System.out.println("Enter Password : "+password);
		// System.out.println("Confirm Password : "+cpassword);
		// System.out.println("Enter Phone-no : "+phNo);
		Users u = new Users();
		System.out.println("Enter Username: " + username);
		u.setUserName(username);
		System.out.println("Enter UserMail-Id: " + mailId);
		u.setUserMailId(mailId);
		System.out.println("Enter Password: " + password);

		u.setSetPassword(password);
		System.out.println("Confirm Password: " + cpassword);

		u.setConfirmPassword(cpassword);
		System.out.println("Enter Phone-number: " + phno);

		boolean equals = password.equals(cpassword);
        boolean status = false;
		if (equals) {
			u.setPhNo(phno);
			System.out.println("Registered Successfully!!");
			UserDAO dao = DAOFactory.getUserDAO();
			List<Users> list = dao.displayUsers();
			try {
				System.out.println(u);
				for (Users user : list) {
					String name = user.getUserName();
					String mail = user.getUserMailId();
					long ph = user.getPhNo();
					if (name.equals(username)||mail.equals(mailId)|| ph == phno) {
						status = true;
					} 
				}
				if(status)
				{
					request.setAttribute("errorMessage1", "Registered already!! Please login...");
					RequestDispatcher dispatcher1 = request.getRequestDispatcher("reg.jsp");
					dispatcher1.forward(request, response);
				}
				else {
					dao.addUser(u);
					response.sendRedirect("sort.jsp");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			request.setAttribute("errorMessage", "Password mismatch Try Again!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);

		}

	}

}