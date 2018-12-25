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
            <h1 class="navigation-back">${seminarControl.courseClass.course.courseName}</h1>
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
    <div class="center-navigation">
        <table class="layui-table" lay-skin="nob">
            <colgroup>
                <col width="100">
                <col width="200">
            </colgroup>
            <tbody>
            <#list 0..<seminarControl.seminarInfo.maxGroup as t>
                <#if seminarControl.presentationList[t]??>
                    <tr>
                        <td>第${t+1}组：</td>
                        <#if seminarControl.seminarStatus==0 && seminarControl.presentationList[t].pptName??>
                            <td style="color:#009688;">${seminarControl.presentationList[t].team.courseClass.classSerial}-${seminarControl.presentationList[t].team.teamSerial}&nbsp;&nbsp;${seminarControl.presentationList[t].pptName}</td>
                        <#elseif seminarControl.presentationList[t].pptName??>
                            <td style="color:#009688;">${seminarControl.presentationList[t].team.courseClass.classSerial}-${seminarControl.presentationList[t].team.teamSerial}&nbsp;&nbsp;<a>${seminarControl.presentationList[t].pptName}</a></td>
                        <#else>
                            <td style="color:#009688;">${seminarControl.presentationList[t].team.courseClass.classSerial}-${seminarControl.presentationList[t].team.teamSerial}&nbsp;&nbsp;未提交</td>
                        </#if>
                    </tr>
                <#else>
                <tr>
                    <td>第${t+1}组：</td>
                    <td style="color:#009688;">未报名</td>
                </tr>
                </#if>
            </#list>
            <#--<tr>-->
                <#--<td>第一组：</td>-->
                <#--<#if seminarControl.seminarStatus==0>-->
                <#--<td style="color:#009688;">1-1业务流程.ppt</td>-->
                <#--<#else>-->
                <#--<td style="color:#009688;">1-1<a>1-1业务流程.ppt</a></td>-->
                <#--</#if>-->
            <#--</tr>-->
            <#--<tr>-->
                <#--<td>第二组：</td>-->
                <#--<td style="color:#009688;">1-2 未提交</td>-->
            <#--</tr>-->
            <#--<tr>-->
                <#--<td>第三组：</td>-->
                <#--<td style="color:#009688;">1-3 未报名</td>-->
            <#--</tr>-->
            <#--<tr>-->
                <#--<td>第四组：</td>-->
                <#--<#if seminarControl.seminarStatus==0>-->
                <#--<td style="color:#009688;">1-4业务流程.ppt</td>-->
                <#--<#else>-->
                <#--<td style="color:#009688;">1-4<a>1-4业务流程.ppt</a></td>-->
                <#--</#if>-->
            <#--</tr>-->
            <#--<tr>-->
                <#--<td>第五组：</td>-->
                <#--<#if seminarControl.seminarStatus==0>-->
                <#--<td style="color:#009688;">1-5业务流程.ppt</td>-->
                <#--<#else>-->
                <#--<td style="color:#009688;">1-5<a>1-5业务流程.ppt</a></td>-->
                <#--</#if>-->
            <#--</tr>-->
            <#--<tr>-->
                <#--<td>第六组：</td>-->
                <#--<#if seminarControl.seminarStatus==0>-->
                <#--<td style="color:#009688;">1-6业务流程.ppt</td>-->
                <#--<#else>-->
                <#--<td style="color:#009688;">1-6<a>1-6业务流程.ppt</a></td>-->
                <#--</#if>-->
            <#--</tr>-->
            </tbody>
        </table>
        <div class="distance4"></div>
        <div class="distance"></div>
    </div>
</div>

<!--<div class="bottom-deco"></div>-->


</body>
</html>