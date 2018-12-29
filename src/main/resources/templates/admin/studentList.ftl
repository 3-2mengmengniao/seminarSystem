<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
      <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
      <link rel="stylesheet" href="/adminStatic/css/font.css">
      <link rel="stylesheet" href="/adminStatic/css/xadmin.css">
      <link href="/adminStatic/css/pagination.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
      <script type="text/javascript" src="/adminStatic/layui/layui.js" charset="utf-8"></script>
      <script type="text/javascript" src="/adminStatic/js/xadmin.js"></script>
      <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
      <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
      <!--<script src="/adminStatic/js/jquery-1.7.2.min.js" type="text/javascript"></script>-->
      <script src="/adminStatic/js/jquery.pagination.js" type="text/javascript"></script>
    <![endif]-->
  </head>
  
  <body>

    <div class="x-body">
      <xblock>
        <form name="filterForm" id="filterForm" class="layui-form" style="display: inline-block" onkeydown="if(event.keyCode===13){return false;}">
          <div class="layui-form-item" style="margin-bottom: 0">
            <div class="layui-inline">
              <input name="username" id="username" type="text" placeholder="请输入学工号/姓名" autocomplete="off" class="layui-input" style="width: 150px;display: inline-block">
            </div>
            <div class="layui-inline">
              <button name="searchBtn" id="searchBtn" type="button" class="layui-btn"><i class="layui-icon">&#xe615;</i></button>
            </div>
          </div>
        </form>
        <!--<a class="layui-btn layui-btn-small" style="line-height:30px;padding:3px 18px;float:right;margin-left: 10px"
           href="javascript:location.replace(location.href);">
          <i class="iconfont" style="line-height:30px">&#xe6aa;</i>
        </a>
        -->
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>学工号</th>
            <th>姓名</th>
            <th>电子邮箱</th>
           <!-- <th>状态</th>-->
            <th>操作</th>
        </thead>
        <tbody>
        <#list pageInfo.list as student>
            <tr class="item">
                <td>
                    <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
                </td>
                <td class="number">${student.account}</td>
                <td class="name">${student.studentName}</td>
                <td class="email">${student.email!""}</td>
                <!--<td class="td-status">
                  <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td>-->
                <td class="td-manage">

                    <a title="编辑"  onclick="x_admin_show('编辑','/admin/editStudent?studentId=${student.id}','460','450')" href="javascript:;" style="margin-right:5px;font-size:25px;">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="重置密码" onclick="member_renew(this,'要重置的id')" href="javascript:;" name="${student.id}" style="margin-right:5px;font-size:15px;">
                        <i class="iconfont" style="font-size:13px;">&#xe6aa;</i>
                    </a>
                    <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;"  name="${student.id}" style="margin-right:5px;font-size:25px;">
                        <i class="layui-icon" >&#xe640;</i>
                    </a>
                </td>
            </tr>
        </#list>
        </tbody>
      </table>
        <div class="box">
            <div id="pagination" class="page center">
            </div>
      <#--<div class="page" style="margin-top:80px;">-->
        <#--<div>-->
          <#--<a class="prev" href="">&lt;&lt;</a>-->
          <#--<a class="num" href="">1</a>-->
          <#--<span class="current">2</span>-->
          <#--<a class="num" href="">3</a>-->
          <#--<a class="num" href="">489</a>-->
          <#--<a class="next" href="">&gt;&gt;</a>-->
        <#--</div>-->
      <#--</div>-->

    </div>
        <script>
            var pageNum = [[${pageInfo.pageNum}]];
            var pages = [[${pageInfo.pages}]];
            var pageSize = [[${pageInfo.pageSize}]];
            $("#pagination").pagination({
                currentPage: pageNum,
                totalPage: pages,
                isShow: true,
                count: pageSize,
                homePageText: "首页",
                endPageText: "尾页",
                prevPageText: "上一页",
                nextPageText: "下一页",
                num_display_entries: 4,
                num_edge_entries: 1,
            });

                //点击页数
            $('.next').on('click', function () {
                pageNum=pageNum+1;
                window.location.href = encodeURI('/admin/studentList?pageNum=' + pageNum);
            });

            $('.prev').on('click', function () {
                if(pageNum>0)
                    pageNum=pageNum-1;
                window.location.href = encodeURI('/admin/studentList?pageNum=' + pageNum);
            });

        </script>
    <script>
        $(function () {
            $("#searchBtn").bind("click",function () {
                //alert($("#username").val())
                $(".item").hide()
                $("td:contains("+$("#username").val()+")").parents('.item').fadeIn()
            })

        });

      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

      function member_renew(obj,id){
          layer.confirm('确认要重置密码吗？',function(index){

              if($(obj).attr('title')=='重置密码'){
                  var studentId=$(obj).attr("name");
                  console.log(studentId);
                  $.ajax(
                          {
                              url:"/admin/student/"+studentId+"/resetPwd",
                              type:'post',
                              success:function(data,status,response){
                                  if(response.status=="200"){
                                      console.log("success");
                                  }
                              },
                              error:function(data,status){
                                  console.log(data);
                                  console.log(status);
                                  layer.msg("修改失败",function(){});
                                  console.log("error");
                              }
                          }
                  );
                  layer.msg('已重置!',{icon: 1,time:1000});
              }else{

              }

          });
      }

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              var studentId=$(obj).attr("name");
              console.log(studentId);
              $.ajax(
                      {
                          url:"/admin/student/"+studentId,
                          type:'delete',
                          success:function(data,status,response){
                              if(response.status=="200"){
                                  console.log("success");
                              }
                          },
                          error:function(data,status){
                              console.log(data);
                              console.log(status);
                              layer.msg("修改失败",function(){});
                              console.log("error");
                          }
                      }
              );
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }


      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>