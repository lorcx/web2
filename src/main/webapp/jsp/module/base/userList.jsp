<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/common.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <form>
        <div>
            <h3>用户查询列表</h3>
        </div>
        <table class="table table-bordered">
            <tr>
                <td>姓名</td>
                <td>
                    <input type="text" class="form-control" id="exampleInputName2" placeholder="张三">
                </td>
                <td>昵称</td>
                <td>
                    <input type="text" class="form-control" id="exampleInputEmail2" placeholder="有点甜">
                </td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: center;">
                    <button type="button" class="btn btn-primary btn-sm">查询</button>
                    <button type="button" class="btn btn-primary btn-sm">清空</button>
                </td>
            </tr>
        </table>
    </form>
    <s:form action="" id="queryForm" method="POST" >
        <div class=""><%--row--%>
            <div class=""><%--col-md-10--%>
                <table class="table table-hover table-striped table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th>序号</th>
                            <th>用户名</th>
                            <th>昵称</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Column content</td>
                            <td>Column content</td>
                            <td>Column content</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </s:form>
</body>
<script type="text/javascript">
    $(function (){
        queryForm();
    });

    /**
     *查询表单
     */
    function queryForm(){

    }
</script>
</html>
