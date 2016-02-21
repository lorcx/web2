<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>级联</title>
  </head>
  <body>
	  <label>省份:</label>
	  <select id="s1" onchange="cityChange();">
	  	<option>---请选择---</option>
	  </select>
	  <label>城市：</label>
	  <select id="s2">
	  	<option ></option>
	  </select>
  </body>
  <script type="text/javascript" src="../../js/demo/jilian.js"></script>
</html>
