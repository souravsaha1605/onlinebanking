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
<%Customer cstmrObj =(Customer)request.getAttribute("cstmrKey"); %>    
<%="Verify the following details :" %>
<%=cstmrObj.getName() %>
<%=cstmrObj.getAcNo() %>
<%=cstmrObj.getUserId() %>
<%=cstmrObj.getPassword() %>



<form action="InsertDetails" method="post" >
<input type ="submit" name ="create" value ="create"/>
</form>
<form action="AdminRegis.html" >
<input type ="submit" name="cancel" value="cancel"/>
</form>
</body>
</html>