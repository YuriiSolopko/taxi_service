<%--
  Created by IntelliJ IDEA.
  User: Jura
  Date: 08.04.2015
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="/css/dashboard.css"/>
    <script src="/js/dashboard.js"></script>
</head>
<body>

<div id="main">
    <span class="hlink" onclick="registerClient()">Register new client</span>
    <br/>
    <span class="hlink" onclick="showAll()">Show all clients</span>
    <br/>
    <span class="hlink" onclick="showGtSum()">Show client with total sum > </span><input type="text" id="totalSum"/>
    <br/>
    <span class="hlink" onclick="showLastMonth()">Show clients for last month</span>
    <br/>
    <span class="hlink" onclick="createOrder()">Create order</span>
    <br/>
</div>

<div id = "table">
    <c:if test="${clientList!=null}">
        <table>
            <tr>
                <td class="menu">ID</td>
                <td class="menu">Name</td>
                <td class="menu">Surname</td>
                <td class="menu">Phone no.</td>
                <td class="menu">Address</td>
                <td class="menu">Total sum</td>
                <td class="menu">Last order date</td>
            </tr>
            <c:forEach var="el" items="${clientList}">
                <tr>
                    <td class="lightgrey"><c:out value="${el.clientId}"/></td>
                    <td class="whitesmoke"><c:out value="${el.firstName}"/></td>
                    <td class="lightgrey"><c:out value="${el.lastName}"/></td>
                    <td class="whitesmoke"><c:out value="${el.phoneNumber}"/></td>
                    <td class="lightgrey"><c:out value="${el.address}"/></td>
                    <td class="whitesmoke"><c:out value="${el.sum}"/></td>
                    <td class="lightgrey"><c:out value="${el.lastOrderDate}"/></td>
                </tr>
            </c:forEach>
            <c:if test="${firstIndex!=-1}">
                <tr>
                    <td colspan="3"></td>
                    <td>
                        <c:if test="${firstIndex>0}">
                            <a href="/dashboard.html/showAll?firstResult=${firstIndex-10}"/> <<
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${(clientSize-firstIndex) > 10}">
                            <a href="/dashboard.html/showAll?firstResult=${firstIndex+10}"/> >>
                        </c:if>
                    </td>
                </tr>
            </c:if>
        </table>
    </c:if>
</div>
</body>
</html>
