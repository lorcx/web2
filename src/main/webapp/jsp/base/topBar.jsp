<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/common/common.jsp"%>
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
            <a class="navbar-brand" href="javascript:;">web2</a>
        </div>
        <%--导航栏内容--%>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="javascript:;">Home</a></li>
                <li><a href="javascript:;">About</a></li>
                <%--工作上的--%>
                <li class="dropdown">
                    <a data-target="#" href="javascript:;" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        工作上的练习<span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li id="autoPerson"><a href="javascript:;">审议会自动选人</a></li>
                        <li id="autoDate"><a href="javascript:;">自动设置时间为下周二</a></li>
                    </ul>
                </li>
                <%--学习+练习--%>
                <li class="dropdown">
                    <a id="dLabel" data-target="#" href="javascript:;" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                      练习<span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li id="zTree"><a href="javascript:;">zTree</a></li>
                        <li id="ifremFlush"><a href="javascript:;">ifrem刷新</a></li>
                        <li id="floatBottom"><a href="javascript:;">浮动在最下边</a></li>
                        <li id="daoTest"><a href="javascript:;">daoTest</a></li>
                        <li id="jslx"><a href="javascript:;">js练习</a></li>
                        <li id="collections"><a href="javascript:;">js实现集合</a></li>
                    </ul>
                </li>
                <li><a href="javascript:;" onclick="openWindow('/base/userAction!list.action','用户列表',1000,600)">用户列表</a></li>
            </ul>

            <%--导航栏右侧--%>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown"><a id="topBarLoginInfo" href="javascript:;">欢迎你：<s:property value="#session.nickName" /> </a></li>
                <li class="dropdown"><a id="currentDate" href="javascript:;"></a></li>
                <li class="dropdown">
                    <a id="dLabel1" data-target="#" href="javascript:;" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        我的操作
                        <span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li id="userInfo"><a href="javascript:;">我的资料</a></li>
                        <li id="headPicUpload"><a href="javascript:;">头像上传</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a id="loginOut" href="javascript:;">注销</a></li>
                        <li><a href="javascript:;">重置密码</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a  data-target="#" href="javascript:;" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        系统信息
                        <span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li id="druid"><a href="javascript:;">druid</a></li>
                    </ul>
                </li>
            </ul>
        </div>

    </div>
</nav>
</body>
<script type="text/javascript">
    $(function (){
        //加载当前时间
        currentDate();
        //注销
        $('#loginOut').click(function (){
            window.location.href = '/login.jsp';
        });
        //我的资料
        $('#userInfo').click(function(){
            openWindow('/base/userAction!userInfoEdit.action','我的资料',500,400);
        });
        //druid配置
        $('#druid').click(function(){
            openWindow('/druid/index.html','druid信息',1280,788);
        });
        //zTree
        $('#zTree').click(function(){
            openWindow('/jsp/test/zTree/tree.jsp','zTree练习',1280,788);
        });
        //ifrem刷新
        $('#ifremFlush').click(function(){
            openWindow('/html/frame.html','ifrem刷新',1280,788);
        });
        //浮动在最下边
        $('#floatBottom').click(function(){
            openWindow('/jsp/float_bottom.jsp','浮动在最下边',1280,788);
        });
        //头像上传
        $('#headPicUpload').click(function(){
            openWindow('/jsp/uploadFile.jsp','头像上传',400,600);
        });
        //daoTest
        $('#daoTest').click(function(){
            openWindow('/jsp/test/commonDaoTest.jsp','daoTest',400,600);
        });
        //自动选人
        $('#autoPerson').click(function(){
            openWindow('/jsp/test/autoPeson.jsp','自动选人',900,600);
        });
        //自动设置时间为下周二
        $('#autoDate').click(function(){
            openWindow('/jsp/test/autoDate.jsp','自动设置时间为下周二',392,129);
        });
        //javascript test练习
        $('#jslx').click(function(){
            openWindow('/html/jslx1.html','javascript test练习',392,129);
        });
        //js实现集合
        $('#collections').click(function(){
            openWindow('/jsp/study/js/Collections.jsp','javascript test练习',900,600);
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
