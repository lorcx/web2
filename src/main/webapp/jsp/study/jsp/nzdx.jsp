<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象</title>
</head>
<body>
<%
  pageContext.setAttribute("p","p");
  request.setAttribute("r","r");
  session.setAttribute("s","s");
  application.setAttribute("a","a");

  //在本页获取
  Object p1 = pageContext.getAttribute("p");
  Object r1 = request.getAttribute("r");
  Object s1 = session.getAttribute("s");
  Object a1 = application.getAttribute("a");

  //request.getRequestDispatcher("nzdx_t1.jsp").forward(request,response);
  response.sendRedirect("nzdx_t1.jsp");
%>

<%=p1%>
<%=r1%>
<%=s1%>
<%=a1%>
</body>
</html>
