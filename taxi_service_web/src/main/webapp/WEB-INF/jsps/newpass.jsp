<%--
  Created by IntelliJ IDEA.
  User: Jura
  Date: 08.04.2015
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Password change</title>
    <script src="/js/pass.js"></script>
    <link  rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<div id="main">
    Operator: <c:out value="${operator.login}"/>
    <br/>
    <c:out value="${newPassMessage}"/>
    <form action="/newpass.html" method="post" onsubmit="return newPassCheck('${operator.password}')">
        <span>Enter old password:</span>
        <input type="password" name="oldpass" id = "oldpass"/>
        <span id="oldPassSpan" class="error"></span>
        <br/>
        <span>Enter new password</span>
        <input type="password" name="newpass" id = "newpass"/>
        <span id="newPassSpan" class="error"></span>
        <br/>
        <span>Confirm new password</span>
        <input type="password" name="confnewpass" id = "confnewpass"/>
        <span id="confNewPassSpan" class="error"></span>
        <br/>
        <input type="submit" value="submit"/>
    </form>
</div>

</body>
</html>
