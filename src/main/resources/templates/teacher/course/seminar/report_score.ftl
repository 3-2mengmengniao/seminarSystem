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
            <h1 class="navigation-back">${course.courseName}讨论课</h1>
            <a href="/teacher/seminar_info?courseId=${course.id}&classId=${classId}&seminarId=${seminarInfo.id}" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
        </div>
        <a href="#" class="sub-go-menu"></a>
        <a href="#" class="sub-go-back"></a>
    </div>
    <div class="decoration"></div>

    <div class="navigation">
        <div class="corner-deco"></div>
        <div class="navigation-wrapper">
            <div class="navigation-item">
                <a href="/teacher/message" class="home-icon">待办</a>
                <em class="active-menu"></em>
            </div>
            <div class="navigation-item">
                <a href="/teacher/index" class="home-icon">个人页</a>
                <em class="active-menu"></em>
            </div>
            <div class="navigation-item">
                <a href="/teacher/index" class="home-icon">讨论课</a>
                <em class="active-menu"></em>
            </div>
        </div>
    </div>
</div>

<div class="content">
    <div class="container no-bottom text-list">
        <div class="container no-bottom">
            <table cellspacing='0' class="table">
                <tr>
                    <td> 第一组：<a href="#" style="margin-left: 10px;display: inline;">1-1 业务流程分析</a><span  class="btn1-default my-btn2"   style="margin-top: 2px;margin-bottom: 2px;">5.0</span></td>
                </tr>
                <tr class='even'>
                    <td>  第二组：<a href="#" style="margin-left: 10px;display: inline;">1-2 业务流程分析</a><span  class="btn1-default my-btn2"   style="margin-top: 2px;margin-bottom: 2px;">5.0</span></td>
                </tr>
                <tr>
                    <td> 第三组：<a href="#" style="margin-left: 10px;display: inline;">1-3 业务流程分析</a><span  class="btn1-default my-btn2"   style="margin-top: 2px;margin-bottom: 2px;">5.0</span></td>
                </tr>
                <tr class='even'>
                    <td>第四组：<a href="#" style="margin-left: 10px;display: inline;">1-4 业务流程分析</a><span  class="btn1-default my-btn2"   style="margin-top: 2px;margin-bottom: 2px;">5.0</span> </td>
                </tr>
                <tr>
                    <td> 第五组：<a href="#" style="margin-left: 10px;display: inline;">1-5 业务流程分析</a><span  class="btn1-default my-btn2"   style="margin-top: 2px;margin-bottom: 2px;">5.0</span></td>
                </tr>
                <tr class='even'>
                    <td>第六组：<a href="#" style="margin-left: 10px;display: inline;">1-6 业务流程分析</a><span  class="btn1-default my-btn2"   style="margin-top: 2px;margin-bottom: 2px;">5.0</span></td>
                </tr>
            </table>
        </div>

        <div class="distance4"></div>
        <div class="distance"></div>
        <p class="center center-text"><a href="/teacher/report_download?courseId=${course.id}&classId=${classId}&seminarId=${seminarInfo.id}" class="button-return button-turqoise">修改</a></p>
        <p class="center center-text"><a href="/teacher/seminar_info?courseId=${course.id}&classId=${classId}&seminarId=${seminarInfo.id}" class="button-return button-turqoise">确认</a></p>
        <div class="distance"></div>
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

<!--<div class="bottom-deco"></div>-->


</body>
</html>