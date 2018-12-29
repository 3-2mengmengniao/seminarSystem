<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">


    <title>登录</title>
    <link href="/styles/style.css" rel="stylesheet" type="text/css">
    <link href="/styles/framework.css" rel="stylesheet" type="text/css">
    <link href="/styles/owl.carousel.css" rel="stylesheet" type="text/css">
    <link href="/styles/owl.theme.css" rel="stylesheet" type="text/css">
    <link href="/styles/swipebox.css" rel="stylesheet" type="text/css">
    <link href="/styles/colorbox.css" rel="stylesheet" type="text/css">
    <link href="/styles/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="/layui/css/layui.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/styles/bootstrap-float-label.css">

    <script type="text/javascript" src="/scripts/jquery-1.11.0.min.js"></script>
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
    <script src="/scripts/jquery.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="/scripts/bootstrap-float-label.js"></script>

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
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="distance3"></div>
    <div class="login-header">
        <h1>讨论课管理系统登录</h1>
    </div>
    <div class="distance4"></div>
    <div class="distance5"></div>
</div>
<div class="content">
    <div class="formSuccessMessageWrap" id="formSuccessMessageWrap">
        <div class="static-notification-green tap-dismiss-notification">
        <#--<h3 class="uppercase">Message Sent </h3>-->
        <#--<a href="#" class="close-big-notification">x</a>-->
            <p style="color:#d44950;">账号或密码有误，请重新输入！</p>
        </div>
    </div>
    <form action="/login" method="post" class="contactForm" id="contactForm" >
        <fieldset>
            <p>
            <#--<div class="formFieldWrap">-->
            <#--<label class="field-title contactNameField" for="contactNameField">教工号/学号:</label>-->
            <#--<input style="-webkit-tap-highlight-color:rgba(255,0,0,0);" autocomplete=”off” type="text" name="username" value="" class="contactField requiredField" id="contactNameField" placeholder="请输入账号"/>-->
            <#--</div>-->
            <div class="form-group floating-control-group formFieldWrap">
                <label for="txtFloatingUsername" style="z-index:9999;font-size:18px;">教工号/学工号</label>
                <input style="margin-bottom:3px;padding-left:13px;font-size:15px;padding-top:10px;" type="text" name="account" autocomplete="off" class="my-form-control contactField requiredField" id="contactNameField"  placeholder="Enter Username">
            </div>
            <div class="formValidationError" id="contactNameFieldError">
                <div class="static-notification-red tap-dismiss-notification">
                    <p class="">请填写教工号/学号!</p>
                </div>
            </div>
        <#--<div class="formFieldWrap">-->
        <#--<label class="field-title contactEmailField" for="contactEmailField">密码: </label>-->
        <#--<img id="demo_img" onclick="hideShowPsw()" src="/images/icons/showPasswd.png">-->
        <#--<input autocomplete=”off” type="password" name="password" value="" class="contactField requiredField" id="contactEmailField" placeholder="初次登录默认密码为 123456"/>-->
        <#--</div>-->
            <div class="form-group floating-control-group formFieldWrap">
                <label for="txtFloatingPassword" style="z-index:9999;font-size:18px;">密码</label>
                <input style="margin-bottom:3px;padding-left:13px;font-size:15px;padding-top:10px;" type="password" name="password" autocomplete="off" class="my-form-control contactField requiredField" id="contactEmailField" placeholder="Enter Password">
                <span class="pswtips" style="font-size: 15px;margin-left: 15px;padding-bottom: 10px;color:rgb(0,0,0,0.4);">默认密码为123456</span>
            </div>
            <div class="formValidationError" id="contactEmailFieldError">
                <div class="static-notification-red tap-dismiss-notification">
                    <p class="uppercase">请填写密码!</p>
                </div>
            </div>
            <a class="forget-password" type="button" style="cursor:pointer;-webkit-appearance:none;color:#009688;font-size:18px;margin-top:-5px;"  onclick="window.location.href='/forgetPassword'">忘记密码？</a>
            <div class="distance"></div>
            <div class="formSubmitButtonErrorsWrap">
                <p class="center center-text "><input type="submit" class="layui-btn"  style="font-size: 18px;line-height: 42px;height: 40px;" id="contactSubmitButton" value="登录" data-formId="contactForm"/>
                </p>
            </div>
            </p>
        </fieldset>
    </form>
</div>

<script type="text/javascript">
    $(function(){
        $('.form-group').floatingLabel();
    })

</script>
</body>
<script>
    <#if message??>
        window.onload = function () {
            layer.msg("${message}",function(){});
        };
    </#if>
    //隐藏text block，显示password block
    var demoImg = document.getElementById("demo_img");
    var demoInput = document.getElementById("contactEmailField");
    function hideShowPsw() {
        if (demoInput.type == "text") {
            demoInput.type = "password";
            demo_img.src = "/images/icons/showPasswd.png";
        } else {
            demoInput.type = "text";
            demo_img.src = "/images/icons/hidePasswd.png";
        }
    }
</script>
</html>