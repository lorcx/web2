<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="../js/jquery/jquery-1.8.2.js"></script>
</head>
<body onload="objinit();">
</body>
	<script language="javascript" type="text/javascript" src = "/jsp/module/office/office.js?t=<%=Math.random()%>"></script>
	<script language="JScript" for="TANGER_OCX" event="AfterOpenFromURL(doc)">
	     TANGER_OCX_OBJ.SetReadOnly(true,"");
	     TANGER_OCX_OBJ.FileSave = false;
	</script>
</html>