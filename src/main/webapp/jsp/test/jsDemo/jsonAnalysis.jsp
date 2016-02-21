<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json解析</title>
</head>
<body>
</body>
<script src="../../js/json2.js"></script>
<script src="../../js/jquery-1.8.2.js"></script>
<script>
  //测试数据

  //字符串
  var jsonStr = '{"name":"caibaojian", "password":"1111"}';

  //对象
  var jsonObj = {"name":"caibaojian.com", "password":"1111"};

  //字符串转json
  var jObj = eval('(' + jsonStr + ')');
//  console.log(jObj);

  //json对象转字符串  js没有方法 只能有别的类库 json2.js
  var sObj = JSON.stringify(jsonObj);
//  console.log(sObj);


  //json2的parse将字符串转对象  但key不能有"


  /***********************************************/
  //jquery 遍历


  //grep 筛选数组
  var array = [1,2,3,4,5,6,7,8,9];
  var newArr = $.grep(array,function(n,i){
    return n > 3;
  });
//  console.log(newArr);

  //each遍历
  $.each(array,function(k,v){
//    console.log(k + ":" + v);
  });

  //inArray  确定第一个参数在数组中的位置，从0开始计数(如果没有找到则返回 -1 )。
   var index = $.inArray(3,array);
//  console.log(index);

  //map//转换
  var values = $.map(array,function (n){
    var result = new Number(n);
    return isNaN(result) ? null : result;
  });
//  console.log(values);

/********************************************************************************/
  //原生js遍历json对象
  var jsonTest = [{dd:'SB',AA:'东东',re1:123},{cccc:'dd',lk:'1qw'}];
  for(var i = 0;i < jsonTest.length;i++){
    for(var key in jsonTest[i]){
//      console.log(key + ':' + jsonTest[i][key]);
    }
  }
  //有规律
  var packJson = [
    {"name":"nikita", "password":"1111"},
    {"name":"tony", "password":"2222"}
  ];
  for(var p in packJson){
//    console.log(packJson[p].name + ":" + packJson[p].password);
  }

  /***************************************************/
  var myJson = {"name":"caibaojian", "password":"1111"};
  for(var p in myJson){//遍历json对象的每个key/value对,p为key
    console.log(p + " " + myJson[p]);
  }

</script>
</html>
