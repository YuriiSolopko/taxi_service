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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Taxi service</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/index.css" rel="stylesheet">
    <script src="/js/index.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-4">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Login</span>
                <input type="text" class="form-control" placeholder="Enter login" aria-describedby="basic-addon1" id="operLogin">
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-4">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon2">Password</span>
                <input type="password" class="form-control" placeholder="Enter password" aria-describedby="basic-addon2" id="operPassword">
            </div>
        </div>
        <div class="col-lg-1 col-md-1 col-sm-1">
            <button class="btn btn-default" onclick="authOperator()">Enter</button>
        </div>
        <div class="col-lg-offset-3 col-lg-2 col-md-offset-2 col-md-3 col-sm-offset-0 col-sm-3">
            <a href="#reg-spoiler" class="btn btn-info" data-toggle="collapse">Register new operator</a>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-offset-2 col-lg-8 col-md-offset-1 col-md-10 col-sm-offset-0 col-sm-12 text-center">
            <div class="collapse" id="reg-spoiler">
                <div class="well">
                    <div class="row">
                        <div class="col-md-6 col-sm-7">
                            <div class="input-group">
                                <span class="input-group-addon" id="login-addon">Login</span>
                                <input type="text" class="form-control" placeholder="Enter login" aria-describedby="login-addon" id="login">
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-5 text-left">
                            <h4><span class="label label-danger" id="login-err"></span></h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 col-sm-7">
                            <div class="input-group">
                                <span class="input-group-addon" id="password-addon">Password</span>
                                <input type="password" class="form-control" placeholder="Enter password" aria-describedby="password-addon" id="password">
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-5 text-left">
                            <h4><span class="label label-danger" id="pass-err"></span></h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 col-sm-7">
                            <div class="input-group">
                                <span class="input-group-addon" id="passconf-addon">Confirm password</span>
                                <input type="password" class="form-control" placeholder="Confirm password" aria-describedby="passconf-addon" id="passconf">
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-5 text-left">
                            <h4><span class="label label-danger" id="passconf-err"></span></h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-6 text-center">
                            <button class="btn btn-primary" onclick="registerOperator()">Register</button>
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-6 text-left">
                            <h4><span class="label label-info"  id="regMessage"></span></h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--<img src="/images/taxi.jpg" class="img-responsive img-rounded center-block"/>--%>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery-1.11.2.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap.js"></script>
</body>
</html>