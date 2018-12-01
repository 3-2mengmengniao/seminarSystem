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
<div class="navigation-back">
    <h1 class="navigation-back">${course.courseName}</h1>
    <a href="/teacher/courses" class="button-close">x</a>
</div>
<div class="decoration"></div>

<div class="content">
    <div class="container no-bottom">
        <h3>课程要求</h3>
        <p>
            ${course.introduction}
        </p>
        <h3>成绩计算规则</h3>
        <p>
            课堂展示    ${course.presentationProportion}%<br>
            课堂提问    ${course.questionProportion}%<br>
            课堂报告    ${course.reportProportion}%<br>
        </p>
        <h3>分组规则</h3>
        <p>
            小组人数：&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${course.minTeamMember}~${course.maxTeamMember}人<br>
            组队开始时间：&emsp; &emsp;${course.teamStartTime?string('yyyy-MM-dd HH:mm:ss')}<br>
            组队截止时间：&emsp;&emsp; ${course.teamEndTime?string('yyyy-MM-dd HH:mm:ss')}<br>
        </p>
        <div class="distance"></div>
        <p class="center center-text"><button class="button-big button-red" id="deleteButton" >删除课程</button></p>
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
    -->
</div>

<!--<div class="bottom-deco"></div>-->
<script>
    $(function(){
        $('#deleteButton').click(function(){
            $.ajax({
                type: "DELETE",
                url: "/teacher/courses?courseId=${course.id}",
                success: function(data){
                    if(data=="200")
                        window.location.href="/teacher/courses";
                    else if(data=="404")
                        alert("课程不存在");
                }
            });
        });
    });
</script>

</body>
</html>