<!doctype html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<meta name="Keywords" content="关键字"/>
<meta name="description"  content="简介"/>
<style type="text/css">										
	 *{margin:0; padding:0;}						
	body{background: url(../img/5-120601092224.gif);font-size:12px;font-family:"微软雅黑";color:#666;}				
												/*margin 第一个垂直 第二个水平*/
	/*auto start*/											
	.auto{width:700px;margin:150px auto;}
	.auto h1{text-align:center;}
	.auto .a_text{width:540px;height:40px;font-size:14px;font-family:"微软雅黑"; line-height:40px;padding-left:10px;}
	.auto .a_button{width:100px;height:43px;font-size:16px;font-family:"微软雅黑";}
	.auto .show{width:552px;background:#fff;margin-left:1px; display: none}
	.auto .show div{line-height:30px;font-size:14px;border:1px solid;padding-left:10px;}
	.auto .show div:hover{background:#E7E7E7;}
	/*auto end*/		
</style>
</head>

<body>
	<!--auto start-->
	<div class="auto">
    	<h1>
        	<img src="../img/bd_logo1.png" alt="百度"  width="270" height="129"/>
        </h1>
       <input type="text" name="search" class="a_text"/>
       <input type="button" name="btn" class="a_button" value="搜索一下"/>
        <div class="show"></div>
    </div>
	<!--auto end-->
</body>
	<script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
	<script type="text/javascript" >
		$(function (){
		 	$(".a_text").keyup(function (){
		 		var value = $(this).val();//获取当前文本框中的值
		 		var _this = $(this);
		 		//empty清空内容
		 		$(".show").empty().show();
		 		$.ajax({
		 			type:"post",
		 			url:"<%=request.getContextPath()%>/jsp/jsonData.jsp",
		 			//dataType:"json",
		 			success:function(data){
		 				//eval javascript编译器解析
		 				var array = eval(data);//将data数据转换成数组
		 				for(var i = 0;i < array.length;i++){
		 					$(".show").append("<div>"+array[i]+"</div>");
		 				}
		 				//prepend追加
		 				$(".show").prepend($(".show").find("div:contains("+value+")")
		 				.each(function (){
		 					$(this).html($(this).text());
		 				}).css("color","blue"));
		 				//鼠标点击赋给文本框值
		 				$(".show").find("div").click(function (){
		 					var divValue = $(this).text();//获取当前div中的值
		 					_this.val(divValue);//向文本框中赋值
		 					$(".show").fadeOut("slow",function (){
		 						window.location.href = "http://www.baidu.com/s?wd="+divValue;
		 					});//淡出
		 				});
		 				
		 			},
		 			error:function (){
		 				alert("请求失败");
		 			}
		 		});	
		 	});
		});
	
	</script>
</html>
