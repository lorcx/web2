<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/common/plugIn.jsp"%>
<html>
<head>
    <title>input value 中json解析</title>
</head>
<body>
  <input type="text" id="inputTest" value="{aa:'1',bb:'2'}"/>
  <input type="text" id="inputTest1" value="['a','b','c']"/>
</body>
<script>
  //json解析
  var json = $('#inputTest').val();
  var obj = eval('('+json+')');
  console.log(obj.aa);
  console.log(obj.bb);

  //array解析
  var arr = $('#inputTest1').val();
  var obj1 = eval('('+arr+')');
  console.log(obj1.length);

  ///////////test
  var arr1 = new Array('a','c','b');
  console.log(arr1.length);


  var arr2 = ['a','b','c','4'];
  console.log(arr2.length);

//  for(var i = 0;i < obj.length;i++){
//    console.log(obj[i]);
//  }
</script>
</html>
