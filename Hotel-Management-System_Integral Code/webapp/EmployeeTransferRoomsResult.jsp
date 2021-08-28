<%@ page import="Database_Access_Object.Renting" %><%--
  Created by IntelliJ IDEA.
  User: osbornwang
  Date: 2021-04-03
  Time: 1:31 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SI2132_HotelManagementProject_EmployeeCheckBookedRooms_EmployeeTransferRoomsResult</title>
</head>
<body>
<h4>Transfer Successful!, related info is below</h4>
<br/>
<% Renting renting_result = (Renting) session.getAttribute("transfer_renting_result");%>
<%=renting_result%>
<br/>

</body>
</html>
