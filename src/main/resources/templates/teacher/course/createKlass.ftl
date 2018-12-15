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
    <a href="/teacher/course/klassList?courseId=${courseId}" class="button-close">x</a>
</div>
<div class="distace3"></div>
<div class="decoration"></div>

<div class="content">
    <div class="distance3"></div>
    <div class="container no-bottom">
        <form class="layui-form" action="/teacher/course/klass/create?courseId=${courseId}" method="post" class="contactForm" id="contactForm">
            <div class="formSuccessMessageWrap" id="formSuccessMessageWrap">
                <div class="static-notification-green tap-dismiss-notification">
                    <p style="color:#d44950;">该班级已被创建！</p>
                </div>
            </div>
            <div class="formFieldWrap">
                <label class="field-title contactNameField" for="contactNameField">班级名称：<span>(required)</span></label>
                <input type="text" name="grade" value="" class="contactField requiredField" id="contactNameField" placeholder="年级" style="width: 100px;"/>
                <input type="text" name="classSerial" value="" class="contactField requiredField" id="contactNameField" placeholder="班级序号"  style="width: 100px;"/>
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
            <p class="center center-text"><input type="submit" class="button-big button-dark" id="contactSubmitButton" value="创建班级" data-formId="contactForm"/></p>
        </form>
        <div class="distance2"></div>

    </div>
</div>
<!--<div class="bottom-deco"></div>-->
<#--<script type="text/javascript" src="/scripts/creat-course.js">-->
<script>
    var $ = jQuery.noConflict();
    var formSubmitted = 'false';


    jQuery(document).ready(function($) {

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
        // fields blur function ends

        // submit form data starts
        function submitData(currentForm, formType){
            formSubmitted = 'true';
            var formInput = $('#' + currentForm).serialize();
            $.post($('#' + currentForm).attr('action'),formInput, function(data,status){
                if(data=="405") {
                    $('#formSuccessMessageWrap').fadeIn(500);
                    formSubmitted = 'false';
                }
                else if(data=="200")
                    window.location.href="/teacher/course/klassList?courseId=${courseId}";

            });
            //window.location.href='1vali_psw.html';
        };
        // submit form data function starts
        // validate form function starts
        function validateForm(currentForm, formType){
            // hide any error messages starts
            $('.formValidationError').hide();
            $('.fieldHasError').removeClass('fieldHasError');
            var count=4;
            // hide any error messages ends
            $('#' + currentForm + ' .requiredField').each(function(i){
                if($(this).val() == '' || $(this).val() == $(this).attr('data-dummy')){
                    // $(this).val($(this).attr('data-dummy'));
                    // $(this).focus();
                    $(this).addClass('fieldHasError');
                    $('#' + $(this).attr('id') + 'Error').fadeIn(300);
                    count=count-1;
                    return false;
                };


            });
            if(formSubmitted == 'false' && count===4){
                submitData(currentForm, formType);
            };

        };
        // validate form function ends

        // contact button function starts
        $('#contactSubmitButton').click(function() {
            var flag2=validateForm($(this).attr('data-formId'));
            if(flag2==true)
                return true;
            return false;
        });
        // contact button function ends



    });
</script>
<script src="/layui/layui.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form();

        //各种基于事件的操作，下面会有进一步介绍
    });
</script>


</body>
</html>