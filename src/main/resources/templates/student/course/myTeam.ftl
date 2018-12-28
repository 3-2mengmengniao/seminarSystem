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
            <h1 class="navigation-back">${course.courseName}小组详情</h1>
            <a href="/student/course/teams?courseId=${course.id}" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
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
    <div class="center-navigation">
        <div style="height:10px;"></div>
        <div class="center-panel">
            <div style="height:30px;"></div>
            <h2 class="my-title">${myTeam.serial.getSerial()} ${myTeam.teamName}</h2>
            <div style="height:10px;"></div>
            <table  class="info-table layui-table" style="border:none;border-width:0 0;" lay-size="lg" lay-skin="line"  >
                <colgroup>
                    <col width="50" >
                    <col width="200" >
                </colgroup>
                <tr>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;">组长：</a>
                    </td>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;">${myTeam.leader.account}&emsp;&emsp;${myTeam.leader.studentName}</a>
                    </td>
                </tr>
                <#list myTeam.memberList as student>
                    <#if student.id!=myTeam.leader.id>
                <tr>
                    <#if student?index==0 || (myTeam.memberList[0].id==myTeam.leader.id && student?index==1)>
                        <td style="padding:0 0;">
                            <a style="font-size:15px;">组员：</a>
                        </td>
                    <#else>
                        <td style="padding:0 0;">
                        </td>
                    </#if>
                    <td style="padding:0 0;">
                        <a style="font-size:15px;">${student.account}&emsp;&emsp;${student.studentName}</a>
                    </td>
                </tr>
                    </#if>
                </#list>
            <#--<tr>-->
            <#---->
            <#--<td style="padding:0 0;">-->
            <#--<a style="font-size:15px;">24320162202877&emsp;&emsp;小刘</a>-->
            <#--</td>-->
            <#--</tr>-->
            <#--<tr>-->
            <#--<td style="padding:0 0;">-->
            <#--</td>-->
            <#--<td style="padding:0 0;">-->
            <#--<a style="font-size:15px;">24320162202877&emsp;&emsp;小刘</a>-->
            <#--</td>-->
            <#--</tr>-->

            </table>
            <div style="height:20px;"></div>
        </div>
        <div style="height:15px;"></div>
        <p style="margin-top:15px;" class="center center-text"><button class="button-big button-red" id="deleteButton" >退出小组</button></p>
    </div>
</div>

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
<style>
    @media screen and (max-width:768px){
        .margin3{
            margin-left:35%;
        }
    }
    @media screen and (min-width:768px){
        .margin3{
            margin-left:44%;
        }
    }

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