<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>

  </head>
  
  <body>
  	<%
		System.out.print(1/0);
//  		String user = (String)request.getAttribute("user");
//  		System.out.println(user);
  	%>
  	<s:property value="#attr.user"/>
  </body>
  <script type="text/javascript">
		var t = new Date();
	    console.log(t);
  </script>
</html>
