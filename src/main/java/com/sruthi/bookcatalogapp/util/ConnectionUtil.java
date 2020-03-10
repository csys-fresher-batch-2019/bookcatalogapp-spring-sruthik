package com.sruthi.bookcatalogapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component

public class ConnectionUtil {
	// private ConnectionUtil() {
	// throw new IllegalStateException("Utility class");
	// }
	public static Connection getConnection() throws SQLException {

		String server = "localhost";
		String username = "system";
		String password = "oracle";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", username, password);
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}

}
