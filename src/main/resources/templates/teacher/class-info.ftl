<!DOCTYPE HTML>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<div class="navigation-back">
    <h1 class="navigation-back">班级信息</h1>
    <a href="/teacher/courses" class="button-back"><img id="button-back-image" src="/images/icons/展开.png"></a>
</div>
<div class="decoration"></div>

<div class="content">
    <#list courseClassList as class>
    <div class="container no-bottom">
        <h3 class="center-text">${class.className}</h3>
        <p class="center-text">
            讨论课时间：&emsp;周三7、8节<br>
            讨论课地点：&emsp;海韵教学楼<br>
            班级学生名单： &emsp;周三56节.xlsx<br>
        <p class="file center-text"><input type="file"></p>
        </p>
        <p class="center center-text"><a href="#" class="button-big button-red">删除班级</a></p>
    </div>
    <div class="decoration"></div>
    </#list>
    <#--<div class="container no-bottom">-->
        <#--<h3 class="center-text">2016-2</h3>-->
        <#--<p class="center-text">-->
            <#--讨论课时间：&emsp;周三7、8节<br>-->
            <#--讨论课地点：&emsp;海韵教学楼<br>-->
            <#--班级学生名单： &emsp;周三56节.xlsx<br>-->
        <#--<p class="file center-text"><input type="file"></p>-->
        <#--</p>-->
        <#--<p class="center center-text "><a href="/teacher/create-course" class="button-big button-red">删除班级</a></p>-->
    <#--</div>-->
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

<!--<div class="bottom-deco"></div>-->


</body>
</html>