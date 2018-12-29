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
            <h1 class="navigation-back">${seminarControl.courseClass.course.courseName}讨论课</h1>
            <a href="/teacher/course/seminar/info?courseId=${seminarControl.courseClass.course.id}&seminarId=${seminarControl.seminarInfo.id}&classId=${seminarControl.courseClass.id}" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
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
        <form id="contactForm">
        <div class="center-navigation">
            <table class="layui-table" lay-skin="nob">
                <colgroup>
                    <col width="100">
                    <col width="200">
                    <col width="100">
                </colgroup>
                <tbody>
            <#list 0..<seminarControl.seminarInfo.maxGroup as t>
                <#if seminarControl.presentationList[t]??>
                    <tr>
                        <td>第${t+1}组：</td>
                        <#if seminarControl.presentationList[t].reportName??>
                            <td style="color:#009688;">${seminarControl.presentationList[t].team.serial.getSerial()}&nbsp;&nbsp;<a>${seminarControl.presentationList[t].reportName}</a></td>
                        <#else>
                            <td style="color:#009688;">${seminarControl.presentationList[t].team.serial.getSerial()}&nbsp;&nbsp;未提交</td>
                        </#if>
                        <td><input name="reportScore" type="text" value="${seminarControl.seminarScoreList[t].reportScore!"0"}" style="width:50px; "/></td>
                    </tr>
                <#else>
                <tr>
                    <td>第${t+1}组：</td>
                    <td style="color:#009688;">未报名</td>
                    <td><input type="text" name="reportScore" value="${(seminarControl.seminarScoreList[t].reportScore)!" "}" style="width:50px; "/></td>
                </tr>
                </#if>
            </#list>
                </tbody>
            </table>

            <div class="distance4"></div>
            <div class="distance"></div>
        </div>

        <div class="distance4"></div>
        <div class="distance"></div>
        <p class="center center-text"><button type="button" id="submitButton" class="button-return button-turqoise">修改</button></p>
        </form>
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

<script>
    $('#submitButton').click(function(){
        var fd=new FormData($('#contactForm')[0]);
        var reportScores=JSON.stringify(fd.getAll("reportScore"));
        $.ajax(
                {
                    url: "/teacher/course/seminar/reportScore",
                    type: 'post',
                    data: {"reportScore": reportScores, "seminarId":${seminarControl.id}},
                        success: function (data) {
                            alert("您已成功提交！")
                        },
                        error: function (data) {
                            alert("提交失败");
                        }
                }
        );
        return false;
    });

</script>
</body>
</html>