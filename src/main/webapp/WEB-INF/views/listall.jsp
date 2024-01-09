<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<h2>all registration here</h2>
<table border="1">
<tr>

<th>name</th>
<th>city</th>
<th>mobile</th>
<th>email</th>
<th>delete</th>
<th>update</th>
</tr>
<% 
  ResultSet result=(ResultSet)request.getAttribute("result");
  while(result.next()){%>
  
<tr>

<td><%=result.getString(1) %></td>
<td><%=result.getString(2) %></td>
<td><%=result.getString(3) %></td>
<td><%=result.getString(4) %></td>
<td> <a href="delete?email=<%=result.getString(4)%>">delete</a></td>
<td> <a href="update?email=<%=result.getString(4)%>&mobile=<%=result.getString(3)%>">update</a></td>

</tr>
<%}%>
</table>

</body>
</html>