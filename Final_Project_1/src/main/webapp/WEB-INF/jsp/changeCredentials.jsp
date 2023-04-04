<%-- 
    Document   : changeCredentials
    Created on : Apr 3, 2023, 6:32:01 PM
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
        <form method="post" action="process_changeAdminCredentials.htm">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <br>
            <button type="submit" onclick="loginCredentialsChanged()">Submit</button>
        </form>

        <script>
            function loginCredentialsChanged() {
                alert("Admin Credentials Changed, Please login again!!!");
            }
        </script>
    </body>
</html>
