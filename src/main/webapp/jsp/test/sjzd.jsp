<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/common/taglib.jsp"%>
<%@include file="/jsp/common/plugIn.jsp"%>
<html>
<head>
    <title>任务单设置数据字典</title>
</head>
<body>
  <div id="content"><%--row--%>
    <div><%--col-md-10--%>
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
            <th>人员类型</th>
            <th>人员级别</th>
            <th>人员单价</th>
          </tr>
        </thead>
        <tbody>
        <tr>
          <td>1</td>
           <td>
             <select  onchange="obtainPrice(this)">
                <option>---选择---</option>
                <option value="1">a</option>
                <option value="2">b</option>
                <option value="3">c</option>
             </select>
           </td>
           <td>
             <select onchange="obtainPrice(this)">
               <option>---选择---</option>
               <option value="1">q</option>
               <option value="2">w</option>
               <option value="3">e</option>
             </select>
           </td>
           <td><input type="text"/></td>
           </tr>
        </tbody>
      </table>
    </div>
  </div>
</body>
<script>
  var data = [{type : 1,level : 2,price :20000},
              {type : 2,level : 2,price :30000},
              {type : 2,level : 1,price :40000}
             ];
  function obtainPrice(o){
//    console.log($(obj).val());
    var thisTr = $(o).parents('tr');
    console.log(thisTr.find(':nth-child(2) option:selected').val());
    var s1 = thisTr.find(':nth-child(2) option:selected').val()
    var s2 = thisTr.find(':nth-child(3) option:selected').val()
    var priceText = thisTr.find(':nth-child(4) input');
    console.log('s1=' + s1 + ' s2=' + s2);
    $.each(data,function (i,o){
       if(s1 == o.type && s2 == o.level){
          priceText.val(o.price);
       }else{
         priceText.val('');
       }
    });
  }
</script>
</html>
