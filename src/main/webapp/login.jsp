<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/common.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<!DOCTYPE HTML>
<html lang="en" class="no-js">
	 <title>登陆</title>
  	 <head>
  			<meta charset="utf-8">
  			<title>登录界面</title>
  			<!-- 让网页的宽度自动适应手机屏幕的宽度 -->
  			<meta name="viewport" content="width=device-width, initial-scale=1.0">
  			<meta name="description" content="简介">
  			<meta name="author" content="lx">
  			<!-- CSS -->
  			<link rel="stylesheet" href="css/login/supersized.css" type="text/css"/>
			<link rel="stylesheet" href="css/login/login.css" type="text/css"/>
			<link rel="stylesheet" href="css/login/bootstrap.min.css" type="text/css"/>
 	 </head>
 	 <body>
		<div class="page-container">
			<div class="main_box">
				<div class="login_box">
					<div class="login_logo">
						<!--<img src="img/login/logo.png" >-->
						<h1>欢迎登陆</h1>
					</div>
					<div class="login_form">
						<form name="login_form" id="login_form"  method="post">
							<div class="form-group">
								<label for="j_username" class="t">用户名：</label>
								<input id="j_username" name="username" type="text" class="form-control x319 in"  autocomplete="off">
							</div>
							<div class="form-group">
								<label for="j_password" class="t">密　码：</label>
								<input id="j_password" name="password" type="password" class="password form-control x319 in">
							</div>
							<div class="form-group">
								<label for="j_captcha" class="t">验证码：</label>
								<input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in">
								<img  id="captcha_img" title="点击更换" onclick="refresh(this);" src="/login!yzm.action">
							</div>
							<div class="form-group">
								<label class="t"></label>
								<label for="j_remember" class="m">
									<input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
							</div>
							<div class="form-group space">
								<label class="t"></label>　　　
								<button type="button" id="submit_btn" class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp;</button>
								<input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
							</div>
						</form>
					</div>
				</div>
				<div class="bottom">Copyright &copy; 2015 - 2016 <a href="#">系统登陆</a></div>
			</div>
		</div>
  	 </body>
  	 <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	 <!--[if lt IE 9]>
	 <script type="text/javascript" src="js/login/html5.js"></script>
	 <![endif]-->
	 <script type="text/javascript" src="js/login/tooltips.js"></script>
	 <script type="text/javascript" src="js/login/login.js"></script>
  	 <script type="text/javascript" src="js/login/supersized.3.2.7.min.js"></script>
	 <script type="text/javascript" src="js/login/supersized-init.js"></script>
	 <script type="text/javascript" src="js/login/scripts.js"></script>
	 <script type="text/javascript">
		 	$(function (){
				$("#submit_btn").click(function (){
					//document.login_form.action = "/login!login.action";//error : $("#login_form").action = "/login!login.action";
					$("#login_form").attr('action','/login!login.action');
					$("#login_form").submit();
				});
			});

		 	//图片切换
		 	function refresh(obj){
		 		obj.src = "/login!yzm.action?n=" + Math.random();//防止缓存
		 	}
	 </script>
 </html>
