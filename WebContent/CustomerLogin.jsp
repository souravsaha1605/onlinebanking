<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--     <%@ include file="Back.jsp" %>
 --%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <script src='http://stevemorse.org/selection.js'></script>
    <script>
      function Keycap(letter) {
        if (letter == '') {
          document.write('<td>&nbsp;</td>')
        } else {
            document.write('<td><div align="center">' +
                            '&nbsp;<a href="javascript:Insert(\'' + letter + '\');"><span style="font-size:100%">' + letter + '</span></a>&nbsp;' +
                            '</div></td>');
        }
      }

      function StartTable() {
        document.write
          ('<table borderColor="#000000" align="center"' +
           ' cellSpacing="1" cellPadding="0" border="2" bgColor="#ffcc99"><tr>')
      }

      function EndTable() {
        document.write('</tr></table>')
      }

      function NextRow() {
        document.write('</tr><tr>')
      }

      var selectedField = '';

      function Insert(letter) {
        if (selectedField == '') {
          alert('You need to select (click in) one of the allowable fields before you can use this keyboard.');
          return;
        }
        var myText = selectedField.value;
        var leftPos = getSelectionStart(selectedField);
        var rightPos = getSelectionEnd(selectedField);
        myText = myText.substring(0,leftPos) + letter + myText.substring(rightPos, myText.length);
        selectedField.value = myText;
        setSelectionRange(selectedField, leftPos+1, leftPos+1);
        selectedField.focus();
      }
    </script>
    <CENTER><h1>ONLINE BANKING</h1></CENTER>
    
  </head>
  <body >
  <link rel="stylesheet" href="layout.css"title="style1"media="screen">
<h2>LOGIN </h2>
<div id="menu" style="background-color:#FFD700;height:300px;width:600px;float:right;">
<center>
      To enter text with this virtual keybord,<br> select a field and then click on the characters you want<br>
    </center>
    <script>
      StartTable();
      Keycap('Q');
      Keycap('W');
      Keycap('E');
      Keycap('R');
      Keycap('T');
      Keycap('Y');
      Keycap('U');
      Keycap('I');
      Keycap('O');
      Keycap('P');
      NextRow();
      Keycap('A');
      Keycap('S');
      Keycap('D');
      Keycap('F');
      Keycap('G');
      Keycap('H');
      Keycap('J');
      Keycap('K');
      Keycap('L');
      Keycap('');
      NextRow();
      Keycap('Z');
      Keycap('X');
      Keycap('C');
      Keycap('V');
      Keycap('B');
      Keycap('N');
      Keycap('M');
	  NextRow()
      Keycap('7');
      Keycap('8');
      Keycap('9');
	  NextRow()
	  Keycap('4');
	  Keycap('5');
	  Keycap('6');
	  NextRow()
	  Keycap('1');
	  Keycap('2');
	  Keycap('3');
	  NextRow()
	  Keycap('0');
	  
      EndTable();
    </script>
    <br>
</div>
<br><br>
<a href="AdminLogin.html"> Admin Login</a>
    <P>
    
   <%String message=(String)request.getAttribute("msg");
    %>
    <%if(message!=null)
    {%><%=message %><%} %>
   <TABLE>
   <form action="ChkCustomerLogin " method="post"  name="f"   >
   <tr><td>
    UserId</td><td> <input TYPE="text" name="uId" onfocus='selectedField=this;' dir='ltr'><br></td></tr>
    <tr><td>Password</td> <td><input type="text" name="pwd" onfocus='selectedField=this;' dir='ltr'></td></tr><br>
    <tr><td></td><td><input type="submit" name="submit" value="submit"></td></tr>
    </form>
    </TABLE>
    	
    </P>
    <div id="footer" style="background-color: ;clear:both;text-align:center;">
<h2>BE ALERT</h2>
<img alt="ALERT MESSAGE" src="flashbannernew3.jpg" width="900" height="400">
</div>
  </body>
</html>
