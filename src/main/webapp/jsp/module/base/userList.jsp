<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/common.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>用户列表</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
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
        <div id="content"><%--row--%>
            <div><%--col-md-10--%>
                <table id="contentTable" class="table table-hover table-striped table-bordered table-condensed">
                    <colgroup>
                        <col width="20%">
                        <col width="30%">
                        <col width="30%">
                        <col width="20%">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>序号</th>
                            <th>用户名</th>
                            <th>昵称</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <%@ include file="/jsp/common/page.jsp" %>
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
     * eval("(" + data + ")").list
     */
    function queryForm(){
        $("#queryFrom").asyncSubmit({},addContent);
    }

    /**
     * 查询显示
     */
    function addContent(data){
        if(data){
            var contentTable = $('#contentTable').find('tbody');
            contentTable.empty();
            var record = '';
            if(data.list && data.list.length > 0){
                $.each(data.list,function(i,obj){
                    record += '<tr>';
                    record += '<td>'+(i+1)+'</td>';
                    record += '<td>'+obj.userName+'</td>';
                    record += '<td>'+obj.nickName+'</td>';
                    record += '<td><input type="checkbox"/></td>';
                    record += '</tr>';
                })
            }else{
                record += '<tr><td colspan="4" class="w2_text_center">暂无任何信息</td></tr>';
            }
            contentTable.append(record);
        }
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
