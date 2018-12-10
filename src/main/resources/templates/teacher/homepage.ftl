<!DOCTYPE HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<title></title>

    <link href="/styles/style.css"     		rel="stylesheet" type="text/css">
    <link href="/styles/framework.css" 		rel="stylesheet" type="text/css">
    <link href="/styles/owl.carousel.css" 	 rel="stylesheet" type="text/css">
    <link href="/styles/owl.theme.css" 		rel="stylesheet" type="text/css">
    <link href="/styles/swipebox.css"		 rel="stylesheet" type="text/css">
    <link href="/styles/colorbox.css"		 rel="stylesheet" type="text/css">
    <link href="/styles/bootstrap.css"		 rel="stylesheet" type="text/css">
    <link href="/layui/css/layui.css"		 rel="stylesheet" type="text/css">

    <script type="text/javascript" src="/scripts/jquery.js"></script>
    <script type="text/javascript" src="/scripts/jqueryui.js"></script>
    <script type="text/javascript" src="/scripts/owl.carousel.min.js"></script>
    <script type="text/javascript" src="/scripts/jquery.swipebox.js"></script>
    <script type="text/javascript" src="/scripts/colorbox.js"></script>
    <script type="text/javascript" src="/scripts/snap.js"></script>
    <script type="text/javascript" src="/scripts/login.js"></script>
    <script type="text/javascript" src="/scripts/custom.js"></script>
    <script type="text/javascript" src="/scripts/framework.js"></script>
    <script type="text/javascript" src="/scripts/framework.launcher.js"></script>
    <script type="text/javascript" src="/scripts/bootstrap-3.1.1.min.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>



</head>
<body>

<div id="preloader">
    <div id="status">
        <p class="center-text">
            Loading the content...
            <em>Loading depends on your connection speed!</em>
        </p>
    </div>
</div>

<div class="top-deco"></div>

<div class="content">
    <div class="header">
        <a href="/teacher/homepage" class="homepage-logo">
            <img src="/images/misc/logo3.png" alt="img">
        </a>
        <a href="#" class="go-menu"></a>
        <a href="#" class="go-back"></a>
    </div>
    <div class="decoration"></div>

    <div class="navigation">
        <div class="corner-deco"></div>
        <div class="navigation-wrapper">
            <div class="navigation-item">
                <a href="/teacher/homepage" class="home-icon">待办</a>
                <em class="active-menu"></em>
            </div>
            <div class="navigation-item">
                <a href="/teacher/homepage" class="home-icon">个人页</a>
                <em class="active-menu"></em>
            </div>
            <div class="navigation-item">
                <a href="/teacher/seminars" class="home-icon">讨论课</a>
                <em class="active-menu"></em>
            </div>
        </div>
    </div>
</div>
<!--
<div class="distance5"></div>
<a class="text-center welcome">${teacher.teacherName},${teacher.account}</a>
<a class="text-center welcome">讨论课管理系统欢迎您！</a><br>
-->
<script>
    layui.use('layer', function(){
        var layer = layui.layer;
        layer.config({
            time:2000
            ,offset: '120px'
        })
        layer.msg('${teacher.teacherName},${teacher.account}<br>讨论课管理系统欢迎您！');
    });
</script>
<div class="distance4"></div>
<div class="landing-navigation">
    <div class="landing-navigation-tablet-top-adjustment"></div>
    <a href="/teacher/courses">
        <img class="nav-image" src="/images/icons/课程2.png" alt="img">
        <nobr><em>我的课程</em></nobr>
    </a>
    <img class="nav-image invisible" src="/images/icons/课程2.png" alt="img">
    <a href="/teacher/security">
        <img class="nav-image" src="/images/icons/设置2.png" alt="img">
        <nobr><em>账户与设置</em></nobr>
    </a>
    <div class="distance2"></div>
    <div class="clear"></div>
    <div class="landing-navigation-tablet-bottom-adjustment"></div>
</div>

<!--
<div class="page_footer">
    <div class="decoration"></div>

    <div class="footer">
        <div class="clear"></div>
        <p class="copyright">
            Copyright @2018 developed by Group 3-2.<br>
            All Rights Reserved
        </p>
    </div>
    <div class="bottom-deco"></div>
</div>
-->


</body>
</html>