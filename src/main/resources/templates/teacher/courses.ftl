<!DOCTYPE HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black">


<title>课程</title>

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
<#list courseList as course>
    <div class="distance3"></div>
    <div class="center-navigation">
        <div class="layui-collapse" lay-accordion="">
            <div class="layui-colla-item layui-anim layui-anim-fadein">
                <h2 class="layui-colla-title">${course.courseName}</h2>
                <div class="layui-colla-content">
                    <i class="layui-icon layui-icon-form layui-anim layui-anim-fadein"></i>
                    <a class="my-navigation layui-anim layui-anim-fadein" href="/teacher/group-score">学生成绩</a>
                </div>
                <div class="layui-colla-content">
                    <i class="layui-icon layui-icon-group layui-anim layui-anim-fadein"></i>
                    <a class="my-navigation layui-anim layui-anim-fadein" href="/teacher/teams">学生组队</a>
                </div>
                <div class="layui-colla-content">
                    <i class="layui-icon layui-icon-about layui-anim layui-anim-fadein"></i>
                    <a class="my-navigation layui-anim layui-anim-fadein" href="/teacher/course-info?courseId=${course.id}">课程信息</a>
                </div>
                <div class="layui-colla-content">
                    <i class="layui-icon layui-icon-about layui-anim layui-anim-fadein"></i>
                    <a class="my-navigation layui-anim layui-anim-fadein" href="/teacher/class-info?courseId=${course.id}">班级信息</a>
                </div>
                <div class="layui-colla-content">
                    <i class="layui-icon layui-icon-menu-fill layui-anim layui-anim-fadein"></i>
                    <a class="my-navigation layui-anim layui-anim-fadein" href="/teacher/course-seminar?courseId=${course.id}">讨论课轮次</a>
                </div>
                <div class="layui-colla-content">
                    <i class="layui-icon layui-icon-set-fill layui-anim layui-anim-fadein"></i>
                    <a class="my-navigation layui-anim layui-anim-fadein"  href="#">共享设置</a>
                </div>
            </div>
        </div>
    </div>
    <div class="distance3"></div>

    </#list>
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="distance5"></div>
    <div class="center-navigation">
    <div class="layui-colla-item">
        <h2 class="layui-colla-title my-navigation2"  onclick="window.location.href='/teacher/create-course'" >新建课程</h2>
    </div>
    </div>
    <div class="distance2"></div>
    <div class="distance"></div>
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
</div>
-->
<!--<div class="bottom-deco"></div>-->

</body>
<script>
    //注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        element.on('collapse(filter)', function(data){
            console.log(data.show); //得到当前面板的展开状态，true或者false
            console.log(data.title); //得到当前点击面板的标题区域DOM对象
            console.log(data.content); //得到当前点击面板的内容区域DOM对象
        });
    });
</script>
</html>