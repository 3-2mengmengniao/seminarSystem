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
            <h1 class="navigation-back">${course.courseName}讨论课</h1>
            <a href="/teacher/course/seminarList?courseId=${course.id}" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
        </div>
        <a href="#" class="sub-go-menu"></a>
        <a href="#" class="sub-go-back"></a>
    </div>
    <div class="decoration"></div>

    <div class="navigation" style="right:0%;margin-top:-5px;">
        <div class="corner-deco"></div>
        <div class="navigation-wrapper">
            <div class="navigation-item">
                <a href="/teacher/index" class="home-icon">待办</a>
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
                <td>轮次</td>
                <td>第${round.roundSerial}轮</td>
            </tr>
            <tr>
                <td>主题</td>
                <td>${seminarInfo.seminarName}</td>
            </tr>
            <tr>
                <td>课次序号</td>
                <td>第${seminarInfo.seminarSerial}次</td>
            </tr>
            <tr>
                <td>要求</td>
                <td>${seminarInfo.introduction}</td>
            </tr>
            <tr>
                <td>课程情况</td>
                <#if status=="UNSTARTED">
                        <td>课程情况：未开始   <a href="/teacher/course/seminar/enrollment?courseId=${course.id}&seminarId=${seminarInfo.id}&classId=${classId}" style="display: inline;margin-left: 20px;">查看信息</a></td>
                <#elseif status=="INPROCESS">
                         <td>课程情况：进行中   <a href="/teacher/course/seminar/enrollment?courseId=${course.id}&seminarId=${seminarInfo.id}&classId=${classId}" style="display: inline;margin-left: 20px;">查看信息</a></td>
                <#else>
                         <td>课程情况：已完成   <a href="/teacher/course/seminar/enrollment?courseId=${course.id}&seminarId=${seminarInfo.id}&classId=${classId}" style="display: inline;margin-left: 20px;">查看信息</a></td>
                </#if>
            </tr>
            </tbody>
        </table>
        <div class="distance4"></div>
        <div class="distance"></div>
        <#if status=="FINISHED">
        <p class="center center-text "><button type="button" class="layui-btn" id="contactSubmitButton" data-formId="contactForm" onclick="window.location.href='/teacher/course/seminar/report?courseId=${course.id}&seminarId=${seminarInfo.id}&classId=${classId}'">查看报告</button>
        </p>
        <div class="distance4"></div>
        <p class="center center-text "><input type="submit" class="layui-btn" id="contactSubmitButton" value="查看成绩" data-formId="contactForm"/>
        </p>
        <#elseif status=="UNSTARTED">
        <p class="center center-text "><input type="submit" class="layui-btn" id="contactSubmitButton" value="开始讨论课" data-formId="contactForm"/>
        </p>
        <div class="distance4"></div>
        <p class="center center-text "><input type="submit" class="layui-btn" id="contactSubmitButton" value="修改讨论课信息" data-formId="contactForm"/>
        </p>
        <#else>
        <p class="center center-text "><input type="submit" class="layui-btn" id="contactSubmitButton" value="进入讨论课" data-formId="contactForm"/>
        </p>
        </#if>
    </div>
</div>

<!--<div class="bottom-deco"></div>-->


</body>
</html>