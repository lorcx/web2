<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作用范围分析</title>
</head>
<body>
<%
  HttpJspPage servlet = (HttpJspPage)page;
  out.println(servlet.getServletInfo());

  out.print("<br/>");
  out.print(this.getServletConfig());
  out.print("获取web.xml中的数据");

  out.print(servlet.getServletConfig().getInitParameter("name"));
  out.print(servlet.getServletConfig().getInitParameter("passWd"));
  out.print(servlet.getServletConfig().getInitParameter("user"));
  out.print(servlet.getServletConfig().getInitParameter("key"));
  //out.println(p.getServletConfig().getInitParameterNames().nextElement());
%>
  <br/>
</body>
</html>
