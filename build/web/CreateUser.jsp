<%-- 
    Document   : newjsp
    Created on : 05-Jan-2019, 13:48:13
    Author     : louis
--%>

<%@page import="java.io.*"%>
<%@page import="Users.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@page import="Serverlets.*;" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>
    <body>
        <h1>Create User</h1>
        <form action="CreateUser" method="GET">
        <label>Firstname</label> <input name="FirstName" type="text"></input>
        <br><br>
        <label>Lastname</label> <input name="LastName" type="text"></input>
         <br><br>
        <label>Address</label> <input name="Address" type="text"></input>
        <br><br>
        <label>Gender</label> <input name="Gender" type="text"></input>
        <br><br>
        <label>Date of Birth</label> <input  name="Dateofbirth" type="date"></input>
        <br><br>
        <label>ID</label> <input name="ID" type="text"></input>
        <br><br>
        <label>Password</label> <input name="Password" type="text"></input>
        <br><br>
        <input type="submit"></input>
        </form>
        <br>
        <button><a href="login.jsp">Go to login</a></button>
    </body>
</html>
