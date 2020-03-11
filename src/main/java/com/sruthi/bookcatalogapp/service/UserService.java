package com.sruthi.bookcatalogapp.service;


import org.springframework.stereotype.Service;

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
import com.sruthi.bookcatalogapp.exception.DBException;
import com.sruthi.bookcatalogapp.exception.ServiceException;
import com.sruthi.bookcatalogapp.exception.ValidatorException;
import com.sruthi.bookcatalogapp.factory.DAOFactory;
import com.sruthi.bookcatalogapp.validator.Validator;

@Service
public class UserService {

	public static void registration(Users user) throws ServiceException, DBException{
		UserDAO dao = DAOFactory.getUserDAO();
		try {
			Validator.validateRegisterForm(user);
			dao.save(user);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public static void addPublisher(Publisher p) throws ServiceException, DBException{
		PublisherDAO dao = DAOFactory.getPublisherDAO();
		try {
			Validator.validatePublisher(p);
			dao.save(p);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
	public static void addAuthor(Author a) throws ServiceException, DBException{
		AuthorDAO dao = DAOFactory.getAuthorDAO();
		try {
			Validator.validateAuthor(a);
			dao.save(a);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
	public static void addTitle(Title t) throws ServiceException, DBException{
		TitleDAO dao = DAOFactory.getTitleDAO();
		try {
			Validator.validateTitle(t);
			dao.save(t);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
	public static void addSubject(Subject s)throws ServiceException,DBException{
		SubjectDAO dao = DAOFactory.getSubjectDAO();
			dao.save(s);
	}

}
