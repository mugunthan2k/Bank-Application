<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.IOException"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank/View Account</title>
<style >
  body {
    margin: 0;
    font-family: Arial, sans-serif;
  }
  .navbar {
    background-color: purple;
    overflow: hidden;
    display: flex;
    justify-content:space-around;
  }
  .navbar a {
   
    color: white;
    text-align: center;
    padding: 14px 20px;
    text-decoration: none;
  }
  .navbar a:hover {
    background-color: #ddd;
    color: black;
  }
  .form
  {
  position: relative;
  left: 400px;
  
  }
  input {
	height: 30px;
	width: 400px;
	font-size: 15px;
}
input[type="submit"]
{
	background-color: purple;
	color: white;
	width: 200px;
	margin-top: 15px;
}
h3 a
{
 text-decoration: none;
 text-align: center;
 background-color:purple;
 padding: 10px;
 color:white;
}
h3 a:hover {
	border: 2px solid purple;
	background-color: white;
	color: purple;
}
.table
{
	
	margin: 20px 0px 0px 350px;
	
}
</style>
</head>
<body> 
<% 
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Rajaram");
PreparedStatement	pe=con.prepareStatement("select * from account ");
		ResultSet  re=pe.executeQuery();
%>

<div class="navbar">
	<a href="homepage.html">Home</a>
  <a href="adminpage.html">Add Account</a>
  <a href="viewAccount.html">View Account</a>
  <a href="#">View All Account</a>
  <a href="#">Perform Transation</a>
</div>
<div class="table">
<table border="2px" cellpadding="30px" style="border-collapse: collapse;"  >
<thead>
	<tr>
	<th>Id</th>
	<th>Account Number</th>
	<th>Name</th>
	<th>Balance</th>
	<th>Phone NO</th>
	</tr>
</thead>
<tbody>
<% while(re.next()) {%>
<tr>
<td><%= re.getInt(1) %></td>
<td><%= re.getLong(2) %></td>
<td><%= re.getString(3) %></td>
<td><%= re.getInt(4) %></td>
<td><%= re.getLong(5) %></td>
</tr>
<%} %>
</tbody>
</table>
</div>

</body>
</html>