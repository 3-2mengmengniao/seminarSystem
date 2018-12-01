<!DOCTYPE HTML>
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
    <link href="/styles/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
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
    <script type="text/javascript" src="/scripts/jquery-1.8.3.min.js" ></script>
    <script type="text/javascript" src="/scripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="/scripts/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="/scripts/bootstrap-datetimepicker.fr.js"></script>
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
    <h1 class="navigation-back">新建课程</h1>
    <a href="/teacher/courses" class="button-close">x</a>
</div>
<div class="decoration"></div>

<div class="content">
    <div class="container no-bottom">
        <form class="layui-form" action="/teacher/create-course" method="post" class="contactForm" id="contactForm">
            <div class="formSuccessMessageWrap" id="formSuccessMessageWrap">
                <div class="static-notification-green tap-dismiss-notification">
                    <p style="color:#c9302c;">该课程已被创建！</p>
                </div>
            </div>
            <div class="formFieldWrap">
                <label class="field-title contactNameField" for="contactNameField">课程名称：<span>(required)</span></label>
                <input type="text" name="courseName" value="" class="contactField requiredField" id="contactNameField"/>
            </div>
            <div class="formValidationError" id="contactNameFieldError">
                <div class="static-notification-red tap-dismiss-notification">
                    <p class="uppercase">请填写课程名!</p>
                </div>
            </div>
            <div class="formTextareaWrap">
                <label class="field-title contactMessageTextarea" for="contactMessageTextarea">课程要求：<span>(required)</span></label>
                <textarea name="introduction" class="contactTextarea requiredField" id="contactMessageTextarea"></textarea>

                <div class="decoration"></div>
            </div>
            <div class="formValidationError" id="contactMessageTextareaError">
                <div class="static-notification-red tap-dismiss-notification">
                    <p class="uppercase">请填写课程要求</p>
                </div>
            </div>

            <label class="field-title contactMessageTextarea" for="contactMessageTextarea">成绩计算规则：<span>(required)</span></label>
            <div >
                <div class="distance3"></div>
                <div class="layui-form-item">
                    <label class="layui-form-label">课堂展示</label>
                    <div class="layui-input-block">
                        <select name="presentationProportion" lay-filter="aihao">
                            <option value="0">0</option>
                            <option value="1">20%</option>
                            <option value="2" selected>40%</option>
                            <option value="3">60%</option>
                            <option value="4">80%</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">课堂提问</label>
                    <div class="layui-input-block">
                        <select name="questionProportion" lay-filter="aihao">
                            <option value="0">0</option>
                            <option value="1">20%</option>
                            <option value="2" selected>40%</option>
                            <option value="3">60%</option>
                            <option value="4">80%</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">书面报告</label>
                    <div class="layui-input-block">
                        <select name="reportProportion" lay-filter="aihao">
                            <option value="0">0</option>
                            <option value="1" selected>20%</option>
                            <option value="2">40%</option>
                            <option value="3">60%</option>
                            <option value="4">80%</option>
                        </select>
                    </div>
                </div>

                <div class="distance4"></div>

            </div>
            <div class="decoration"></div>
            <label class="field-title contactMessageTextarea" for="contactMessageTextarea">组队相关规则<span>(required)</span></label>
            <div >
                <div class="distance3"></div>
                <div class="layui-form-item">
                    <label class="layui-form-label">小组人数上限</label>
                    <div class="layui-input-block">
                        <select name="maxTeamMember" lay-filter="aihao">
                            <option value="0">4人</option>
                            <option value="1" selected>5人</option>
                            <option value="2">6人</option>
                            <option value="3">7人</option>
                            <option value="4">8人</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">小组人数下限</label>
                    <div class="layui-input-block">
                        <select name="minTeamMember" lay-filter="aihao">
                            <option value="0">3人</option>
                            <option value="1">4人</option>
                            <option value="2" selected>5人</option>
                            <option value="3">6人</option>
                            <option value="4">7人</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">组队开始时间</label>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <input type="text" class="layui-input" id="test5" placeholder="yyyy-MM-dd HH:mm:ss">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">组队截止时间</label>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <input type="text" class="layui-input" id="test5" placeholder="yyyy-MM-dd HH:mm:ss">
                        </div>
                    </div>
                </div>

            </div>

            <div class="distance4"></div>
            <p class="center center-text"><input type="submit" class="button-big button-dark" id="contactSubmitButton" value="创建课程" data-formId="contactForm"/></p>
        </form>
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
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //常规用法
        laydate.render({
            elem: '#test1'
        });

        //国际版
        laydate.render({
            elem: '#test1-1'
            ,lang: 'en'
        });

        //年选择器
        laydate.render({
            elem: '#test2'
            ,type: 'year'
        });

        //年月选择器
        laydate.render({
            elem: '#test3'
            ,type: 'month'
        });

        //时间选择器
        laydate.render({
            elem: '#test4'
            ,type: 'time'
        });

        //日期时间选择器
        laydate.render({
            elem: '#test5'
            ,type: 'datetime'
        });

        //日期范围
        laydate.render({
            elem: '#test6'
            ,range: true
        });

        //年范围
        laydate.render({
            elem: '#test7'
            ,type: 'year'
            ,range: true
        });

        //年月范围
        laydate.render({
            elem: '#test8'
            ,type: 'month'
            ,range: true
        });

        //时间范围
        laydate.render({
            elem: '#test9'
            ,type: 'time'
            ,range: true
        });

        //日期时间范围
        laydate.render({
            elem: '#test10'
            ,type: 'datetime'
            ,range: true
        });

        //自定义格式
        laydate.render({
            elem: '#test11'
            ,format: 'yyyy年MM月dd日'
        });
        laydate.render({
            elem: '#test12'
            ,format: 'dd/MM/yyyy'
        });
        laydate.render({
            elem: '#test13'
            ,format: 'yyyyMMdd'
        });
        laydate.render({
            elem: '#test14'
            ,type: 'time'
            ,format: 'H点m分'
        });
        laydate.render({
            elem: '#test15'
            ,type: 'month'
            ,range: '~'
            ,format: 'yyyy-MM'
        });
        laydate.render({
            elem: '#test16'
            ,type: 'datetime'
            ,range: '到'
            ,format: 'yyyy年M月d日H时m分s秒'
        });

        //开启公历节日
        laydate.render({
            elem: '#test17'
            ,calendar: true
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
        //不出现底部栏
        laydate.render({
            elem: '#test22'
            ,showBottom: false
        });

        //只出现确定按钮
        laydate.render({
            elem: '#test23'
            ,btns: ['confirm']
        });

        //自定义事件
        laydate.render({
            elem: '#test24'
            ,trigger: 'mousedown'
        });

        //点我触发
        laydate.render({
            elem: '#test25'
            ,eventElem: '#test25-1'
            ,trigger: 'click'
        });

        //双击我触发
        lay('#test26-1').on('dblclick', function(){
            laydate.render({
                elem: '#test26'
                ,show: true
                ,closeStop: '#test26-1'
            });
        });

        //日期只读
        laydate.render({
            elem: '#test27'
            ,trigger: 'click'
        });

        //非input元素
        laydate.render({
            elem: '#test28'
        });

        //墨绿主题
        laydate.render({
            elem: '#test29'
            ,theme: 'molv'
        });

        //自定义颜色
        laydate.render({
            elem: '#test30'
            ,theme: '#393D49'
        });

        //格子主题
        laydate.render({
            elem: '#test31'
            ,theme: 'grid'
        });


        //直接嵌套显示
        laydate.render({
            elem: '#test-n1'
            ,position: 'static'
        });
        laydate.render({
            elem: '#test-n2'
            ,position: 'static'
            ,lang: 'en'
        });
        laydate.render({
            elem: '#test-n3'
            ,type: 'month'
            ,position: 'static'
        });
        laydate.render({
            elem: '#test-n4'
            ,type: 'time'
            ,position: 'static'
        });
    });
</script>

</body>
</html>