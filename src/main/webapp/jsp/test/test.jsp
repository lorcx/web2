<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
	  	<script type="text/javascript" src="../../js/jquery/jquery-1.8.2.js"></script>
  </head>
	<% 
		String radio = request.getParameter("radio");
		if(radio==null || radio.equals("")){
			radio="2";
		}
		request.setAttribute("radio", radio);
	    System.out.println(radio);
	%>
  <body>
   		<form id="form1" name="form1" action="/dt/demoAction!test.action" method="post" >


			<input type="submit" value="提交"/>

   		   <%--<div onload="huixian">
   		   	   	<input type="radio" value="1" name="radio" />abcd<br/>
				<input type="radio" value="2" name="radio"/>123<br/>
   		   </div>	
		
			<input type="button" value="tijiao" onclick="toSubmit();"/>
			<input type="button" value="abc" onclick="abcd()"/>--%>
			
		</form>
  </body>
  <script type="text/javascript">
/*
  	  function toSubmit(){
  		  document.forms["form1"].action="<%=request.getContextPath()%>/jsp/test/test.jsp";
  		  document.forms["form1"].submit();
  	  }
*/


  	  
  	$(function (){

//		var reg = /^[-\+]?\d+$/.test('a') || /^[-\+]?\d+(\.\d+)?$/.test('s'); 整数或小数正则

  	});


//	  function accAdd(arg1,arg2){
//		  var r1,r2,m;
//		  try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
//		  try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
//		  m=Math.pow(10,Math.max(r1,r2))
//		  return (arg1*m+arg2*m)/m
//	  }

	//以数组作为参数
//	var arr = new Array('a','b');
//	sendMsgRemind(arr);
//	function sendMsgRemind(data){
//		console.log(data);
//	}


//	  var stu = new Object();
//	  stu.name = 'a';
//	  stu.id = 1;
//	  var json = JSON.stringify(stu);
//	  alert(json.name);
//	  var jsonStr = JSON.parse(json);
//	  console.log(jsonStr.name);

//	var str1 = '{ "title": "11", "memo": "22" }';
//	var str3 = { "title": "11", "memo": "22" };
//	var json = JSON.parse(str1);
//	//alert(json.name);
//	console.log(json);
//	console.log(str3);

	var data = {"title":"","memo":"",
				"users":[{"acceptUser":"1","acceptDept":"","showDate":""}],
				"depts":[{"acceptUser":"1","acceptDept":"","showDate":""}]
	           };

	var data1 = {"title":"","memo":"",
					"depts":[{"acceptUser":"1","acceptDept":"","showDate":""}]
				};
	var data2 = {"title":"","memo":"",
				"users":[{"acceptUser":"1","acceptDept":"","showDate":""}],
			};


	sendMsgRemind(data2);

	function sendMsgRemind(data2){
		var arr = '[';
		if(!data2.users){
			var u = data2.users;
			for(var i = 0;i < u.length;i++){
				arr+='{"msgRemind/acceptUser":'+u[i].acceptUser+',"msgRemind/acceptDept":'+u[i].acceptDept+',"showDate":'+u[i].showDate+'}'
			}
		}

		arr += ']';
	}

  </script>
</html>
