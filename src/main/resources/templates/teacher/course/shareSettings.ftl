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
            <h1 class="navigation-back">${course.courseName}</h1>
            <a href="/teacher/courseList" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
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
    <#list course.seminarSubCourseList as subCourse>
    <div class="center-navigation">
        <div class="layui-collapse" lay-accordion="">
            <div class="layui-colla-item layui-anim layui-anim-fadein">
                <h2 class="layui-colla-title">${subCourse.courseName}</h2>
                <div class="layui-colla-content">
                    <table class="layui-table" style="margin:0;border:none;">
                        <tbody>
                        <tr class="item">
                            <td width="150" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-index" style="margin-top:-5px;">共享类型：</a>
                            </td>
                            <td width="100" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-content" style="margin-top:-5px;">共享讨论课</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="layui-colla-content">
                    <table class="layui-table" style="margin:0;border:none;">
                        <tbody>
                        <tr class="item">
                            <td width="150" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-index" style="margin-top:-5px;">共享情况：</a>
                            </td>
                            <td width="100" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-content" style="margin-top:-5px;">主课程</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="layui-colla-content">
                    <p class="center center-text "><button class="layui-btn cancelSeminarButton" name="${subCourse.id}" style="margin-top:10px;">取消共享</button></p>
                </div>
            </div>
        </div>
    </div>
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="distance5"></div>
    </#list>
    <#list course.teamSubCourseList as subCourse>
    <div class="center-navigation">
        <div class="layui-collapse" lay-accordion="">
            <div class="layui-colla-item layui-anim layui-anim-fadein">
                <h2 class="layui-colla-title">${subCourse.courseName}</h2>
                <div class="layui-colla-content">
                    <table class="layui-table" style="margin:0;border:none;">
                        <tbody>
                        <tr class="item">
                            <td width="150" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-index" style="margin-top:-5px;">共享类型：</a>
                            </td>
                            <td width="100" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-content" style="margin-top:-5px;">共享分组</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="layui-colla-content">
                    <table class="layui-table" style="margin:0;border:none;">
                        <tbody>
                        <tr class="item">
                            <td width="150" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-index" style="margin-top:-5px;">共享情况：</a>
                            </td>
                            <td width="100" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-content" style="margin-top:-5px;">主课程</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="layui-colla-content">
                    <p class="center center-text "><button class="layui-btn cancelTeamButton" name="${subCourse.id}" style="margin-top:10px;">取消共享</button></p>
                </div>
            </div>
        </div>
    </div>
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="distance5"></div>
    </#list>
    <#if seminarMainCourse??>
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="distance5"></div>
    <div class="center-navigation">
        <div class="layui-collapse" lay-accordion="">
            <div class="layui-colla-item layui-anim layui-anim-fadein">
                <h2 class="layui-colla-title">${seminarMainCourse.courseName}</h2>
                <div class="layui-colla-content">
                    <table class="layui-table" style="margin:0;border:none;">
                        <tbody>
                        <tr class="item">
                            <td width="150" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-index" style="margin-top:-5px;">共享类型：</a>
                            </td>
                            <td width="100" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-content" style="margin-top:-5px;"> 共享讨论课</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="layui-colla-content">
                    <table class="layui-table" style="margin:0;border:none;">
                        <tbody>
                        <tr class="item">
                            <td width="150" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-index" style="margin-top:-5px;">共享情况：</a>
                            </td>
                            <td width="100" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-content" style="margin-top:-5px;">从课程</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="layui-colla-content">
                    <p class="center center-text "><button class="layui-btn cancelSeminarButton" name="${seminarMainCourse.id}" style="margin-top:10px;">取消共享</button></p>
                </div>
            </div>
        </div>
    </div>
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="distance5"></div>
    </#if>
    <#if teamMainCourse??>
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="distance5"></div>
    <div class="center-navigation">
        <div class="layui-collapse" lay-accordion="">
            <div class="layui-colla-item layui-anim layui-anim-fadein">
                <h2 class="layui-colla-title">${teamMainCourse.courseName}</h2>
                <div class="layui-colla-content">
                    <table class="layui-table" style="margin:0;border:none;">
                        <tbody>
                        <tr class="item">
                            <td width="150" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-index" style="margin-top:-5px;">共享类型：</a>
                            </td>
                            <td width="100" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-content" style="margin-top:-5px;"> 共享分组</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="layui-colla-content">
                    <table class="layui-table" style="margin:0;border:none;">
                        <tbody>
                        <tr class="item">
                            <td width="150" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-index" style="margin-top:-5px;">共享情况：</a>
                            </td>
                            <td width="100" style="border: none;margin:0;">
                                <a class="my-navigation layui-anim layui-anim-fadein my-content" style="margin-top:-5px;">从课程</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="layui-colla-content">
                    <p class="center center-text "><button class="layui-btn cancelTeamButton" name="${course.id}" style="margin-top:10px;">取消共享</button></p>
                </div>
            </div>
        </div>
    </div>
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="distance5"></div>
    </#if>
    <div class="distance3"></div>
    <div class="center-navigation">
        <div class="layui-colla-item">
            <h2 class="layui-colla-title my-navigation2"  onclick="window.location.href='/teacher/course/addShare?courseId=${course.id}'" >新增共享</h2>
        </div>
    </div>
    <div class="distance2"></div>
    <div class="distance"></div>
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
<#--<script>-->
    <#--$(".cancelButton").bind("click",function () {-->
        <#--$.ajax(-->
                <#--{-->
                    <#--url:"/teacher/course/application/cancel",-->
                    <#--type:'post',-->
                    <#--data:{},-->
                    <#--success:function(data,status,response){-->
                        <#--if(response.status=="200"){-->
                            <#--alert("共享请求已成功发送！");-->
                            <#--window.location.href='/teacher/course/shareSettings?courseId=${course.id}';-->
                        <#--}-->
                    <#--},-->
                    <#--error:function(data,status){-->
                        <#--alert("添加失败!");-->
                    <#--}-->
                <#--}-->
        <#--);-->
    <#--});-->
<#--</script>-->
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
    $(".cancelSeminarButton").bind("click",function () {
        var courseId=$(this).attr('name');
        $.ajax(
                {
                    url:'/teacher/course/application/cancel',
                    type:'post',
                    data:{"type":"seminar","courseId":courseId},
                    success:function(data,status,response){
                        if(response.status=="200") {
                            window.location.reload();
                        }
                    },
                    error:function(data,status,response){
                        alert("共享关系未找到!");

                    }
                }
        );
    });
    $(".cancelTeamButton").bind("click",function () {
        var courseId=$(this).attr('name');
        $.ajax(
                {
                    url:'/teacher/course/application/cancel',
                    type:'post',
                    data:{"type":"team","courseId":courseId},
                    success:function(data,status,response){
                        if(response.status=="200") {
                            window.location.reload();
                        }
                    },
                    error:function(data,status,response){
                            alert("共享关系未找到!");
                    }
                }
        );
    });
</script>
</body>
</html>