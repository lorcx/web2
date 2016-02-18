<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<html>
<head>
    <title>自动选人</title>
</head>
<body>
  <table id="auditTab">
    <tr>
      <td>组长</td>
      <td><input type="text" class="audit_result" value="1"/></td>
      <td>技术1</td>
      <td><input type="text" class="audit_result" /></td>
      <td>技术2</td>
      <td><input type="text" class="audit_result" /></td>
    </tr>
    <tr>
      <td>应用</td>
      <td><input type="text" class="audit_result" /></td>
      <td>业务</td>
      <td><input type="text" class="audit_result" /></td>
      <td>审议结论</td>
      <td><input type="text" id="final_result" /></td>
    </tr>
  </table>
</body>
<script type="text/javascript">
    $(function (){
        //0 未通过 1 通过 2 有条件通过 3 复议
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

    });

</script>
</html>
