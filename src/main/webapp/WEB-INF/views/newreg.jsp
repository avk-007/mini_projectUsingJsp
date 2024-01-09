<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New registration</title>
</head>
<body>
<h2>new registration here</h2>
<form action="savereg" method="post">

<pre>
name<input type="text" name="name"/>
city<input type="text" name="city"/>
mobile<input type="text" name="mobile"/>
email<input type="text" name="email"/>
</pre>
<input type="submit" value="save"/>




<%
if(request.getAttribute("msg")!=null){
out.println(request.getAttribute("msg"));
}
%>

</form>
</body>
</html>