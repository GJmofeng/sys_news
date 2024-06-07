<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>    
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title>旅游系统</title>
    <link href="resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="resource/css/a3common.css" rel="stylesheet">
    <link rel="stylesheet" href="resource/css/login.css">
    <link rel="stylesheet" href="resource/css/font_43459_lbtux0zjkr6yldi.css">
</head>



    <div id="main" class="main-warp">
        <div class="main-content">
            <div class="formDiv">
                
                    <h2 class="text-center">注册</h2>
                
                
                <form id="loginForm" action="UserServlet?action=addUser"  method="post" class="layui-form" enctype="multipart/form-data">
                    <div class="dataform" >
                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-yonghu1"></span>
                            <input id="message" name="stno" type="text" class="inputs" placeholder="用户名" maxlength="64">
                        </div>
                       
                            <span id="userNameErr" style="color:red" >${msg}</span>
                       

                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-baomi"></span>
                            <input class="inputs" type="text" name="pwd" placeholder="密码" id="pwd" maxlength="20">
                        </div>
                        
                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-yonghu1"></span>
                            <input class="inputs" type="text" name="name" placeholder="真实姓名" id="name" maxlength="20">
                        </div>
                        
                        
                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-yonghu1"></span>
                            <input class="inputs" type="text" name="email" placeholder="邮箱" id="email" maxlength="20">
                        </div>
                        
                        
                       
                                <input type="file" name="imgUrl" id="imgUrl" class="layui-input"  /> 

				       
				      
				        <div class="input-warp gap">
                              <img src="" id="preview_img" width="100px" height="100px" alt="">

				       </div>    
                       
                       
                      

                        <div class="btn-warp gap">
                            <div class="text-center">                               

                                <button type="submit" id="btnLogin" class="btn btn-block lgbtn blue">注册</button>
                            </div>
                        </div>
                        <div class="gap">
                            
                                <div class="pull-right" style="margin-top: 6px">
                            |<a href="LoginServlet?action=loginOut" class="link">返回登录</a></div> 
                            
                            <div class="pretty-box">
                              
                            </div>
                        </div>

                        
                        
                    </div>
                </form>

            </div>
        </div>
    </div>

<style>
.copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
</style>
<div class="copyrights" id="links20210126">
	Collect from <a href="http://www.cssmoban.com/"  title="网站模板">模板之家</a>
	<a href="https://www.chazidian.com/"  title="查字典">查字典</a>
</div>
<script src="layui/jquery-1.9.1.min.js"></script>

<script>


setTimeout(function(){ $("#userNameErr").html("")},3000);


$("#imgUrl").change(function () {
    //创建blob对象，浏览器将文件放入内存中，并生成标识
    var img_src = URL.createObjectURL($(this)[0].files[0]);
    //给img标检的src赋值
    document.getElementById("preview_img").src=img_src;
    //URL.revokeObjectURL(img_src);// 手动 回收，
});
</script>
</body>
</html>
