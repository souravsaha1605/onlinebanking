<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
session=request.getSession(false);
String user=(String)session.getAttribute("user");
if(user==null){
	request.setAttribute("msg", "Session Expired");
	RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
	rd.forward(request, response);
}
	
%>



<p align="right">
<form action="View Transaction.html">
<input type="submit" value="Transaction Deatils"/>
</form>
<br>

<form action="Transfer.html">

<input type="submit" value="Transfer money"/>

</form>


</body>
</html>