<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <title>登录</title>
    <link href="../static/styles/style.css"     		rel="stylesheet" type="text/css">
    <link href="../static/styles/framework.css" 		rel="stylesheet" type="text/css">
    <link href="../static/styles/owl.carousel.css" 	 rel="stylesheet" type="text/css">
    <link href="../static/styles/owl.theme.css" 		rel="stylesheet" type="text/css">
    <link href="../static/styles/swipebox.css"		 rel="stylesheet" type="text/css">
    <link href="../static/styles/colorbox.css"		 rel="stylesheet" type="text/css">
    <link href="../static/styles/bootstrap.css"		 rel="stylesheet" type="text/css">

    <script type="text/javascript" src="../static/scripts/jquery.js"></script>
    <script type="text/javascript" src="../static/scripts/jqueryui.js"></script>
    <script type="text/javascript" src="../static/scripts/owl.carousel.min.js"></script>
    <script type="text/javascript" src="../static/scripts/jquery.swipebox.js"></script>
    <script type="text/javascript" src="../static/scripts/colorbox.js"></script>
    <script type="text/javascript" src="../static/scripts/snap.js"></script>
    <script type="text/javascript" src="../static/scripts/login.js"></script>
    <script type="text/javascript" src="../static/scripts/custom.js"></script>
    <script type="text/javascript" src="../static/scripts/framework.js"></script>
    <script type="text/javascript" src="../static/scripts/framework.launcher.js"></script>
    <script type="text/javascript" src="../static/scripts/bootstrap-3.1.1.min.js"></script>


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
<div class="distance4"></div>
<div class="content">
    <div class="formSuccessMessageWrap" id="formSuccessMessageWrap">
        <div class="big-notification green-notification">
            <h3 class="uppercase">Message Sent </h3>
            <a href="#" class="close-big-notification">x</a>
            <p>Your message has been successfuly sent. Please allow up to 48 hours for a reply! Thank you!</p>
        </div>
    </div>
    <form action="" method="post" class="contactForm" id="contactForm">
        <fieldset>
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
                <label class="field-title contactNameField" for="contactNameField">学号/教工号/管理员账号:</label>
                <input type="text" name="contactNameField" value="" class="contactField requiredField" id="contactNameField"  placeholder="请输入账号"/>
            </div>
            <div class="formFieldWrap">
                <label class="field-title contactEmailField" for="contactEmailField">密码: </label>
                <img id="demo_img" onclick="hideShowPsw()" src="../static/images/icons/showPasswd.png">
                <input type="text" name="contactEmailField" value="" class="contactField requiredField" id="contactEmailField" placeholder="初次登录默认密码为 123456"/>
            </div>
        </fieldset>
    </form>

</div>
<div class="distance4"></div>
<p class="center center-text"><a href="/teacher/homepage" class="button-big button-dark">登录</a></p>

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
            demo_img.src = "../static/images/icons/hidePasswd.png";
        }else {
            demoInput.type = "text";
            demo_img.src = "../static/images/icons/showPasswd.png";
        }
    }


</script>
</html>