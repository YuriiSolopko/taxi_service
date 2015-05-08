<%--
  Created by IntelliJ IDEA.
  User: Jura
  Date: 09.04.2015
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="/css/styleReg.css"/>
    <script src="/js/pass.js"></script>
</head>
<body>
<div id="main">
    <span class="error"><c:out value="${regmessage}"/></span>
    <form action="/registration.html" method="post" onsubmit="return registerCheck()">
        <span class="label">Enter login:</span>
        <input type="text" name="login" id = "login"/>
        <span id="loginSpan" class="error"></span>
        <br/>
        <span class="label">Enter password</span>
        <input type="password" name="password" id = "password"/>
        <span id="passwordSpan" class="error"></span>
        <br/>
        <span class="label">Confirm password</span>
        <input type="password" name="confirmPass" id = "confirmPass"/>
        <span id="confirmPassSpan" class="error"></span>
        <br/>
        <span class="label">Enter ID</span>
        <input type="text" name="id" id = "id"/>
        <span id="idSpan" class="error"></span>
        <br/>
        <input type="submit" value="submit"/>
    </form>
</div>
</body>
</html>
