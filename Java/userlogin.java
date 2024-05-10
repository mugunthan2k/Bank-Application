package com.jdbc.bank;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;
@WebServlet("/ulog")
public class userlogin  extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("username");
		String pin=req.getParameter("pin");
		
	try {
		PreparedStatement pr=	database.data().prepareStatement("select * from account where aname=? and pincode=?");
		pr.setString(1, name);
		pr.setInt(2, Integer.parseInt(pin));
		ResultSet re=pr.executeQuery();
		if(re.next())
		{
		RequestDispatcher rd=req.getRequestDispatcher("send.html");
		rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("userlogin.html");
			rd.forward(req, resp);
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
