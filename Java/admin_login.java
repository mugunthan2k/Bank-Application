package com.jdbc.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ulogin")
public class admin_login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("username");
		String pin=req.getParameter("pin");
		
		try {
			PreparedStatement	pe = database.data() .prepareStatement("select * from account ");
		} catch (ClassNotFoundException | SQLException e) {
			PrintWriter print=resp.getWriter();
			print.print("Enter correct detailes");
		}
		
	}
	

}
