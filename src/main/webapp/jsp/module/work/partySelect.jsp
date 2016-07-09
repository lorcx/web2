<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/common.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title></title>
</head>
<body>
  <s:radio name="s1" list="#{'A0081294':'章光敏','A0081290':'王欣','A0056617':'郭雪岩'}"/>
  <button type="button" class="btn btn-lg btn-default" onclick="confirm();">确定</button>
</body>
<script>
  function confirm(){
     var selectedVal = $('input[type="radio"]:checked').val();
     console.log(selectedVal);
  }

</script>
</html>
