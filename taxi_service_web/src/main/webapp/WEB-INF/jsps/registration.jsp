<%--
  Created by IntelliJ IDEA.
  User: Jura
  Date: 17.04.2015
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="/css/registration.css"/>
    <script src="/js/jquery-1.11.2.min.js"></script>
    <script src="/js/registration.js"></script>
</head>
<body>
<div id="main">

    <div id="menu">
    <div class="menuButton" onclick="voterReg()">
        Регистрация избирателя
    </div>
    <div class="menuButton" onclick="candidateReg()">
        Регистрация кандидата
    </div>
    <div class="menuButton" onclick="regionReg()">
        Добавить регион
    </div>
    </div>

    <div id="form">
    </div>

</div>
</body>
</html>
