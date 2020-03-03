package com.sruthi.bookcatalogapp.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sruthi.bookcatalogapp.dao.TitleDAO;
import com.sruthi.bookcatalogapp.domain.Title;
import com.sruthi.bookcatalogapp.factory.DAOFactory;
@WebServlet("/SearchByServlet")
public class SearchByServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filter = request.getParameter("filter");
		System.out.println("value: " + filter);
		String nextPage = null;
		String errorMessage = null;
		switch (filter) {
		case "RECENT_BOOKS": {
			try {
				System.out.println("Recent Books are...");

				TitleDAO dao = DAOFactory.getTitleDAO();
				List<Title> list = dao.displayByRecentBooks();
				request.setAttribute("RECENT_BOOKS", list);
				nextPage = "RecentBooks.jsp";
			} catch (Exception e) {
				errorMessage = "Records not found";
			}
			break;
		}

		case "COURSE": {
			try {
				TitleDAO dao1 = DAOFactory.getTitleDAO();
				String courseId = request.getParameter("CourseId");
				int id = Integer.valueOf(courseId);
				System.out.println(id);
				List<Title> list1 = dao1.displayTitleForCourseId(id);
				request.setAttribute("COURSE", list1);
				nextPage = "Course.jsp";

			} catch (NumberFormatException e) {
				errorMessage = "Records not found";
				nextPage = "Course.jsp";
			}
			break;
		}
		case "SEARCH_BY_YEAR": {
			try {

				TitleDAO dao2 = DAOFactory.getTitleDAO();
				String year = request.getParameter("date");
				LocalDate date = LocalDate.parse(year);
				System.out.println(date);
				List<Title> list2 = dao2.displayYearWiseBooks(date);
				request.setAttribute("TITLE_LIST", list2);
				nextPage = "year1.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				errorMessage = e.getMessage();
				e.printStackTrace();
				nextPage = "year1.jsp";
			}
			break;
		}
		case "YEAR": {
			try {

				
				nextPage = "year.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
		default: {
			System.out.println("Invalid Action");
		}
		}
		System.out.println("ErrorMessage:" + errorMessage);
		System.out.println("Next Page:" + nextPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);

	}

}