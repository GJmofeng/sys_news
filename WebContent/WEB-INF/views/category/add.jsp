
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="/WEB-INF/common/form_header.jsp"/>
<body>

 
  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-header">新增新闻类型</div>
          <div class="layui-card-body">
             <form action="CategoryServlet?action=addCategory" method="post" id="registerForm" name="registerForm"  class="layui-form" >
              <div class="layui-form-item">
                <label class="layui-form-label">名称:</label>
                <div class="layui-input-inline">
				<input name="cname" id="cname" class="layui-input" /> 
				  <span id="msg3" style="color:red">${message}</span>
                </div>
              </div>
               

              <br>
                <div class="layui-form-item">
                <div class="layui-input-block">
                  <button class="layui-btn" type="submit" id="sub_btn">提交</button>
                  <a href="CategoryServlet?action=toAddCategory" class="layui-btn layui-btn-primary" >重置</a>
                </div>
              </div>  
              </form>
            </div>
            
          </div>
        </div>
      </div>
    </div>
		

<script src="layui/layui.js"></script>
<script src="layui/jquery-1.9.1.min.js"></script>
<script>

layui.use([ 'form','jquery','layer','laydate' ], function() {
	var form = layui.form,
	 layer = layui.layer,
	 laydate=layui.laydate,
	 $= layui.jquery;
	 form.render();//这句一定要加，占坑
	 
	 laydate.render({
		    elem: '#time'
		  });
	 
	 $(function () {
		    // 给注册绑定单击事件i
		    $("#sub_btn").click(function () {
		        var name = $("#name").val();
		        var sex = $("#sex").val();
		        var classes = $("#classes").val();
		        var time = $("#time").val();
		        var xy = $("#xy").val();
		        var phone = $("#phone").val();
		        var pwd = $("#pwd").val();
		        var stno = $("#stno").val();
		      /*   if(sex == null || sex== ""){
		        	layer.msg('性别不能为空！');
		        	return false;
		        }
		        if(name == null || name== ""){
		        	layer.msg('姓名不能为空！');
		        	return false;
		        }
		        if(classes == null || classes== ""){
		        	layer.msg('班级不能为空！');
		        	return false;
		        }
		        if(time == null || time== ""){
		        	layer.msg('入学时间不能为空！');
		        	return false;
		        }
		        if(xy == null || xy== ""){
		        	layer.msg('学院不能为空！');
		        	return false;
		        }
		        if(phone == null || phone== ""){
		        	layer.msg('手机号不能为空！');
		        	return false;
		        }
		        if(pwd == null || pwd== ""){
		        	layer.msg('密码不能为空！');
		        	return false;
		        }
		        if(stno == null || stno== ""){
		        	layer.msg('学号不能为空！');
		        	return false;
		        } */
		    });
		    setTimeout(function(){ $("#errorMsg").html("")},3000);
	});
	 setTimeout(function(){ $("#msg3").html("")},3000);
	 
	 $("#imgUrl").change(function () {
		    //创建blob对象，浏览器将文件放入内存中，并生成标识
		    var img_src = URL.createObjectURL($(this)[0].files[0]);
		    //给img标检的src赋值
		    document.getElementById("preview_img").src=img_src;
		    //URL.revokeObjectURL(img_src);// 手动 回收，
		});

});
</script>
</body>
</html>