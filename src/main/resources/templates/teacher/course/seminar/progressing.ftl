<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/html">
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

    <link rel="stylesheet" href="/styles/bootstrap-float-label.css">
    <script type="text/javascript" src="/scripts/jquery.js"></script>
    <script type="text/javascript" src="/scripts/snap.js"></script>
    <script type="text/javascript" src="/scripts/login.js"></script>
    <script type="text/javascript" src="/scripts/custom.js"></script>
    <script type="text/javascript" src="/scripts/framework.js"></script>
    <script type="text/javascript" src="/scripts/framework.launcher.js"></script>
    <script type="text/javascript" src="/scripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/scripts/bootstrap-float-label.js"></script>
    <script type="text/javascript" src="/scripts/jquery.runner-min.js"></script>
    <script src="/scripts/sockjs.js"></script>
    <script src="/scripts/stomp.js"></script>
    <script src="/scripts/app.js"></script>

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
                <a href="/teacher/seminars" class="home-icon">讨论课</a>
                <em class="active-menu"></em>
            </div>
        </div>
    </div>
</div>
<div>
    <div id="wrapper">
        <div class="center-title">
            <span id="seminarId" name="${seminarControl.id}"></span>
            <span id="usertype" name="teacher"></span>
            <h1 class="thick">业务流程分析</h1>
            <p style="font-size:16px;" id="greetings"></p>
            <p style="color:#009688;font-size:17px;margin-left:-33px;" id="notation"></p>
            <div>
                <span id="runner"></span><br><br>
                <div>
                    <div style="z-index: 999;" id="timeMonitor"><img id="startBtn" src="/images/开始.png"></div>
                </div>
            </div>
        </div>
        <div id="left-side">
            <ul>
                <#list 0..<seminarControl.seminarInfo.maxGroup as t>
                    <#if seminarControl.presentationList[t]?? && seminarControl.presentationList[t].present==1>
                    <li class="group active">
                        ${seminarControl.presentationList[t].team.serial.getSerial()}
                    </li>
                    <#elseif seminarControl.presentationList[t]?? && seminarControl.presentationList[t].present==0>
                    <li class="group">
                        ${seminarControl.presentationList[t].team.serial.getSerial()}
                    </li>
                    </#if>
                </#list>
            </ul>
        </div>
        <div id="border">
            <div id="line" class="one"></div>
        </div>
        <div id="right-side">
        <#list 0..<seminarControl.seminarInfo.maxGroup as t>
            <#if seminarControl.presentationList[t]??>
            <div class="group">
                <div style="height:30px;"></div>
                <h1>展示成绩</h1>
                <form class="form-group floating-control-group formFieldWrap" target="frame1" method="post" action="/teacher/course/seminar/presentationScore?presentationId=${seminarControl.presentationList[t].id}" >
                    <input style="margin-bottom:3px;font-size:15px;padding-top:10px;z-index:99;" type="text"  autocomplete="off" class="my-form-control contactField requiredField"  placeholder="请输入成绩" name="score">
                <#--<button type="submit" class="uploadButton layui-btn layui-btn-mini" style="margin-left: 10px;">提交</button>-->
                    <input title="提交" type="submit" style="border:none;background:none;z-index: 9999;width:27px;top:-35px;right:-80%;cursor:pointer;"/>
                </form>
                <iframe name="frame1" frameborder="0" id="frame" style="display: none;"></iframe>
                <div style="height:20px;"></div>
                <h1>提问</h1>
                <table  class="append-col layui-table" lay-skin="line" style="border:none;border-width:0 0;" >
                    <colgroup>
                        <col width="100" >
                        <col width="200" >
                    </colgroup>
                </table>
                <div style="height:20px;"></div>
            </div>
            </#if>
        </#list>
        </div>
    </div>
    <div class="center center-text ">
        <div class="formSubmitButtonErrorsWrap">
            <input id="select" type="submit" class="layui-btn"  style="margin-right:15%;font-size: 18px;line-height: 42px;height: 40px;" value="抽取提问" data-formId="contactForm"/>
            <input id="restart" type="submit" class="layui-btn"  style="font-size: 18px;line-height: 42px;height: 40px;" value="下组展示" data-formId="contactForm"/>
        </div>
    </div>
    <div style="height:100px;z-index:-1;"></div>
    <div class="distance"></div>
    <p class="center center-text"><button class="button-big button-red" id="endButton" >结束讨论课</button></p>
</div>


<!--<div class="bottom-deco"></div>-->
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
<script>
    function submitForm() {
        var id=$(this).attr("name");
        alert(id);
        $('#'+id).submit();
    }
</script>
<script>
    //点击增加提问
    var outputScore="";
    outputScore=	"<tr>\n"+
            "\t\t<td style=\"padding:0 10px;\">\n"+
            "\t\t\t\t<a style=\"font-size:17px;margin-top:-30px;\">1-1&nbsp;小红</a>\n"+
            "\t\t</td>\n"+
            " \t\t<td style=\"padding:0 10px;\">\n"+
            " \t\t\t\t<form class=\"form-group floating-control-group formFieldWrap\" target='frame1'>\n"+
            " \t\t\t\t\t\t<input style=\"margin-bottom:3px;font-size:15px;padding-top:10px;\" type=\"text\"  autocomplete=\"off\" class=\"my-form-control contactField requiredField\"  placeholder=\"请输入成绩 \">\n"+
            "\t\t\t\t\t\t<img title=\"提交\" style=\"border:none;background:none;z-index: 9999;width:27px;top:-35px;right:-80%;cursor:pointer;\">\n"+
            " \t\t\t\tM</form></div>\n"+
            "\t\t</td>\n"+
            "</tr>";
    // function selectQ(question){
    //     var q=JSON.parse(question.body);
    //     var teamId=q.teamId;
    //     alert("enter");
    //     alert(teamId);
    //     var classSerial=q.courseClassSerial;
    //     var teamSerial=q.teamSerial;
    //     var studentName=q.studentName;
    //     var qid=q.id;
    //     outputScore=	"<tr>\n"+
    //             "\t\t<td style=\"padding:0 10px;\">\n"+
    //             "\t\t\t\t<a style=\"font-size:17px;margin-top:-30px;\">"+classSerial+"-"+teamSerial+"&nbsp;"+studentName+"</a>\n"+
    //             "\t\t</td>\n"+
    //             " \t\t<td style=\"padding:0 10px;\">\n"+
    //             " \t\t\t\t<div class=\"form-group floating-control-group formFieldWrap\">\n"+
    //             "\t\t\t\t\t\t<form class=\"form-group floating-control-group formFieldWrap\" method=\"post\" action=\"/teacher/course/seminar/questionScore?questionId="+qid+"\">"+
    //             " \t\t\t\t\t\t<input style=\"margin-bottom:3px;font-size:15px;padding-top:10px;\" type=\"text\"  autocomplete=\"off\" class=\"my-form-control contactField requiredField\"  placeholder=\"请输入成绩 \">\n"+
    //             "\t\t\t\t\t\t<input type=\"submit\" style=\"border:none;background:none;z-index: 9999;width:27px;top:-35px;right:-40%;cursor:pointer;\">\n"+
    //             " \t\t\t\t</form>\n"+
    //             " \t\t\t\t</div>\n"+
    //             "\t\t</td>\n"+
    //             "</tr>";
    //     var allDiv= $('div.group');
    //     var groupIndex=$('li.group').filter('.active').index();
    //     $("table.append-col").eq(groupIndex).append(outputScore);
    //     $.each($(allDiv),function(){
    //         if($(this).index()<groupIndex){
    //             var divHeight=$(this).height();
    //             // alert(divHeight);
    //             $(this).css('margin-top','-'+divHeight+'px');
    //         }
    //         if($(this).index()>groupIndex){
    //             var divHeight=$(this).height()-20;
    //             // alert(divHeight);
    //             $(this).css('margin-top','-'+divHeight+'px');
    //         }
    //     })
    // };
//表单失去焦点提交
    $("my-form-control").blur(function(){
        if($(this).val()!=null||$(this).val()!=''){
            alert($(this).val());
        }
    });
    $("#right-side").children(":first").addClass('active');
    $('li.group').click(function(){
        $(this).addClass('active');
        $(this).siblings().removeClass('active');
        var groupIndex= $(this).index();
        var allDiv= $('div.group');
        $(allDiv).eq(groupIndex).css('margin-top','');
        $(allDiv).eq(groupIndex).addClass('active');
        $(allDiv).eq(groupIndex).siblings().removeClass('active');
        $.each($(allDiv),function(){
            if($(this).index()<groupIndex){
                var divHeight=$(this).height();
                // alert(divHeight);
                $(this).css('margin-top','-'+divHeight+'px');
            }
            if($(this).index()>groupIndex){
                var divHeight=$(this).height()-20;
                // alert(divHeight);
                $(this).css('margin-top','-'+divHeight+'px');
            }
        })
    })
    $('#restart').click(function(){
        $('#runner').runner('reset');
        var currentLi=$('li.group').filter('.active').next();
        var groupIndex= $(currentLi).index();
        var iframeWidth=$(window).width();
        if(groupIndex=='-1'){
            if(iframeWidth>768){
                layer.open({
                    type: 2,
                    icon:7,
                    titlt:"",
                    shade: 0.6 ,//遮罩透明度
                    area: ['500px', '520px'],
                    fixed: false, //不固定
                    maxmin: true,
                    anim: 6, //0-6的动画形式，-1不开启
                    content: '/teacher/course/seminar/report_deadline?seminarId=${seminarControl.id}',
                    scrollbar: true
                });
            }
            else{
                layer.open({
                    type: 2,
                    icon:7,
                    titlt:"",
                    shade: 0.6 ,//遮罩透明度
                    area: ['300px', '520px'],
                    fixed: false, //不固定
                    maxmin: true,
                    anim: 6, //0-6的动画形式，-1不开启
                    content: '/teacher/course/seminar/report_deadline?seminarId=${seminarControl.id}',
                    scrollbar: true
                });
            }
        }
        else{
            $(currentLi).addClass('active');
            $(currentLi).siblings().removeClass('active');
            var groupIndex= $(currentLi).index();
            var allDiv= $('div.group');
            $(allDiv).eq(groupIndex).css('margin-top','');
            $(allDiv).eq(groupIndex).addClass('active');
            $(allDiv).eq(groupIndex).siblings().removeClass('active');
            $.each($(allDiv),function(){
                if($(this).index()<groupIndex){
                    var divHeight=$(this).height();
                    // alert(divHeight);
                    $(this).css('margin-top','-'+divHeight+'px');
                }
                if($(this).index()>groupIndex){
                    var divHeight=$(this).height()-20;
                    // alert(divHeight);
                    $(this).css('margin-top','-'+divHeight+'px');
                }
            })
        }
        nextGroup();
    })
    $( "#select" ).click(function() { selectQuestion(); });
    $( "#endButton" ).click(function() {
        endSeminar();
        window.location.href="/teacher/course/seminar/score?seminarId=${seminarControl.id}";
    });
    $('#timeMonitor').click(function(){
        var btnId=$(this).children('img').attr('id');
        if(btnId=='startBtn'){
            $('#runner').runner('start');
            $(this).children('img').attr('id','stopBtn');
            $(this).children('img').attr('src','/images/暂停.png');
        }
        if(btnId=='stopBtn'){
            $('#runner').runner('stop');
            $(this).children('img').attr('id','startBtn');
            $(this).children('img').attr('src','/images/开始.png');
        }
    })
    $('.my-form-control').click(function(){
        $(this).attr("placeholder", "");
        if($(this).val()!=''||$(this).val()!=null){
            $(this).addClass('my-padding-left')
        }
    })
    $('.my-form-control').blur(function(){
        if($(this).val()==''||$(this).val()==null){
            $(this).removeClass('my-padding-left')
            $(this).attr("placeholder", "请输入成绩");
        }
    })
    $('#runner').runner({
        milliseconds: false,
        format: function millisecondsToString(milliseconds) {
            var oneHour = 3600000;
            var oneMinute = 60000;
            var oneSecond = 1000;
            var seconds = 0;
            var minutes = 0;
            var hours = 0;
            var result;
            if (milliseconds >= oneHour) {
                hours = Math.floor(milliseconds / oneHour);
            }
            milliseconds = hours > 0 ? (milliseconds - hours * oneHour) : milliseconds;
            if (milliseconds >= oneMinute) {
                minutes = Math.floor(milliseconds / oneMinute);
            }
            milliseconds = minutes > 0 ? (milliseconds - minutes * oneMinute) : milliseconds;
            if (milliseconds >= oneSecond) {
                seconds = Math.floor(milliseconds / oneSecond);
            }
            milliseconds = seconds > 0 ? (milliseconds - seconds * oneSecond) : milliseconds;
            if (hours > 0) {
                result = (hours > 9 ? hours : "0" + hours) + ":";
            } else {
                result = "00:";
            }
            if (minutes > 0) {
                result += (minutes > 9 ? minutes : "0" + minutes) + ":";
            } else {
                result += "00:";
            }
            if (seconds > 0) {
                result += (seconds > 9 ? seconds : "0" + seconds);
            } else {
                result += "00";
            }
            return result;
        }
    });
</script>
<script>
    layui.use('form', function(){
        var form = layui.form();
        //各种基于事件的操作，下面会有进一步介绍
    });
    new Function($('.run').text())();
    //var index = parent.layer.getFrameIndex(window.name);
    //parent.layer.iframeAuto(index);
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //日期时间选择器
        laydate.render({
            elem: '#test5'
            ,type: 'datetime'
        });
        //自定义重要日
        laydate.render({
            elem: '#test18'
            ,mark: {
                '0-10-14': '生日'
                ,'0-12-31': '跨年' //每年的日期
                ,'0-0-10': '工资' //每月某天
                ,'0-0-15': '月中'
                ,'2017-8-15': '' //如果为空字符，则默认显示数字+徽章
                ,'2099-10-14': '呵呵'
            }
            ,done: function(value, date){
                if(date.year === 2017 && date.month === 8 && date.date === 15){ //点击2017年8月15日，弹出提示语
                    layer.msg('这一天是：中国人民抗日战争胜利72周年');
                }
            }
        });
        //限定可选日期
        var ins22 = laydate.render({
            elem: '#test-limit1'
            ,min: '2016-10-14'
            ,max: '2080-10-14'
            ,ready: function(){
                ins22.hint('日期可选值设定在 <br> 2016-10-14 到 2080-10-14');
            }
        });
        //前后若干天可选，这里以7天为例
        laydate.render({
            elem: '#test-limit2'
            ,min: -7
            ,max: 7
        });
        //限定可选时间
        laydate.render({
            elem: '#test-limit3'
            ,type: 'time'
            ,min: '09:30:00'
            ,max: '17:30:00'
            ,btns: ['clear', 'confirm']
        });
        //同时绑定多个
        lay('.test-item').each(function(){
            laydate.render({
                elem: this
                ,trigger: 'click'
            });
        });
        //初始赋值
        laydate.render({
            elem: '#test19'
            ,value: '1989-10-14'
            ,isInitValue: true
        });
        //选中后的回调
        laydate.render({
            elem: '#test20'
            ,done: function(value, date){
                layer.alert('你选择的日期是：' + value + '<br>获得的对象是' + JSON.stringify(date));
            }
        });
        //日期切换的回调
        laydate.render({
            elem: '#test21'
            ,change: function(value, date){
                layer.msg('你选择的日期是：' + value + '<br><br>获得的对象是' + JSON.stringify(date));
            }
        });
        //墨绿主题
        laydate.render({
            elem: '#test29'
            ,theme: 'molv'
        });
    });
</script>
<style type="text/css">
    .layui-laydate-content table {
        border-collapse: collapse;
        border-spacing: 0;
        font-size: 14px;
    }
    #startBtn{
        width:23px;
        height:23px;
        margin-top: -128px;
        margin-left: 105%;
    }
    #stopBtn{
        width:23px;
        height:23px;
        margin-top: -128px;
        margin-left: 105%;
    }
    #runner{
        font-size: 19px;
        margin-top: -27.5%;
        margin-left: 39%;
        position: absolute;
        color: #009688;
    }
    .my-padding-left{
        padding-left:40%;
    }
    .layui-table[lay-skin=line] td,.layui-table[lay-skin=line] th {
        border-width:0 0;
    }
    .my-form-control::placeholder{
        font-size:18px;
        text-align:center;
        color:rgb(0,0,0,0.4);
    }
    html, body {
        margin: 0;
        padding: 0;
        width: 100%;
        /*height: 100%;*/
        background-color: #eee;
        font-family: 'Raleway';
    }
    ul, li {
        margin: 0;
        padding: 0;
        list-style: none;
        font-size:18px;
    }
    .center-title{
        position:absolute;
        top:20px;
        left:40%;
        font-weight:800;
    }
    .thick {font-weight: bold}
    @media screen and (max-width:768px){
        ul{
            padding: 0;
            list-style: none;
            margin-left:-50%;
            font-size:18px;
        }
        .center-navigation{
            margin-left:2%;
            margin-right:2%;
        }
        .center-title{
            position:absolute;
            top:20px;
            left:30%;
            font-weight:800;
        }
    }
    @media screen and (max-width:1024px) and (min-width:768px){
        .center-title{
            position:absolute;
            top:20px;
            left:40%;
            font-weight:800;
        }
    }
    @media screen and (max-width:768px){
        #wrapper {
            width: 95%;
            margin: auto;
            min-height:490px;
            background-color: #fff;
            box-shadow: 0 3px 5px rgba(0, 0, 0, 0.12), 0 3px 5px rgba(0, 0, 0, 0.24);
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-align: center;
            -webkit-align-items: center;
            -ms-flex-align: center;
            align-items: center;
            -webkit-box-pack: left;
            -webkit-justify-content: left;
            -ms-flex-pack: left;
            justify-content: left;
            overflow:hidden;
        }
    }
    @media screen and (min-width:768px){
        #wrapper {
            width: 95%;
            margin: auto;
            min-height:400px;
            background-color: #fff;
            box-shadow: 0 3px 5px rgba(0, 0, 0, 0.12), 0 3px 5px rgba(0, 0, 0, 0.24);
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-align: center;
            -webkit-align-items: center;
            -ms-flex-align: center;
            align-items: center;
            -webkit-box-pack: left;
            -webkit-justify-content: left;
            -ms-flex-pack: left;
            justify-content: left;
            overflow:hidden;
        }
    }
    #left-side {
        height: 100%;
        width: 10%;
        margin-left: 5%;
        margin-top: -15%;
        display: -webkit-box;
        display: -webkit-flex;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-align: center;
        -webkit-align-items: center;
        -ms-flex-align: center;
        align-items: center;
        -webkit-box-pack: center;
        -webkit-justify-content: center;
        -ms-flex-pack: center;
        justify-content: center;
    }
    @media screen and  (min-width:768px){
        #left-side {
            height: 100%;
            width: 10%;
            margin-left:0;
            margin-top: -10%;
        }
    }
    #left-side ul li {
        padding-top: 10px;
        padding-bottom: 10px;
        display: -webkit-box;
        display: -webkit-flex;
        display: -ms-flexbox;
        display: flex;
        line-height: 34px;
        color: rgba(51, 51, 51, 0.5);
        font-weight: 500;
        cursor: pointer;
        -webkit-transition: all .2s ease-out;
        transition: all .2s ease-out;
    }
    #left-side ul li:hover {
        color: #333333;
        -webkit-transition: all .2s ease-out;
        transition: all .2s ease-out;
    }
    #left-side ul li:hover > .icon {
        fill: #333;
    }
    #left-side ul li.active {
        color: #333333;
    }
    #left-side ul li.active:hover > .icon {
        fill: #009688;
    }
    #border {
        height: 288px;
        margin-top: -15%;
        width:1px;
        background-color: rgba(51, 51, 51, 0.2);
    }
    #border #line.one {
        width: 5px;
        height: 54px;
        background-color: #009688;
        margin-left: -2px;
        margin-top: 35px;
        -webkit-transition: all .4s ease-in-out;
        transition: all .4s ease-in-out;
    }
    #border #line.two {
        width: 5px;
        height: 54px;
        background-color: #009688;
        margin-left: -2px;
        margin-top: 89px;
        -webkit-transition: all .4s ease-in-out;
        transition: all .4s ease-in-out;
    }
    #border #line.three {
        width: 5px;
        height: 54px;
        background-color: #009688;
        margin-left: -2px;
        margin-top: 143px;
        -webkit-transition: all .4s ease-in-out;
        transition: all .4s ease-in-out;
    }
    #border #line.four {
        width: 5px;
        height: 54px;
        background-color: #009688;
        margin-left: -2px;
        margin-top: 197px;
        -webkit-transition: all .4s ease-in-out;
        transition: all .4s ease-in-out;
    }
    #right-side {
        /*height: 350px;*/
        margin-top: 28%;
        width: 90%;
        overflow:hidden;
    }
    @media screen and (min-width:768px) and (max-width:1024px){
        #right-side {
            /*height: 350px;*/
            margin-top: 13%;
            width: 90%;
            overflow:hidden;
        }
    }
    @media screen and (min-width:1024px){
        #right-side {
            /*height: 350px;*/
            margin-top: 10%;
            width: 90%;
            overflow:hidden;
        }
    }
    div.group{
        /*position: absolute;*/
        /* height: 380px; */
        width: 85%;
        -webkit-transition: all .6s ease-in-out;
        transition: all .6s ease-in-out;
        margin-top: -350px;
        margin-left:10%;
        opacity: 0;
        display: -webkit-box;
        display: -webkit-flex;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-align: center;
        -webkit-align-items: center;
        -ms-flex-align: center;
        align-items: center;
        -webkit-box-pack: center;
        -webkit-justify-content: flex-start;
        -ms-flex-pack: center;
        justify-content: flex-start;
        -webkit-box-orient: vertical;
        -webkit-box-direction: normal;
        -webkit-flex-direction: column;
        -ms-flex-direction: column;
        flex-direction: column;
    }
    .active{
        z-index:99;
    }
    #right-side h1 {
        font-weight: 500;
        font-size: 22px;
        color: #333;
    }
    #right-side p {
        color: #333;
        font-weight: 500;
        padding-left: 30px;
        padding-right: 30px;
    }
    div.group.active{
        margin-top: 0px;
        opacity: 1;
        -webkit-transition: all .6s ease-in-out;
        transition: all .6s ease-in-out;
    }
</style>
</body>
</html>