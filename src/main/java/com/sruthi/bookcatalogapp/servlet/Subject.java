package com.sruthi.bookcatalogapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sruthi.bookcatalogapp.dao.TitleDAO;

import com.sruthi.bookcatalogapp.domain.Title;
import com.sruthi.bookcatalogapp.exception.DBException;

@SuppressWarnings("serial")
@WebServlet("/Subject")
public class Subject extends HttpServlet {
	@Autowired
	TitleDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subName = request.getParameter("sub_name");

		try {
			List<Title> list = dao.findBySubjectName(subName);
			System.out.println(list);
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewSubjectBooks.jsp");
			dispatcher.forward(request, response);

		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
