package com.sruthi.bookcatalogapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

import com.sruthi.bookcatalogapp.exception.DBException;

@Component

public class ConnectionUtil {
	
	public static Connection getConnection() throws DBException {
		String server = "localhost";
		String username = "system";
		String password = "oracle";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				return DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", username, password);
			} 
			 catch (ClassNotFoundException e) {
				throw new DBException(e.getMessage());
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
	
		
	}

	public static void main(String[] args) throws DBException{
		System.out.println(getConnection());
	}

}
