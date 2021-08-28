<%--
  Created by IntelliJ IDEA.
  User: osbornwang
  Date: 2021-04-01
  Time: 8:11 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CSI2132_HotelManagementProject_LoginCustomer</title>
</head>
<body>

<form action = "Customer-Search" method = "post">             <%-- pass form to new URL--%>
    <h4>Welcome, Dear Customer!</h4>
    <h4>Please use search tool below for room searching and booking</h4>
        <br/>
        <br/>
        Please Enter The City: <input type = "text" name = "City"> <br>
        <br/>
        Please Enter The Room Capacity: <input type = "text" name = "Room_Capacity"> <br>
        <br/>
        Please Enter The date: <input type = "text" name = "Date"> <br>
        <br/>
        <button type="submit">Confirm</button>
</form>
<%--Below is Show message after action above--%>
<p>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null){%>
    <%=message%>
    <% } %>
</p>

</body>
</html>

