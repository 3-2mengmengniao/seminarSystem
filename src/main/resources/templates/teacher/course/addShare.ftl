<!DOCTYPE HTML>
<html>
<head xmlns="http://www.w3.org/1999/html">
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
    <link href="/styles/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/layui/css/layui.css" rel="stylesheet" type="text/css">

     <script type="text/javascript" src="/scripts/jquery.js"></script>
    <script type="text/javascript" src="/scripts/jqueryui.js"></script>
    <script type="text/javascript" src="/scripts/owl.carousel.min.js"></script>
    <script type="text/javascript" src="/scripts/jquery.swipebox.js"></script>
    <script type="text/javascript" src="/scripts/colorbox.js"></script>
    <script type="text/javascript" src="/scripts/snap.js"></script>
    <script type="text/javascript" src="/scripts/custom.js"></script>
    <script type="text/javascript" src="/scripts/framework.js"></script>
    <script type="text/javascript" src="/scripts/framework.launcher.js"></script>
    <script type="text/javascript" src="/scripts/bootstrap-3.1.1.min.js"></script>
    <script type="text/javascript" src="/scripts/jquery-1.8.3.min.js" ></script>
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
    <h1 class="navigation-back">新增共享</h1>
    <a href="/teacher/course/shareSettings?courseId=${myCourse.id}" class="button-close">x</a>
</div>
<div class="distace3"></div>
<div class="decoration"></div>

<div class="content">
    <div class="distance3"></div>
    <div class="container no-bottom">
        <form class="layui-form contactForm" action="#" method="post" id="contactForm">
            <div class="formSuccessMessageWrap" id="formSuccessMessageWrap">
                <div class="static-notification-green tap-dismiss-notification">
                    <p style="color:#d44950;">共享失败！</p>
                </div>
            </div>
            <div >
                <div class="distance3"></div>
                <div class="layui-form-item">
                    <label class="layui-form-label ">共享类型</label>
                    <div class="layui-input-block" >
                        <select name="type" class="type">
                            <option value="1">共享讨论课</option>
                            <option value="2" selected>共享分组</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item margin1 ">
                    <label class="layui-form-label">共享对象</label>
                    <div class="layui-input-block">
                        <select name="subCourse">
                            <#list courseList as course>
                            <#if course.id!=myCourse.id>
                            <#if course?index==0||(courseList[0].id==myCourse.id && course?index==1)>
                                <option value="${course.id}" selected>${course.courseName}</option>
                            <#else>
                                <option value="${course.id}">${course.courseName}</option>
                            </#if>
                            </#if>
                            </#list>
                        </select>
                    </div>
                </div>
            </div>
            <div class="decoration"></div>
            <div class="distance4"></div>
            <p class="center center-text"><input type="button" class="layui-btn" id="contactSubmitButton" value="创建共享" data-formId="contactForm"/></p>
        </form>
        <div class="distance2"></div>
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
<script src="/layui/layui.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form();

        //各种基于事件的操作，下面会有进一步介绍
    });
</script>
<script>
    //禁止共享讨论课(value=2)
    $(function(){
        var choose=$('select.type option:selected').attr("value");
        if(choose=="2"){
            $("input.layui-btn").addClass("layui-btn-disabled");
        }
    });

    $('#formSuccessMessageWrap').hide(0);
    $('.formValidationError').fadeOut(0);

    // fields focus function starts
    $('input[type="text"], input[type="password"], textarea').focus(function(){
        if($(this).val() == $(this).attr('data-dummy')){
            $(this).val('');
        };
    });
    // fields focus function ends

    // fields blur function starts
    $('input, textarea').blur(function(){
        if($(this).val() == ''){
            $(this).val($(this).attr('data-dummy'));
        };
    });
    $("#contactSubmitButton").bind("click",function () {
        var fd=new FormData($('#contactForm')[0]);
        var subCourse=fd.get("subCourse");
        alert(subCourse);
        var type=fd.get("type");
        $.ajax(
                {
                    url:"/teacher/course/application/add",
                    type:'post',
                    data:{"mainCourseId":${myCourse.id},"subCourseId":subCourse,"type":type},
                    success:function(data,status,response){
                        if(response.status=="200"){
                            alert("共享请求已成功发送！");
                            window.location.href='/teacher/course/shareSettings?courseId=${myCourse.id}';
                        }
                    },
                    error:function(data,status){
                        alert("添加失败!");
                    }
                }
        );
    });
</script>

<style>
    .layui-unselect{
        width: 200px;
    }
</style>

</body>
</html>