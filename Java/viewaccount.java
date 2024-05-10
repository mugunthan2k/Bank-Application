package com.jdbc.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vaccount")
public class viewaccount extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String Account=req.getParameter("vanum");
	String id=req.getParameter("vid");
	String name=req.getParameter("vname");
	try {
	PreparedStatement	pe = database.data() .prepareStatement("select * from account where id=? and anumber=? and aname=?");
		pe.setInt(1,(int)Integer.parseInt(id));
		pe.setLong(2,Long.parseLong(Account));
		pe.setString(3, name);
	ResultSet rs=pe.executeQuery();
		
		if(rs.next())
		{
			PrintWriter pt=resp.getWriter();
			pt.println("<h1>Name:-</h1><h2>"+rs.getString("aname")+"</h2>");
			pt.println("<h1>Account number:-</h1><h2>"+rs.getString("anumber")+"</h2>");
			pt.println("<h1>Balance:-</h1><h2>"+rs.getString("balance")+"</h2>");
			pt.println("<h1>Mobile number:-</h1><span>"+rs.getString("mnumber")+"</span>");
			
		}
		else
		{
		PrintWriter pr	=resp.getWriter();
		pr.print("<h1 style=\"text-align: center;position: absolute;top: 120px;left:500px\">Enter correct detaile</h1>");
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}
