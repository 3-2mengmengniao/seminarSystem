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
            <h1 class="navigation-back">${seminarControl.courseClass.course.courseName}讨论课成绩</h1>
            <a href="/teacher/course/seminar/info?courseId=${seminarControl.courseClass.course.id}&seminarId=${seminarControl.seminarInfo.id}&classId=${seminarControl.courseClass.id}" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
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
    <div class="container no-bottom text-list">
        <div class="container no-bottom">
            <table cellspacing='0' class="table">
                <thead>
                <tr>
                    <th>小组</th>
                    <th>展示</th>
                    <th>提问</th>
                    <th>报告</th>
                    <th>总分</th>
                </tr>
                </thead>
                <tbody>
                <#list seminarScoreList as seminarScore>
                    <tr>
                        <td>${seminarControl.courseClass}-${seminarScore.teamSerial.teamSerial}</td>
                        <td>${seminarScore.presentationScore!""}</td>
                        <td>${seminarScore.questionScore!""}</td>
                        <td>${seminarScore.reportScore!""}</td>
                        <td>${seminarScore.totalScore!""}</td>
                    </tr>
                </#list>
                <#--<#if seminarControl.seminarScoreList??>-->
                <#--<#list seminarControl.seminarScoreList as seminarScore>-->
                    <#--<tr>-->
                        <#--<td>1-1</td>-->
                        <#--<td>${seminarScore.presentationScore!""}</td>-->
                        <#--<td>${seminarScore.questionScore!""}</td>-->
                        <#--<td>${seminarScore.reportScore!""}</td>-->
                        <#--<td>${seminarScore.totalScore!""}</td>-->
                    <#--</tr>-->
                <#--</#list>-->
                <#--</#if>-->
                <#--<tr>-->
                    <#--<td>1-2</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                <#--</tr>-->
                <#--<tr>-->
                    <#--<td>1-3</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                <#--</tr>-->
                <#--<tr>-->
                    <#--<td>1-4</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                <#--</tr>-->
                <#--<tr>-->
                    <#--<td>1-5</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                    <#--<td>5.0</td>-->
                <#--</tr>-->
                </tbody>

            </table>
        </div>

        <div class="distance"></div>
        <p class="center center-text"><a href="#" class="button-return button-turqoise">确认</a></p>
        <div class="distance4"></div>
        <p class="center center-text"><a href="#" class="button-return button-turqoise">修改</a></p>
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