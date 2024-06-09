<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="wpoceans">
    <!-- Page Title -->
    <title>首页</title>
    <!-- Icon fonts -->
    <link href="assets/css/themify-icons.css" rel="stylesheet">
    <link href="assets/css/flaticon.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Plugins for this template -->
    <link href="assets/css/animate.css" rel="stylesheet">
    <link href="assets/css/owl.carousel.css" rel="stylesheet">
    <link href="assets/css/owl.theme.css" rel="stylesheet">
    <link href="assets/css/slick.css" rel="stylesheet">
    <link href="assets/css/slick-theme.css" rel="stylesheet">
    <link href="assets/css/odometer-theme-default.css" rel="stylesheet">
    <link href="assets/css/owl.transitions.css" rel="stylesheet">
    <link href="assets/css/jquery.fancybox.css" rel="stylesheet">
    <link href="assets/css/magnific-popup.css" rel="stylesheet">
    <link href="assets/css/nice-select.css" rel="stylesheet">
    <link href="assets/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body id="home">
    <!-- start page-wrapper -->
    <div class="page-wrapper">
        <!-- start preloader -->
        <div class="preloader">
            <div class="spinner">
                <div class="bounce1"></div>
                <div class="bounce2"></div>
                <div class="bounce3"></div>
            </div>
        </div>
        <!-- end preloader -->
        <!-- Start header -->
        <header id="header">
            <div class="site-header header-style-1">
                <nav class="navigation navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="open-btn">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="IndexServlet?action=toIndex">YOLO News Website</a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse navigation-holder">
                        <button class="close-navbar"><i class="ti-close"></i></button>
                        <ul class="nav navbar-nav">
                            <li class="menu-item-has-children">
                                <a href="IndexServlet?action=toIndex">首页</a>
                              <!--   <ul class="sub-menu">
                                    <li><a href="IndexServlet?action=toIndex">首页</a></li>
                                </ul> -->
                            </li>
                         
                            <li class="menu-item-has-children">
                                 <a href="IndexServlet?action=toNews">时事热点</a>
                            </li>
                        </ul>
                    </div><!-- end of nav-collapse -->
                        <div class="cart-search-contact">
                            <div class="get-quote">
                            <c:if test="${user != null }">
                             <a href="#">欢迎用户：${user.name }</a>
                             <h1><a href="LoginServlet?action=loginOut">Login Out</a></h1>
                        </c:if>
                         <c:if test="${user == null }">
                             <h1><a href="LoginServlet?action=loginOut">Sign In</a></h1>
                        </c:if>
                        </div></div>
                    </div><!-- end of container -->
                </nav>
            </div>
        </header>
        <!-- end of header -->
        <!-- start of hero -->
        <section class="hero hero-style-2">
            <div class="hero-slider">
                <div class="slide">
                    <div class="container">
                        <img src="assets/images/slider/slide-4.jpg" alt class="slider-bg">
                        <div class="row">
                            <div class="col col-md-8 slide-caption">
                                <div class="slide-title">
                                    <h2>Welcome to YOLO News Website!</h2>
                                </div>
                                <div class="slide-subtitle">
                                    <p>........</p>
                                </div>
                                <!-- <div class="btns">
                                    <a href="#" class="theme-btn">Book A Room</a>
                                </div> -->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="slide">
                    <div class="container">
                        <img src="assets/images/slider/slide-5.jpg" alt class="slider-bg">
                        <div class="row">
                            <div class="col col-md-8 slide-caption">
                                <div class="slide-title">
                                    <h2>Welcome to YOLO News Website!</h2>
                                </div>
                                <div class="slide-subtitle">
                                     <p>小天地</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="slide">
                    <div class="container">
                        <img src="assets/images/slider/slide-6.jpg" alt class="slider-bg">
                        <div class="row">
                            <div class="col col-md-8 slide-caption">
                                <div class="slide-title">
                                    <h2>Welcome to YOLO News Website!</h2>
                                </div>
                                <div class="slide-subtitle">
                                     <p>大舞台</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="slide">
                    <div class="container">
                        <img src="assets/images/slider/slide-7.jpg" alt class="slider-bg">
                        <div class="row">
                            <div class="col col-md-8 slide-caption">
                                 <div class="slide-title">
                                    <h2> Welcome to YOLO News Website!</h2>
                                </div>
                                <div class="slide-subtitle">
                                     <p>时事热点</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
       
    </div>
    <!-- All JavaScript files
    ================================================== -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <!-- Plugins for this template -->
    <script src="assets/js/jquery-plugin-collection.js"></script>
    <script src="assets/js/bootstrap-datepicker.min.js"></script>
    <!-- Custom script for this template -->
    <script src="assets/js/script.js"></script>
</body>

</html>