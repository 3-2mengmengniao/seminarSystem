<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <title>登录</title>
    <link href="/styles/style.css"     		rel="stylesheet" type="text/css">
    <link href="/styles/framework.css" 		rel="stylesheet" type="text/css">
    <link href="/styles/owl.carousel.css" 	 rel="stylesheet" type="text/css">
    <link href="/styles/owl.theme.css" 		rel="stylesheet" type="text/css">
    <link href="/styles/swipebox.css"		 rel="stylesheet" type="text/css">
    <link href="/styles/colorbox.css"		 rel="stylesheet" type="text/css">
    <link href="/styles/bootstrap.css"		 rel="stylesheet" type="text/css">

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
    <div class="login-header">
        <h1 class="login-logo">讨论课管理系统登录</h1>
    </div>
    <div class="decoration"></div>
</div>
<div class="content">
    <div class="formSuccessMessageWrap" id="formSuccessMessageWrap">
        <div class="big-notification green-notification">
            <h3 class="uppercase">Message Sent </h3>
            <a href="#" class="close-big-notification">x</a>
            <p>账号密码错误！请再次尝试</p>
        </div>
    </div>
    <form action="/login" method="post" class="contactForm" id="contactForm">
        <fieldset>
            <p>
                <div class="formValidationError" id="contactNameFieldError">
                    <div class="static-notification-red tap-dismiss-notification">
            <p class="center-text uppercase">请填写教工号/学号!</p>
</div>
</div>
<div class="formValidationError" id="contactEmailFieldError">
    <div class="static-notification-red tap-dismiss-notification">
        <p class="center-text uppercase">请填写密码!</p>
    </div>
</div>

<div class="formFieldWrap">
    <label class="field-title contactNameField" for="contactNameField">学号/教工号/管理员账号:<span>(required)</span></label>
    <input type="text" name="contactNameField" value="" class="contactField requiredField" id="contactNameField" placeholder="请输入账号"/>
</div>
<div class="formFieldWrap">
    <label class="field-title contactEmailField" for="contactEmailField">密码: <span>(required)</span></label>
    <img id="demo_img" onclick="hideShowPsw()" src="/images/icons/showPasswd.png">
    <input type="text" name="contactEmailField" value="" class="contactField requiredField" id="contactEmailField" placeholder="初次登录默认密码为 123456"/>
</div>
<div class="distance2"></div>
<div class="formSubmitButtonErrorsWrap">
    <p class="center center-text "><input type="submit" class="buttonWrap button button-dark button-big contactSubmitButton" id="contactSubmitButton" value="登录" data-formId="contactForm"/>
    </p>
</div>
</p>
</fieldset>
</form>


</div>

<div class="page_footer">
    <div class="decoration"></div>
    <div class="footer">
        <div class="clear"></div>
        <p class="copyright">
            Copyright @2018 developed by Group 3-2.<br>
            All Rights Reserved
        </p>
    </div>
    <div class="bottom-deco"></div>
</div>


</body>
<script>
    //隐藏text block，显示password block
    var demoImg = document.getElementById("demo_img");
    var demoInput = document.getElementById("contactEmailField");
    function hideShowPsw(){

        if (demoInput.type == "text") {
            demoInput.type = "password";
            demo_img.src = "/images/icons/hidePasswd.png";
        }else {
            demoInput.type = "text";
            demo_img.src = "/images/icons/showPasswd.png";
        }
    }


</script>
</html>