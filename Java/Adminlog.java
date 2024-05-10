package com.jdbc.bank;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/adminlogin")
public class Adminlog extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String mail=req.getParameter("amail");
	String pass=req.getParameter("apass");
	//data base connection
	try {
		Connection con=database.data();
		PreparedStatement pr=con.prepareStatement("select * from admin where email=? and password=?");
		pr.setString(1, mail);
		pr.setString(2, pass);
		
	ResultSet rs=pr.executeQuery();
	if(rs.next())
	{
	RequestDispatcher re=req.getRequestDispatcher("adminpage.html");
	re.forward(req, resp);
	}
	else
	{
		PrintWriter pe=resp.getWriter();
		pe.print("<h1> enter correct email id and password</h1>");
	}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
