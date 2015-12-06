<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>js 节点创建</title>
  </head>
  <body>
  		<h2>增加图片</h2>
		<img id="img" src="../../img/eg_cute.gif"/>
  		<div id = "div"></div>
	   <input type = "button"  value="增加" onclick="create();"/><br/>
	   <input type = "button" value="删除" onclick="del();"/>
	   <input type = "button" value="替换" onclick="replace();"/>

  </body>
  <script type="text/javascript">
  	//js常见节点
  	function create(){
  		 var div = document.getElementById("div");
  		 var img = document.createElement("img");
  		 img.setAttribute("src", "<%=request.getContextPath()%>/img/eg_cute.gif");
  		 //将img插入到div节点后面
  		 document.body.insertBefore(img, div);
  	 }
  	//删除
  	function del(){
  		var div = document.getElementById("div");
  		document.body.removeChild(div);
  	}
  	//替换
  	function replace(){
  		var img1 = document.getElementById("img");
  		var img2 = document.createElement("img");
  		img2.setAttribute("src", "<%=request.getContextPath()%>/img/bd_logo1.png");
  		document.body.replaceChild(img2, img1);
  	}
  </script>
</html>
