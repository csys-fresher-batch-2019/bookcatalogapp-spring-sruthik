package com.sruthi.bookcatalogapp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.sruthi.bookcatalogapp.dao.UserDAO;
import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.exception.DBException;
import com.sruthi.bookcatalogapp.util.ConnectionUtil;

@Repository
public class UserImpl implements UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserImpl.class);
	@Override
	public List<Users> findAll() throws DBException {
		List<Users> list = new ArrayList<>();
		String sql = "Select user_name,user_mail_id,set_password,confirm_password,ph_no from Users";
		
	    try {
	    	Connection connection = ConnectionUtil.getConnection();
		    Statement stmt=connection.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String userName = rs.getString("user_name");
				String userMail = rs.getString("user_mail_id");
				String password = rs.getString("set_password");
				String cpassword = rs.getString("confirm_password");
				long phNo = rs.getLong("ph_no");
				Users user = new Users();
				user.setUserName(userName);
				user.setUserMailId(userMail);
				user.setSetPassword(password);
				user.setConfirmPassword(cpassword);
				user.setPhNo(phNo);
				logger.debug(userName+" "+userMail+" "+password+" "+cpassword);
				list.add(user);
				
			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to display User");
		}
		return list;
	}

	@Override
	public int save(Users user) throws DBException {
			int rows = 0;
			String sql = "insert into Users(user_name,user_mail_id,set_password,confirm_password,ph_no)values(?,?,?,?,?)";
			
			try(Connection connection =ConnectionUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql)) {
				pst.setString(1, user.getUserName());
				pst.setString(2, user.getUserMailId());
				pst.setString(3, user.getSetPassword());
				pst.setString(4, user.getConfirmPassword());
				pst.setLong(5, user.getPhNo());
				
				 rows = pst.executeUpdate();
				logger.info("No of rows inserted:"+rows);
			} catch (SQLException e) {
				logger.debug(e.getMessage());
				throw new DBException("Unable to add User");
			}
			return rows;
		}
	
	public boolean login(Users user) throws DBException {
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
			
			
			logger.error(e.getMessage());
			throw new DBException("Unable to add User");
			
		}
		return result;
	}
	
	}
	


