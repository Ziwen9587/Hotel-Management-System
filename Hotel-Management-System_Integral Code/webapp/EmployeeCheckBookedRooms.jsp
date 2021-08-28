<%@ page import="Database_Access_Object.Rooms" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Database_Access_Object.BookingInfo" %>
<%--
  Created by IntelliJ IDEA.
  User: osbornwang
  Date: 2021-04-02
  Time: 4:56 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SI2132_HotelManagementProject_EmployeeCheckBookedRooms</title>
</head>
<body>
<br/>
<br/>
<h4>Room Status Transfer Tool:</h4>
<p>Please enter the info below:<p>
<form action = "Employee-Transfer-Booked-Rooms" method = "post">             <%-- pass form to new URL--%>
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
<h4>1. Please have the booked rooms lists below</h4>
<ol>
    <% ArrayList<Rooms> bookedRoomList = (ArrayList<Rooms>) session.getAttribute("booked_room_list");
        for (int i = 0; i < bookedRoomList.size(); i++){%>
    <li><%=bookedRoomList.get(i)%></li>
    <br>
    <%}%>
</ol>

<h4>2. Please have the related booking information lists below</h4>
<ol>
    <% ArrayList<BookingInfo> bookingInfoList = (ArrayList<BookingInfo>) session.getAttribute("booking_info_list");
        for (int i = 0; i < bookingInfoList.size(); i++){%>
    <li><%=bookingInfoList.get(i)%></li>
    <br>
    <%}%>
</ol>


</body>
</html>
