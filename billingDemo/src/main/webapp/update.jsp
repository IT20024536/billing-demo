<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String id = request.getParameter("id");
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "test";
	String userid = "root";
	String password = "";
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	%>
	<%
	try{
		connection = DriverManager.getConnection(connectionUrl+database, userid, password);
		statement=connection.createStatement();
		String sql ="select * from bills where bid=" + id;
		resultSet = statement.executeQuery(sql);
	while(resultSet.next()){
	%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Bill</title>
</head>
<body>
	<h1>Update data</h1>
	<form method="post" action="updateProcessServlet">
		<input type="hidden" name="bid" value="<%=resultSet.getString("bid") %>">
		<input type="text" name="bid" value="<%=resultSet.getString("bid") %>" disabled> <br>
		
		Customer Name<input type="text" name="name" value="<%=resultSet.getString("name") %>"><br>
		Phone number<input type="text" name="phone" value="<%=resultSet.getString("phone") %>"><br>
		Units<input type="text" name="units" id="units" value="<%=resultSet.getString("units") %>" disabled><br>
		Bill<input type="text" name="bill" id="bill" value="<%=resultSet.getString("bill") %>" disabled><br>
		
		<input type="submit" name="submit" value="Update">
	</form>
	
	<%
	}
		connection.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
</body>
</html>