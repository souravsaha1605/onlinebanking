<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.model.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Customer cstmr=(Customer)request.getAttribute("UIdPassKey"); %>
<%="hello your account has been created :" %>
<table>
<tr><th>ACCOUNT NUMBER</th><th>PASSWORD</th></tr>
<tr><td><center><%=cstmr.getAcNo() %></center></td><td><%=cstmr.getPassword() %></td></tr>

</table>



</body>
</html>