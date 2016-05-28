<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/common.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <form id="queryFrom" action="/base/userAction!getUserList.action" method="post">
        <div>
            <h3>用户查询列表</h3>
        </div>
        <table class="table table-bordered">
            <tr>
                <td>用户名</td>
                <td>
                    <input id="userName" type="text" name="userName" class="form-control"  placeholder="张三">
                </td>
                <td>昵称</td>
                <td>
                    <input id="nickName" type="text" name="nickName" class="form-control"  placeholder="有点甜">
                </td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: center;">
                    <button id="queryBtn" type="button" class="btn btn-primary">查询</button>
                    <button id="clearBtn" type="button" class="btn btn-primary">清空</button>
                </td>
            </tr>
        </table>
    </form>
    <form action="" id="queryForm" method="POST" >
        <div class=""><%--row--%>
            <div class=""><%--col-md-10--%>
                <table id="contentTable" class="table table-hover table-striped table-bordered table-condensed">
                    <colgroup>
                        <col width="20%"></col>
                        <col width="30%"></col>
                        <col width="30%"></col>
                        <col width="20%"></col>
                    </colgroup>
                    <thead>
                        <tr>
                            <th>序号</th>
                            <th>用户名</th>
                            <th>昵称</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
    </form>
</body>
<script type="text/javascript">
    $(function (){
        $('#clearBtn').click(clearText);
        $('#queryBtn').click(queryForm);
        queryForm();
    });

    /**
     *查询表单
     */
    function queryForm(){
        $("#queryFrom").asyncSubmit({},function (data){
            if(data){
                $('#contentTable tbody').empty();
                var list = data.list;
                if(list){
                    var n = list.length;
                    var record = '';
                    for(var i = 0;i < n;i++){
                        var obj = list[i];
                        record += '<tr>';
                        record += '<td>'+(i+1)+'</td>';
                        record += '<td>'+obj.userName+'</td>';
                        record += '<td>'+obj.nickName+'</td>';
                        record += '<td><input type="checkbox"/></td>';
                        record += '</tr>';
                    }
                    $('#contentTable tbody').append(record);
                }
            }

        });
    }

    /**
     * 清除文本框
     */
    function clearText(){
        $('#userName').val('');
        $('#nickName').val('');
    }
</script>
</html>
