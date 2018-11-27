<!DOCTYPE HTML>
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
    <link href="/styles/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/styles/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>

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

        <div class="formFieldWrap">
            <label class="field-title contactNameField" for="contactNameField">课程名称：<span>(required)</span></label>
            <input type="text" name="contactNameField" value="" class="contactField requiredField" id="contactNameField"/>
        </div>
        <div class="formTextareaWrap">
            <label class="field-title contactMessageTextarea" for="contactMessageTextarea">课程要求：<span>(required)</span></label>
            <textarea name="contactMessageTextarea" class="contactTextarea requiredField" id="contactMessageTextarea"></textarea>

            <div class="decoration"></div>
        </div>

        <label class="field-title contactMessageTextarea" for="contactMessageTextarea">成绩计算规则：<span>(required)</span></label>
        <div >
            <div class="distance3"></div>
            <p class="input-list">课堂展示</p>
            <p class="input-list">课堂提问</p>
            <p class="input-list">书面报告</p>
        </div>
        <div class="bottom-group">
            <div class="dropdown">
                <button class="my-btn2 btn1-default dropdown-toggle" type="button1" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    60%
                    <span class="caret1"></span>
                </button>
                <ul class="dropdown-menu1" aria-labelledby="dropdownMenu1">
                    <li class="bootstrap"><a href="#">20%</a></li>
                    <li class="bootstrap"><a href="#">30%</a></li>
                    <li class="bootstrap"><a href="#">40%</a></li>
                </ul>
            </div>
            <div class="distance4"></div>
            <div class="dropdown">
                <button class="my-btn3 btn1-default dropdown-toggle" type="button1" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    10%
                    <span class="caret1"></span>
                </button>
                <ul class="dropdown-menu1" aria-labelledby="dropdownMenu1">
                    <li class="bootstrap"><a href="#">20%</a></li>
                    <li class="bootstrap"><a href="#">30%</a></li>
                    <li class="bootstrap"><a href="#">40%</a></li>
                </ul>
            </div>
            <div class="distance4"></div>
            <div class="dropdown">
                <button class="my-btn4 btn1-default dropdown-toggle" type="button1" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    30%
                    <span class="caret1"></span>
                </button>
                <ul class="dropdown-menu1" aria-labelledby="dropdownMenu1">
                    <li class="bootstrap"><a href="#">20%</a></li>
                    <li class="bootstrap"><a href="#">30%</a></li>
                    <li class="bootstrap"><a href="#">40%</a></li>
                </ul>
            </div>
        </div>
        <div class="decoration"></div>
        <label class="field-title contactMessageTextarea" for="contactMessageTextarea">成绩计算规则：<span>(required)</span></label>
        <div >
            <div class="distance3"></div>
            <p class="input-list">小组人数上限</p>
            <p class="input-list">小组人数下限</p>
            <p class="input-list">组队开始时间</p>
            <p class="input-list">组队截止时间</p>
        </div>
        <div class="bottom-group2">
            <div class="dropdown">
                <button class="my-btn2 btn1-default dropdown-toggle" type="button1" id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    5人
                    <span class="caret1"></span>
                </button>
                <ul class="dropdown-menu1" aria-labelledby="dropdownMenu1">
                    <li class="bootstrap"><a href="#">4人</a></li>
                    <li class="bootstrap"><a href="#">3人</a></li>
                </ul>
            </div>
            <div class="distance4"></div>
            <div class="dropdown">
                <button class="my-btn3 btn1-default dropdown-toggle" type="button1" id="dropdownMenu5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    1人
                    <span class="caret1"></span>
                </button>
                <ul class="dropdown-menu1" aria-labelledby="dropdownMenu1">
                    <li class="bootstrap"><a href="#">&emsp;2人&emsp;</a></li>
                    <li class="bootstrap"><a href="#">&emsp;3人&emsp;</a></li>
                </ul>
            </div>

            <input type="date" style="margin-bottom: 5px;">
            <input type="date">
            <div class="distance4"></div>

        </div>
        <div class="distance4"></div>
        <p class="center center-text"><a href="/teacher/courses" class="button-big button-dark">创建课程</a></p>

        <div class="decoration"></div>
        <div class="footer">
            <div class="clear"></div>
            <p class="copyright">
                Copyright @2018 developed by Group 3-2.<br>
                All Rights Reserved
            </p>
        </div>
    </div>

<div class="bottom-deco"></div>
<script>

</script>

</body>
</html>