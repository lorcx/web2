<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<html>
<head>
  <title>下载用户图片</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
</head>
<body>
  <!-- jsp下载会弹出空白页面 （已废弃）-->
  <%
    response.reset();
    String userName = request.getParameter("userName");
    response.addHeader("Content-Disposition","attachment;filename=" + userName + ".bmp");

    //查询数据
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
      Connection conn = DriverManager.getConnection(url, "llxx", "lorcx");
      StringBuilder sql = new StringBuilder();
      sql.append("select u.pic from base_user u where u.user_name = '").append(userName).append("'");
      PreparedStatement ps = conn.prepareStatement(sql.toString());
      ResultSet rs = ps.executeQuery();
      if(rs != null){
        while (rs.next()){
          Blob blob = rs.getBlob(1);//获取文件
          int size = (int)blob.length();
          byte[] b = blob.getBytes(1,size);
          ServletOutputStream os = response.getOutputStream();
          os.write(b);
          os.flush();
          out.clear();
          out = pageContext.pushBody();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  %>
</body>
</html>
