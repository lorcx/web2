<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<%@include file="/jsp/common/plugIn.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> <!-- 关键词 -->
	<meta http-equiv="description" content="web2 首页"> <!-- 简介 -->
  </head>
  
  <body>
	  <div id="container">
  	 	  <!--导航条-->
		  <div id="top_bar"></div>
	  </div>

	  <!--内容-->
	  <div class="page-header">
	  		<table class="table table-bordered table-hover">
			   <thead>
				   <tr>
					   <th>#</th>
					   <th>First Name</th>
					   <th>Last Name</th>
					   <th>Username</th>
				   </tr>
			   </thead>
			   <tbody>
				   <tr>
					   <td rowspan="2">${sessionScope.userName}</td>
					   <td>Mark</td>
					   <td>Otto</td>
					   <td>@mdo</td>
				   </tr>
				   <tr>
					   <td>Mark</td>
					   <td>Otto</td>
					   <td>@TwBootstrap</td>
				   </tr>
				   <tr>
					   <td>2</td>
					   <td>Jacob</td>
					   <td>Thornton</td>
					   <td>@fat</td>
				   </tr>
				   <tr>
					   <td>3</td>
					   <td colspan="2">Larry the Bird</td>
					   <td>@twitter</td>
				   </tr>
			   </tbody>
		    </table>
	   </div>

	  <%--<hr class="container">--%>

	  <footer class="container">
		  <p>Brought to you by Weborithm.Collect from <a href="http://www.cssmoban.com/" title="网站模板" target="_blank">网站模板</a></p>
	  </footer>

  </body>
  <script type="text/javascript">

	  $(function (){
		 $('#top_bar').load("/jsp/base/topBar.jsp");//加载顶部导航条
	  });

	  /**
	   *上传文件
	   */
	  function uploadFile(){
		  var url = "/jsp/uploadFile.jsp";
		  var iHeight = "550";//弹出的高度
		  var iWidth = "400";//弹出的宽度
		  var iTop = (window.screen.height-30-iHeight)/2; //获得窗口的垂直位置;
		  var iLeft = (window.screen.width-10-iWidth)/2; //获得窗口的水平位置;
		  var style = 'status=no,maximize=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,top='+iTop+',left='+iLeft+', resizable=yes,height='+iHeight+',width='+iWidth;
		  window.open(url,"uploadFile",style);
	  }

	  /**
	   *下载文件
	   */
	  function downLoadPic(){
		  var userName = '${sessionScope.userName}';
		  var url = "/downPic/downPic!downPic.action?userName="+userName;
		  window.location.href = url;
	  }

	  /**
	   * 返回主页
	   */
	  function goBackIndex(){
		window.location.href = "/";
	  }
  </script>
</html>


