package com.jdbc.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class addaccount extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String id=req.getParameter("aid");
String name	=req.getParameter("aname");
String balance	=req.getParameter("abal");
String phno	=req.getParameter("anum");
PreparedStatement pe;
try {
	pe = database.data() .prepareStatement("insert into account values(?,?,?,?,?,?)");
	pe.setInt(1, Integer.parseInt(id));
	pe.setLong(2, genetor.acgenetor());
	pe.setString(3, name);
	pe.setDouble(4,Integer.parseInt(balance) );
	pe.setLong(5, Integer.parseInt(phno));
	pe.setInt(6, genetor.pingenetor());
	int num=pe.executeUpdate();
	if(num>0)
	{
	RequestDispatcher rs=req.getRequestDispatcher("adminpage.html");
	rs.forward(req, resp);
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
