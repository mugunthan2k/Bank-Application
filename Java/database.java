package com.jdbc.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class database
{
	public static Connection data() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Rajaram"); 
	}
}
