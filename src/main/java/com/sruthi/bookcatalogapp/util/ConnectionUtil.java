package com.sruthi.bookcatalogapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String server = "localhost";
		String username = "system";
		String password = "oracle";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				throw new ClassNotFoundException(e.getMessage());
			}
	
		return DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", username, password);
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println(getConnection());
	}

}
