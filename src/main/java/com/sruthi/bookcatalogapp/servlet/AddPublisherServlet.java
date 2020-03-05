package com.sruthi.bookcatalogapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sruthi.bookcatalogapp.dao.PublisherDAO;
import com.sruthi.bookcatalogapp.domain.Publisher;
import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.exception.DBException;
import com.sruthi.bookcatalogapp.factory.DAOFactory;

@WebServlet("/AddPublisherServlet")
public class AddPublisherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pubName = request.getParameter("pubName");
		String pubMail = request.getParameter("pubMail");
		String pubPhNo = request.getParameter("pubPhNo");
		long ph = Long.valueOf(pubPhNo);
		Publisher p = new Publisher();
		p.setPubName(pubName);
		p.setPubMailId(pubMail);
		p.setPubPhNo(ph);
		PublisherDAO dao = DAOFactory.getPublisherDAO();
		boolean status = false;
		List<Publisher> list;
		try {
			list = dao.displayPubId();
		
			for (Publisher pub : list) {
				String name=pub.getPubName();
				String mail = pub.getPubMailId();
				long no = pub.getPubPhNo();
				if (name.equals(pubName) || mail.equals(pubMail)|| no == ph) {
					status = true;
				} 
			}
		


		if(status)
		{
			request.setAttribute("errorMessage2", "Publisher already exists");
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("AddPublishers.jsp");
			dispatcher2.forward(request, response);
		}
		else {
			System.out.println(p);
			dao.addPublisher(p);
			response.sendRedirect("sort.jsp");
		}

	} catch (Exception e) {
		
		e.printStackTrace();
	}
}	
	}

