<%-- 
    Document   : home.jsp
    Created on : Apr 3, 2023, 3:47:50 PM
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
        
        <a href="login.htm"><button>Login</button></a>
        
        <form method="post" action="process_tracking_id.htm">
            <label for="tracking_id">Enter Tracking ID:</label>
            <input type="text" id="tracking_id" name="tracking_id" required>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
