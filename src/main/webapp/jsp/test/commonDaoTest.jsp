<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/common.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<html>
<head>
    <title>公共dao_test</title>
</head>
<body>
  <h1>dao test</h1>
  <button onclick="test();">test</button>
</body>
<script>

  function test(){
    $.ajax({
      url : '/dt/test1Action!commonTest.action',
      type : 'post',
      success : function (data){
        alert(1);
      },
      error : function (){
        alert('error ajax');
      }
    });
  }
</script>
</html>
