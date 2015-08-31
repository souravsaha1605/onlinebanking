<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.model.Transaction" %>
    <%@ page import="java.util.List" %>
   <%--  <%@ include file="Back.jsp" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<h3 align="right"><a href="LogOut">LogOut</a></h3>
<center>
<table>
<tr><th>
<form action="View Transaction.html">

<input type="submit" value="Transaction Deatils"/>
</form>
</th>
<th>

<form action="Transfer.html">

<input type="submit" value="Transfer money"/>

</form>
</th>
<th>
<form action="ViewAccounts" method="post" >
 <input type="submit" value="View Accounts"/>
 </form> 
 </th>
</tr>
</table>

</center>

</body>
</html>