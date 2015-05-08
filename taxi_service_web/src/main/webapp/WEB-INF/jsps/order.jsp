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
    <title>Create order</title>
    <style>
        table {background-color: whitesmoke; font-weight: bold}
        #carlist span{display:block;clear:both;cursor:pointer;}
    </style>
    <script src="/js/jquery-1.11.2.min.js"></script>
    <script src="/js/getCars.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
    <script>
        function setCar(id,name){
            console.log(name);
            document.getElementById('taxi_id').value = id;
            document.getElementById('carlist').innerHTML = ' ';
            document.getElementById('cars').value = name;
        }
    </script>
    <script>
        $(document).ready(function(){
            $.ajax({
                type: "GET",
                url: "/getAddress.html",
                success: function(result){
                    var adrList = '<select name="street" id="street">'+result+'</select>';
                    document.getElementById('adrSelect').innerHTML = adrList;
                }
            });
        });
    </script>
</head>
<body>
Operator: <c:out value="${operator.login}"/>
<br/>
<c:out value="${orderMessage}"/>
<form action="/createOrder.html" method="post">
    <table>
        <tr>
            <td align="left">Enter sum</td>
            <td><input type="text" name = "orderSum"/></td>
        </tr>
        <tr>
            <td align="left">Enter 'from' address</td>
            <td>
                <div id="adrSelect">
                </div>
            </td>
        </tr>
        <tr>
            <td align="left">Enter destination address</td>
            <td><input type="text" name = "orderAddressTo"/></td>
        </tr>
        <tr>
            <td align="left">Set car:</td>
            <td>
                <input type="text" name = "cars" id="cars" value=""/>
                <input type="hidden" name="taxi_id" value="" id="taxi_id"/>
            </td>
        </tr>
        <tr>
            <td align="left">Cars list:</td>
            <td>
                <div id="carlist"></div>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="create"/>
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
