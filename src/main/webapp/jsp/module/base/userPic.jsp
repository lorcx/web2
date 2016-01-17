<%@ page import="java.sql.*" %>
<%@ page import="java.io.OutputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取用户图片</title>
</head>
<body>
  <%
    response.setContentType("image/jpeg");//设置返回类型为图片
    String userName = request.getParameter("userName");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
    Connection conn = DriverManager.getConnection(url,"llxx","lorcx");
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
        os.close();
      }
    }
  %>
</body>
</html>
