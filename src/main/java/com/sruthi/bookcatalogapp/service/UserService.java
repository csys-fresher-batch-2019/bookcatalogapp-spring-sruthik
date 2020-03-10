package com.sruthi.bookcatalogapp.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sruthi.bookcatalogapp.dao.UserDAO;
import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.exception.DBException;
import com.sruthi.bookcatalogapp.exception.ServiceException;
import com.sruthi.bookcatalogapp.exception.ValidatorException;
import com.sruthi.bookcatalogapp.factory.DAOFactory;
import com.sruthi.bookcatalogapp.util.ConnectionUtil;
import com.sruthi.bookcatalogapp.validator.Validator;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
//	private UserService () {
//	    throw new IllegalStateException("Utility class");
//	  }
public static void registration(Users user) throws ServiceException {
	UserDAO dao = DAOFactory.getUserDAO();
		try {
			Validator.validateRegisterForm(user);
			dao.save(user);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
		}
}
	public static boolean login(Users user) {
		boolean result = false;
		try(Connection con = ConnectionUtil.getConnection();CallableStatement stmt=con.prepareCall("{call login_procedure(?,?,?)}")) {
			stmt.setString(1,user.getUserMailId());
			stmt.setString(2, user.getSetPassword());
			stmt.registerOutParameter(3, Types.VARCHAR);
			int executeUpdate = stmt.executeUpdate();
			System.out.println("call:" + executeUpdate);
			String status=stmt.getString(3);
			System.out.println(status);
			if(status.equals("Login successful")) {
			
			logger.debug("Logged In");
			result =  true;
             }
			else {
				logger.debug("Logged out");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getMessage());
			
		}
		return result;
	}
	
	
}
