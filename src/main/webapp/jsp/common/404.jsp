<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>404</title>
    <meta name="keywords" content="404错误" />
    <meta name="description" content="404错误" />
    <meta http-equiv="refresh" content="60;url=/login.jsp"><%--60秒后自动跳转--%>
    <link href="../../css/error/error.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div id="container"><img class="png" src="/img/error/404/404.png" /> <img class="png msg" src="/img/error/404/404_msg.png" />
      <p>
         <a href="#" target="_blank" onclick="javascript:history.go(-1);">
            <img class="png" src="/login.jsp" />
         </a>
      </p>
    </div>
    <div id="cloud" class="png"></div>
</body>
</html>
