<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象跳转页面</title>
</head>
<body>
<%

  Object p1 = pageContext.getAttribute("p");
  Object r1 = request.getAttribute("r");
  Object s1 = session.getAttribute("s");
  Object a1 = application.getAttribute("a");
%>
<%=p1%>
<%=r1%>
<%=s1%>
<%=a1%>

<p>
page作用域的获取不到不再一个页面上，page相当于这个页面生成的类的this
</p>
<p>
  reqeust在转发后就获取不到了
</p>
<p>
  session会话仅限同一个浏览器 一个浏览器一个会话
</p>
<p>
  application 作用范围是整个应用 从服务器启动到终止
</p>
内置对象跳转页面
</body>
</html>
