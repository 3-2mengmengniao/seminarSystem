<!DOCTYPE HTML>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <title>学生组队</title>

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
    <script type="text/javascript" src="/scripts/creat-team.js"></script>
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
            <a href="/student/courseList" class="button-back"><img id="button-back-image-2" src="/images/icons/展开.png"></a>
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
    <div class="distance3"></div>
    <div class="container no-bottom">
        <form class="layui-form contactForm"  id="contactForm" name="${course.id}">
            <div class="formFieldWrap">
                <label class="field-title contactNameField" for="contactNameField">小组名称：<span>(required)</span></label>
                <input type="text" name="teamName" value="" class="contactField requiredField" id="teamName"/>
            </div>
            <div class="formValidationError" id="teamNameError">
                <div class="static-notification-red tap-dismiss-notification">
                    <p class="uppercase">请填写小组名!</p>
                </div>
            </div>
            <div class="distance3"></div>
            <div >
                <div class="layui-form-item">
                    <div >
                        <div class="layui-form-item">
                            <label class="layui-form-label margin2" style="font-weight:bold;font-size:16px;">选择班级:&nbsp;&nbsp;<span style="float: right;opacity: 0.2;">(required)</span></label>
                            <div class="layui-input-block">
                                <select name="class" id="classId">
                                    <#list classList as class>
                                    <#if class?index==0>
                                        <option value="${class.id}" selected> ${class.grade?c}-(${class.classSerial})</option>
                                    <#else>
                                        <option value="${class.id}"> ${class.grade?c}-(${class.classSerial})</option>
                                    </#if>
                                    </#list>
                                </select>
                            </div>
                        </div>
                </div>
            </div>
            <div class="decoration"></div>
                <form name="filterForm" id="filterForm" class="layui-form" style="display: inline-block" onkeydown="if(event.keyCode===13){return false;}">
                    <div class="layui-form-item" >
                        <div class="searchDiv">
                            <input name="searchContent" id="searchContent" type="text" placeholder="请输入学工号/姓名" autocomplete="off" class="layui-input" style="height:35px;width: 170px;display: inline-block;border-radius:8px;">
                            <img style="width:23px;margin-left:-30px;" id="searchBtn" src="/images/搜索.png">
                        </div>
                    </div>
                </form>
            <label class="field-title contactMessageTextarea margin3" for="contactMessageTextarea">添加成员：</label>
            <div class="layui-table-box">
                <div class="distance3"></div>
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
                    <#--<tr class="item">-->
                        <#--<td data-field="0"  class="layui-table-col-special">-->
                            <#--<div class="layui-table-cell  laytable-cell-checkbox">-->
                                <#--<input type="checkbox" name="layTableCheckbox" lay-skin="primary">-->
                                <#--<div class="layui-unselect layui-form-checkbox" lay-skin="primary">-->
                                    <#--<i class="layui-icon layui-icon-ok"></i>-->
                                <#--</div>-->
                            <#--</div>-->
                        <#--</td>-->
                        <#--<td data-field="id"  class="">-->
                            <#--<div class="layui-table-cell ">24320122202845</div>-->
                        <#--</td>-->
                        <#--<td data-field="username"  class="">-->
                            <#--<div class="layui-table-cell">&nbsp;小刘&nbsp;</div>-->
                        <#--</td>-->
                    <#--</tr>-->
                    <#--<tr class="item">-->
                        <#--<td data-field="0"  class="layui-table-col-special">-->
                            <#--<div class="layui-table-cell  laytable-cell-checkbox">-->
                                <#--<input type="checkbox" name="layTableCheckbox" lay-skin="primary">-->
                                <#--<div class="layui-unselect layui-form-checkbox" lay-skin="primary">-->
                                    <#--<i class="layui-icon layui-icon-ok"></i>-->
                                <#--</div>-->
                            <#--</div>-->
                        <#--</td>-->
                        <#--<td data-field="id"  class="">-->
                            <#--<div class="layui-table-cell ">24320122202846</div>-->
                        <#--</td>-->
                        <#--<td data-field="username"  class="">-->
                            <#--<div class="layui-table-cell">&nbsp;小李&nbsp;</div>-->
                        <#--</td>-->
                    <#--</tr>-->
                    </tbody>
                </table>
                <div class="distance4"></div>
                <p class="center center-text"><input type="button" class="button-big button-dark" id="contactSubmitButton" value="创建小组" data-formId="contactForm"/></p>
             </div>
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

<script>
    layui.use(['element', 'layer'], function(){
        var element = layui.element();
        var layer = layui.layer;

        //监听折叠
        element.on('collapse(test)', function(data){
            layer.msg('展开状态：'+ data.show);
        });
    });
    // layui.use('table', function(){
    //     var table = layui.table;
    //     table.render({
    //         elem: '#member'
    //         // ,url:'/demo/table/user/'
    //         ,cols: [[
    //             {type:'checkbox'}
    //             ,{field:'id', width:100, title: 'ID', sort: true}
    //             ,{field:'username', width:80, title: '用户名'}
    //         ]]
    //         ,page: true
    //     });
    // });
</script>
<script>
    layui.use('form', function(){
        var form = layui.form();

        //各种基于事件的操作，下面会有进一步介绍
    });
    $("#searchBtn").bind("click",function () {
        if($("#username").val()==''||$("#username").val()==null){
            layer.msg("请输入查找内容") ;
        }
        $(".item").fadeOut(2000);
        $("td:contains("+$("#searchContent").val()+")").parents('.item').fadeIn();
    });

</script>

<style>
    .layui-unselect{
        margin-right:17px;
    }
    div.layui-form-checkbox.layui-unselect{
        width:auto;
    }

    .searchDiv{
        float:right;
        margin-bottom:-35px;
        margin-right:0;
    }
    .addMember{
        margin:0 auto;
        width:39%;
    }

    @media screen and (min-width:768px) and (max-width:1024px;){
        .margin3{
            margin-left:9%;
        }
        .margin2{
            margin-left:0;
        }
        .searchDiv{
            float:right;
            margin-bottom:-35px;
            margin-right:29.5%;
        }
    }
    @media screen and (min-width:1024px){
        .margin3{
            margin-left:3%;
        }
        .margin2{
            margin-left:2.5%;
        }
        .searchDiv{
            float:right;
            margin-bottom:-35px;
            margin-right:29.5%;
        }
    }
</style>
</body>
</html>