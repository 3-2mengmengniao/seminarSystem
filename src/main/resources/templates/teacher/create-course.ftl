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
                    <div class="layui-input-block">
                        <input name="teamStartTime" type="date" class="courseInput">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">组队截止时间</label>
                    <div class="layui-input-block">
                        <input name="teamEndTime" type="date" class="courseInput">
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

</body>
</html>