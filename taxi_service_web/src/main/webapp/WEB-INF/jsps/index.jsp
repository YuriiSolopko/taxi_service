<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 30.03.15
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Operator Authentication</title>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="/js/auth.js"></script>
</head>
<body>
<div id="main">
    <a href="/register.html">Register</a>
    <br/>
        <span class="label">Enter login: </span>
        <input type="text" name="login" id="login"/>
        <br/>
        <span class="label">Enter password: </span>
        <input type="password" name="password" id="password"/>
        <br/>
        <button id="submit" onclick="auth()">Enter</button>
    <br/>

    <span id="tries">

    </span>
    <br/>
    <div class="error" id="errorMessage">

    </div>

</div>
</body>
</html>
