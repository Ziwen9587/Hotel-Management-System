<%--
  Created by IntelliJ IDEA.
  User: osbornwang
  Date: 2021-04-01
  Time: 11:50 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CSI2132_HotelManagementProject_LoginManager</title>
</head>
<body>
<p>Welcome, dear Employee <br><br> <%=session.getAttribute("show_customerList")%> !<p>
</body>
</html>
