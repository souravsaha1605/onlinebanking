<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.model.Transaction" %>
    <%@page import ="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table border =2 width=800>

<tr><th>Secondary Account</th><th>Amount Transferred(Rupees)</th><th>Mode</th><th>Date</th></tr>
<%List <Transaction> list =(List<Transaction>)request.getAttribute("viewKey");
for(Transaction transac: list)
{
%>


<tr><td><center><%=transac.getFrmAcNo() %></center></td><td><center><%=transac.getBalance() %></center></td><td><%=transac.getMode() %></td><td><%=transac.getDate() %></td>
</tr>

<%} %>

<tr><td></td><td><form action="CustomerHome.jsp">

<input type="submit" value="GO BACK">


</form>
</td></tr>
</table>
</center>


</body>
</html>