package com.sruthi.bookcatalogapp.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.util.ConnectionUtil;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
//	private UserService () {
//	    throw new IllegalStateException("Utility class");
//	  }
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