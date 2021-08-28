<%@ page import="java.util.ArrayList" %>
<%@ page import="Database_Access_Object.Rooms" %><%--
  Created by IntelliJ IDEA.
  User: osbornwang
  Date: 2021-04-01
  Time: 9:12 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CustomerSearchRoomResult</title>
</head>
<body>
<form action = "Customer-End-Booking" method = "post">             <%-- pass form to new URL--%>
    <p>Please information below to book the room<p>
        <br/>
        Please Enter Your SIN: <input type = "text" name = "SIN"> <br>
        <br/>
        Please Enter The Street Number: <input type = "text" name = "Street_Number"> <br>
        <br/>
        Please Enter The Room Number: <input type = "text" name = "Room_Number"> <br>
        <br/>
        Please Enter Any Additional Comments: <input type = "text" name = "Additional_Comments"> <br>
        <br/>
        <button type="submit">Book The Room</button>
</form>
<br/>
<%
    String message = (String) request.getAttribute("message");
    if (message != null){%>
<%=message%>
<% } %>
<br/>
<br/>
<h4>Please review the available rooms below</h4>
<ol>
    <% ArrayList<Rooms> roomList = (ArrayList<Rooms>) session.getAttribute("show_roomList");
        for (int i = 0; i < roomList.size(); i++){%>
    <li><%=roomList.get(i)%></li>
    <br>
    <%}%>
</ol>

</body>
</html>
