<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
	  	<script type="text/javascript" src="../../js/jquery-1.8.2.js"></script>
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
   		<form id="form1" name="form1" action="" method="post" >
   		   <div onload="huixian">
   		   	   	<input type="radio" value="1" name="radio" />abcd<br/>
				<input type="radio" value="2" name="radio"/>123<br/>
   		   </div>	
		
			<input type="button" value="tijiao" onclick="toSubmit();"/>
			<input type="button" value="abc" onclick="abcd()"/>
			
		</form>
  </body>
  <script type="text/javascript">
  	  function toSubmit(){
  		  document.forms["form1"].action="<%=request.getContextPath()%>/jsp/test/test.jsp";
  		  document.forms["form1"].submit();
  	  }
  	  
  	$(function (){
  		  var radio = "${radio}";
		  $('input[name="radio"]').each(function (){
			  if(this.value == radio){
				  $(this).attr("checked","checked");
			  }
		  });
  	})
  		  
  </script>
</html>
