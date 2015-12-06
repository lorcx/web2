<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'e.jsp' starting page</title>
    

  </head>
  
  <body>
   		${applicationScope.abc}
   		${paramValues.aa[0]}
   		${paramValues.aa[1]}
   		
   		${cookie.cook.value}
   		
   		${sessionScope.s}
  </body>
</html>
