<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>框架页测试</title>
</head>
<frameset rows="15%,*">
   <frame src="testTop.jsp" />
    <frameset cols="20%,*">
        <frame src="testLeft.jsp" />
        <frame src="testContent.jsp" name="show1" />
    </frameset>
</frameset>
</html>
