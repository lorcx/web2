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
        <fieldset>
            <legend>配置数据源</legend>
            <div class="form-group">
                <label class="col-sm-1 control-label" for="nickName">昵称</label>
                <div class="col-sm-5">
                    <input class="form-control" id="nickName" type="text"/>
                </div>
                
                <div>
                    <img src="../../../img/l1.jpg" class="img-thumbnail" alt="吐吐吐吐"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 control-label" for="userName">用户名</label>
                <div class="col-sm-5">
                    <input class="form-control" id="userName" type="text"/>
                </div>

                <label class="col-sm-1 control-label" for="creDate">创建时间</label>
                <div class="col-sm-5">
                    <input class="form-control" id="creDate" type="text"/>
                </div>

            </div>


        </fieldset>
    </form>
</body>
</html>
