<%--
  Created by IntelliJ IDEA.
  User: Jura
  Date: 10.04.2015
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register client</title>
    <link rel="stylesheet" href="/css/styleReg.css"/>
</head>
<body>
<div id="main">
    Operator: <c:out value="${operator.login}"/>
    <c:out value="${clientMessage}"/>
    <form action="/registrationClient.html" method="post">

        <span class = "label">Enter name</span>
        <input type="text" name="clientName" id="clientName"/>
        <br/>
        <span class = "label">Enter surname</span>
        <input type="text" name="clientSurname" id="clientSurname"/>
        <br/>
        <span class = "label">Enter phone nmbr</span>
        <input type="text" name="clientPhone" id="clientPhone"/>
        <br/>
        <span class = "label">Enter address</span>
        <input type="text" name="clientAddress" id="clientAddress"/>
        <br/>
        <input type="submit" value="submit"/>

    </form>
    <a href="/dashboard.html">back</a>
</div>
</body>
</html>
