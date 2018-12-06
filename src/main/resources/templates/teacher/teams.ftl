<!DOCTYPE HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/splash/splash-icon.png">
<link rel="apple-touch-startup-image" href="images/splash/splash-screen.png" 			media="screen and (max-device-width: 320px)" />  
<link rel="apple-touch-startup-image" href="images/splash/splash-screen_402x.png" 		media="(max-device-width: 480px) and (-webkit-min-device-pixel-ratio: 2)" /> 
<link rel="apple-touch-startup-image" sizes="640x1096" href="images/splash/splash-screen_403x.png" />
<link rel="apple-touch-startup-image" sizes="1024x748" href="images/splash/splash-screen-ipad-landscape" media="screen and (min-device-width : 481px) and (max-device-width : 1024px) and (orientation : landscape)" />
<link rel="apple-touch-startup-image" sizes="768x1004" href="images/splash/splash-screen-ipad-portrait.png" media="screen and (min-device-width : 481px) and (max-device-width : 1024px) and (orientation : portrait)" />
<link rel="apple-touch-startup-image" sizes="1536x2008" href="images/splash/splash-screen-ipad-portrait-retina.png"   media="(device-width: 768px)	and (orientation: portrait)	and (-webkit-device-pixel-ratio: 2)"/>
<link rel="apple-touch-startup-image" sizes="1496x2048" href="images/splash/splash-screen-ipad-landscape-retina.png"   media="(device-width: 768px)	and (orientation: landscape)	and (-webkit-device-pixel-ratio: 2)"/>

<title>学生组队</title>

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
                <a href="/teacher/homepage" class="home-icon">讨论课</a>
                <em class="active-menu"></em>
            </div>
        </div>
    </div>
</div>

<div class="content">
    <div class="distance3"></div>
    <div class="center-navigation">
        <div class="layui-collapse" lay-accordion="">
            <#list teamList as team>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">${classList[team?index].classSerial}-${team.teamSerial} &nbsp&nbsp&nbsp${team.teamName}</h2>
                <div class="layui-colla-content">
                    <p class="text-center">组长：${leaderList[team?index].studentName}</p>
                    <p class="text-center">成员：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </p>
                    <#list studentList[team?index] as student>
                    <p class="text-center">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${student.studentName}&nbsp&nbsp&nbsp${student.account}</p>
                    <#--<p class="text-center">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 李晓霞</p>-->
                    </#list>
                </div>
            </div>
            </#list>
            <#--<div class="layui-colla-item">-->
                <#--<h2 class="layui-colla-title">1-2 晚晚鸟</h2>-->
                <#--<div class="layui-colla-content">-->
                    <#--<p class="text-center">组长： 罗小黑</p>-->
                    <#--<p class="text-center">组员： 刘晓波</p>-->
                    <#--<p class="text-center">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 王洪</p>-->
                    <#--<p class="text-center">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 李晓霞</p>-->
                <#--</div>-->
            <#--</div>-->
        </div>
    </div>
</div>


<div class="back-button">
    <a href="/teacher/courses" class="button-return button-dark">返回</a>
</div>

<!--
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

<script>
    layui.use(['element', 'layer'], function(){
        var element = layui.element();
        var layer = layui.layer;

        //监听折叠
        element.on('collapse(test)', function(data){
            layer.msg('展开状态：'+ data.show);
        });
    });
</script>
</body>
</html>