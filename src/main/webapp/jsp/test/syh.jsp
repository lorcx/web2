<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/common.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<html>
<head>
    <title>任务单审议会如何保存</title>
</head>
<body>
    <form id="form1" action="/dt/demoAction!test.action" >
        <div style="margin: 0 auto;width:600px;">
            <table>
                <tr>
                    <td>组长</td>
                    <td>
                        <input type="text" name="test.tname" value="5"/>
                    </td>
                    <td>技术1</td>
                    <td>
                        <input type="text" name="test.tname" value="2"/>
                    </td>
                    <td>技术2</td>
                    <td>
                        <input type="text" name="test.tname" value="3"/>
                    </td>
                </tr>
                <tr>
                    <td>业务</td>
                    <td>
                        <input type="text" name="test.tname" value="4"/>
                    </td>
                    <td>应用</td>
                    <td>
                        <input type="text" name="test.tname" value="1"/>
                    </td>
                    <td></td>
                    <td>

                    </td>
                </tr>
            </table>
            <hr/>
            <button id="btn">xxx</button>
            <div class="station"></div>
        </div>
    </form>
</body>
<script type="text/javascript">

    $(function () {
//        var tb = '';
//            tb += '<table>';
//            for(var i = 0;i < 2;i++){
//               tb += '<tr>';
//               tb += '<td></td>';
//               tb += '<td></td>';
//               tb += '</tr>';
//            }
//            tb += '</table>';
//        $('.station').append(tb);
        $('#btn').click(function(){
            $('#form1').submit();
        });

    });
</script>
</html>
