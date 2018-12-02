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
    <h1 class="navigation-back">新建班级</h1>
    <a href="/teacher/class-info" class="button-close">x</a>
</div>
<div class="distace3"></div>
<div class="decoration"></div>

<div class="content">
    <div class="distance3"></div>
    <div class="container no-bottom">
        <form class="layui-form" action="/teacher/create-class" method="post" class="contactForm" id="contactForm">
            <div class="formSuccessMessageWrap" id="formSuccessMessageWrap">
                <div class="static-notification-green tap-dismiss-notification">
                    <p style="color:#c9302c;">该班级已被创建！</p>
                </div>
            </div>
            <div class="formFieldWrap">
                <label class="field-title contactNameField" for="contactNameField">班级名称：<span>(required)</span></label>
                <input type="text" name="className" value="" class="contactField requiredField" id="contactNameField"/>
            </div>
            <div class="formValidationError" id="contactNameFieldError">
                <div class="static-notification-red tap-dismiss-notification">
                    <p class="uppercase">请填写班级名!</p>
                </div>
            </div>
            <div class="formTextareaWrap">
                <label class="field-title contactNameField" for="contactMessageTextarea">班级简介：<span>(required)</span></label>
                <textarea name="introduction" class="contactTextarea requiredField" id="contactMessageTextarea"></textarea>
            </div>
            <div class="formValidationError" id="contactMessageTextareaError">
                <div class="static-notification-red tap-dismiss-notification">
                    <p class="uppercase">请填写班级简介！</p>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label contactNameField" style="font-weight: bold;">班级学生名单</label>
                <p class="file center-text"><input type="file"></p>
            </div>
            <div class="distance4"></div>
            <p class="center center-text"><input type="submit" class="button-big button-dark" id="contactSubmitButton" value="创建课程" data-formId="contactForm"/></p>
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
<script type="text/javascript" src="/scripts/creat-course.js"></script>
<script src="/layui/layui.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form();

        //各种基于事件的操作，下面会有进一步介绍
    });
</script>


</body>
</html>