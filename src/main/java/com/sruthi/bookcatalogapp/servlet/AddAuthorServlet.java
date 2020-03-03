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
import com.sruthi.bookcatalogapp.factory.DAOFactory;


@WebServlet("/AddAuthorServlet")
public class AddAuthorServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String authorName = request.getParameter("authorName");
			String authorMail = request.getParameter("authorMail");
			String authorPhNo = request.getParameter("authorPhNo");
			long ph = Long.valueOf(authorPhNo);
			Author a = new Author();
			a.setAuthorName(authorName);
			a.setAuthorMailId(authorMail);
			a.setAuthorPhNo(ph);
			AuthorDAO dao = DAOFactory.getAuthorDAO();
			boolean status = false;
			List<Author> list = dao.displayNumberOfAuthors();
			try {
				for (Author au: list) {
					String name=au.getAuthorName();
					String mail = au.getAuthorMailId();
					long no = au.getAuthorPhNo();
					if (name.equals(authorName) || mail.equals(authorMail)|| no == ph) {
						
						status = true;
					
				}
				}
				
			if(status)
			{
				request.setAttribute("errorMessage2", "Author already exists");
				RequestDispatcher dispatcher2 = request.getRequestDispatcher("AddAuthors.jsp");
				dispatcher2.forward(request, response);
			}
			else {
				dao.addAuthor(a);
				response.sendRedirect("sort.jsp");
			}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
