<html><head>
    <meta charset="utf-8">
    <title></title>

    <link href="/styles/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="/layui/css/layui.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/scripts/jquery.js"></script>
    <script type="text/javascript" src="/scripts/jquery.js"></script>
    <script type="text/javascript" src="/scripts/snap.js"></script>
    <script type="text/javascript" src="/scripts/login.js"></script>
    <script type="text/javascript" src="/scripts/custom.js"></script>
    <script type="text/javascript" src="/scripts/framework.js"></script>
    <script type="text/javascript" src="/scripts/framework.launcher.js"></script>
    <script type="text/javascript" src="/scripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/scripts/bootstrap-float-label.js"></script>
    <script type="text/javascript" src="/scripts/jquery.runner-min.js"></script>
    <style>
        body{padding:10px; font-size:16px; background:#fff; width:95%; margin:0 auto;  line-height:20px; overflow:hidden;}
        p{margin-bottom:10px;text-align:center;}
        input{border:1px solid #999; padding:5px 10px; margin:0 10px 10px 0;}
    </style>
</head>
<body>

<div style="margin-top:20px;">
    <strong><p style="font-size:18px;">讨论课已结束</p></strong>
    <p style="margin-top:20px;">请设置书面报告截止时间</p>
    <div style="width:200px;margin-left:auto;margin-right:auto;">
        <input style="text-align:center;" type="text" class="layui-input requiredField" id="test5" placeholder="yyyy-MM-dd HH:mm:ss">
    </div>
</div>
<div>
    <p><button class="layui-btn layui-btn-primary" id="submitIframe" type="button" style="margin-top:20px;">确定</button></p>
</div>

<style type="text/css">
    .layui-laydate-content table {
        border-collapse: collapse;
        border-spacing: 0;
        font-size: 14px;
    }
</style>
<script>
    var index = parent.layer.getFrameIndex(window.name);
    $('#submitIframe').click(function(){
        var val = $('input').val();
        if(val === ''){
            layer.msg('请填写报告截止日期!');
            return;
        }
       var deadline=val;
        $.ajax(
                {
                    url:"/teacher/course/seminar/endSeminar?seminarId=${seminarControl.id}",
                    type:'post',
                    data:{"deadline":deadline},
                    contentType:'application/x-www-form-urlencoded',
                    success:function(data,status,response){
                        if(response.status=="200"){
                            parent.layer.close(index);
                        }
                    },
                    error:function(data,status){
                        console.log(data);
                        console.log(status);
                    }
                }
        );
        // parent.layer.msg('您将日期 [ ' +val + ' ] 成功传送给了父窗口');
        //
    });
    layui.use('form', function(){
        var form = layui.form();

        //各种基于事件的操作，下面会有进一步介绍
    });
    new Function($('.run').text())()

    //var index = parent.layer.getFrameIndex(window.name);
    //parent.layer.iframeAuto(index);
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //日期时间选择器
        laydate.render({
            elem: '#test5'
            ,type: 'datetime'
        });


        //自定义重要日
        laydate.render({
            elem: '#test18'
            ,mark: {
                '0-10-14': '生日'
                ,'0-12-31': '跨年' //每年的日期
                ,'0-0-10': '工资' //每月某天
                ,'0-0-15': '月中'
                ,'2017-8-15': '' //如果为空字符，则默认显示数字+徽章
                ,'2099-10-14': '呵呵'
            }
            ,done: function(value, date){
                if(date.year === 2017 && date.month === 8 && date.date === 15){ //点击2017年8月15日，弹出提示语
                    layer.msg('这一天是：中国人民抗日战争胜利72周年');
                }
            }
        });

        //限定可选日期
        var ins22 = laydate.render({
            elem: '#test-limit1'
            ,min: '2016-10-14'
            ,max: '2080-10-14'
            ,ready: function(){
                ins22.hint('日期可选值设定在 <br> 2016-10-14 到 2080-10-14');
            }
        });

        //前后若干天可选，这里以7天为例
        laydate.render({
            elem: '#test-limit2'
            ,min: -7
            ,max: 7
        });

        //限定可选时间
        laydate.render({
            elem: '#test-limit3'
            ,type: 'time'
            ,min: '09:30:00'
            ,max: '17:30:00'
            ,btns: ['clear', 'confirm']
        });

        //同时绑定多个
        lay('.test-item').each(function(){
            laydate.render({
                elem: this
                ,trigger: 'click'
            });
        });

        //初始赋值
        laydate.render({
            elem: '#test19'
            ,value: '1989-10-14'
            ,isInitValue: true
        });

        //选中后的回调
        laydate.render({
            elem: '#test20'
            ,done: function(value, date){
                layer.alert('你选择的日期是：' + value + '<br>获得的对象是' + JSON.stringify(date));
            }
        });

        //日期切换的回调
        laydate.render({
            elem: '#test21'
            ,change: function(value, date){
                layer.msg('你选择的日期是：' + value + '<br><br>获得的对象是' + JSON.stringify(date));
            }
        });

        //墨绿主题
        laydate.render({
            elem: '#test29'
            ,theme: 'molv'
        });

    });
</script>
</body>
</html>