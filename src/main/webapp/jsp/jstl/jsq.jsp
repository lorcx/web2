<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>简单的计算器</title>

  </head>
  
  <body>
  	<h3>el简单的计算器</h3>
  	<form action="jsq.jsp" method="post">
    	<input type="text" name="number1" />
    	<select name="fuhao">
    		<option value="0">+</option>
   			<option value="1">-</option>
    		<option value="2">*</option>
    		<option value="3">/</option>
    	</select>

		<input type="text" name="number2" />
    	<input type="submit" value="计算"/>
    </form>	
    <c:if test="${param.fuhao eq '0'}">
    	${param.number1}+${param.number2}=${param.number1+param.number2}
    </c:if>
    <c:if test="${param.fuhao eq '1'}">
    	${param.number1}-${param.number2}=${param.number1-param.number2}
    </c:if>
    <c:if test="${param.fuhao eq '2'}">
    	${param.number1}*${param.number2}=${param.number1*param.number2}
    </c:if>
    <c:if test="${param.fuhao eq '3'}">
    	${param.number1}/${param.number2}=${param.number1/param.number2}
    </c:if>
    
  </body>
</html>
