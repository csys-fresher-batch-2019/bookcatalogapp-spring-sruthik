package com.sruthi.bookcatalogapp.factory;

import org.springframework.stereotype.Component;

import com.sruthi.bookcatalogapp.dao.AuthorDAO;
import com.sruthi.bookcatalogapp.dao.CourseTitleDAO;
import com.sruthi.bookcatalogapp.dao.PublisherDAO;
import com.sruthi.bookcatalogapp.dao.SubjectDAO;
import com.sruthi.bookcatalogapp.dao.TitleDAO;
import com.sruthi.bookcatalogapp.dao.UserDAO;
import com.sruthi.bookcatalogapp.dao.impl.AuthorImpl;
import com.sruthi.bookcatalogapp.dao.impl.CourseTitleImpl;
import com.sruthi.bookcatalogapp.dao.impl.PublisherImpl;
import com.sruthi.bookcatalogapp.dao.impl.SubjectImpl;
import com.sruthi.bookcatalogapp.dao.impl.TitleImpl;
import com.sruthi.bookcatalogapp.dao.impl.UserImpl;
@Component
public class DAOFactory {
//	private DAOFactory() {
//	    throw new IllegalStateException("Utility class");
//	  }
	
	public static AuthorDAO getAuthorDAO() {
	return new AuthorImpl();
	}
	public static PublisherDAO getPublisherDAO() {
		
		return new PublisherImpl();
		}
	public static SubjectDAO getSubjectDAO() {
		
		return new SubjectImpl();
		}
	public static TitleDAO getTitleDAO() {
		
		return new TitleImpl();
		}
	public static CourseTitleDAO getCourseTitleDAO() {
		
		return new CourseTitleImpl();
		}
	public static UserDAO getUserDAO() {
		
		return new UserImpl();
		}
	

}
