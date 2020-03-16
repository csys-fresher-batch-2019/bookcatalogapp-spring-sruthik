package com.sruthi.bookcatalogapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sruthi.bookcatalogapp.dao.AuthorDAO;
import com.sruthi.bookcatalogapp.domain.Author;
import com.sruthi.bookcatalogapp.exception.DBException;
import com.sruthi.bookcatalogapp.exception.ServiceException;
import com.sruthi.bookcatalogapp.factory.DAOFactory;
import com.sruthi.bookcatalogapp.service.UserService;

@SuppressWarnings("serial")
@WebServlet("/AddAuthorServlet")
public class AddAuthorServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String authorName = request.getParameter("authorName");
		String authorMail = request.getParameter("authorMail");
		String authorPhNo = request.getParameter("authorPhNo");
		long ph = Long.valueOf(authorPhNo);
		Author a = new Author();
		a.setName(authorName);
		a.setMailId(authorMail);
		a.setPhoneNumber(ph);
		AuthorDAO dao = DAOFactory.getAuthorDAO();
		boolean status = false;
		List<Author> list;
		try {
			list = dao.findAll();
			for (Author au : list) {
				String name = au.getName();
				String mail = au.getMailId();
				long no = au.getPhoneNumber();
				if (name.equals(authorName) || mail.equals(authorMail) || no == ph) {
					status = true;
				}
			}

			if (status) {
				request.setAttribute("errorMessage2", "Author already exists");
				RequestDispatcher dispatcher2 = request.getRequestDispatcher("AddAuthors.jsp");
				dispatcher2.forward(request, response);
			} else {
				UserService.addAuthor(a);
				response.sendRedirect("sort.jsp");
			}

		} catch (DBException e) {
			
			e.printStackTrace();
		} catch (ServiceException e) {
			request.setAttribute("errorMessage2", e.getMessage());
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("AddAuthors.jsp");
			dispatcher2.forward(request, response);
			
		}
	}

}
