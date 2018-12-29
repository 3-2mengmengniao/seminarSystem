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
            <img id="button-back-image-2" src="/images/icons/展开.png">
            <form id="postForm" action="/student/course/seminar/info" method="post">
                <input type="hidden" value="${seminarControl.seminarInfo.id}" name="seminarId">
                <input type="hidden" value="${seminarControl.courseClass.id}" name="classId">
            </form>
        </div>
        <a href="#" class="sub-go-menu"></a>
        <a href="#" class="sub-go-back"></a>
    </div>
    <div class="decoration"></div>

    <div class="navigation">
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
                            <td style="color:#009688;">${seminarControl.presentationList[t].team.serial.getSerial()}&nbsp;&nbsp;${seminarControl.presentationList[t].pptName}</td>
                        <#elseif seminarControl.presentationList[t].pptName??>
                            <td style="color:#009688;">${seminarControl.presentationList[t].team.serial.getSerial()}&nbsp;&nbsp;<a>${seminarControl.presentationList[t].pptName}</a></td>
                        <#else>
                            <td style="color:#009688;">${seminarControl.presentationList[t].team.serial.getSerial()}&nbsp;&nbsp;未提交</td>
                        </#if>
                    </tr>
                <#else>
                <tr>
                    <td>第${t+1}组：</td>
                    <#if seminarControl.seminarStatus==0>
                        <td style="color:#009688;"><a class="registerButton" name="${t+1}">未报名</a></td>
                    <#else>
                    <td style="color:#009688;">未报名</td>
                    </#if>
                </tr>
                </#if>
            </#list>
            </tbody>
        </table>
        <div class="distance4"></div>
        <div class="distance"></div>
        <#if enrollment==true>
        <button type="button" class="deleteButton layui-btn layui-btn-mini" id="deleteButton"  style="margin-left:50px;background-color: #C0392B">删除班级</button>
        </#if>
    </div>
</div>
<!--<div class="bottom-deco"></div>-->


</body>
<script>
    $('#button-back-image-2').click(function () {
        $('#postForm').submit();
    });
    $('.registerButton').click(function(){
        var t=$(this).attr("name");
        $.ajax({
            type: "POST", // 使用post方式
            url: "/student/course/seminar/info/register?teamId=${team.id}&seminarId=${seminarControl.id}&order="+t,
            success: function(data,status,response){
                    if(response.status=="200"){
                        window.location.reload();
                    }
            },
            error: function(result){
                layer.alert("报名失败！",{icon:5});
            }
        });
    });
    $('#deleteButton').click(function(){
        var t=$(this).attr("name");
        $.ajax({
            type: "POST", // 使用post方式
            url: "/student/course/seminar/info/cancel?teamId=${team.id}&seminarId=${seminarControl.id}",
            success: function(data,status,response){
                if(response.status=="200"){
                    window.location.reload();
                }
            },
            error: function(result){
                layer.alert("取消报名失败！",{icon:5});
            }
        });
    });


</script>
</html>