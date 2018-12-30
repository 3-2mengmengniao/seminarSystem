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
            <h2 class="my-title">${myTeam.serial.getSerial()} ${myTeam.teamName} &nbsp&nbsp&nbsp</h2>
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
                        <a style="font-size:15px;">${myTeam.leader.account}&emsp;${myTeam.leader.studentName}</a>
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
                            <a style="font-size:15px;display: inline;">${student.account}&emsp;${student.studentName}</a> <img class="deleteMember" src="/images/删除.png" name="${student.id}" />
                        </td>
                </tr>
                    </#if>
                </#list>
                <#--<tr>-->
                    <#---->
                    <#--<td style="padding:0 0;">-->
                        <#--<a style="font-size:15px;">24320162202877&emsp;小刘</a>-->
                    <#--</td>-->
                <#--</tr>-->
                <#--<tr>-->
                    <#--<td style="padding:0 0;">-->
                    <#--</td>-->
                    <#--<td style="padding:0 0;">-->
                        <#--<a style="font-size:15px;">24320162202877&emsp;小刘</a>-->
                    <#--</td>-->
                <#--</tr>-->

            </table>

            <div style="height:20px;"></div>
            <label class="field-title contactMessageTextarea" >添加成员：</label>
            <form name="filterForm" id="filterForm" class="layui-form" style="display: inline-block" onkeydown="if(event.keyCode===13){return false;}">
                <div class="layui-form-item" >
                    <div class="searchDiv">
                        <input name="searchContent" id="searchContent" type="text" placeholder="请输入学工号/姓名" autocomplete="off" class="layui-input" style="height:35px;width: 170px;display: inline-block;border-radius:8px;">
                        <img style="width:23px;margin-left:-30px;" id="searchBtn" src="/images/搜索.png">
                    </div>
                </div>
            </form>
            <div class="layui-table-box">
                <div class="distance3"></div>
                <form class="layui-form contactForm"  id="contactForm" name="${course.id}">
                    <table  id="member" class="layui-table addMember" >
                        <tbody >
                    <#list noTeamStudentList as student>
                        <#if student.id!=myId>
                    <tr class="item">
                        <td data-field="0"  class="layui-table-col-special">
                            <div class="layui-table-cell  laytable-cell-checkbox">
                                <input type="checkbox" name="members" lay-skin="primary" value="${student.id}"/>
                                <div class="layui-unselect layui-form-checkbox" lay-skin="primary">
                                    <i class="layui-icon layui-icon-ok"></i>
                                </div>
                            </div>
                        </td>
                        <td data-field="id"  class="">
                            <div class="layui-table-cell ">${student.account}</div>
                        </td>
                        <td data-field="username"  class="">
                            <div class="layui-table-cell">&nbsp;${student.studentName}&nbsp;</div>
                        </td>
                    </tr>
                        </#if>
                    </#list>
                        </tbody>
                    </table>
                </form>
                <div class="distance4"></div>
            </div>
            <div style="height:20px;"></div>
        </div>
        <div style="height:15px;"></div>
        <div style="height:15px;"></div>
        <p class="center center-text">
            <button class="my-width layui-btn margin-right" style="background-color:#d44950;" id="deleteButton" >解散小组</button>
            <#if myTeam.status==0>
            <button class="my-width  layui-btn margin-right" id="groupVerify" >提交审核</button>
            </#if>
            <button class="my-width  layui-btn"  id="addButton" >添加组员</button>
        </p>
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
        layui.use('form', function(){
            var form = layui.form();

            //各种基于事件的操作，下面会有进一步介绍
        });
        $("#groupVerify").click(function(){
            layer.prompt({
                formType: 0,
                value: '',
                title: '申请理由'
            }, function(value,index){
                $.ajax(
                        {
                            url:"/student/course/team/application",
                            type:'post',
                            data:{"teamId":${myTeam.id},"reason":value,"teacherId":${course.teacherId}},
                            success:function(data,status,response){
                                if(response.status=="200"){
                                    alert("申请已提交！");
                                }
                            },
                            error:function(data,status){
                                alert("添加失败!");
                            }
                        }
                );
                layer.close(index);
            });
        });
        $("#searchBtn").bind("click",function () {
            if($("#searchContent").val()==''||$("#searchContent").val()==null){
                layer.msg("请输入查找内容") ;
            }
            else{
                $(".item").fadeOut();
                $("td:contains("+$("#searchContent").val()+")").parents('.item').fadeIn();
            }

        });
        $(".deleteMember").bind("click",function () {
            var studentId=$(this).attr("name");
            $.ajax(
                    {
                        url:'/student/course/team/delete?teamId=${myTeam.id}&studentId='+studentId,
                        type:'delete',
                        processData: false,
                        contentType: false,
                        success:function(data,status,response){
                            if(response.status=="200") {
                                window.location.reload();
                            }
                        },
                        error:function(data){alert('删除失败！');}
                    }
            );
        });

        $("#addButton").bind("click",function () {
            var fd=new FormData($('#contactForm')[0]);
            var members=JSON.stringify(fd.getAll("members"));
            $.ajax(
                    {
                        url:"/student/course/team/add",
                        type:'post',
                        data:{"teamId":${myTeam.id},"members":members},
                        success:function(data,status,response){
                            if(response.status=="200"){
                                window.location.reload();
                            }
                        },
                        error:function(data,status){
                            alert("添加失败!");
                        }
                    }
            );
        });

        $("#deleteButton").bind("click",function () {
            $.ajax(
                    {
                        url:'/student/course/team/disband?teamId=${myTeam.id}',
                        type:'delete',
                        processData: false,
                        contentType: false,
                        success:function(data,status,response){
                            if(response.status=="200") {
                                window.location.href = '/student/course/teams?courseId=${course.id}';
                            }
                        },
                        error:function(data){alert('删除失败！');}
                    }
            );
        });

    </script>
    <style>
        .deleteMember{
            height: 22px;
            width: 17px;
            color: #1E9FFF;
            display: inline;
            margin: 3px 15px;
        }

        .my-width{
            width:30%;
            padding-left:13px;
        }


        .margin-right{
            margin-right:0;
        }
        .center-panel {
            /* margin-right: -6%; */
            /* margin-left: -6%; */
            background-color: #fff;
            box-shadow: 0 3px 5px rgba(0, 0, 0, 0.12), 0 3px 5px rgba(0, 0, 0, 0.24);
        }
        .layui-unselect{
            margin-right:17px;
        }
        div.layui-form-checkbox.layui-unselect{
            width:auto;
        }

        .searchDiv{
            float: right;
            margin-bottom: -27px;
            margin-left: 20px;
        }
        .addMember{
            margin:0 auto;
            width:55%;
        }

        #searchBtn{
            width: 23px;
            margin-left: -30px;
        }

        @media screen and (min-width:768px) and (max-width:1024px){
            .margin-right{
                margin-right:15%;
            }

            .deleteMember{
                height: 25px;
                width: 20px;
                color: #1E9FFF;
                display: inline;
                margin: 3px 15px;
            }
            .searchDiv{
                float: right;
                margin-bottom: -43px;
                margin-right: 19.5%;
                margin-left: 120px;
            }
            .my-width{
                width:15%;
            }

            #searchBtn{
                width: 23px;
                margin-left: 140px;
                /* position: absolute; */
                margin-top: -50px;
            }
            label.field-title{
                margin-left:-20px;
            }
        }
        @media screen and (min-width:1024px){
            .margin-right{
                margin-right:15%;
            }
            .deleteMember{
                height: 25px;
                width: 20px;
                color: #1E9FFF;
                display: inline;
                margin: 3px 15px;
            }
            .my-width{
                width:10%;
            }
            .searchDiv{
                float: right;
                margin-bottom: -25px;
                margin-right: 19.5%;
                margin-left: 220px;
            }
            #searchBtn{
                width: 23px;
                float: right;
                margin-top: -30px;
                margin-right: 10px;
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