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
@WebServlet("/ViewBooks")
public class ViewBooks extends HttpServlet {
	@Autowired
	TitleDAO dao ;
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			    
				
					try {
						
						List<Title> list = dao.displayTitleWithPrice();
						request.setAttribute("output", list);
						RequestDispatcher dispatcher = request.getRequestDispatcher("viewBooks.jsp");
						dispatcher.forward(request, response);
					} catch (DBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
				
			
			}
			
	


