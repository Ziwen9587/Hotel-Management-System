<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>CSI2132_HotelManagementProject</title>
</head>
<body>

<form action = "Login-HotelSystem" method = "post">
    <br/>
    <br/>
    <h3>Welcome to CSI2132 GROUP#19 Hotel Management System!</h3>
    <br/>
    <br/>
    <br/>
    <h4>Please Select Your Role Below:</h4>
    <br/>
    Customer<input type = "radio" name = "role" value = "customer"><br>
    <br/>
    Employee<input type = "radio" name = "role" value = "employee"><br>
    <br/>
    <button type="submit">Login</button>
    <br/>
</form>

<p>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null){%>
            <%=message%>
     <% } %>
</p>

</body>
</html>
