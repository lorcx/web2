<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/common.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <title>我的个人信息</title>
</head>
<body>
    <form class="form-horizontal" role="form">
        <div id="content" class="container">
            <div class="row">
                <div class="col-md-12" role="main">
                    <%--面板--%>
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">我的信息</h3>
                        </div>
                        <div class="panel-body">
                            <fieldset>
                                <%--<legend>我的信息</legend>--%>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nickName">昵称：</label>
                                    <div class="col-sm-8">
                                        <input class="form-control" id="nickName" type="text"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="userName">用户名：</label>
                                    <div class="col-sm-8">
                                        <input class="form-control" id="userName" type="text"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="creDate">创建时间：</label>
                                    <div class="col-sm-8">
                                        <input class="form-control" id="creDate" type="text"/>
                                    </div>
                                </div>
                            </fieldset>
                        </div>
                    </div>
                    <%--按钮--%>
                    <div style="width:100%;margin: 0 auto;">
                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-primary">保存</button>
                        </div>
                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-primary">关闭</button>
                        </div>
                    </div>
                </div><%--col-md-12--%>
            </div><%--row--%>
        </div><%--container--%>
    </form>
</body>
</html>
