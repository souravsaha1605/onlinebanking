<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="DeleteControl" method="get">
Account No.<input type="text" name="acNo"/>
User Id<input type="text" name="uId" />
Mobile no.<input type="text" name="mobNo" />
<input type="submit" value="submit"/>
</form>
<%String message=(String)request.getAttribute("msg"); %>

<%if(message!=null)
    {%><%=message %><%} %>

</body>
</html>