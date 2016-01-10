<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	</style>
  </head>
  
  <body>
	  <div id="Main">
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
		  <p>www.baidu.com</p><p>www.baidu.com</p><p>www.baidu.com</p>
	  </div>
	  <div id="ToolBar">
	  	<a href="#" onclick="uploadFile()">上传文件</a>
	  </div>
  </body>
  <script type="text/javascript">
	  function uploadFile(){
		  var url = "/jsp/uploadDemo.jsp";
		  var iHeight = "500";//弹出的高度
		  var iWidth = "400";//弹出的宽度
		  var iTop = (window.screen.height-30-iHeight)/2; //获得窗口的垂直位置;
		  var iLeft = (window.screen.width-10-iWidth)/2; //获得窗口的水平位置;
		  var style = 'status=no,maximize=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,top='+iTop+',left='+iLeft+', resizable=yes,height='+iHeight+',width='+iWidth;
		  window.open(url,"uploadFile",style);
	  }
  </script>
</html>


