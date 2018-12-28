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
        <div class="navigation-back">
            <h1 class="navigation-back">待办及通知</h1>
            <a href="/teacher/index" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
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
    <div class="distance3"></div>
    <#list shareSeminarApplicationList as application>
    <div class="center-navigation">
        <div class="layui-collapse" lay-accordion="">
            <div class="layui-colla-item layui-anim layui-anim-fadein">
                <h2 class="layui-colla-title">${application.mainCourse.courseName}的共享讨论课请求</h2>
                <div class="layui-colla-content">
                    <p class="text-center">${application.mainCourse.courseName}提出与您的${application.subCourse.courseName}共享讨论课</p>
                </div>
                <div class="layui-colla-content">
                    <p class="center center-text "><button name="${application.subCourse.id}" class="layui-btn agreeSeminarButton" id="${application.id}" style="margin:10px 15px 15px 0">同意</button><button class="layui-btn layui-btn-danger refuseButton" name="shareSeminar" id="${application.id}" style="margin:10px 15px 15px 0;">拒绝</button></p>
                </div>
            </div>
        </div>
    </div>
    </#list>
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="distance5"></div>
    <#list shareTeamApplicationList as application>
    <div class="center-navigation">
        <div class="layui-collapse" lay-accordion="">
            <div class="layui-colla-item layui-anim layui-anim-fadein">
                <h2 class="layui-colla-title">${application.mainCourse.courseName}的共享分组请求</h2>
                <div class="layui-colla-content">
                    <p class="text-center">${application.mainCourse.courseName}提出与您的${application.subCourse.courseName}共享分组</p>
                </div>
                <div class="layui-colla-content">
                    <p class="center center-text "><button class="layui-btn agreeTeamButton" name="${application.subCourse.id}" id="${application.id}" style="margin:10px 15px 15px 0">同意</button><button class="layui-btn layui-btn-danger refuseButton" name="shareTeam" id="${application.id}" style="margin:10px 15px 15px 0;">拒绝</button></p>
                </div>
            </div>
        </div>
    </div>
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="distance5"></div>
    </#list>

    <#list teamValidApplicationList as application>
    <div class="center-navigation">
        <div class="layui-collapse" lay-accordion="">
            <div class="layui-colla-item layui-anim layui-anim-fadein">
                <h2 class="layui-colla-title">${application.team.course} &nbsp ${application.team.serial.getSerial()} ${application.team.leader.studentName}的特殊组队请求</h2>
                <div class="layui-colla-content">
                    <p class="text-center">${application.team.course} &nbsp ${application.team.serial.getSerial()} ${application.team.leader.studentName}提出了特殊组队请求，理由如下：</p>
                    <p class="text-center">${application.reason}</p>
                </div>
                <div class="layui-colla-content">
                    <p class="center center-text "><button name="teamValid" class="layui-btn agreeValiButton" id="${application.id}" style="margin:10px 15px 15px 0">同意</button><button class="layui-btn layui-btn-danger refuseButton" name="teamValid" id="${application.id}" style="margin:10px 15px 15px 0;">拒绝</button></p>
                </div>
            </div>
        </div>
    </div>
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="distance5"></div>
    </#list>
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
<style>
    .my-index{
        margin-top: -5px;
        margin-bottom: -5px;
        /* margin: -5px 0; */
        margin-right: 30%;
        float: right;
    }
    .my-content{
        margin-left: -80%;
        /* margin: -5px 0; */
        margin-top: -5px;
        margin-bottom: -5px;
    }
</style>
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
<script>
    $(".agreeSeminarButton").bind("click",function () {
        var applicationId=$(this).attr("id");
        var courseId=$(this).attr('name');
        $.ajax(
                {
                    url:'/teacher/message/handle',
                    type:'post',
                    data:{"applicationId":applicationId,"status":1,"type":"seminar","courseId":courseId}
                    success:function(data,status,response){
                        if(response.status=="200") {
                            window.location.reload();
                        }
                    },
                    error:function(data,status,response){
                        if(response.status=="404") {
                            layer.alert("请求未找到！",{icon:5});
                        }
                        else if(response.status=="409"){
                            layer.alert("从课程无法接受其他共享！",{icon:5});
                        }
                    }
                }
        );
    });

    $(".agreeTeamButton").bind("click",function () {
        var applicationId=$(this).attr("id");
        var courseId=$(this).attr('name');
        $.ajax(
                {
                    url:'/teacher/message/handle',
                    type:'post',
                    data:{"applicationId":applicationId,"status":1,"type":"team","courseId":courseId}
                    success:function(data,status,response){
                        if(response.status=="200") {
                            window.location.reload();
                        }
                    },
                    error:function(data,status,response){
                        if(response.status=="404") {
                            layer.alert("请求未找到！",{icon:5});
                        }
                        else if(response.status=="409"){
                            layer.alert("从课程无法接受其他共享！",{icon:5});
                        }
                    }
                }
        );
    });

    $(".agreeValiButton").bind("click",function () {
        var applicationId=$(this).attr("id");
        var type=$(this).attr('name');
        $.ajax(
                {
                    url:'/teacher/message/handle',
                    type:'post',
                    data:{"applicationId":applicationId,"status":1,"type":"validate"}
                    success:function(data,status,response){
                        if(response.status=="200") {
                            window.location.reload();
                        }
                    },
                    error:function(data,status,response){
                        if(response.status=="404") {
                            layer.alert("请求未找到！",{icon:5});
                        }
                    }
                }
        );
    });

    $(".refuseButton").bind("click",function () {
        var applicationId=$(this).attr("name");
        $.ajax(
                {
                    url:'/teacher/message/handle',
                    type:'post',
                    data:{"applicationId":applicationId,"status":0,"type":type},
                    success:function(data,status,response){
                        if(response.status=="200") {
                            window.location.reload();
                        }
                    },
                    error:function(data,status,response){
                        if(response.status=="404") {
                            layer.alert("请求未找到！",{icon:5});
                        }
                    }
                }
        );
    });
</script>
</html>