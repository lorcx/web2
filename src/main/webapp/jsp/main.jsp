<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<%@include file="/jsp/common/plugIn.jsp"%>
<!doctype html>
<html>
  <head>
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> <!-- 关键词 -->
	<meta http-equiv="description" content="This is my page"> <!-- 简介 -->

	<style type="text/css" >
		/*底部导航栏begin*/
		html,body {
			width:100%;
			height:100%;
			margin:0px;
			padding:0px;
			overflow:hidden;
		}
		#Main {
			position:relative;
			bottom:0px;
			left:0px;
			width:100%;
			height:100%;
			overflow:auto;
			z-index:1;
		}
		#ToolBar {
			position:absolute;
			bottom:0px;
			right:16px;
			width:100%;
			height:100px;
			text-align:center;
			BACKGROUND-IMAGE: url(http://hi.csdn.net/attachment/201101/18/7494075_1295323598v2Ii.png);
			z-index:2;
			overflow:hidden;
		}
		/*底部导航栏end*/
		/*表格begin*/
		.dt{
			border-collapse: collapse;
			border: 1px solid #4698ff;
			width: 600px;
			margin: 0 auto;
		}
		.dt tbody td{
			border-bottom:1px solid #d45eff;
			border-top:1px solid #d45eff;
			border-left:1px solid #d45eff;
		}
		.dt_td_l{
			text-align: right;
			font-size: 15px;
		}
		.dt_td_r{
			border-right: 0;
			font-size: 12px;
		}
		/*输入框*/
		.dt_text{
			border-top : 0;
			border-left: 0;
			border-right : 0;
			border-bottom: 1px solid #57232e;
			width: 70%;
		}
		/*表格end*/
	</style>
  </head>
  
  <body>
	  <div id="Main">
		  <s:form id="dataForm" name="dataForm"  method="post" cssClass="dataForm" theme="simple">
			  <table id="data" class="dt"  >
				  <colgroup>
					  <col style="width: 15%;"/>
					  <col style="width: 35%;"/>
					  <col style="width: 15%;"/>
					  <col style="width: 35%;"/>
				  </colgroup>
				  <tbody>
					  <tr>
						  <td class="dt_td_l">登录名：</td>
						  <td class="dt_td_r" >
							  <s:textfield id="userName" name="#attr.baseUser.userName"  cssClass="dt_text"  />
						  </td>
						  <td class="dt_td_l">昵称：</td>
						  <td class="dt_td_r">
							  <s:textfield id="nickname" name="#attr.baseUser.nickname"  cssClass="dt_text"  />
						  </td>
					  </tr>
					  <tr>
						  <td class="dt_td_l">登陆密码：</td>
						  <td class="dt_td_r">
							  <s:textfield id="passWord" name="#attr.baseUser.passWord"  cssClass="dt_text"  />
						  </td>
						  <td class="dt_td_l">创建时间：</td>
						  <td class="dt_td_r">
							  <s:date name="#attr.baseUser.creDate" format="yyyy-MM-dd"></s:date>
						  </td>
					  </tr>
					  <tr>
						  <td class="dt_td_l">头像：</td>
						  <td class="dt_td_r" style="" colspan="3" >
								<img width="500px" onclick="downLoadPic();" height="250px" src="/jsp/module/base/userPic.jsp?userName=<s:property value="#attr.baseUser.userName"/>"/>
						  </td>
					  </tr>
				  </tbody>
			  </table>
			  <div>
					session: <s:property value="#attr.userName"/><br/>
				  			<s:property value="#attr.nickName"/>
			  </div>
		  </s:form>
	  </div>
	  <div id="ToolBar">
	  	<a href="#" onclick="uploadFile()">上传文件</a>
	  </div>
  </body>
  <script type="text/javascript">
	  //上传文件
	  function uploadFile(){
		  var url = "/jsp/uploadDemo.jsp";
		  var iHeight = "500";//弹出的高度
		  var iWidth = "400";//弹出的宽度
		  var iTop = (window.screen.height-30-iHeight)/2; //获得窗口的垂直位置;
		  var iLeft = (window.screen.width-10-iWidth)/2; //获得窗口的水平位置;
		  var style = 'status=no,maximize=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,top='+iTop+',left='+iLeft+', resizable=yes,height='+iHeight+',width='+iWidth;
		  window.open(url,"uploadFile",style);
	  }

	  //下载文件
	  function downLoadPic(){
		  var userName = '${requestScope.baseUser.userName}';
		  var url = "/jsp/module/base/downLoadPic.jsp?userName="+userName;
		  var iHeight = "500";//弹出的高度
		  var iWidth = "400";//弹出的宽度
		  var iTop = (window.screen.height-30-iHeight)/2; //获得窗口的垂直位置;
		  var iLeft = (window.screen.width-10-iWidth)/2; //获得窗口的水平位置;
		  var style = 'status=no,maximize=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,top='+iTop+',left='+iLeft+', resizable=yes,height='+iHeight+',width='+iWidth;
		  window.open(url,"",style);
	  }
  </script>
</html>


