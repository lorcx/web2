<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC ">
<html>
  <head>
    <title>轮换图片</title>
  </head>
  <body onload="change();">
  		<div id="d1">
  			<img id="i1" src=""/>
  		</div>
  </body>
  <script type="text/javascript">
	 var img = new Array(4);
	 img[1] = "<%=request.getContextPath()%>/img/l1.jpg";
	 img[2] = "<%=request.getContextPath()%>/img/l2.jpg";
	 img[3] = "<%=request.getContextPath()%>/img/l3.jpg";
	 var count = 1;
	 function change(){
		 if(count == img.length){
			 count = 1;
		 }else{
		 	document.getElementById("i1").src = img[count];
			count++;
		 }
		 setTimeout("change()",1000);
	 }	
  </script>
</html>
