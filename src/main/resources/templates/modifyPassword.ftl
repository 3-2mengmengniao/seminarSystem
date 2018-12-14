<!DOCTYPE HTML>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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

     <script type="text/javascript" src="/scripts/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="/scripts/jqueryui.js"></script>
    <script type="text/javascript" src="/scripts/owl.carousel.min.js"></script>
    <script type="text/javascript" src="/scripts/jquery.swipebox.js"></script>
    <script type="text/javascript" src="/scripts/colorbox.js"></script>
    <script type="text/javascript" src="/scripts/snap.js"></script>
    <script type="text/javascript" src="/scripts/new_password.js"></script>
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
    <div class="navigation-back">
        <h1 class="navigation-back">修改密码</h1>
        <a href="/" class="button-back"><img id="button-back-image" src="/images/icons/展开.png"></a>
    </div>
    <div class="decoration"></div>
</div>


<div class="content">
    <div class="formFailureMessageWrap" id="formFailureMessageWrap">
        <div class="big-notification green-notification">
            <p>密码修改失败！请稍后重试</p>
        </div>
    </div>
    <div class="formSuccessMessageWrap" id="formSuccessMessageWrap">
        <div class="big-notification green-notification">
            <p>密码修改成功！即将跳转到登录页面</p>
        </div>
    </div>
    <form action="/modifyPassword" method="post" class="contactForm" id="contactForm">
        <fieldset>
            <div class="distance3"></div>
            <div class="formFieldWrap">
                <label class="field-title contactNameField" for="contactNameField">新密码:<span>(required)</span></label>
                <input type="password" name="newPsw" value="" class="contactField requiredField" id="contactNameField" placeholder="请输入新密码"/>
            </div>
            <div class="formValidationError" id="contactNameFieldError">
                <div class="static-notification-red tap-dismiss-notification">
                    <p class="uppercase">请填写新密码!</p>
                </div>
            </div>
            <div class="formFieldWrap">
                <label class="field-title contactEmailField" for="contactEmailField">确认密码: <span>(required)</span></label>
                <input type="password" name="confirmPsw" value="" class="contactField requiredField" id="contactEmailField" placeholder="请再次输入新密码"/>
            </div>
            <div class="formValidationError" id="contactEmailFieldError">
                <div class="static-notification-red tap-dismiss-notification">
                    <p class="uppercase">请填写确认密码!</p>
                </div>
            </div>
            <div class="formValidationError" id="differentError">
                <div class="static-notification-red tap-dismiss-notification">
                    <p class="uppercase">新密码与确认密码不一致!</p>
                </div>
            </div>
            <div class="distance2"></div>
            <div class="formSubmitButtonErrorsWrap">
                <p class="center center-text "><input type="submit" class="buttonWrap button button-dark button-big contactSubmitButton" id="contactSubmitButton" value="确认提交" data-formId="contactForm"/>
                </p>
            </div>
            </p>
        </fieldset>
    </form>

</body>
</html>