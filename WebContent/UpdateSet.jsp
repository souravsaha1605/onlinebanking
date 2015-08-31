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
<%Customer cstmr=(Customer)request.getAttribute("updateKey") ;%>
<%String acNo=cstmr.getAcNo();
String mobNo=cstmr.getMobNo();
String update=cstmr.getUpdate();
%>

<form action="UpdateSet" method="get">
Account No.<input type="text" name="acNo" value=<%=acNo %> readonly="readonly"/>

Mobile no.<input type="text" name="mobNo" value= <%=mobNo %> readonly="readonly" />
<%=update %><input type="text" name="<%=update %>"  />
<input type="submit" value="submit">
</form>
</body>
</html>