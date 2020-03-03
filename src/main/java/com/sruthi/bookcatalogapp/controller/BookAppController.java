package com.sruthi.bookcatalogapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sruthi.bookcatalogapp.dao.TitleDAO;
import com.sruthi.bookcatalogapp.dao.UserDAO;
import com.sruthi.bookcatalogapp.domain.Title;
import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.dto.Messagedto;



@RestController
@RequestMapping("api")
public class BookAppController {
	@Autowired
	UserDAO dao;
	@Autowired
	TitleDAO dao1;// = DAOFactory.getTitleDAO();
	
	@GetMapping("/Register")
	
	public Messagedto Register(@RequestParam("username") String name,@RequestParam("mailId") String mail,@RequestParam("password") String pass,@RequestParam("cpassword") String cpass,@RequestParam("phNo") long phno) {
		Messagedto msg = new Messagedto();
		Users u = new Users();
		u.setUserName(name);
		u.setUserMailId(mail);
		u.setSetPassword(pass);
		u.setConfirmPassword(cpass);
		u.setPhNo(phno);
			
			 int v = dao.addUser(u);
			 if(v == 1) {
				 msg.setInfoMessage("Registered Successfully!!");
			 }
			 else
			 {
				 msg.setErrorMessage("Registration Failed");
			 }
				 
	
		return msg;
	         
}
	@GetMapping("/displayUsers")
	public List<Users> displayUsers(){
		
		List<Users> user = dao.displayUsers();
		return user;
	}
	@GetMapping("/displayTitles")
	public List<Title> displayTitles(){
		List<Title> title = dao1.displayTitleWithPrice();
		return title;
	}
	@GetMapping("/displayTitleForCourseId")
	public List<Title> displayTitleForCourseId(@RequestParam("courseId") int id){
		List<Title> c = dao1.displayTitleForCourseId(id);
		return c;
	}
	public Messagedto AddPublisher(@RequestParam("name") String pname,@RequestParam("mail") String pmail,@RequestParam("phno") String pphno) {
		Messagedto msg = new Messagedto();
		return msg;
	  
	}
}
