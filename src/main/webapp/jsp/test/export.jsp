<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>无标题文档</title>
  <script type="text/javascript">
    function saveCode(obj) {
      var winname = window.open('', '_blank', 'top=10000');
      var strHTML = document.all.tableExcel.innerHTML;
      winname.document.open('text/html', 'replace');
      winname.document.writeln(strHTML);
      winname.document.execCommand('saveas','','excel.xls');
      winname.close();
    }
  </script>
</head>
<div id="tableExcel">
  <table id="test" width="100%" border="1" cellspacing="0" cellpadding="0">
    <tr>
      <td colspan="5" align="center">WEB页面导出为EXCEL文档的方法</td>
    </tr>
    <tr>
      <td>列标题1</td>
      <td>列标题2</td>
      <td>列标题3</td>
      <td>列标题4</td>
      <td>列标题5</td>
    </tr>
    <tr>
      <td>aaa</td>
      <td>bbb</td>
      <td>ccc</td>
      <td>ddd</td>
      <td>eee</td>
    </tr>
    <tr>
      <td>AAA</td>
      <td>BBB</td>
      <td>CCC</td>
      <td>DDD</td>
      <td>EEE</td>
    </tr>
    <tr>
      <td>FFF</td>
      <td>GGG</td>
      <td>HHH</td>
      <td>III</td>
      <td>JJJ</td>
    </tr>
    <tr>
      <td>aaa</td>
      <td>bbb</td>
      <td>ccc</td>
      <td>ddd</td>
      <td>eee</td>
    </tr>
    <tr>
      <td>AAA</td>
      <td>BBB</td>
      <td>CCC</td>
      <td>DDD</td>
      <td>EEE</td>
    </tr>
    <tr>
      <td colspan="5">FFFGGGHHHIIIJJJ</td>
    </tr>

    <tr>
      <td>aaa</td>
      <td>bbb</td>
      <td>ccc</td>
      <td>ddd</td>
      <td>eee</td>
    </tr>
    <tr>
      <td>AAA</td>
      <td>BBB</td>
      <td rowspan="4">CCCHHHcccccc</td>
      <td>DDD</td>
      <td>EEE</td>
    </tr>
    <tr>
      <td>FFF</td>
      <td>GGG</td>
      <td>III</td>
      <td>JJJ</td>
    </tr>

    <tr>
      <td>aaa</td>
      <td>bbb</td>
      <td>ddd</td>
      <td>eee</td>
    </tr>
    <tr>
      <td>aaa</td>
      <td>bbb</td>
      <td>ddd</td>
      <td>eee</td>
    </tr>
    <tr>
      <td>AAA</td>
      <td>BBB</td>
      <td>CCC</td>
      <td>DDD</td>
      <td>EEE</td>
    </tr>
    <tr>
      <td>FFF</td>
      <td>GGG</td>
      <td>HHH</td>
      <td>III</td>
      <td>JJJ</td>
    </tr>
  </table>
</div>
<body>
<input type="button" value="另存为 Excel" onclick="saveCode(tableExcel)">
</body>
</html>  