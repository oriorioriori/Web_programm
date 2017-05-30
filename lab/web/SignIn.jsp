<%--
  Created by IntelliJ IDEA.
  User: Arina
  Date: 28.05.2017
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Sign in</h1>
<form action="SignIn" method = "POST">
    <p>
        <input type="text" id = "Login" name ="Login"><label for="Login">Login</label>
    </p>
    <p>
        <input type="text" id = "Password" name ="Password"><label for="Password">Password</label>
    </p>
    <p><input name="Role" type="radio" value="user" checked>User</p>
    <p><input name="Role" type="radio" value="admin">Admin</p>
    <input type = "submit"/>
</form>
<a href = "http://localhost:8080/MainServlet">Sign up a new user</a>
</body>
