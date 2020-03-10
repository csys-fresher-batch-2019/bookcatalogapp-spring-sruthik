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

import com.sruthi.bookcatalogapp.dao.AuthorDAO;
import com.sruthi.bookcatalogapp.domain.Author;

import com.sruthi.bookcatalogapp.exception.DBException;

@SuppressWarnings("serial")
@WebServlet("/ViewAuthors")
public class ViewAuthors extends HttpServlet {
	@Autowired
	AuthorDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Author> list = dao.findAll();
			System.out.println(list);
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listByAuthors.jsp");
			dispatcher.forward(request, response);

		} catch (DBException e) {
			e.printStackTrace();
		}

	}

}
