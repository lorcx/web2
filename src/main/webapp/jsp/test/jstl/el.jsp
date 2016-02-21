<%@page import="module.test.entity.Test"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML >
<html>
  <head>
    
    <title>My JSP 'el.jsp' starting page</title>

  </head>
  
  <body>
  
    	${1+1}<br/>
    	${1-1}<br/>
    	${1/1}<br/>
    	${1*1}<br/>
    	\${1*1}<br/>
    	${0/0}<br/>
    	${1==1}<br/>
    	${1!=1}<br/>
    	${1>=1}<br/>
    	${1<=1}<br/>
    	\${1 &lt; 1}<br/>
    	${'b'<='a'}<br/>
    	${1 <null}<br/>
    	${1 >null}<br/>
    	${null >= null}<br/>
    	${'b'!='a'}<br/>
    	${1 =='1'}<br/>
   		${a =='a'}<br/>
   		${true && true}<br/>
   		${true || false}<br/>
   		
   		${empty param.username}<br/> <!-- 接收url中？传的值 -->
   		${empty param.username}<br/>
   		<hr/>
   		${ 1 eq 1}<br/>
   		${ 1 ne 1}<br/>
		${ true and true}<br/>
   		${ true or true}<br/>
   		${1 eq 1 ? 'a' : 'b' }
   		<!-- 设置变量到page作用范围 -->
   		<c:set var="name" value="abcd"></c:set><br/>
   		<%
   			request.setAttribute("a", 123);
   		 %>
   		 ${a }<br/>
   		 ${name}<br/>
   		 ${param.passwd}<br/>
   		 
   		<%
   			String a = request.getParameter("passwd");
   		 	out.print(a);
   		 %> 
   		 <c:set var="name1" value="abcd" scope="page"></c:set><br/>
   		 <c:set var="name2"  scope="page">
   			 abcd
   		 </c:set><br/>
   		  ${name}<br/>
   		  
   		  <c:set var="name3"  scope="page">
   			 ${1 +1  }
   		 </c:set><br/> 
   		   ${name3}<br/>
   		   
   		 <c:out value="qweqwe"></c:out>  <br/>
   		 <c:out value="<b>qweqwe</b>" escapeXml="false"></c:out>  <br/>
   		 
   		 
   		 <c:remove var="name3"/><br/>
   		 ${name3 }1<br/>
   		 
   		 <%
   		 	Test t = new Test();
   		 	t.setTid("1");
   		 	t.setTname("b");
			request.setAttribute("t", t);
   		  %>
   		  ${t["tname"]}<br/>
   		  
   		  
   		  <%
   		  	application.setAttribute("abc", "abc");
   		   %>
   		  <hr/>
   		  <form action="e.jsp" method="post">
	   		  <input type="checkbox" value="a" name="aa"/>
	   		  <input type="checkbox" value="b" name="aa"/>
	   		  <input type="checkbox" value="c" name="aa"/>
	   		    <%
	   		  	Cookie cook = new Cookie("cook","cooke");
	   		  	response.addCookie(cook);
	   		   %>
	   		  <input type="submit" value="tj"/>
   		  </form>
   		  
   		
   		${header["host"]}<br/>
   		${header["user-agent"]}<br/>
   		${initParam.loginName}<br/>
   		  
   		  
   		  ${pageContext.request.queryString}<br/>
   		  ${pageContext.request.requestURL}<br/>
   		  ${pageContext.request.contextPath}<br/>
   		  ${pageContext.request.method}<br/>
   		   ${pageContext.request.protocol}<br/>
   		   ${pageContext.request.remoteAddr}<br/>
   		    ${pageContext.session.id}<br/>
   		    
   	  <c:forEach var="item" begin="1" end="5">
   	  		${item}<br/>
   	  </c:forEach>  
   	  
   	 	<c:forEach var="item" begin="1" end="100">
   	 		<c:set var="sum" value="${sum+item}"></c:set>
   	 	</c:forEach>
   	 	<c:out value="${sum}"></c:out><br/>
		
		
		<c:set var="str" value="a-b-c-d"></c:set>
		<c:forTokens var="s" items="${str}" delims="-">
			${s}<br/>
		</c:forTokens>
		
		<c:set var="sum" value="0"></c:set>
		<c:forEach var="num" begin="1" end="100" step="2">
			<c:set var="sum" value="${sum+num }"></c:set>
		</c:forEach>
		<c:out value="${sum }"></c:out><br/>
		
		<table border="1px solid">
			<c:forEach var="item" begin="1" end="10">
				<tr>
					<c:forEach var="tem" begin="1" end="10" varStatus="s">
						<td>${s.index}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		
		
		<c:forEach var="hang" begin="1" end="9">
			<c:forEach var="lie" begin="1" end="${hang}">
				${lie}*${hang}=${lie*hang}
			</c:forEach>
			<br/>
		</c:forEach>
  </body>
</html>
