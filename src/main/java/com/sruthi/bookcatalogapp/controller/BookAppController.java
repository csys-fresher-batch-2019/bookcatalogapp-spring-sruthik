package com.sruthi.bookcatalogapp.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sruthi.bookcatalogapp.dao.AuthorDAO;
import com.sruthi.bookcatalogapp.dao.PublisherDAO;
import com.sruthi.bookcatalogapp.dao.SubjectDAO;
import com.sruthi.bookcatalogapp.dao.TitleDAO;
import com.sruthi.bookcatalogapp.dao.UserDAO;
import com.sruthi.bookcatalogapp.domain.Author;
import com.sruthi.bookcatalogapp.domain.Publisher;
import com.sruthi.bookcatalogapp.domain.Subject;
import com.sruthi.bookcatalogapp.domain.Title;
import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.dto.Messagedto;
import com.sruthi.bookcatalogapp.exception.DBException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class BookAppController {
	@Autowired
	UserDAO dao;
	@Autowired
	TitleDAO dao1;// = DAOFactory.getTitleDAO();
	@Autowired
	PublisherDAO dao2;
	@Autowired
	AuthorDAO dao3;
	@Autowired
	SubjectDAO dao4;
	@GetMapping("/Register")
	public Messagedto Register(@RequestParam("username") String name, @RequestParam("mailId") String mail,
			@RequestParam("password") String pass, @RequestParam("cpassword") String cpass,
			@RequestParam("phNo") long phno) {
		Messagedto msg = new Messagedto();
		Users u = new Users();
		u.setUserName(name);
		u.setUserMailId(mail);
		u.setSetPassword(pass);
		u.setConfirmPassword(cpass);
		u.setPhNo(phno);
		
		int v = 0;
		try {
			v = dao.save(u);
		} catch (DBException e) {
			e.printStackTrace();
		}
		if (v == 1) {
			msg.setInfoMessage("Registered Successfully!!");
		} else {
			msg.setErrorMessage("Registration Failed");
		}
		System.out.println(msg);
		return msg;

	}

	@GetMapping("/displayUsers")
	public List<Users> displayUsers() throws DBException {

		List<Users> user = null;
		try {
			user = dao.findAll();
		} catch (DBException e) {
			throw new DBException("Unable to Select User");
		}
		return user;
	}

	@GetMapping("/displayTitles")
	public List<Title> displayTitles() throws DBException {
		List<Title> title = null;
		try {
			title = dao1.findAll();
		} catch (DBException e) {
			throw new DBException("Unable to Select Titles");
		}
		return title;
	}

	@GetMapping("/displayTitleForCourseId")
	public List<Title> displayTitleForCourseId(@RequestParam("courseId") int id) {
		List<Title> c = null;
		try {
			c = dao1.findByCourseId(id);
		} catch (DBException e) {

			e.printStackTrace();
		}
		return c;
	}

	@GetMapping("/Login")
	public Messagedto Login(@RequestParam("mailId") String mail, @RequestParam("password") String pass) {
		Messagedto m = new Messagedto();
		boolean msg = false;
		Users u = new Users();
		u.setUserMailId(mail);
		u.setSetPassword(pass);
		try {
			msg = dao.login(u);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (msg) {
			m.setInfoMessage("Login Successful");
		} else {
			m.setErrorMessage("Login not Successful Try Again!!");
		}
		return m;

	}

	@GetMapping("/viewPublishers")
	public List<Publisher> viewPublishers() throws DBException {
		List<Publisher> p = dao2.findAll();
		return p;

	}

	@GetMapping("/viewAuthors")
	public List<Author> viewAuthors() throws DBException {
		List<Author> a = dao3.findAll();
		return a;
	}

	@GetMapping("/viewSubject")
	public List<Subject> viewSubject() {
		List<Subject> s = null;
		try {
			s = dao4.findAll();
		} catch (DBException e) {

			e.printStackTrace();
		}
		return s;
	}

	@GetMapping("/recentBooks")
	public List<Title> recentBooks() {
		List<Title> r = null;
		try {
			r = dao1.findRecentBooks();
		} catch (DBException e) {

			e.printStackTrace();
		}
		return r;
	}

	@GetMapping("/displayBooksYearwise")
	public List<Title> displayBooksYearwise(@RequestParam("date") String pubDate) {
		LocalDate d = LocalDate.parse(pubDate);
		List<Title> r = null;
		try {
			r = dao1.findByYear(d);
		} catch (DBException e) {

			e.printStackTrace();
		}
		return r;
	}

}
