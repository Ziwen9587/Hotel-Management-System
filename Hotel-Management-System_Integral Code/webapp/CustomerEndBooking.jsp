<%--
  Created by IntelliJ IDEA.
  User: osbornwang
  Date: 2021-04-01
  Time: 11:11 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String message = (String) request.getAttribute("message");
    if (message != null){%>
<%=message%>
<% } %>
<br/>
<form action = "Customer-Return-Search" method = "post">
    <h3>Booking Successful!</h3>
    <br/>
    <p>Go back to the room search tool<p>
        <br/>
        <button type="submit">Return</button>
</form>

</body>
</html>
