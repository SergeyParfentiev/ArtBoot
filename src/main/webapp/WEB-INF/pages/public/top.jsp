<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cl" %>
<html>
<head>
    <title>Wall of Arts</title>
    <link rel="shortcut icon" href="<c:url value='/images/favicon.ico'/>?${startTime}" type="image/x-icon">
    <link rel="apple-touch-icon" href="/images/apple-touch-icon.png">
    <link rel="apple-touch-icon-precomposed" href="/images/apple-touch-icon-precomposed.png'">
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">--%>
    <%--<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/content.css?${startTime}">
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
<div class="header">
        <nav class="navbar navbar-default" role="navigation" style="box-shadow: 0 10px 10px #DFE1F0; border: 0">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header" style="margin-top: 5px;">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a id="logo">
                    <img style="max-height: 40px; margin: auto 0;" src="<c:url value='/images/icon.png'/>"/><img style="max-height: 40px" src="<c:url value='/images/name.png'/>"/>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul class="nav navbar-nav categories_list_drop">
                    <li>
                        <a class="category_list_container"  href="#">
                            <div class="category_name" style="text-align: center">Каталог товаров</div>
                            <div class="pointer">
                                <div style="vertical-align: middle" class="glyphicon glyphicon-chevron-down"></div>
                            </div>
                        </a>
                        <cl:categoryList categories="${all_menu}" classParameter="nav categories_list" source="${all_menu_source}"/>
                    </li>
                </ul>
                <div class="col-sm-3 col-md-2">
                    <form class="navbar-form" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search" name="q">
                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                            </div>
                        </div>
                    </form>
                </div>
                <%--<div class="console"></div>--%>
                <ul class="nav navbar-nav">
                    <img style="width: 40px; height: 40px" src="<c:url value="/images/buket.png"/>">
                </ul>
                <ul class="nav navbar-nav">
                    <div style="font-size: 40px" class="glyphicon glyphicon-shopping-cart"></div>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a class="hover-efekt" href="#">Войти</a></li>
                    <li><a class="hover-efekt" href="#">Зарегистрироваться</a></li>
                    <%--<li class="dropdown">--%>
                        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>--%>
                        <%--<ul class="dropdown-menu">--%>
                            <%--<li><a href="#">Action</a></li>--%>
                            <%--<li><a href="#">Another action</a></li>--%>
                            <%--<li><a href="#">Something else here</a></li>--%>
                            <%--<li class="divider"></li>--%>
                            <%--<li><a href="#">Separated link</a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
        <%--<nav class="navbar">--%>
            <%--<div class="container-fluid">--%>
                <%--<div class="navbar-header">--%>
                    <%--<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">--%>
                        <%--<span class="icon-bar"></span>--%>
                        <%--<span class="icon-bar"></span>--%>
                        <%--<span class="icon-bar"></span>--%>
                    <%--</button>--%>


                <%--</div>--%>

                <%--<div class="collapse navbar-collapse" id="myNavbar">--%>
                    <%--<ul class="nav navbar-nav">--%>
                        <%--<li class="navbar_logo">--%>
                            <%--&lt;%&ndash;<div>&ndash;%&gt;--%>
                                <%--<a class="navbar_logo_link" href="/">--%>
                                    <%--<img class="navbar_logo_img" src="<c:url value='/images/a1.jpg'/>"/>--%>
                                <%--</a>--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

                        <%--</li>--%>
                        <%--<li id="header_goods">--%>
                            <%--<ul>--%>
                                <%--<li>--%>
                                    <%--<a href="#">Каталог товаров</a>--%>
                                    <%--<ul>--%>
                                        <%--<li><a href="#">Sub Menu 1</a></li>--%>
                                        <%--<li><a href="#">Sub Menu 2</a></li>--%>
                                        <%--<li><a href="#">Sub Menu 3</a></li>--%>
                                        <%--<li><a href="#">Sub Menu 4</a>--%>
                                            <%--<ul>--%>
                                                <%--<li><a href="#">Deep Menu 1</a>--%>
                                                    <%--<ul>--%>
                                                        <%--<li><a href="#">Sub Deep 1</a></li>--%>
                                                        <%--<li><a href="#">Sub Deep 2</a></li>--%>
                                                        <%--<li><a href="#">Sub Deep 3</a></li>--%>
                                                        <%--<li><a href="#">Sub Deep 4</a></li>--%>
                                                    <%--</ul>--%>
                                                <%--</li>--%>
                                                <%--<li><a href="#">Deep Menu 2</a></li>--%>
                                            <%--</ul>--%>
                                        <%--</li>--%>
                                        <%--<li><a href="#">Sub Menu 5</a></li>--%>
                                    <%--</ul>--%>
                                <%--</li>--%>
                            <%--</ul>--%>
                        <%--</li>--%>

                            <%--<li class="input-group">--%>
                                <%--<input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">--%>
                                <%--<div class="input-group-btn">--%>
                                    <%--<button class="btn" style="background: none; height: 30px" type="submit">--%>
                                        <%--<i style="font-size: 20px" class="glyphicon glyphicon-search"></i>--%>
                                    <%--</button>--%>
                                <%--</div>--%>
                            <%--</li>--%>

                        <%--<li class="active"><a href="#">Home</a></li>--%>
                        <%--<li class="dropdown">--%>
                            <%--<a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>--%>
                            <%--<ul class="dropdown-menu">--%>
                                <%--<li><a href="#">Page 1-1</a></li>--%>
                                <%--<li><a href="#">Page 1-2</a></li>--%>
                                <%--<li><a href="#">Page 1-3</a></li>--%>
                            <%--</ul>--%>
                        <%--</li>--%>
                        <%--<li><a href="#">Page 2</a></li>--%>
                        <%--<li><a href="#">Page 3</a></li>--%>
                    <%--</ul>--%>
                    <%--<ul class="nav navbar-nav navbar-right">--%>
                        <%--<li><a href="#"><span class="glyphicon glyphicon-user"></span> Войти</a></li>--%>
                        <%--<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Зарегестрироваться</a></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</nav>--%>
        <%--<div id="header_logo">--%>
            <%--<img src="<c:url value='/images/a1.jpg'/>"/>--%>
        <%--</div>--%>

    <div class="breadcrumbs">
        <ol class="arrows">
            <c:forEach items="${breadcrumbsPath}" var="path" varStatus="status">
                <c:choose>
                    <c:when test="${breadcrumbsPath.size() != status.count}">
                        <li><a href="${pageContext.request.contextPath}${path.key}">${path.value}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a>${path.value}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ol>
    </div>
</div>

<%--${"param"}--%>