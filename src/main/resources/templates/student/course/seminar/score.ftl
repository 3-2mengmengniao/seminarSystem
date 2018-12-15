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
            <a href="/student/course/seminar/info?courseId=${course.id}&seminarId=${seminarInfo.id}&classId=${classId}" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
        </div>
        <a href="#" class="sub-go-menu"></a>
        <a href="#" class="sub-go-back"></a>
    </div>
    <div class="decoration"></div>

    <div class="navigation" style="right:0%;margin-top:-5px;">
        <div class="corner-deco"></div>
        <div class="navigation-wrapper">
            <div class="navigation-item">
                <a href="/student/index" class="home-icon">个人页</a>
                <em class="active-menu"></em>
            </div>
            <div class="navigation-item">
                <a href="/student/seminars" class="home-icon">讨论课</a>
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
                <td>报名情况</td>
                <td>2016-（1）第3组</td>
            </tr>
            <tr>
                <td> PPT</td>
                <td>5.0</td>
            </tr>
            <tr>
                <td> 书面报告</td>
                <td>5.0</td>
            </tr>
            <tr>
                <td> 提问</td>
                <td>5.0</td>
            </tr>
            <tr>
                <td> 总成绩</td>
                <td>5.0</td>
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