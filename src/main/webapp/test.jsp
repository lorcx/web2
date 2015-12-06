<%@page import="org.apache.log4j.Logger"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>

  </head>
  
  <body>
  	${user }
  	<%
  		String user = (String)request.getAttribute("user");
  		System.out.println(user);
  	%>
  	<s:property value="#attr.user"/>
  </body>
</html>
