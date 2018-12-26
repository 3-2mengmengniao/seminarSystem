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
<div class="content">
    <div class="header">
        <div class="navigation-back">
            <h1 class="navigation-back">${course.courseName}</h1>
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
                <a href="/teacher/index" class="home-icon">讨论课</a>
                <em class="active-menu"></em>
            </div>
        </div>
    </div>
</div>

<div class="content">
    <#list roundList as round>
    <div class="distance3"></div>
    <div class="center-navigation">
        <div class="layui-collapse" lay-accordion="">
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">第${round.roundSerial}轮</h2>
                <div class="layui-colla-content">
                    <div class="layui-collapse" lay-accordion="">
                        <#list round.roundScoreList as roundScore>
                            <div class="layui-colla-item">
                                <h2 class="layui-colla-title">${roundScore.serial.getSerial()}&nbsp&nbsp&nbsp${roundScore.totalScore}分</h2>
                                <div class="layui-colla-content ">
                                    <div class="layui-collapse" lay-accordion="">
                                        <#list roundScore.seminarScoreList as seminarScore>
                                            <div class="layui-colla-item">
                                                <h2 class="layui-colla-title">${seminarScore.seminarInfoName}</h2>
                                                <div class="layui-colla-content ">
                                                    展示：${seminarScore.presentationScore}分&nbsp&nbsp提问：${seminarScore.questionScore}分&nbsp&nbsp报告：${seminarScore.reportScore}分
                                                </div>
                                            </div>
                                        </#list>
                                        <div class="layui-colla-item">
                                            <h2 class="layui-colla-title">总成绩</h2>
                                            <div class="layui-colla-content ">
                                                展示：${roundScore.presentationScore}分&nbsp&nbsp提问：${roundScore.questionScore}分&nbsp&nbsp报告：${roundScore.reportScore}分&nbsp&nbsp总分：${roundScore.totalScore}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="distance4"></div>
    </#list>
</div>


    <div class="distance2"> </div>
    <div class="distance2"> </div>
<button onclick="window.location.href='#'"  class="uploadButton layui-btn layui-btn-mini margin3" >导出成绩</button>

    <div class="distance2"> </div>
    <div class="distance4"> </div>
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


<!--<div class="bottom-deco"></div>-->

<style>
    @media screen and (max-width:768px){
        .margin3{
            margin-left:35%;
        }
    }
    @media screen and (min-width:768px){
        .margin3{
            margin-left:44%;
        }
    }
</style>
</body>
<script>
    //注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        element.on('collapse(filter)', function(data){
            console.log(data.show); //得到当前面板的展开状态，true或者false
            console.log(data.title); //得到当前点击面板的标题区域DOM对象
            console.log(data.content); //得到当前点击面板的内容区域DOM对象
        });
    });
</script>
</html>