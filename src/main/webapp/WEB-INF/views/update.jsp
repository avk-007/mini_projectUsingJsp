<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
<h2>update</h2>
<form action="update" method="post">

<pre>

mobile<input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/>
email<input type="text" name="email"   value="<%=request.getAttribute("email")%>"/>
</pre>
<input type="submit" value="update"/>




<%
if(request.getAttribute("msg")!=null){
out.println(request.getAttribute("msg"));
}
%>

</form>
</body>
</html>