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
    <script src="/scripts/sockjs.js"></script>
    <script src="/scripts/stomp.js"></script>



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
            <h1 class="navigation-back">OOAD</h1>
            <a href="/student/courseList" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
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
    <h2 class="center-text" id="notation">1-1组正在展示 <span id="greetings">当前有0人提问</span></h2>
    <span id="teamId" name="${myTeam.id}"></span>
    <span id="seminarId" name="${seminarControl.id}"></span>
    <span id="studentId" name="${studentId}"></span>
    <span id="usertype" name="student"></span>
    <div class="distance"></div>
    <div class="center-navigation">
        <table class="layui-table" lay-skin="nob">
            <colgroup>
                <col width="100">
                <col width="100">
            </colgroup>
            <tbody>
            <#list 0..<seminarControl.seminarInfo.maxGroup as t>
                <#if seminarControl.presentationList[t]??>
                    <#if seminarControl.presentationList[t].present==1>
                        <tr class="group active">
                            <td class="active">第${t+1}组：</td>
                            <td class="active">${seminarControl.presentationList[t].team.serial.getSerial()}</td>
                        </tr>
                    <#else>
                        <tr class="group">
                            <td>第${t+1}组：</td>
                            <td>${seminarControl.presentationList[t].team.serial.getSerial()}</td>
                        </tr>
                    </#if>
                </#if>
            </#list>
            </tbody>
        </table>
        <div class="distance4"></div>
        <div class="distance"></div>
    </div>
</div>

<div class="distance4"></div>
<div class="distance"></div>
<p class="center center-text"><button type="button" class="button-return button-turqoise" id="QAbutton">Q&A</button></p>
<div class="distance"></div>
<!--<div class="bottom-deco"></div>-->


</body>
<script src="/scripts/app.js"></script>
<script>
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#QAbutton" ).click(function() { sendQuestion(); });

</script>
<style>
    .active{
        color:darkred;
    }
    .normal{
        color:#009688;
    }
</style>
</html>