<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<%@include file="/jsp/common/plugIn.jsp"%>
<!DOCTYPE html>
<html>
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
	   <div>
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
					   <td rowspan="2">1</td>
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



	  <!--
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
					  <td class="dt_td_r" style="" colspan="3" ><s:property value="#attr.baseUser.userName"/>
						  <img width="500px" onclick="downLoadPic();" height="250px" src="/jsp/module/base/userPic.jsp?userName=<s:property value="#attr.baseUser.userName"/>"/>
					  </td>
				  </tr>
				  </tbody>
			  </table>
			  <div>
				  session: <s:property value="#attr.userInfo.userName"/><br/>
				  <s:property value="#attr.userInfo.nickname"/>
			  </div>
		  </s:form>
	  </div>

	  <div id="ToolBar">
		  <button type="button" class="btn btn-lg btn-link" onclick="uploadFile();">上传文件</button>
		  <button type="button" class="btn btn-lg btn-link" onclick="goBackIndex();">返回主页</button>
	  </div>

	  -->
  </body>
  <script type="text/javascript">

	  $(function (){
		 $('#top_bar').load("/jsp/base/topBar.jsp");
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
		  var userName = '${requestScope.baseUser.userName}';
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


