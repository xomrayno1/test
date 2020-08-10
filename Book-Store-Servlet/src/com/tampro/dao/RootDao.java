package com.tampro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class RootDao {
	
	private final static String URL = "jdbc:mysql://localhost:3306/book-store";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "";
	
	public static Connection getConnection()  {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return connection;
	}
	public static void main(String[] args)  {
		System.out.println(getConnection());
	}

}
