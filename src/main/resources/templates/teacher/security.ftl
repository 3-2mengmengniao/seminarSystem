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
        <div class="navigation-back">
            <h1 class="navigation-back">账户与设置</h1>
            <a href="/teacher/homepage" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
        </div>
        <a href="#" class="sub-go-menu"></a>
        <a href="#" class="sub-go-back"></a>
    </div>
    <div class="decoration"></div>

    <div class="navigation">
        <div class="corner-deco"></div>
        <div class="navigation-wrapper">
            <div class="navigation-item">
                <a href="/teacher/homepage" class="home-icon">代办</a>
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

<div class="content">
    <div class="container no-bottom text-list">
        用户姓名：<br>
        ${teacher.teacherName}<br>
        <div class="text-decoration"></div>
        <div class="distance3"></div>
        教工号： <br>
        ${teacher.account}<br>
        <div class="text-decoration"></div>
        <div class="distance3"></div>
        邮箱：<br>
        ${teacher.email}<br>
        <div class="text-decoration"></div>
        <div class="distance4"></div>
        账户密码<br>
        <div class="text-decoration"></div>
        <div class="distance4"></div>
        通知时间间隔
        <div class="text-decoration"></div>
        <div class="distance4"></div>
        <div class="distance"></div>
        <div class="distance"></div>
        <p class="center center-text"><a href="/" class="button-big button-red">退出登录</a></p>
        <!--
        <div class="decoration"></div>
        <div class="footer">
            <div class="clear"></div>
            <p class="copyright">
                Copyright @2018 developed by Group 3-2.<br>
                All Rights Reserved
            </p>
        </div>
        -->
    </div>
</div>

        <div class="right-image-div">
            <img class="right-image" src="/images/修改.png" onclick="window.location.href='/email-modify'"></img>
            <div class="distance3"></div>
            <img class="right-image" src="/images/修改.png" onclick="window.location.href='/vali_psw'">
        </div>
    <div class="dropdown">
        <button class="my-btn btn1-default dropdown-toggle" type="button1" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            6小时一次
            <span class="caret1"></span>
        </button>
        <ul class="my-dropmenu dropdown-menu2" aria-labelledby="dropdownMenu1">
            <li class="bootstrap"><a href="#">1小时一次</a></li>
            <li class="bootstrap"><a href="#">3小时一次</a></li>
            <li class="bootstrap"><a href="#">5小时一次</a></li>
        </ul>
    </div>

<!--<div class="bottom-deco"></div>-->

</body>
</html>