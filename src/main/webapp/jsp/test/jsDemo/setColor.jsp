<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/taglib.jsp"%>
<%@include file="/jsp/common/plugIn.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>首页</title>
  <style>
    .checked_bg{background: #25ffaa;}
  </style>
</head>
<body>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>是否存在风险</th>
        <th>有风险陈述</th>
        <th>无风险陈述</th>
      </tr>
    </thead>
    <tbody>
    <tr>
      <td>
          <select class="isCheckSelet" onchange="highlightDeclare(this);">
             <option value="0">无</option>
             <option value="1">有</option>
             <option value="2">不符合</option>
          </select>
      </td>
      <td>aaaaaaaa</td>
      <td>bbbbbbbb</td>
    </tr>
    <tr>
      <td>
        <select class="isCheckSelet"  onchange="highlightDeclare(this);">
          <option value="0">无</option>
          <option value="1">有</option>
          <option value="2">不符合</option>
        </select>
      </td>
      <td style="">aaaaaaaa</td>
      <td>bbbbbbbb</td>
    </tr>
    <tr>
      <td>
        <select class="isCheckSelet"  onchange="highlightDeclare(this);">
          <option value="0">无</option>
          <option value="1">有</option>
          <option value="2">不符合</option>
        </select>
      </td>
      <td>aaaaaaaa</td>
      <td>bbbbbbbb</td>
    </tr>
    <tr>
      <td>
        <select class="isCheckSelet"  onchange="highlightDeclare(this);">
          <option value="0">无</option>
          <option value="1">有</option>
          <option value="2">不符合</option>
        </select>
      </td>
      <td>aaaaaaaa</td>
      <td>bbbbbbbb</td>
    </tr>
    </tbody>
  </table>
</body>
<script type="text/javascript">
  $(function (){ });

    //高亮陈述
    function highlightDeclare(obj){
       var checkVal =  $(obj).find(':selected').val();
       switch (checkVal){
         case '0':
           console.log($(obj).parents('tr').find(':nth-child(2)').text());
           $(obj).parents('tr').find('td:nth-child(2)').addClass('checked_bg');
           $(obj).parents('tr').find('td:nth-child(3)').removeClass('checked_bg');
         break;
         case '1':
           $(obj).parents('tr').find('td:nth-child(3)').addClass('checked_bg');
           $(obj).parents('tr').find('td:nth-child(2)').removeClass('checked_bg');
           break;
         case '2':
           $(obj).parents('tr').find('td:nth-child(2)').removeClass('checked_bg');
           $(obj).parents('tr').find('td:nth-child(3)').removeClass('checked_bg');
           break;
       }
    }
</script>
</html>
