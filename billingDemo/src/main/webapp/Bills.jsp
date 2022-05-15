<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "test2";
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
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Bills</h1>
	<table>
		<thead>
			<tr>
				<th>Bill ID</th>
				<th>Customer Name</th>
				<th>Phone</th>
				<th>Units</th>
				<th>Bill</th>
				<th>Actions</th>
			</tr>
		</thead>
		
		<tbody>
			<%
				try{
					connection = DriverManager.getConnection(connectionUrl+database, userid, password);
					statement=connection.createStatement();
					String sql ="select * from bills";
					resultSet = statement.executeQuery(sql);
				while(resultSet.next()){
			%>
			<tr>
				<td><%=resultSet.getString("bid") %></td>
				<td><%=resultSet.getString("name") %></td>
				<td><%=resultSet.getString("phone") %></td>
				<td><%=resultSet.getString("units") %></td>
				<td><%=resultSet.getString("bill") %></td>
				<td><a href="update.jsp?id=<%=resultSet.getString("bid")%>">Update</a> | 
					<a href="delete.jsp?id=<%=resultSet.getString("bid")%>">Delete</a> 
				</td>
			</tr>
			<%
				}
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		</tbody>
	</table>
</body>
</html>