<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page import="java.sql.*" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.io.*" %>

<%
String id=request.getParameter("id");
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "form";
String userid = "root";
String password = "Sat@12345";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="home.css">
</head>
<body>

<form method="post">
  <div class="banner">
    <div class="nav">
    <img src="Admin-icon.png" class="logo">
    <div class="search">
    <input class="srch" type="search" name="">
    <a href="name=?"><button class="btn">Search</button></a>
   </div>
     
  <ul>
   <li class="active"><a href="home.jsp">Home</a></li>
   <li><a href="login.jsp">Insert</a></li>
   <li><a href="select.jsp">Update</a></li>
   <li><a href="delete2.jsp">Delete</a></li>
   <li><a href="#">Close</a></li>
   </ul>
   </div>
   
 <div class="tables">
 
  <table align="center">
<tr>
 
<th><b>User Name</b></th>
<th><b>Phone Number</b></th>
  <th><b>Password</b></th>
  <th><b>Message</b></th>
  <th><b>Id</b></th>
</tr>
<%
try{
con = DriverManager.getConnection(connectionUrl+database, userid, password);
stmt=con.createStatement();
String sql ="select * from logic";
rs = stmt.executeQuery(sql);
while(rs.next()){

	  %>
   <tr>
   <td><%=rs.getString("Name")%></td>
   <td><%=rs.getString("Number")%></td>
  <td><%=rs.getString("Password")%></td>
  <td><%=rs.getString("Message")%></td>
   <td><%=rs.getString("id")%></td>
  </tr>
  
<% 
  }con.close();
  }
catch(Exception e){
	e.printStackTrace();
}
 %>
  </table>
 </div>
  </div>

</form>   
</body>
</html>