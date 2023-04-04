<%-- 
    Document   : loginHome
    Created on : Apr 3, 2023, 4:20:38 PM
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
        <h1>Welcome to the Admin Home Page</h1>
        <a href="addNewEmployee.htm"><button>Add New Employee</button></a>
        <a href="changeAdminCredentials.htm"><button>Change Admin Credentials</button></a>
        <a href="deleteEmployee.htm"><button>Delete Employee</button></a>
        
        <form method="POST" action="search_packages">
            <input type="text" id="searchPackage" name="package" required><br>
            <input type="radio" id="packageID" name="type" value="packageID">
            <label for="packageID">Package ID</label><br>
            <input type="radio" id="name" name="type" value="name">
            <label for="name">Name</label><br>
            <label for="start_date">Start Date:</label>
            <input type="date" id="start_date" name="start_date" required><br>
            <label for="end_date">End Date:</label>
            <input type="date" id="end_date" name="end_date" required><br>
            <button type="submit">Search</button>
        </form>
    </body>
</html>
