<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自动设置时间为下周2的下午14：00</title>
</head>
<body>

</body>
<script>
//    window.onload = getAssignDate();

    (function (){
        getAssignDate();
    })();
    /*1
     *
     * 自动设置时间为下周2的下午14：00
     *
     * */
    function getAssignDate() {
        //var d = new Date('2016-02-03');
        //  d.setHours(13);
        var d = new Date();
        var year = d.getFullYear();
        var mouth = d.getMonth() + 1;
        var day = d.getDate();
        var week = d.getDay();
        var hour = d.getHours();
        if (week == 2) {//周二
            if (hour == 14) {
                console.log(year + '-' + mouth + '-' + day + ' 14 : 00');
            } else if (hour < 14) {
                console.log(year + '-' + mouth + '-' + day + ' 14 : 00');
            }
        } else if (week < 2) { // < 2
            var n = 2 - week;
            d.setDate(d.getDate() + n);
            console.log(d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' 14 : 00');
        }
        if ((week == 2 && hour > 14) || (week > 2)) {
            var n = week - 2;//计算与周二的差
            d.setDate(d.getDate() + 7 - n);
            console.log(d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' 14 : 00');
        }
    }

</script>
</html>
