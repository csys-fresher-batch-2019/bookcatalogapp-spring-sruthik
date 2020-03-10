package com.sruthi.bookcatalogapp.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sruthi.bookcatalogapp.dao.UserDAO;
import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.exception.DBException;
import com.sruthi.bookcatalogapp.exception.ServiceException;
import com.sruthi.bookcatalogapp.factory.DAOFactory;
import com.sruthi.bookcatalogapp.service.UserService;

@SuppressWarnings("serial")
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

		Users u = new Users();
		u.setUserName(username);
		u.setUserMailId(mailId);
		u.setPhNo(phno);
		u.setSetPassword(password);
		u.setConfirmPassword(cpassword);
		System.out.println(u);

		boolean equals = password.equals(cpassword);
		boolean status = false;
		if (equals) {

			System.out.println("Registered Successfully!!");
			UserDAO dao = DAOFactory.getUserDAO();
			List<Users> list;
			try {
				list = dao.findAll();
				for (Users user : list) {
					System.out.println(user);
					String name = user.getUserName();
					String mail = user.getUserMailId();
					long ph = user.getPhNo();
					if (name.equals(username) || mail.equals(mailId) || ph == phno) {
						status = true;
					}
				}
				System.out.println("Status:" + status);

				if (status) {
					request.setAttribute("errorMessage1", "Registered already!! Please login...");
					RequestDispatcher dispatcher1 = request.getRequestDispatcher("reg.jsp");
					dispatcher1.forward(request, response);
				} else {
					UserService.registration(u);
					System.out.println("Successfully added");
					response.sendRedirect("sort.jsp");
				}

			} catch (DBException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				request.setAttribute("errorMessage1", e.getMessage());
			}
		} else {

			request.setAttribute("errorMessage", "Password mismatch Try Again!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);

		}
	}
}
