<%--
  Created by IntelliJ IDEA.
  User: Jura
  Date: 05.04.2015
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Orders</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0
        }
        body {
            text-align: center;
        }
        table {
            margin: 0 auto;
        }
        table td.whitesmoke {
            background-color: whitesmoke;
            padding: 3px 6px;
        }
        table td.lightgrey {
            background-color: lightgrey;
            padding: 3px 6px;
        }
        table td.menu {
            background-color: darkslategrey;
            color: white;
            font-weight: bold;
            padding: 3px 6px;
        }
    </style>
</head>
<body>
Operator: <c:out value="${operator.login}"/>
<c:out value="${orderMessage}"/>
<c:if test="${orderList!=null}">
    <table>
        <tr>
            <td class="menu">ID</td>
            <td class="menu">Client</td>
            <td class="menu">Address from</td>
            <td class="menu">Address to</td>
            <td class="menu">Order date</td>
            <td class="menu">Sum</td>
        </tr>
        <c:forEach var="el" items="${orderList}">
            <tr>
                <td class="lightgrey"><c:out value="${el.orderId}"/></td>
                <td class="whitesmoke"><c:out value="${el.client}"/></td>
                <td class="lightgrey"><c:out value="${el.addressFrom}"/></td>
                <td class="whitesmoke"><c:out value="${el.addressTo}"/></td>
                <td class="lightgrey"><c:out value="${el.orderDate}"/></td>
                <td class="whitesmoke"><c:out value="${el.sum}"/></td>
                <td class="lightgrey">
                    <form action="/orders.html/edit" method="GET">
                        <input type="hidden" name="orderId" value="${el.orderId}">
                        <input type="submit" value="edit">
                    </form>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${firstIndex!=-1}">
            <tr>
                <td colspan="2"></td>
                <td>
                    <c:if test="${firstIndex>0}">
                        <a href="/orders.html?firstResult=${firstIndex-5}"/> <<
                    </c:if>
                </td>
                <td>
                    <c:if test="${(orderSize-firstIndex) > 5}">
                        <a href="/orders.html?firstResult=${firstIndex+5}"/> >>
                    </c:if>
                </td>
            </tr>
        </c:if>
    </table>
</c:if>
<form action="/dashboard.html" method="post">
    <input type="hidden" name="login" value="${operator.login}">
    <input type="hidden" name="password" value="${operator.password}">
    <input type="submit" value="back">
</form>
</body>
</html>
