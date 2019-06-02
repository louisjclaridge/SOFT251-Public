<%-- 
    Document   : login
    Created on : 06-Jan-2019, 18:27:56
    Author     : louis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <%@page import="Serverlets.*;" %>
        <title>JSP Page</title>
    </head>
    <body>
        <button style="float: right"><a href="login.jsp">Logout</a></button>
        <h1>Login</h1>
        <form action="Login" method="GET">
            <label>ID</label>
            <br>
        <input type="text" name="username"></input>
        <br>
         <label>Password</label>
         <br>
        <input type="password" name="password">
        <br>
        <input type="submit"></input>
        </form>
                <button><a href="CreateUser.jsp">Create user</a></button>
    </body>
</html>
