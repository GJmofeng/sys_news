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
    <title>新闻信息</title>

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
                                <a href="IndexServlet?action=toNews">新闻</a>
                            </li>
                        </ul>
                    </div><!-- end of nav-collapse -->
                        <div class="cart-search-contact">
                            <div class="get-quote">
                            <c:if test="${user != null }">
                           
                             <a href="#">欢迎用户：${user.name }</a>
                             <h1><a href="LoginServlet?action=loginOut">Login out</a></h1>
                        </c:if>
                         <c:if test="${user == null }">
                             <h1><a href="LoginServlet?action=loginOut">Sign in</a></h1>
                        </c:if>
                        </div></div>
                    </div><!-- end of container -->
                </nav>
            </div>
        </header>
        <!-- end of header -->
        <!-- start page-title -->
        <section class="page-title">
            <div class="container">
                <div class="row">
                    <div class="col col-xs-12">
                        <h2>新闻信息</h2>
                        <ol class="breadcrumb">
                            <li><a href="IndexServlet?action=toIndex">首页</a></li>
                            <li>新闻</li>
                        </ol>
                    </div>
                </div> <!-- end row -->
            </div> <!-- end container -->
        </section>
        <!-- end page-title -->
        

        <!-- start wpo-blog-single-section -->
        
     
        <section class="wpo-blog-single-section section-padding">
            <div class="container">
                <div class="row">
                <c:if test="${news != null }">
                    <div class="col col-md-8">
                        <div class="wpo-blog-content clearfix">
                            <div class="post">
                                <div class="entry-media">
                                    <img src="/images/${news.img }" alt>
                                </div>
                                <ul class="entry-meta">
                                    <li><a href="#"> 作者：${news.editor }</a></li>
                                    <li><a href="#"> 创作时间：${news.times }</a></li>
                                    <li><a href="#"> 浏览次数：（${news.see_count }）</a></li>
                                    <li><a href="#"> 评论次数：（${news.comment_count }）</a></li>
                                </ul>
                                <h2>${news.title }</h2>
                                ${news.content }
                            </div>
                            
                            
                            
                            <div class="comments-area">
                                <div class="comments-section">
                                    <h3 class="comments-title">评论</h3>
                                    <ol class="comments">
                                    
                                    <c:forEach items="${commentsList}" var="u">
                                    
                                          <li class="comment">
                                            <div>
                                                <div class="comment-theme">
                                                    <div class="comment-image"><img src="/images/${u.img }" style="width:60px; height:60px; border-radius:100%; overflow:hidden;" ></div>
                                                </div>
                                                <div class="comment-main-area">
                                                    <div class="comment-wrapper">
                                                        <div class="comments-meta">
                                                            <h4>${u.creater }<span class="comments-date">${u.times }</span></h4>
                                                        </div>
                                                        <div class="comment-area">
                                                            <p>${u.comments }</p>
                                                           <!--  <div class="comments-reply">
                                                                <a  class="comment-reply-link" href="#"><span><i class="fa fa-reply" aria-hidden="true"></i> Reply</span></a>
                                                            </div> -->
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>


                                     

                                   
                                    </ol>
                                </div> <!-- end comments-section -->
                          <c:if test="${user != null }">
  
                             <div class="comment-respond">
                                    <h3 class="comment-reply-title">发表评论</h3>
                                    <form method="post" action="CommentsServlet?action=addComments" id="commentform" class="comment-form">
                                     <input id="nid" name="nid" value="${news.id}" type="hidden">

                                         <div class="form-textarea">
                                            <textarea id="comments" name="comments" placeholder="请输入评论信息"></textarea>
                                        </div>
                                        <div class="form-submit">
                                            <input id="submit" value="提交" type="submit">
                                        </div>
                                    </form>
                                </div>
                            </c:if>
                                
                            </div> <!-- end comments-area -->
                        </div>
                    </div>
                  </c:if>
                  <c:if test="${news == null }">
                   <div class="col col-md-8">
      <c:forEach items="${newsList}" var="u">
                                    <div class="post">
                                        <div class="img-holder">
                                     <a href="IndexServlet?action=toNews&nid=${u.id }"><img src="/images/${u.img }" alt></a>
                                        </div>
                                        <div class="details">
                                            <h4><a href="IndexServlet?action=toNews&nid=${u.id }">${u.title }</a></h4>
                                            <span class="date">${u.times }</span>
                                        </div>
                                    </div>
                                    </c:forEach>
                   </div>
                  </c:if>
                  
                    <div class="col col-md-4">
                        <div class="wpo-blog-sidebar">
                        
                           <div class="widget search-widget">
                                <form action="IndexServlet?action=toNews"  method="post">
                                    <div>
                                        <input type="text" name="names" value="${names }" class="form-control" placeholder="请输入标题">
                                        <button type="submit"><i class="ti-search"></i></button>
                                    </div>
                                </form>
                            </div>
                     <div class="widget category-widget">
                                <h3>分类</h3>
                                <ul>
                                  <c:forEach items="${categoryList}" var="u">
                                     <li><a href="IndexServlet?action=toNews&category=${u.cname }">${u.cname }</a></li>
                                  </c:forEach>
                                  
                                </ul>
                            </div>
                        
                            <div class="widget recent-post-widget">
                                <h3>新闻热点</h3>
                                	
                                <div class="posts">
                                  <c:forEach items="${newsList}" var="u">
                                    <div class="post">
                                        <div class="img-holder">
                                            <img src="/images/${u.img }" alt>
                                        </div>
                                        <div class="details">
                                            <h4><a href="IndexServlet?action=toNews&nid=${u.id }">${u.title }</a></h4>
                                            <span class="date">${u.times }</span>
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- end container -->
        </section>
        <!-- end wpo-blog-single-section -->   


        <!-- start wpo-site-footer -->
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
