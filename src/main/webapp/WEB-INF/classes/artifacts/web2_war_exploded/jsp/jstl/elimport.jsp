<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'elimport.jsp' starting page</title>

  </head>
  
  <body>
	 <c:import url="1.txt" charEncoding="utf-8"></c:import>
	 <hr/>
	 <c:import url="/index.jsp" context="/springTest"></c:import>
	 
	 <c:import url="/index.jsp" context="/springTest" var="s" scope="session"></c:import>
	 
	 <a href="${pageContext.request.contextPath}/jsp/jstl/e.jsp" >abcd</a>
	 <%=request.getContextPath() %>
  </body>
</html>
