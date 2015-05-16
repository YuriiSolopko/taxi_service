<%--
  Created by IntelliJ IDEA.
  User: Jura
  Date: 16.05.2015
  Time: 12:17
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
    <title>Dashboard</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/font-awesome.css" rel="stylesheet">
    <link href="/css/dashboard.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

    <div class="container">
        <div class="row my-bar">
            <div class="col-lg-2 text-center">
                <a class="btn btn-default btn-lg" href="/"><i class="fa fa-home fa-lg"></i></a>
            </div>
            <div class="col-lg-8">
                <ul class="nav nav-pills">
                    <li class="active"><a href="#orders" data-toggle="tab">Orders</a></li>
                    <li><a href="#clients" data-toggle="tab">Clients</a></li>
                    <li><a href="#taxists" data-toggle="tab">Taxi drivers</a></li>
                    <li><a href="#addresses" data-toggle="tab">Addresses</a></li>
                    <li><a href="#regions" data-toggle="tab">Regions</a></li>
                </ul>
            </div>
            <div class="col-lg-2 text-right">
                <h4><span class="label-info label">Operator: <c:out value="${operator.login}"/></span></h4>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 my-menu">
                <br>
                <div class="tab-content">
                    <div class="tab-pane active fade in" id="orders">
                        <div class="list-group">
                            <a class="list-group-item" href="#orders-create" data-toggle="tab"><i class="fa fa-plus-square fa-fw"></i>&nbsp; Create order</a>
                            <a class="list-group-item" href="#orders-edit" data-toggle="tab"><i class="fa fa-pencil-square fa-fw"></i>&nbsp; Edit order</a>
                            <a class="list-group-item" href="#orders-show" data-toggle="tab"><i class="fa fa-table fa-fw"></i>&nbsp; Show orders</a>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="clients">
                        <div class="list-group">
                            <a class="list-group-item" href="#orders-create" data-toggle="tab"><i class="fa fa-user-plus fa-fw"></i>&nbsp; Add client</a>
                            <a class="list-group-item" href="#orders-show" data-toggle="tab"><i class="fa fa-table fa-fw"></i>&nbsp; Show clients</a>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="taxists">
                        <div class="list-group">
                            <a class="list-group-item" href="#orders-create" data-toggle="tab"><i class="fa fa-user-plus fa-fw"></i>&nbsp; Add taxi driver</a>
                            <a class="list-group-item" href="#orders-show" data-toggle="tab"><i class="fa fa-table fa-fw"></i>&nbsp; Show taxists</a>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="addresses">
                        <div class="list-group">
                            <a class="list-group-item" href="#orders-create" data-toggle="tab"><i class="fa fa-plus-square fa-fw"></i>&nbsp; Add address</a>
                            <a class="list-group-item" href="#orders-show" data-toggle="tab"><i class="fa fa-table fa-fw"></i>&nbsp; Show addresses</a>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="regions">
                        <div class="list-group">
                            <a class="list-group-item" href="#orders-create" data-toggle="tab"><i class="fa fa-plus-square fa-fw"></i>&nbsp; Add region</a>
                            <a class="list-group-item" href="#orders-show" data-toggle="tab"><i class="fa fa-table fa-fw"></i>&nbsp; Show regions</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-10">
                <br>
                <div class="tab-content">
                    <div class="tab-pane fade" id="orders-create">
                        <div class="list-group">
                            <p>1</p>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="orders-edit">
                        <p>2</p>
                    </div>
                    <div class="tab-pane fade" id="orders-show">
                        <p>3</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery-1.11.2.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap.js"></script>
</body>
</html>