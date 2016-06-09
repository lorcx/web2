<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>顶部导航栏</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar">1 </span>
                <span class="icon-bar">2</span>
                <span class="icon-bar">3</span>
            </button>
            <a class="navbar-brand" href="#">web2</a>
        </div>
        <%--导航栏内容--%>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                    <a id="dLabel" data-target="#" href="#" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        Dropdown trigger
                        <span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li><a href="#">Another action</a></li>
                    </ul>
                </li>
                <li><a href="#" onclick="openWindow('/base/userAction!list.action','用户列表',1000,600)">用户列表</a></li>
            </ul>

            <%--导航栏右侧--%>
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a id="currentDate" href="#">2016-06-05 11:11:11 </a></li>
                <li class="dropdown">
                    <a id="dLabel1" data-target="#" href="#" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        我的操作
                        <span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li id="userInfo"><a href="#">我的资料</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a id="loginOut" href="#">注销</a></li>
                        <li><a href="#">重置密码</a></li>
                    </ul>
                </li>

            </ul>
        </div>

    </div>
</nav>
</body>
<script type="text/javascript">
    $(function (){
        currentDate();
        //注销
        $('#loginOut').click(function (){
            window.location.href = '/login.jsp';
        });
        //我的资料
        $('#userInfo').click(function(){
            openWindow('/base/userAction!userInfoEdit.action','我的资料',500,400);
        });
    });

    function currentDate(){
        var nowDate = new Date();
        var y = nowDate.getFullYear();
        var M = nowDate.getMonth();
        var d = nowDate.getDate();
        var h = nowDate.getHours();
        var m = nowDate.getMinutes();
        var s = nowDate.getSeconds();
        $('#currentDate').text(y + '-' + datePrefix(M) + '-' + datePrefix(d) + ' ' + datePrefix(h) + ':' + datePrefix(m) + ':' + datePrefix(s));
        setTimeout("currentDate();",500);
    }

    function datePrefix(str){
        return str < 10 ? '0' + str : str;;
    }
</script>
</html>
