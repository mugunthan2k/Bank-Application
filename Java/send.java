package com.jdbc.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mon")
public class send extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ac=req.getParameter("rac");
		String name=req.getParameter("rname");
		String amount=req.getParameter("money");
		String pin=req.getParameter("pin");
		
		try {
			
			PreparedStatement pr2=database.data().prepareStatement("select * from account where pincode=?");
			pr2.setInt(1, Integer.parseInt(pin));
			ResultSet rs2=	pr2.executeQuery();
		if(rs2.next())
		{
			PreparedStatement pr1=database.data().prepareStatement("select * from account where anumber=?");
			pr1.setLong(1, Long.parseLong(ac));
			ResultSet rs1=	pr1.executeQuery();
			if(rs1.next())
			{
				int debit=rs2.getInt("balance");
				int credit=rs1.getInt("balance");
				//debit
				PreparedStatement pr3=database.data().prepareStatement("update account set balance=? where pincode=?");
				pr3.setInt(1, debit-Integer.parseInt(amount));
				pr3.setInt(2, Integer.parseInt(pin));
				pr3.execute();
				//credit
				PreparedStatement pr4=database.data().prepareStatement("update account set balance=? where anumber=?");
				pr3.setInt(1, Integer.parseInt(amount)+credit);
				pr3.setLong(2,Long.parseLong(ac));
				pr3.execute();
			}
			else
			{
				PrintWriter pt=resp.getWriter();
				pt.print("<h2>Enter Account Number</h2>");
				RequestDispatcher re=req.getRequestDispatcher("send.html");
				re.include(req, resp);
			}
			
		}
		else
		{
			PrintWriter pt=resp.getWriter();
			pt.print("<h2>Enter correct pin</h2>");
			RequestDispatcher re=req.getRequestDispatcher("send.html");
			re.include(req, resp);
		}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
