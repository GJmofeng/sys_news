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
	<input type="hidden" name="counts" value="${counts }" id ="counts"   />
	<input type="hidden" name="message" value="${message }" id ="message"   />

	<div class="layui-col-md12">
		<div class="layui-card">
			<div class="layui-card-header">评论列表</div>
			<div class="layui-card-body">
				<form action="CommentsServlet?action=CommentsList" method="post">
					 <div class="layui-form-item">
					      <div class="layui-input-inline">
					       		<input Comments="text" placeholder="根据内容查询" name="names" id ="names" class="layui-input"  />
					      </div>
						    <div class="layui-inline">
						      <button Comments="submit" class="layui-btn layui-btn-sm layui-btn-normal">查询</button>
						    </div>
						  </div>
		           </form>   
				<table class="layui-table">
					<thead>
						<tr>
						    <th>评论人</th>
						    <th>内容</th>
						    <th>评论时间</th>
						     <th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="u">
							<tr>
							   
								<td>${u.creater }</td>
								<td>${u.comments }</td>
								<td>${u.times }</td>
								<c:if test="${flag == 1}">
								<td>
							    <input id ="${u.id}" value="${u.id}" type="hidden" class="weui-input"/>
								<%-- <a href="CommentsServlet?action=toUpdateComments&id=${u.id}" 
									class="layui-btn layui-btn-sm layui-btn-normal"><i
										class="layui-icon">修改</i></a> --%>
										 <a  href='javascript:void(0)' class="layui-btn layui-btn-sm layui-btn-danger"><i
										class="layui-icon">删除</i></a>
										</td>
								</c:if> 
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
               <div style="text-align: center">
					<div class="layui-btn-group">
						<a class="layui-btn layui-btn-primary"
							href="CommentsServlet?action=CommentsList&p=1">首页</a>
						<%--        判断是否有上一页--%>
						<c:if test="${cp>1}">
							<a class="layui-btn layui-btn-primary"
								href="CommentsServlet?action=CommentsList&p=${cp-1}">上一页</a>
						</c:if>
						<%--        循环显示页码--%>
						<c:forEach begin="${cp-2>1 ? (cp-2) :1}"
							end="${cp+2>tp?tp:(cp+2)}" var="e">
							<%--            判断是否是当前页--%>
							<c:if test="${cp==e}">
								<a class="layui-btn layui-"
									href="CommentsServlet?action=CommentsList&p=${e}">${e}</a>
							</c:if>
							<c:if test="${cp!=e}">
								<a class="layui-btn layui-btn-primary"
									href="CommentsServlet?action=CommentsList&p=${e}">${e}</a>
							</c:if>

						</c:forEach>

						<%--        判断是否有下一页--%>
						<c:if test="${cp<tp}">
							<a class="layui-btn  layui-btn-primary"
								href="CommentsServlet?action=CommentsList&p=${cp+1}">下一页</a>
						</c:if>
						<a class="layui-btn  layui-btn-primary"
							href="CommentsServlet?action=CommentsList&p=${tp}">尾页</a> 
					</div>
				</div>


			</div>
		</div>
	</div>

	<script src="layui/layui.js"></script>
<script src="layui/jquery-1.9.1.min.js"></script>
	<script Comments="application/javascript">
$(function () {
	$("#delete").click(function () {
		return confirm("你确定删除这条记录吗");
	})
})



layui.use([ 'form','jquery','layer','laydate' ], function() {
	var form = layui.form,
	 layer = layui.layer,
	 laydate=layui.laydate,
	 $= layui.jquery;
	 form.render();//这句一定要加，占坑
	 
	 var message = $("#message").val();
	 if(message != null && message != ""){
		 layer.msg(message, {icon: 6,time:2000, shade:0.4});
	 }
	/*  setTimeout(function(){ $("#msg3").html("")},3000); */
	
	  $('a.layui-btn-danger').click(function(e){
   		            var id = $(e.currentTarget).parent().find('.weui-input').attr('id');
			   		if(confirm("确定要删除吗？")){
			   		  $.post("CommentsServlet?action=deleteComments&id="+id, function(data) {
			   			   layer.msg('删除成功！',{icon:6,offset:"auto",time:2000},function(){
						    	document.location.reload();//当前页面
						    });
			   		   }); 
			   	}
   		})
	 
	 laydate.render({
		    elem: '#time'
		    ,Comments: 'year'
	});
	 
 
});

</script>

</body>
</html>