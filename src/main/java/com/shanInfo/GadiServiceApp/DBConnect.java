package com.shanInfo.GadiServiceApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	static Connection con=null;
	public static Connection Connect() throws SQLException, ClassNotFoundException {
		System.out.println("LOADING JDBC......");
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcEx","root","root");
		 return con;
	}
}
