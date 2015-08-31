<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.model.Transaction" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Transaction transac=(Transaction)request.getAttribute("dwKey");
%>
<%="Successful "+transac.getMode()+"of Rupees"+transac.getBalance() %>

<form action="Depost&wthdraw.html">
<input type ="submit" value="OK"/>

</form>
</body>
</html>