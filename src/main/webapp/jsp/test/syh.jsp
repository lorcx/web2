<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/common.jsp" %>

<html>
<head>
    <title>任务单审议会如何保存</title>
    <script type="text/javascript" src="../../js/jquery/jquery-1.12.1.min.js"></script>
</head>
<body>
    <form>
        <div style="margin: 0 auto;width:600px;">
            <table>
                <tr>
                    <td>组长</td>
                    <td>
                        <s:select list="#{'1':'通过','2':'有条件通过','3':'不通过',4:'复议'}"  headerKey="" headerValue=""  onchange="autoGenerateResult();" cssClass="audit_result"></s:select>
                    </td>
                    <td>技术1</td>
                    <td>
                        <s:select list="#{'1':'通过','2':'有条件通过','3':'不通过',4:'复议'}" headerKey="" headerValue=""  onchange="autoGenerateResult();"  cssClass="audit_result" ></s:select>
                    </td>
                    <td>技术2</td>
                    <td>
                        <s:select list="#{'1':'通过','2':'有条件通过','3':'不通过',4:'复议'}" headerKey="" headerValue=""  onchange="autoGenerateResult();"  cssClass="audit_result" ></s:select>
                    </td>
                </tr>
                <tr>
                    <td>业务</td>
                    <td>
                        <s:select list="#{'1':'通过','2':'有条件通过','3':'不通过',4:'复议'}" headerKey="" headerValue=""   onchange="autoGenerateResult();"  cssClass="audit_result"></s:select>
                    </td>
                    <td>应用</td>
                    <td>
                        <s:select list="#{'1':'通过','2':'有条件通过','3':'不通过',4:'复议'}" headerKey="" headerValue="" onchange="autoGenerateResult();"  cssClass="audit_result"></s:select>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
                <div id="res"></div>
            </table>
            <hr/>
             <a onclick="autoGenerateResult();">xxxxx</a>
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
//        $('#btn').click(function(){
//            $('#form1').submit();
//        });

    });

    /**
     *自动生成审议会结果
     */
    function autoGenerateResult(){
        var arr = $.unique($('.audit_result').map(function (){
            var res = $(this).val();
            if(res){
                return res;
            }else{
                return;
            }
        }).get());
        //alert(arr);
        var n1 = $.inArray('1',arr);
        var n2 = $.inArray('2',arr);
        var n3 = $.inArray('3',arr);
        if(arr.length == 1){
            if(n1 != -1){
                alert('通过');
            }else if(n2 != -1){
                alert('有条件');
            }else if(n3 != -1){
                alert('否决');
            }
        }else if(arr.length == 2){
            if(n1 != -1 && n2 != -1 ) {
                alert('有条件');
            }else if(n1 != -1 && n3 != -1){
                alert('否决');
            }else if(n2 != -1 && n3 != -1){
                alert('否决');
            }
        }else{
            alert('否决');
        }
    }


    function t(){
        var final_res = "":
        var tg,ntg,tjtg = 0;
        $('#auditTab input[class="audit_result"]').each(function(i,o){
            var res = $(o).val();//每个审议结果
            switch (parseInt(res)){
                case 0:
                    ntg++;
                    break;
                case 1:
                    tg++;
                    break;
                case 2:
                    tjtg++;
                    break;
            }
        });
        if(ntg > 0){
            $('#final_result').val('不通过');
            return;
        }else if(tjtg > 0){
            $('#final_result').val('有条件通过');
        }else{
            $('#final_result').val('通过');
        }
    }
</script>
</html>
