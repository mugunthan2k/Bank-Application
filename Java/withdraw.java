package com.jdbc.bank;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/with")
public class withdraw extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ac=req.getParameter("ac");
		String pin=req.getParameter("pin");
		String amount=req.getParameter("amount");
		
		
		try {
			PreparedStatement	pr1 = database.data().prepareStatement("select * from account where anumber=? and pincode=?");
			pr1.setLong(1, Long.parseLong(ac));
			pr1.setInt(2, Integer.parseInt(pin));
			ResultSet rs2=	pr1.executeQuery();
		if(rs2.next())
	{
	        int dedit=	rs2.getInt("balance");
			PreparedStatement pr3=database.data().prepareStatement("update account set balance=? where pincode=?");
			pr3.setInt(1, dedit-Integer.parseInt(amount));
			pr3.setInt(2, Integer.parseInt(pin));
			pr3.execute();
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
}