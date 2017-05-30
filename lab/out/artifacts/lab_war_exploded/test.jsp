<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 18.03.2017
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
    <form action = "MainServlet" method = "POST" onsubmit="validate(this); return false;">
        <h1>Registration</h1>
        <p>
            <input name = "Login" type = "text" id="nameInput"/>
            <label>Login</label>
        </p>
        <p>
            <input name = "Password" type = "text" id="passwordInput"/>
            <label>Password</label>
        </p>
        <p><input name="Role" type="radio" value="user" checked>User</p>
        <p><input name="Role" type="radio" value="admin">Admin</p>
        <input name = "registration" type = "submit"/><br><br>
        <a href = "http://localhost:8080/MainServlet/SignIn">Sign in</a>
    </form>
</body>
<script>
    alert('<%=request.getAttribute("title")%>');

    function validate(form) {
        var inputName = document.getElementById("nameInput");
        var inputPassword = document.getElementById("passwordInput");
        console.log(event);
        if (inputName.value == '' || inputPassword.value == '') {
            event.stopPropagation(true);
            event.preventDefault();
            alert("Error: Empty field");
            return false;
        }

        var regName = /^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$/; //Имя пользователя (с ограничением 2-20 символов, которыми могут быть буквы и цифры, первый символ обязательно буква)
        var regPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$/; //Пароль (Строчные и прописные латинские буквы, цифры)

        if (!regName.test(inputName.value) || !regPassword.test(inputPassword.value)){
            event.stopPropagation(true);
            event.preventDefault();
            alert("Error: Incorrect name or password field");
            return false;
        } else form.submit();
    }
</script>
</html>
