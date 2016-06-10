<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
    <%response.setStatus(HttpServletResponse.SC_OK);%>
    <head>
        <meta http-equiv="refresh" content="60;url=/login.jsp"><%--60秒后自动跳转--%>
        <link href="../../css/error/error.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="container"><img class="png" src="/img/error/404/404.png" /> <img class="png msg" src="/img/error/404/404_msg.png" />
            <p>
                <a href="/login.jsp">返回首页</a>
            </p>
        </div>
        <div id="cloud" class="png"></div>
    </body>
</html>
