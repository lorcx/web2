<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>JS实现table</title>
    <style type="text/css">
    	*{margin: 0;padding: 0;}
    	.main{margin: 0 auto;width:400px;border: 1px solid;overflow: hidden;}
    	.main #title ul{list-style: none;}
    	.main #title ul li{float: left;display: block;margin-left:20px;}
    	.main .content1{clear: both;}
    	.main .d1{background-color: yellow;width: 150px;height: 150px;float: left;}
    	.main .d2{background-color: red;width: 150px;height: 150px;float: left;}
    	.main .clear{clear: both;}
    	.main .d3{background-color: blue;width: 150px;height: 150px;float: left;}
    	.main .d4{background-color: green;width: 150px;height: 150px;float: left;}
    	.main .content2 , .content3{display: none;}
    	.btn{width: 50px;text-align: center;-moz-border-radius: 5px;border-radius: 5px;background: yellow; }
    	.btn:HOVER {background: red;}
    	.btn:ACTIVE {background: blue;}
    	.green{width: 50px;text-align: center;-moz-border-radius: 5px;border-radius: 5px;background: green;}
    	.blue{width: 50px;text-align: center;-moz-border-radius: 5px;border-radius: 5px;background: blue;}
    </style>
  </head>
  
  <body>
	   <div class="main">
		   	<div id="title">
		  		<ul>
			   		<li><input type="button" class="btn" value="ads" onclick="ch(0);"/></li>
			   		<li><input type="button" class="btn" value="basd" onclick="ch(1);"/></li>
			   		<li><input type="button" class="btn" value="cqwe" onclick="ch(2);"/></li>
		   		</ul>
		   	</div>
		   	<div class="clear"></div>
		   	<div id="c0" class="content1"> 
		   		<div class="d1">a</div>
		   		<div class="d2">b</div>
		   		<div class="clear"></div>
		   		<div class="d3">d</div>
		   		<div class="d4">e</div>
		   	</div>
	   	   	<div id="c1" class="content2"> 
		   		<div class="d1">f</div>
		   		<div class="d2">g</div>
		   		<div class="clear"></div>
		   		<div class="d3">i</div>
		   		<div class="d4">j</div>
		   	</div>
	   	   	<div id="c2" class="content3"> 
		   		<div class="d1">k</div>
		   		<div class="d2">m</div>
		   		<div class="clear"></div>
		   		<div class="d3">n</div>
		   		<div class="d4">o</div>
		   	</div>
	   	</div>
  </body>
  <script type="text/javascript">
  		function ch(index){
  			var li = document.getElementById("title").getElementsByTagName("li");
  			for(var i=0;i<li.length;i++){
  				if(i == index){
  					li[i].className="green";
  					document.getElementById("c"+i).style.display="block";
  				}else{
  					li[i].className="blue";
  					document.getElementById("c"+i).style.display="none";
  				}
  			}
  		}
  </script>
</html>
