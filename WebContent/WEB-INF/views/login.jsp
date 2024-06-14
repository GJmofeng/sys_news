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
	<title>管理系统</title>
    <link href="resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="resource/css/a3common.css" rel="stylesheet">
    <link rel="stylesheet" href="resource/css/login.css">
    <link rel="stylesheet" href="resource/css/font_43459_lbtux0zjkr6yldi.css">
</head>



    <div id="main" class="main-warp">
        <div class="main-content">
            <div class="formDiv">
                
                    <h2 class="text-center">登录</h2>
                
                
                <form id="loginForm" action="LoginServlet?action=login"  method="post">
                    <div class="dataform" >
                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-yonghu1"></span>
                            <input id="userName" name="userName" type="text" class="inputs" placeholder="手机号码或登录账号" maxlength="64">
                        </div>
                       
                            <span id="userNameErr" style="color:red" >${msg}</span>
                       
                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-baomi"></span>
                            <input class="inputs" type="password" name="password" placeholder="密码" id="password" maxlength="20">
                        </div>
                        <%--登录验证码--%>
                        <div class="input-warp gap">
                            <span class="input-icon iconfont icon-yanzhengma"></span>
                            <input class="inputs" type="text" name="code" placeholder="验证码" id="code" maxlength="4">
                            <img src="checkCodeServlet?action=getCode" id="codeImg" onclick="changeCode(this)">
                        </div>

                                
                                  <div class=" gap">
				                        <span class="input-icon ">角色</span>
				                        <select name="type" class="select">
				                            <option value="1">管理员</option>
				                            <option value="2">用户</option>
				                            <option value="3">编辑者</option>
				                        </select>
				                
				                    </div>


                        <div class="btn-warp gap">
                            <div class="text-center">                               

                                <button type="submit" id="btnLogin" class="btn btn-block lgbtn blue">登录</button>
                            </div>
                        </div>
                        <div class="gap">
                            
                                <div class="pull-right" style="margin-top: 6px">
                              |<a href="LoginServlet?action=toRegister" class="link">新用户注册</a></div>
                            
                            <div class="pretty-box">
                              
                            </div>
                        </div>

                        
                          <!--   <div class="biggap third-party-title">
                                <h5 class="text-center"><span>第三方账号登录</span></h5>
                            </div>
                            <div class="third-auth">                              
                                
                                <a title="用钉钉登录" class="dt" href="javascript:;"></a>                                
                                <a title="用微信账户登录" class="wx" href="javascript:;"></a>
                                <a title="用QQ账户登录" class="qq" href="javascript:;"></a>
                                
                            </div> -->
                        
                    </div>
                </form>

            </div>
        </div>
    </div>

<style>
.copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
</style>
<div class="copyrights" id="links20210126">
	Collect from <a href="http://www.cssmoban.com/"  title="网站模板">精品模板</a>
	<a href="https://www.chazidian.com/"  title="查字典">查看字典</a>
</div>

<script src="resource/component/layui/layui.js"></script>
		<script src="resource/component/pear/pear.js"></script>
		<script>
		layui.use(['layer', 'form','jquery'], function(){
			var form = layui.form,
			 layer = layui.layer,
			 $= layui.jquery;
			 form.render();
		   
		$("#btnLogin").on("click", function() {
		    var userName = $("#userName").val().trim(); // trim()去除空格
		    var password = $("#password").val().trim();
		    var type = $("#type").val();
		    
		    
		    if(userName == ""){
		    	layer.msg('用户名或者手机号不能为空！');
		    	return false;
		    }
		    if(password == ""){
		    	layer.msg('密码不能为空！');
		    	return false;
		    }
		    if(type == ""){
		    	layer.msg('请选择角色！');
		    	return false;
		    }

		});

		setTimeout(function(){ $("#userNameErr").html("")},3000);

		});
        function changeCode() {
            document.getElementById('codeImg').src = 'checkCodeServlet?action=getCode&' + Math.random();
        }
		</script>
</body>
</html>
