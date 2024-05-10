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

@WebServlet("/profile")
public class profileupdate extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String phon=req.getParameter("phone");
		String pin=req.getParameter("pin");
		
		
		try {
			PreparedStatement	pr1 = database.data().prepareStatement("select * from account where  pincode=?");
			pr1.setInt(1, Integer.parseInt(pin));
			ResultSet rs2=	pr1.executeQuery();
		if(rs2.next())
	{
	     
			PreparedStatement pr3=database.data().prepareStatement("update account set aname=? ,mnuber=? where pincode=?");
			pr3.setString(1,name);
			pr3.setLong(2, Long.parseLong(phon));
			pr3.setInt(3,Integer.parseInt(pin) );
			pr3.execute();
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	

}
