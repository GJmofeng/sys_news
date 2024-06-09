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

	<div class="layui-col-md12">
		<div class="layui-card">
			<div class="layui-card-header">新闻列表</div>
			<div class="layui-card-body">
			     <form action="NewsServlet?action=NewsList" method="post">
						    
						         <div class="layui-form-item">
									    <div class="layui-inline">
									      <div class="layui-input-inline">
									       		<input type="text" placeholder="根据新闻标题" name="names" id ="names" class="layui-input"  />
									      </div>
									    </div>
									    <div class="layui-inline">
									      <button type="submit" class="layui-btn layui-btn-sm layui-btn-normal">查询</button>
									  </div>
							     </div>
						    
		           </form>   
				<table class="layui-table">
					<thead>
						<tr>
						   <th>标题</th>
						    <th>分类</th>
							<th>作者</th>
							<th>发布时间</th>
							<th>浏览次数</th>
							<th>评论次数</th>
							<th>封面</th>
							<th>状态</th>
				            <th>操作</th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach items="${list}" var="u">
							<tr>
							    <td>${u.title }</td>
							    <td>${u.category }</td>
							    <td>${u.editor }</td>
								<td>${u.times }</td>
								<td>${u.see_count }</td>
								<td>${u.comment_count }</td>
								<td><img src="/images/${u.img}" width="50px" height="50px" alt=""></td>
				                	<td>
				                	<c:if test="${u.state == '0' }">
				                	待管理员审核
				                	</c:if>
				                		<c:if test="${u.state == '1' }">
				                	审核通过
				                	</c:if>
				                		<c:if test="${u.state == '2' }">
				                	审核拒绝
				                	</c:if>
				                	</td>
				                	<td>
				                	
							    <input id ="${u.id}" value="${u.id}" type="hidden" class="weui-input"/>
							    <c:if test="${u.state == '0' && flag == '1' }">
				                	<a href="javascript:void(0)" 
									    class="layui-btn layui-btn-sm layui-btn-normal agree"><i
										class="layui-icon">同意</i></a> 
										<a href="javascript:void(0)" 
									    class="layui-btn layui-btn-sm layui-btn-warm refused"><i
										class="layui-icon">拒绝</i></a> 
				                	</c:if>
								
										 <a  href='javascript:void(0)' class="layui-btn layui-btn-sm layui-btn-danger"><i
										class="layui-icon">删除</i></a>
										</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="text-align: center">
					<div class="layui-btn-group">
						<a class="layui-btn layui-btn-primary"
							href="NewsServlet?action=NewsList&p=1">首页</a>
						<%--        判断是否有上一页--%>
						<c:if test="${cp>1}">
							<a class="layui-btn layui-btn-primary"
								href="NewsServlet?action=NewsList&p=${cp-1}">上一页</a>
						</c:if>
						<%--        循环显示页码--%>
						<c:forEach begin="${cp-2>1 ? (cp-2) :1}"
							end="${cp+2>tp?tp:(cp+2)}" var="e">
							<%--            判断是否是当前页--%>
							<c:if test="${cp==e}">
								<a class="layui-btn layui-btn-normal"
									href="NewsServlet?action=NewsList&p=${e}">${e}</a>
							</c:if>
							<c:if test="${cp!=e}">
								<a class="layui-btn layui-btn-primary"
									href="NewsServlet?action=NewsList&p=${e}">${e}</a>
							</c:if>

						</c:forEach>

						<%--        判断是否有下一页--%>
						<c:if test="${cp<tp}">
							<a class="layui-btn  layui-btn-primary"
								href="NewsServlet?action=NewsList&p=${cp+1}">下一页</a>
						</c:if>
						<a class="layui-btn  layui-btn-primary"
							href="NewsServlet?action=NewsList&p=${tp}">尾页</a> 
					</div>
				</div>
				
			</div>
		</div>
	</div>

	<script src="layui/layui.js"></script>
<script src="layui/jquery-1.9.1.min.js"></script>
	<script type="application/javascript">
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
	 
	 laydate.render({
		    elem: '#time'
		    ,type: 'year'
	});
	 
	 
	 $('a.layui-btn-danger').click(function(e){
	   		            var id = $(e.currentTarget).parent().find('.weui-input').attr('id');
				   		if(confirm("确定要删除吗？")){
				   		  $.post("NewsServlet?action=deleteNews&id="+id, function(data) {
				   			   layer.msg('删除成功！',{icon:6,offset:"auto",time:2000},function(){
							    	document.location.reload();//当前页面
							    });
				   		   }); 
				   	}
	   		})
	 $('a.agree').click(function(e){
	   		            var id = $(e.currentTarget).parent().find('.weui-input').attr('id');
				   		if(confirm("确定要同意吗？")){
				   		  $.post("NewsServlet?action=updateStatus&id="+id+"&state=1", function(data) {
				   			   layer.msg('操作成功！',{icon:6,offset:"auto",time:2000},function(){
							    	document.location.reload();//当前页面
							    });
				   		   }); 
				   	}
	   		})
	 $('a.refused').click(function(e){
	   		            var id = $(e.currentTarget).parent().find('.weui-input').attr('id');
				   		if(confirm("确定要拒绝吗？")){
					   		  $.post("NewsServlet?action=updateStatus&id="+id+"&state=2", function(data) {
				   			   layer.msg('操作成功！',{icon:6,offset:"auto",time:2000},function(){
							    	document.location.reload();//当前页面
							    });
				   		   }); 
				   	}
	   		})

});

</script>

</body>
</html>