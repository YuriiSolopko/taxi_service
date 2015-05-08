<%--
  Created by IntelliJ IDEA.
  User: al1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Голосование</title>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="/js/jquery-1.11.2.min.js"></script>
    <script src="/js/election.js"></script>
</head>
<body>
<div id="header">
    <a href="/registration.html">Регистрация</a>
</div>
<div id="form">
    <fieldset>
        <legend>Персональные данные:</legend>
        <div class="label">Имя</div>
        <input type="text" class="field" name="firstName" id="firstName"/>
        <div class="error" id="firstNameErr"></div>
        <br/>
        <div class="label">Фамилия</div>
        <input type="text" class="field" name="lastName" id="lastName"/>
        <div class="error" id="lastNameErr"></div>
        <br/>
        <div class="label">Отчество</div>
        <input type="text" class="field" name="patronymic" id="patronymic"/>
        <div class="error" id="patronymicErr"></div>
        <br/>
        <div class="label">Населенный пункт</div>
        <input type="text" class="field" name="place" id="place"/>
        <div class="error" id="placeErr"></div>
        <br/>
        <div class="label">Серия и номер паспорта</div>
        <input type="text" class="field" name="passportId" id="passportId"/>
        <div class="error" id="passportIdErr"></div>
        <br/>
        <button class="button" onclick="auth()">OK</button>
    </fieldset>
</div>
<div id="election">

</div>
</body>
</html>
