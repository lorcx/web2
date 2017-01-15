<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
      <title>测试页面</title>
  </head>
  <body>
    <button onclick="test();">提交</button>
  </body>
  <script src="/plug_in/jquery/jquery.min.js"></script>
  <script type="text/javascript">
      function test() {
          $.ajax({
              type : 'GET',
              url : '/test/list',
              data : '{}',
              dataType : 'json',
              success : function (data) {
                alert(data);
              },
              error : function () {

              }
          });
      }
  </script>
</html>
