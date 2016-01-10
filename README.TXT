2015.12.10

web2项目                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ：ssh + maven项目
  连接池    ：druid
  druid首页 : http://localhost:8080/druid/wall.html

注意：
    导入本地jstl.jar和standard.jar



在页面中引入
        <%@ include file="/jsp/common/common.jsp" %>  标签库
        <%@ include file="/jsp/common/plugIn.jsp" %>  js插件


1.struts2 拦击*.action因为用了servlet




待解决 ：
    1.hibernate template 的currentSession (文件上传)
    2. session request的获取的区别

       获得request对象：
       A．HttpServletRequest request = ServletActionContext.getRequest ();
       B．ActionContext ct= ActionContext.getContext();
       HttpServletRequest request = (HttpServletRequest)ct.get(
           ServletActionContext.HTTP_REQUEST);




       获得request对象有三种方式：

       　　方式一：aware接口注入，即实现ServletRequestAware接口（此方式最为麻烦）

       　　public class Demo2ServletAction extends ActionSupport implements ServletRequestAware{

       　　　　private HttpServletRequest request;

       　　

       　　　　@Override

       　　　　public String execute() throws Exception {

       　　　　    request.setAttribute("gf", "request_aware");

       　　　　    return SUCCESS;

       　　　　}

       　　

       　　　　@Override

       　　　　public void setServletRequest(HttpServletRequest request) {

       　　　　    this.request = request;

       　　　　}

       　　}


       　　　方式二：使用ServletActionContext工具类（此方式虽好，但与servlet api耦合）

       　　public class Demo1ServletAction extends ActionSupport{

       　　　　@Override

       　　　　public String execute() throws Exception {

       　　    　　ServletActionContext.getRequest().setAttribute("gf", "request");

       　　    　　return SUCCESS;

       　　    }

       　　    }


       　　方式三：通过ActionContext来获得（此方式与servlet api解耦，建议使用）

       　　public class Demo3ServletAction extends ActionSupport{

           　　@Override

           　　public String execute() throws Exception {

               　　ActionContext.getContext().put("gf", "request");

               　　return SUCCESS;

           　　}

       　　}