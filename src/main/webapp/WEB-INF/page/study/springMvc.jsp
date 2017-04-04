<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<%@include file="/jsp/common/taglib.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
foreach: <br/>
<c:forEach var="item" items="${userList}">
    usernaem : ${item.userName}
    phone : ${item.phone}
    creTime : ${item.creTime}
</c:forEach>

<form action="/springMvcTest/m6" method="post">
    <input type="text" name="username">
    <input type="text" name="password">

    <input type="submit" value="提交">
</form>
<br/>
PUT(修改)
<form action="/springMvcTest/m7" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="text" name="username">
    <input type="text" name="password">

    <input type="submit" value="提交">
</form>
<br/>
delete(删除)
<form action="/springMvcTest/m8" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="text" name="username">
    <input type="text" name="password">

    <input type="submit" value="提交">
</form>

<br/>
${user.userName}

<br/>

上传
<form action="/springMvcTest/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br>
    <input type="submit" value="submit">
</form>


</body>
<script src="../../../statics/libs/jquery-1.12.1.min.js"></script>
<script>
//    console.log(new Date());
//    var dataStr = JSON.stringify(["123","456"]);
//    $.ajax({
//        type: 'POST',
//        url: '/springMvcTest/m10',
////        data : "id=123&id=000",
//        data : dataStr,
//        dataType: 'json',
//        contentType : 'application/json',
////        contentType: "application/x-www-form-urlencoded",
//        success: function (result) {
//            console.log(result);
//        }
//    });
//
//    $.post('/springMvcTest/m8', "id=123&id=000", function (result) {
//        console.log(result);
//    });
////
//    $.get('/springMvcTest/testDateFormat1', "id=123", function (result) {
//        console.log(result);
//    });
</script>
</html>
