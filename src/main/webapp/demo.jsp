<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  <%!
      synchronized void count() {
          ServletContext application = ServletActionContext.getServletContext();
          Integer num = (Integer)application.getAttribute("num");
          if (null == num) {
              num = new Integer(1);
              application.setAttribute("num", num);
          } else {
              num = new Integer(1 + num);
              application.setAttribute("num", num);
          }
      }
  %>
  <%
      //      if (session.isNew()) { //为了避免用户的刷新的问题
      count();
//      }
      Integer tNum = (Integer)application.getAttribute("num");
      out.print(tNum);
  %>
  <button id="btn4" onclick="op();">ee</button>
  </body>
<script>

    function op(){

    }

</script>
</html>
