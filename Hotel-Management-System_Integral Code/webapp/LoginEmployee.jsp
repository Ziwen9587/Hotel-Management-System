<%@ page import="java.util.ArrayList" %>
<%@ page import="Database_Access_Object.Customers" %><%--
  Created by IntelliJ IDEA.
  User: osbornwang
  Date: 2021-04-01
  Time: 11:49 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CSI2132_HotelManagementProject_LoginEmployee</title>
</head>
<body>
<form action = "Employee-Login" method = "post">             <%-- pass form to new URL--%>
    <h3>Welcome, dear Employee!</h3>
    <h4>Please enter your information below to access hotel employee system.</h4>
        <br/>
        <br/>
        SIN: <input type = "text" name = "SIN"> <br>
        <br/>
        Hotel Address: <input type = "text" name = "Hotel_Address"> <br>
        <br/>
        <button type="submit">Confirm</button>
</form>
<%
    String message = (String) request.getAttribute("message");
    if (message != null){%>
<%=message%>
<% } %>

</body>
</html>
