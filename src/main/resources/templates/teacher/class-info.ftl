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
            班级简介：&emsp;${class.introduction}<br>
            班级学生名单： &emsp;周三56节.xlsx<br>
        <p class="file center-text"><input type="file"></p>
        </p>
        <p class="center center-text"><button class="button-big button-red deleteButton" id="deleteButton" name="${class.id}">删除班级</button></p>
    </div>
    <div class="decoration"></div>
    </#list>
</div>
<div class="distance4"></div>
<div class="layui-colla-item">
    <h2 class="layui-colla-title my-navigation2"  onclick="window.location.href='/teacher/create-class'" style="width: 200px; text-align: center;margin:0 auto;padding: 0;">新建班级</h2>
</div>
<div class="distance4"></div>
<div class="distance4"></div>
<!--<div class="bottom-deco"></div>-->
<script>
    $('.deleteButton').click(function(){
        $.ajax({
            type: "DELETE",
            url: "/teacher/courses/class?classId=" + $(this).attr('name'),
            success: function(data){
                if(data==="200")
                    window.location.href="/teacher/courses";
                else if(data==="404")
                    alert("班级不存在");
            }
        });
    });
</script>

</body>
</html>