<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC >
<html>
  <head>
    <title>TIME</title>
  </head>
  
  <body onload="showTime();">
   		<span id="time"></span>
  </body>
  <script type="text/javascript">
  	   function showTime(){
  		   var date = new Date();
  		   var year = date.getFullYear();//年
  		   var mouth = date.getMonth()+1;//月
  		   var day = date.getDate();//日
  		   var week = date.getDay();//星期
  		   var hours = date.getHours();//时
  		   var second = date.getSeconds();//秒
  		   var minutes = date.getMinutes();//分
  		   var weekName = "星期";
  		   switch(week){
  		   	  case 0:
  			  	  weekName+="日";
  			  	  break;
  		   	  case 1:
			  	  weekName+="一";
			  	  break;
  		      case 2:
			  	  weekName+="二";
			  	  break;
  			  case 3:
		  	  	  weekName+="三";
		  	  	  break;
  			  case 4:
			  	  weekName+="四";
			  	  break;
  			  case 5:
			  	  weekName+="五";
			  	  break;
  			  case 6:
			  	  weekName+="六";
			  	  break;
  		   }
  	   	 document.getElementById("time").innerHTML="当前时间"+year+"年"+mouth+"月"
  	   	 +day+"日"+hours+"点"+minutes+"分"+second+"秒"+"今天是"+weekName;
  		   
  		   
  		   
  	   }
  	   
  	   
  	   
  </script>
</html>
