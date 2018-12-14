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
    <link href="/layui/css/layui.css" rel="stylesheet" type="text/css">

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
    <h1 class="navigation-back">班级信息</h1>
    <a href="/teacher/courseList" class="button-back"><img id="button-back-image" src="/images/icons/展开.png"></a>
</div>
<div class="decoration"></div>

<div class="content">
    <#list courseClassList as class>
    <div class="container no-bottom">
        <h3 class="center-text" style="font-weight:bold;">${class.grade?c}-(${class.classSerial})</h3>
        <div class="distance5"></div>
        <p class="center-text">
            ${class.introduction}<br>
            班级学生名单： &emsp;周三56节.xlsx<br>
        <form id="form${class.id}" enctype="multipart/form-data" method="post" action="/teacher/course/klassList?courseId=${courseId}&classId=${class.id}" class="file center-text">
            <input type="file" name="file" id="file${class.id}" class="center-block center-text" multiple/>
            <div class="distance3"></div>
            <button type="button" class="uploadButton layui-btn layui-btn-mini" name="${class.id}" data-formId="${class.id}" style="margin-left: 10px;">提交</button>
            <button type="button" class="deleteButton layui-btn layui-btn-mini" id="deleteButton"  style="margin-left:50px;background-color: #C0392B" name="${class.id}">删除班级</button>
            <span class="showUrl"></span>
        </form>
        <div class="distance3"></div>
    </div>
</div>

    <div class="decoration"></div>
    </#list>
</div>
<div class="distance4"></div>
<div class="layui-colla-item" style="border-color: rgb(0,0,0,0);">
    <h2 class="layui-colla-title my-navigation2"  onclick="window.location.href='/teacher/course/klass/create?courseId=${courseId}'" style="width: 200px;margin:0 auto;padding: 0;">新建班级</h2>
</div>
<div class="distance4"></div>
<div class="distance4"></div>
<!--<div class="bottom-deco"></div>-->
<script>
    $('.deleteButton').click(function(){
        $.ajax({
            type: "DELETE",
            url: "/teacher/course/klass/" + $(this).attr('name'),
            success: function(data){
                if(data==="200")
                    window.location.href="/teacher/course/klassList?courseId=${courseId}";
                else if(data==="404")
                    alert("班级不存在");
            }
        });
    });
</script>
<script>
    $('.uploadButton').click(function(){

        var id=$(this).attr('data-formId');
        var fd=new FormData();
        fd.append("name", "bill");
        var t="file"+id;
        var ttt= $('#'+t)[0].files[0];
        fd.append("file", $('#'+t)[0].files[0]);
        console.log(ttt)
        var currentForm="form"+id;
        var postPath=$('#' + currentForm).attr('action');
        alert(postPath);
        $.ajax(
                {
                    url:postPath,
                    type:'post',
                    processData: false,
                    contentType: false,
                    data:fd,
                    success:function(data){console.log("success");},
                    error:function(data){console.log("error");}
                }
        );
        return false;
    });
</script>
<style>
    @media screen and (max-width:768px){
        .margin3{
            margin-left:25%;
        }
    }
    @media screen and (min-width:768px){
        .margin3{
            margin-left:42%;
        }
    }
</style>
</body>
</html>