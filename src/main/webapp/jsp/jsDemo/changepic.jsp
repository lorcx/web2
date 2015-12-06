<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>js改变样式</title>
    <style type="text/css">
    	.btn{ background: url(../../img/bd_logo1.png);}
    	.btn1{ background-color: yellow;}
    </style>
  </head>
  <body>
  	<input type="button" value="提交" class="btn" id="t" onmousedown="ch();"/>
  </body>
  <script type="text/javascript" >
	  function ch(){
		document.getElementById("t").className = "btn1";
	  }
  </script>
</html>
