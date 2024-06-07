
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
          <div class="layui-card-header">修改用户信息</div>
          <div class="layui-card-body">
             <form action="UserServlet?action=updateUser" method="post" id="registerForm"  name="registerForm" class="layui-form">
             	<input name="sid" id="sid" value="${User.id }"  type = "hidden" /> 
              <div class="layui-form-item">
                <label class="layui-form-label">用户名:</label>
                <div class="layui-input-inline">
				<input name="stno" id="stno" value="${User.stno }" class="layui-input" /> 
				  <span id="msg3" style="color:red">${message}</span>
                </div>
              </div>
              
               <div class="layui-form-item">
                <label class="layui-form-label">密码:</label>
                <div class="layui-input-inline">
				<input name="pwd" id="pwd" class="layui-input" value="${User.pwd }"/> 
                </div>
              </div>
              
              <div class="layui-form-item">
                <label class="layui-form-label">姓名:</label>
                <div class="layui-input-inline">
				<input name="name" id="name" class="layui-input" value="${User.name }"/> 
                </div>
              </div>
              
              
              <div class="layui-form-item">
                <label class="layui-form-label">邮箱:</label>
                <div class="layui-input-inline">
				<input name="email" id="email" class="layui-input" value="${User.email }"/> 
                </div>
              </div>
              
             <%--  <div class="layui-form-item">
                <label class="layui-form-label">金额:</label>
                <div class="layui-input-inline">
				<input name="sums" id="sums" class="layui-input" value="${User.sums }"/> 
                </div>
              </div> --%>
              
             <%--  <div class="layui-form-item">
                <label class="layui-form-label">上传图片:</label>
                <div class="layui-input-inline">
                    <input type="file" name="imgUrl" id="imgUrl" class="layui-input"  /> 
                </div>
               </div>
                   <div class="layui-form-item">
                     <label class="layui-form-label">图片展示:</label>
                        <div class="layui-input-inline">
                            <img src="<%=path %>${User.imgUrl}" id="preview_img" width="350px" height="200px" alt="">
                        </div>
               </div>  --%>
              
              
              <br>
                <div class="layui-form-item">
                <div class="layui-input-block">
                  <button class="layui-btn" type="submit" id="sub_btn">修改</button>
                    <c:if test="${flag ==  '2' }">
                           <a href="UserServlet?action=toUpdateUser&id=${User.id }" class="layui-btn layui-btn-primary" >重置</a>
	                     </c:if>
	                     
	                      <c:if test="${flag ==  '1' }">
	                        <a href="UserServlet?action=UserList" class="layui-btn layui-btn-primary" >返回</a>
	                     </c:if>
                 
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
		    elem: '#create_date'
		  });
	 
	 laydate.render({
		    elem: '#over_date'
		  });
	 
	 $(function () {
		    // 给注册绑定单击事件i
		    $("#sub_btn").click(function () {
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