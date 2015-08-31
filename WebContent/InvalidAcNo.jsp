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
<%="Transaction could not be completed" %>
<p/>
<%="Enter valid account number" %>
<p/>
<%
Transaction transac=(Transaction)request.getAttribute("trnsfrKey");%>
<br/>
<p/>
<%@ include file="Transfer.html" %>
<%="This account number"+transac.gettAcNo()+"is not valid" %>
<%

Transaction transacObj=(Transaction)request.getAttribute("dwKey");
if(transac.gettAcNo().equals("bank"))
{
%>
<%="The account number"+transac.gettAcNo()+"is invalid" %>
	<%
}

%>

</body>
</html>