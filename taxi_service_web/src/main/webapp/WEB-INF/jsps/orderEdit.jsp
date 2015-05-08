<%--
  Created by IntelliJ IDEA.
  User: Jura
  Date: 06.04.2015
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit order</title>
</head>
<body>
Operator: <c:out value="${operator.login}"/>
<br/>
<c:out value="${editOrderMessage}"/>

<form action="/orders.html/editSubmit" method="post">
    <table>
        <tr>
            <td align="left">Order ID</td>
            <td><input type="text" name = "orderId" contenteditable="false" value="${orderForEdit.orderId}"/></td>
        </tr>
        <tr>
            <td align="left">Enter client's phone nmbr</td>
            <td><input type="text" name = "clientPhoneNo" value="${orderForEdit.client.phoneNumber}"/></td>
        </tr>
        <tr>
            <td align="left">Enter new sum</td>
            <td><input type="text" name = "orderSum" value="${orderForEdit.sum}"/></td>
        </tr>
        <tr>
            <td align="left">Enter new 'from' address</td>
            <td><input type="text" name = "orderAddressFrom" value="${orderForEdit.addressFrom}"/></td>
        </tr>
        <tr>
            <td align="left">Enter new destination address</td>
            <td><input type="text" name = "orderAddressTo" value="${orderForEdit.addressTo}"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="save"/>
            </td>
        </tr>
    </table>
</form>

<form action="/dashboard.html" method="post">
    <input type="hidden" name="login" value="${operator.login}">
    <input type="hidden" name="password" value="${operator.password}">
    <input type="submit" value="back">
</form>
</body>
</html>
