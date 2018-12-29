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
                                <h2 class="layui-colla-title">${roundScore.serial.getSerial()}&nbsp&nbsp&nbsp${roundScore.totalScore!0}分</h2>
                                <div class="layui-colla-content ">
                                    <div class="layui-collapse" lay-accordion="">
                                        <#list roundScore.seminarScoreList as seminarScore>
                                            <div class="layui-colla-item">
                                                <h2 class="layui-colla-title">${seminarScore.seminarInfoName}</h2>
                                                <div class="layui-colla-content ">
                                                    <form method="post" action="/teacher/course/grade?seminarControlId=${seminarScore.seminarControlId}&teamId=${seminarScore.teamId}" id="${seminarScore.seminarControlId}+${seminarScore.teamId}">
                                                    <img name="${seminarScore.seminarControlId}+${seminarScore.teamId}" class="edit-score" src="/images/灰色修改.png"></img>
                                                    <div>展示：&emsp;&emsp;&emsp;&emsp;分
                                                        <div>
                                                            <input disabled name="presentationScore" class="layui-input layui-disabled"  style="width:40px;margin-left:50px;margin-top:-30px;"  value="${seminarScore.presentationScore!0}">
                                                        </div>
                                                    </div>
                                                    <div>提问：&emsp;&emsp;&emsp;&emsp;分
                                                        <div>
                                                            <input disabled name="questionScore" class="layui-input layui-disabled"  style="width:40px;margin-left:50px;margin-top:-30px;" value="${seminarScore.questionScore!0}">
                                                        </div>
                                                    </div>
                                                    <div>报告：&emsp;&emsp;&emsp;&emsp;分
                                                        <div>
                                                            <input disabled name="reportScore" class="layui-input layui-disabled" style="width:40px;margin-left:50px;margin-top:-30px;"    value="${seminarScore.reportScore!0}">
                                                         </div>
                                                    </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </#list>
                                        <div class="layui-colla-item">
                                            <h2 class="layui-colla-title">总成绩</h2>
                                            <div class="layui-colla-content ">
                                                展示：${roundScore.presentationScore!0}分&nbsp&nbsp提问：${roundScore.questionScore!0}分&nbsp&nbsp报告：${roundScore.reportScore!0}分&nbsp&nbsp总分：${roundScore.totalScore!0}分
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
<script>
    $("img.edit-score").on("click",function(){
        if($(this).hasClass("edit-score")){
            $(this).attr("src","/images/灰色保存.png");
            $(this).nextAll().find(".layui-input").each(function(){
                $(this).removeAttr("disabled");
                $(this).removeClass("layui-disabled");
            });
            $(this).removeClass("edit-score");
            $(this).addClass("save-score");
        }
       else{
           var id=$(this).attr("name");
           alert(id);
            $('#'+id).submit();
            $(this).attr("src","/images/灰色修改.png");
            $(this).nextAll().find(".layui-input").each(function(){
                $(this).attr("disabled","disabled");
                $(this).addClass("layui-disabled");
            });
            $(this).removeClass("save-score");
            $(this).addClass("edit-score");
        }
    });
    // $("img.save-score").on("click",function(){
    //     $(this).attr("src","/images/灰色修改.png");
    //     $(this).parents().parents().find(".layui-input").each(function(){
    //         $(this).attr("disabled","disabled");
    //         $(this).addClass("layui-disabled");
    //     });
    //     $(this).removeClass("save-score");
    //     $(this).addClass("edit-score");
    // });
</script>
<style>
    .edit-score{
        z-index:9999;
        width: 40px;
        cursor: pointer;
        margin-top: 30px;
        margin-right: 15%;
        float: right;
     }
    .save-score{
        z-index:9999;
        width: 40px;
        cursor: pointer;
        margin-top: 30px;
        margin-right: 15%;
        float: right;
    }
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