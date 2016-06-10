<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<html>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<head>
  <meta http-equiv="refresh" content="60;url=/login.jsp"><%--60秒后自动跳转--%>
  <style type="text/css" ></style>
  <link href="/plug_in/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
  <div id="container" style="text-align: center;"><img class="png" src="/img/error/500.jpg" />
    <button type="button" class="btn btn-lg btn-primary" style="position: absolute;left: 879px;top: 495px;width:150px; " onclick="toMain();">返回首页</button>
  </div>
</body>
<script type="text/javascript">
  function toMain(){
    window.location.href = '/';
  }
</script>

</html>
