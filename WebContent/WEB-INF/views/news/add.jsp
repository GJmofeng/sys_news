
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
          <div class="layui-card-header">新增新闻信息</div>
          <div class="layui-card-body">
             <form action="NewsServlet?action=addNews" method="post" id="registerForm" name="registerForm" enctype="multipart/form-data" class="layui-form">
              <div class="layui-form-item">
                <label class="layui-form-label">标题:</label>
                <div class="layui-input-inline">
				<input name="title" id="title" class="layui-input" /> 
				  <span id="msg3" style="color:red">${message}</span>
                </div>
              </div>
              
              <div class="layui-form-item">
                <label class="layui-form-label">新闻类型:</label>
                <div class="layui-input-inline">
				 <select  class="form-control" id="category" name="category" >
                            <c:forEach items="${categoryList}" var ="bc" >
								<option value="${bc.cname}">${bc.cname}</option>
							</c:forEach>
                            </select>
                </div>
              </div>
              
              
               <div class="layui-form-item">
                <label class="layui-form-label">上传封面:</label>
                <div class="layui-input-inline">
                    <input type="file" name="imgUrl" id="imgUrl" class="layui-input"  /> 
                </div>
               </div>
               
                   <div class="layui-form-item">
                     <label class="layui-form-label">照片展示:</label>
                        <div class="layui-input-inline">
                            <img src="" id="preview_img" width="350px" height="200px" alt="">
                        </div>
               </div> 
              
              
                   <div class="layui-form-item">
                 <label class="layui-form-label">内容详情</label>
                  <div class="layui-input-inline">
                   <script id="container" name="content" type="text/plain"></script>
                </div>
              </div>
              
              <br>
                <div class="layui-form-item">
                <div class="layui-input-block">
                  <button class="layui-btn" type="submit" id="sub_btn">提交</button>
                  <a href="NewsServlet?action=toAddNews" class="layui-btn layui-btn-primary" >重置</a>
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
<script src="js/ueditor/ueditor.config.js"></script>
    <script src="js/ueditor/ueditor.all.min.js"></script>
    <script src="js/ueditor/lang/zh-cn/zh-cn.js"></script>
       <script type="text/javascript">
       var ue = UE.getEditor('container',{
    	   initialFrameWidth:1000,
    	//   initialFrameHeight:400,
       });
   </script>
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