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
    <link href="/layui/css/layui.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="/scripts/jquery.js"></script>
    <script type="text/javascript" src="/scripts/jqueryui.js"></script>
    <script type="text/javascript" src="/scripts/snap.js"></script>
    <script type="text/javascript" src="/scripts/courseDelete.js"></script>
    <script type="text/javascript" src="/scripts/custom.js"></script>
    <script type="text/javascript" src="/scripts/framework.js"></script>
    <script type="text/javascript" src="/scripts/framework.launcher.js"></script>
    <script type="text/javascript" src="/layui/layui.js" charset="utf-8"></script>


    <!--<div class="bottom-deco"></div>-->



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
    <a href="/teacher/courseList" class="button-close" style="margin-top:-45px;">x</a>
</div>
<div class="decoration"></div>

<div class="content">
    <div class="center-navigation">
        <div class="center-panel">
            <div class="distance3"></div>
            <table  class="info-table layui-table" style="border:none;border-width:0 0;" lay-size="lg" lay-skin="line"  >
                <colgroup>
                    <col width="100" >
                    <col width="200" >
                </colgroup>
                <tr>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;">成绩计算规则:</a>
                    </td>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;">课堂展示    ${course.presentationPercentage}%</a>
                    </td>
                </tr>
                <tr>
                    <td style="padding:0 0;">
                    </td>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;">课堂提问    ${course.questionPercentage}%</a>
                    </td>
                </tr>
                <tr>
                    <td style="padding:0 0;">
                    </td>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;">课堂报告    ${course.reportPercentage}%</a>
                    </td>
                </tr>
            </table>
            <h3 class="my-title">分组规则</h3>
            <table  class="info-table layui-table" style="border:none;border-width:0 0;" lay-size="lg" lay-skin="line"  >
                <colgroup>
                    <col width="150" >
                    <col width="200" >
                </colgroup>
                <tr>
                    <td style="padding:0 0;"><a style="font-size:15px;">组队开始时间：</a>
                    </td>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;">${course.teamStartTime?string('yyyy-MM-dd HH:mm:ss')}</a>
                    </td>
                </tr>
                <tr>
                    <td style="padding:0 0;"><a style="font-size:15px;">组队截止时间：</a>
                    </td>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;"> ${course.teamEndTime?string('yyyy-MM-dd HH:mm:ss')}</a>
                    </td>
                </tr>
            </table>
            <div style="height:20px;"></div>
            <!--</p>-->
            <!--<h2 class="my-title">分组规则</h2>-->
            <!--<p class="margin4">-->
            <!--小组人数：&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;6~8人<br>-->
            <!--组队开始时间：&emsp; &emsp;${course.teamStartTime?string('yyyy-MM-dd HH:mm:ss')}<br>-->
            <!--组队截止时间：&emsp;&emsp; ${course.teamEndTime?string('yyyy-MM-dd HH:mm:ss')}<br>-->
            <!--</p>-->
            <!--<div class="distance"></div>-->
        </div>
        <div class="center-panel" style="margin-top:15px;">
            <div class="distance3"></div>
            <h2 class="my-title" style="margin-bottom:15px;">组队要求</h2>
            <h3 class="my-title">组员基本要求</h3>
            <table  class="info-table layui-table" style="border:none;border-width:0 0;" style="border:none;border-width:0 0;" lay-size="lg" lay-skin="line"  >
                <colgroup>
                    <col width="200" >
                    <col width="100" >
                </colgroup>
                <tr>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;">小组总人数：(含组长)</a>
                    </td>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;">${thisCourse.getMinMember()}~${thisCourse.getMaxMember()}人</a>
                    </td>
                </tr>
            </table>
            <h3 class="my-title">组内选修课程人数：</h3>
            <table  class="info-table layui-table" style="border:none;border-width:0 0;" style="border:none;border-width:0 0;" lay-size="lg" lay-skin="line"  >
                <colgroup>
                    <col width="200" >
                    <col width="100" >
                </colgroup>
                <#list memberLimit as strategy>
                    <tr>
                        <td style="padding:0 0;">
                            <a style="font-size:15px;">${optionCourses[strategy?index].courseName}:</a>
                        </td>
                        <td style="padding:0 0;">
                            <a style="font-size:15px;">${strategy.getMinMember()}~${strategy.getMaxMember()}人</a>
                        </td>
                    </tr>
                </#list>
                <tr>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;">选修课程人数要求：</a>
                    </td>
                    <td style="padding:0 0;">
                        <#if choose==0>
                            <a style="font-size:15px;">均满足</a>
                         <#else>
                            <a style="font-size:15px;">任一满足</a>
                        </#if>
                    </td>
                </tr>
            </table>
            <div style="10px;"></div>
            <h3 class="my-title">冲突课程</h3>
            <table  class="info-table layui-table" style="border:none;border-width:0 0;" lay-size="lg" lay-skin="line"  >
                <#list conflictCourses as courseList>
                <tr>
                    <td style="padding:0 0;">
                        <#list courseList as oneCourse>
                            <span style="font-size:13px;">${oneCourse.courseName}</span>
                        </#list>
                    </td>
                </tr>
                </#list>
            </table>
            <div style="10px;"></div>
        </div>
    </div>
    <p style="margin-top:15px;" class="center center-text"><button class="button-big button-red" id="deleteButton" >删除课程</button></p>
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

<script>
    $('#deleteButton').click(function(){
        $.ajax({
            type: "DELETE",
            url: "/teacher/course/${course.id}",
            success: function(data,status,response){
                if(response.status=="200")
                    window.location.href="/teacher/courseList";
                else if(data==="404")
                    alert("课程不存在");
            }
        });
    });
</script>
<style>

    .info-table{
        text-align:center;
        margin-left:auto;
        margin-right:auto;
        width:90%;
        background-color:#fff;
        border:none;
        border-width:0 0;
    }
    .my-title{
        text-align:center;
        font-weight:bold;
    }
    .my-content{
        text-align:center;
        margin-left:10%;
        margin-right:10%;
    }
    @media screen and (max-width:768px){
        .margin3{
            margin-left:20%;
        }
        .margin4{
            margin-left:13%;
        }
        .info-table{
            margin-left:auto;
            margin-right:auto;
            width:90%;
            background-color:#fff;
            border:none;
            border-width:0 0;
        }
    }
    @media screen and (min-width:768px){
        .margin3{
            text-align:center;
        }
        .margin4{
            margin-left:33%;
        }
        .info-table{
            margin-left:25%;
            margin-right:20%;
            width:65%;
            background-color:#fff;
            border:none;
            border-width:0 0;
        }
    }
</style>
</body>
</html>