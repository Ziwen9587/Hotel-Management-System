<%--
  Created by IntelliJ IDEA.
  User: osbornwang
  Date: 2021-04-02
  Time: 4:29 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CSI2132_HotelManagementProject_EmployeeChoice</title>
</head>
<body>
<h3>Please select one option below</h3>
<br/>
<br/>
<form action = "Employee-Check-Booked-Rooms" method = "post">             <%-- pass form to new URL--%>
    <h4>Option.1: Check The Booked Rooms / Transfer Room Status</h4>
    -   Click The Button<button type="submit">Check and Transfer</button>
</form>
<br/>
<p>
    <%
        String message1 = (String) request.getAttribute("message1");
        if (message1 != null){%>
    <%=message1%>
    <% } %>
</p>
<br/>
<br/>
<form action = "Employee-Check-Available-Rooms" method = "post">             <%-- pass form to new URL--%>
    <h4>Option.2: Check The Available Rooms / Transfer Room Status</h4>
    - Please Enter The Checking Date: <input type = "text" name = "Checking_Date"> <br>
    - Click The Button: <button type="submit">Check Available Rooms</button>
</form>
<br/>
<p>
    <%
        String message2 = (String) request.getAttribute("message2");
        if (message2 != null){%>
    <%=message2%>
    <% } %>
</p>
</body>
</html>
