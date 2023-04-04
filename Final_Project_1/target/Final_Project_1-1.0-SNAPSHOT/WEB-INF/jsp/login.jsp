<%-- 
    Document   : login
    Created on : Apr 3, 2023, 4:05:46 PM
    Author     : sparshramchandani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="process_login.htm">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <br>
            <input type="radio" id="employee" name="role" value="employee">
            <label for="employee">Employee</label>
            <br>
            <input type="radio" id="admin" name="role" value="admin">
            <label for="admin">Admin</label>
            <br>
            <button type="submit">Login</button>
        </form>

    </body>
</html>
