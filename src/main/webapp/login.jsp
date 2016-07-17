<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/common.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<!DOCTYPE HTML>
<html lang="zh-CN" class="no-js">
	 <title>web2 - ssh练习项目</title>
  	 <head>
		<title>登录界面</title>
		<meta charset="utf-8">
		 <%--IE 兼容性设置--%>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<%-- 让网页的宽度自动适应手机屏幕的宽度 --%>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="简介">
		<meta name="author" content="lx">
		<%-- CSS --%>
		<link rel="stylesheet" href="/css/login/supersized.css" type="text/css">
		<link rel="stylesheet" href="/css/login/login.css" type="text/css">
		<link rel="stylesheet" href="/css/login/bootstrap.min.css" type="text/css">
 	 </head>
 	 <body>
		<div class="page-container">
			<div class="main_box">
				<div class="login_box">
					<div class="login_logo">
						<p class="masked" style="font-size: 51px;font-family:Microsoft Yahei, Arial, sans-serif">欢迎登陆</p>
					</div>
					<div class="login_form">
						<form name="login_form" id="login_form"  method="post">
							<div class="form-group">
								<label for="j_username" class="t">用户名：</label>
								<input id="j_username" name="username" type="text" class="form-control x319 in" placeholder="请输入用户名"  autocomplete="off">
							</div>
							<div class="form-group">
								<label for="j_password" class="t">密　码：</label>
								<input id="j_password" name="password" type="password" class="password form-control x319 in" placeholder="请输入密码">
							</div>
							<div class="form-group">
								<label for="j_captcha" class="t">验证码：</label>
								<input id="j_captcha" name="captcha" type="text" class="form-control x164 in">
								<img  id="captcha_img" title="点击更换" onclick="refresh(this);" src="/login!yzm.action">
							</div>
							<div class="form-group">
								<label class="t"></label>
								<label for="j_remember" class="m">
									<input id="j_remember" type="checkbox" value="true">&nbsp;记住密码!</label>
							</div>
							<div class="form-group space">
								<label class="t"></label>　　　
								<button type="button" id="submit_btn" class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp;</button>
								<input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
							</div>
						</form>
					</div>
				</div>
				<div class="bottom">Copyright &copy; 2015 - 2016 <a href="javascript:void(0)">系统登陆</a></div>
			</div>
		</div>
  	 </body>
  	 <%-- HTML5 shim, for IE6-8 support of HTML5 elements --%>
	 <!--[if lt IE 9]>
	 <script type="text/javascript" src="js/login/html5.js"></script>
	 <![endif]-->
	 <%--<script type="text/javascript" src="js/login/tooltips.js"></script>--%>
	 <script type="text/javascript" src="js/login/login.js"></script>
  	 <script type="text/javascript" src="js/login/supersized.3.2.7.min.js"></script>
	 <script type="text/javascript" src="js/login/supersized-init.js"></script>
	 <script type="text/javascript" src="js/login/scripts.js"></script>
	 <script type="text/javascript">
		 	$(function (){
				//将cookie中的密码填入（未加密）
				initUserInfoByCookie();
				$("#submit_btn").click(function (){
					/**
					 *    原生js提交: document.login_form.action = "/login!login.action";
					 *	      错误 : $("#login_form").action = "/login!login.action";
					 *
					 *	      旧的form提交:
					 *	      show_loading();
					 *	      $("#login_form").attr('action','/login!login.action');
					 *	      $("#login_form").submit();
					 *	      show_msg('登录成功咯！  正在为您跳转...','/');
					 *	      ajax form提交:
					 *	      $("#login_form").attr('action','/login!login.action');
					 *		  $("#login_form").asyncSubmit(loginProcess);
					 */
					//验证表单
					if(validateForm()){
						$("#login_form").attr('action','/login!login.action')
										.asyncSubmit({},loginProcess);
					}
				});

			});

			/**
			 * 初始化cookie信息
			 * */
			function initUserInfoByCookie(){
				var userPwd = getCookie("uPwd");
				var userName = getCookie("uName");
				if(userName && userPwd){
					$('#j_username').val(userName);
					$('#j_password').val(userPwd);
					$("#j_remember").attr("checked", true);
				}
			}
			//登陆处理
			function loginProcess(data){
				if(data.isOk){
					savePwdToCookie();
					delCookie('captcha');//删除验证码信息
					window.location.href = '/login!toMain.action';
				}else{
					w2.error(data.msg);
				}
			}

			//刷新div
			//function refreshDiv(){
				//$('#refreshDiv').val('${sessionScope.yzmResult}');
			//	setTimeout("refreshDiv();",500)
			//}

			/**
			 * 验证表单
			 */
			function validateForm(){
				//密码
				if(!$('#j_password').val()){
//					show_err_msg('密码还没填呢！');
					w2.error('密码还没填呢！');
					$('#password').focus();
					return false;
				}
				var captcha = $('#j_captcha').val();
				if(!captcha){
//					show_err_msg('验证码不能为空！');
					w2.error('验证码不能为空！');
					$('#password').focus();
					return false;
				}else{
					var loginCookieVal = getCookie('captcha');
					if(captcha != loginCookieVal){
//						show_err_msg('验证码不正确！');
						w2.error('验证码不正确！');
						return false;
					}
				}
				return true;
			}

		 	/**
		 	 *  图片切换
			 *  @param obj
			 */
		 	function refresh(obj){
		 		obj.src = "/login!yzm.action?n=" + Math.random();//防止缓存
		 	}

			/**
			 * 记住密码
			 */
		 	function savePwdToCookie(){
				var pwdVal = $('#j_password').val();
				var nameVal = $('#j_username').val();
				if($('#j_remember').is(':checked')){
					setCookie('uPwd',pwdVal,7);//保存7天
					setCookie('uName',nameVal,7);
				}else{
					delCookie('uPwd');
					delCookie('uName');
				}
			}
	 </script>
 </html>
