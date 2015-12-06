<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'jindutiao.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		.center{width:300px;height:30px;border: 1px solid red;margin:0 auto; background:yellow;position:relative;display:none}
		.center #nei{width:0;height:29px;background:blue ;text-align:center;position:absolute;z-index:-1}
		.center #sha{position:absolute;z-index:1; filter: Alpha(Opacity=30);}
	</style>
  <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
   <script type="text/javascript">
  	var process = 1;
	var u = 100;
	var msg = "1";
  	$(function (){
  		//demo();
  		//var c = "center";
  		showDiv();
  	});
  	function demo(){
  		$('#nei').show();
  		syn();
  	}
  	function syn(){
  		$('#nei').css("width",process+"%");
  		$('b ').text("正在进行同步"+process+"%");
  		if(process < 100){
  			process++;
  			setTimeout(syn,u);
  		}else{
  			//alert('同步完成');
  		//	$('.center').hide();
  		}
  		
  	}
  	function showDiv(divName){
  		var top = ($(window).height()-$("#center").height())/2;
  		var left = ($(window).width()-$("#center").width())/2;	
  		var scrollTop = $(document).scrollTop();
  		var scrollLeft = $(document).scrollLeft();
  		$("#center").css({position:'absolute',top:top+scrollTop,left:left+scrollLeft}).show();
  	}
  </script>
</head>
  <body>
   		<div class="center" id="center" >
   			<div id="sha">
   				<font color='red'><b></b></font>
   			</div>
   			<div id="nei" style="display:none"></div>
   		</div>
  </body>
 
</html>
