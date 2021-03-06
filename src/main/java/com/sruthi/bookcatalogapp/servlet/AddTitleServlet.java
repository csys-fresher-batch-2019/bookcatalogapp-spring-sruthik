package com.sruthi.bookcatalogapp.servlet;

import java.io.IOException;
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
import com.sruthi.bookcatalogapp.exception.DBException;
import com.sruthi.bookcatalogapp.exception.ServiceException;
import com.sruthi.bookcatalogapp.factory.DAOFactory;
import com.sruthi.bookcatalogapp.service.UserService;

@SuppressWarnings("serial")
@WebServlet("/AddTitleServlet")
public class AddTitleServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String authorId = request.getParameter("authorId");
		int id = Integer.valueOf(authorId);
		String pubId = request.getParameter("pubId");
		int id1 = Integer.valueOf(pubId);
		String subId = request.getParameter("subId");
		int id2 = Integer.valueOf(subId);
		String pubDate = request.getParameter("pubDate");
		LocalDate date = LocalDate.parse(pubDate);
		String title = request.getParameter("title");
		String version = request.getParameter("version");
		int v = Integer.valueOf(version);
		String price = request.getParameter("price");
		int p = Integer.valueOf(price);
		System.out.println(id);
		System.out.println(id1);
		System.out.println(id2);
		System.out.println(title);
		System.out.println(v);
		System.out.println(p);
		Title t = new Title();
		t.setAuthorId(id);
		t.setId(id1);
		t.setSubjectId(id2);
		t.setPublishedDate(date);
		t.setTitleName(title);
		t.setVersionNumber(v);
		t.setPrice(p);
		TitleDAO dao = DAOFactory.getTitleDAO();

		boolean status = false;
		List<Title> list;
		try {
			list = dao.findAll();

			for (Title ti : list) {

				int pub = ti.getPublisherId();
				int author = ti.getAuthorId();
				int sub = ti.getSubjectId();
				String tit = ti.getTitleName();
				int pri = ti.getPrice();
				int version1 = ti.getVersionNumber();
				LocalDate d = ti.getPublishedDate();

				if (pub == id1 && author == id && sub == id2 && tit.equals(title) && pri == p && version1 == v
						&& d.equals(date)) {

					status = true;

				}
			}
			System.out.println(status);
			if (status) {
				request.setAttribute("errorMessage2", "Title already exists");
				RequestDispatcher dispatcher2 = request.getRequestDispatcher("AddTitles.jsp");
				dispatcher2.forward(request, response);
			} else {

				UserService.addTitle(t);
				response.sendRedirect("sort.jsp");
			}
		}

		catch (DBException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
}
