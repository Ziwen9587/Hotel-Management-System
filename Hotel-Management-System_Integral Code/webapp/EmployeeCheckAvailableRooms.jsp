<%@ page import="Database_Access_Object.Rooms" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: osbornwang
  Date: 2021-04-02
  Time: 7:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<br/>
<br/>
<h4>Room Status Transfer Tool:</h4>
<p>Please enter the info below:<p>
<form action = "Employee-Transfer-NonBooked-Rooms" method = "post">             <%-- pass form to new URL--%>
    <br/>
    Customer SIN: <input type = "text" name = "Customer_SIN"> <br>
    <br/>
    Room Number: <input type = "text" name = "Room_Number"> <br>
    <br/>
    Payment: <input type = "text" name = "Payment"> <br>
    <br/>
    Start Date: <input type = "text" name = "Start_Date"> <br>
    <br/>
    End Date: <input type = "text" name = "End_Date"> <br>
    <br/>
    <button type="submit">Confirm</button>

    <%
        String message1 = (String) request.getAttribute("message1");
        if (message1 != null){%>
    <%=message1%>
    <% } %>

</form>
<br/>
<br/>
<br/>
<h4>Please have the available rooms lists below</h4>

<ol>
    <% ArrayList<Rooms> availableRoomList = (ArrayList<Rooms>) session.getAttribute("available_room_list");
        for (int i = 0; i < availableRoomList.size(); i++){%>
    <li><%=availableRoomList.get(i)%></li>
    <br>
    <%}%>
</ol>
</body>
</html>
