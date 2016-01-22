************************************   web2项目   ************************************************
                                                                           创建时间：2015.12.10
导入项目注意：
    导入本地jstl.jar和standard.jar
使用的技术（框架和插件）：
       ssh : struts2 spring hibernate
       maven
       jquery系列 : jqeury-form 、jquery、jquery-uploadify

一、常用链接：druid首页 : http://localhost:8080/druid/wall.html


二、公共使用：
  jsp页面：
     在页面中引入
        <%@ include file="/jsp/common/common.jsp" %>  标签库
        <%@ include file="/jsp/common/plugIn.jsp" %>  js插件

三、已有功能：
        文件上传，下载

四、其他：
    1.struts2 拦击*.action因为用了servlet




-------------------------------------------------------
ajaxsubmit
struts2 拦截



待解决 ：
    1.hibernate template 的currentSession (文件上传)
    hibernate封装
