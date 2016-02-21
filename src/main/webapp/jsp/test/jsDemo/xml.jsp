<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>js 操作xml</title>
  </head>
  <body>
    	
  </body>
  <script type="text/javascript">
  	//var isIE = !!document.all;//判断ie6
    function isIE() { //ie?  
        if (!!window.ActiveXObject || "ActiveXObject" in window){ 
            return true;  
        }else{  
            return false;  
        }    
    }  
  	
  	window.onload = init();
  	//初始化
  	function init(){
  		var xmlDOC = document.implementation.createDocument("","",null);
  		//异步加载
  		xmlDOC.async = true;
  		xmlDOC.load("/web/jsp/A.xml");
  		//return xmlDOC;
  		getNodesValue(xmlDOC);
  	}
  	//获取节点的值
  	function getNodesValue(xmlDOC){
  		var nodeList=xmlDOC.getElementsByTagName("Type");  // 非IE  
  		 
  		for(var i=0;i<nodeList.length;i++){  
  			alert(nodeList[i].childNodes[0].nodeValue);
  		}
  	}
  		
  </script>
</html>
