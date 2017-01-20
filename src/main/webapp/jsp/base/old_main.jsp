<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/taglib.jsp"%>
<%@include file="/jsp/common/plugIn.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
	 <title>首页</title>
     <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=Edge">
	 <meta name="description" content="web2 首页" >
	 <meta name="keywords" content="HTML, CSS, XML, XHTML, JavaScript"  >
  </head>
  <body>
	  <div id="container">
  	 	  <%--导航条--%>
		  <div id="top_bar"></div>
	  </div>

	  <%--内容--%>
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
		 $('#top_bar').load("/jsp/sys/topBar.jsp");//加载顶部导航条
	  });

	  /**
	   *上传文件
	   */
	  function uploadFile(){
		  var url = "/jsp/uploadFile.jsp";
		  openWindow(url,'上传文件',550,400);
	  }

	  /**
	   *下载文件
	   */
	  function downLoadPic(){
		  var userName = '${sessionScope.userName}';
		  window.location.href = "/downPic/downPic!downPic.action?userName=" + userName;
	  }

	  /**
	   * 返回主页
	   */
	  function goBackIndex(){
		window.location.href = "/";
	  }
  </script>
</html>


