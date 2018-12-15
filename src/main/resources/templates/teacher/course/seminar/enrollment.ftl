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
    <link href="/layui/css/layui.css" rel="stylesheet" type="text/css">

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
        <div class="navigation-back">
<<<<<<< HEAD:src/main/resources/templates/student/complete_enrollment.ftl
            <h1 class="navigation-back">${course.courseName}讨论课</h1>
            <a href="/student/seminar_info?courseId=${course.id}&classId=${classId}&seminarId=${seminarInfo.id}" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
=======
            <h1 class="navigation-back">${course.courseName}</h1>
            <a href="/teacher/course/seminar/info?courseId=${course.id}&seminarId=${seminarInfo.id}&classId=${classId}" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
>>>>>>> b5d964932e63aa2fc0f79f68e4de55f7076ff3fa:src/main/resources/templates/teacher/course/seminar/enrollment.ftl
        </div>
        <a href="#" class="sub-go-menu"></a>
        <a href="#" class="sub-go-back"></a>
    </div>
    <div class="decoration"></div>

    <div class="navigation" style="right:0%;margin-top:-5px;">
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
                <a href="/teacher/seminars" class="home-icon">讨论课</a>
                <em class="active-menu"></em>
            </div>
        </div>
    </div>
</div>

<div class="content">
    <div class="distance4"></div>
    <div class="center-navigation">
        <table class="layui-table" lay-skin="nob">
            <colgroup>
                <col width="100">
                <col width="200">
            </colgroup>
            <tbody>
            <tr>
                <td>第一组：</td>
                <td style="color:#009688;">1-1业务流程.ppt</td>
            </tr>
            <tr>
                <td>第二组：</td>
                <td style="color:#009688;">1-2业务流程.ppt</td>
            </tr>
            <tr>
                <td>第三组：</td>
                <td style="color:#009688;">1-3业务流程.ppt</td>
            </tr>
            <tr>
                <td>第四组：</td>
                <td style="color:#009688;">1-4业务流程.ppt</td>
            </tr>
            <tr>
                <td>第五组：</td>
                <td style="color:#009688;">1-5业务流程.ppt</td>
            </tr>
            <tr>
                <td>第六组：</td>
                <td style="color:#009688;">1-6业务流程.ppt</td>
            </tr>
            </tbody>
        </table>
        <div class="distance4"></div>
        <div class="distance"></div>
    </div>
</div>

<!--<div class="bottom-deco"></div>-->


</body>
</html>