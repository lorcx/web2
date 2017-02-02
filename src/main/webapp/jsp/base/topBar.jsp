<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/common/taglib.jsp"%>
<%@include file="/jsp/common/plugIn.jsp" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <title>顶部导航栏</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
</head>
<body>
    <%--<nav class="navbar navbar-inverse navbar-fixed-top">--%>
        <%--<div class="container">--%>
            <%--<div class="navbar-header">--%>
                <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"--%>
                        <%--aria-expanded="false" aria-controls="navbar">--%>
                    <%--<span class="sr-only">Toggle navigation</span>--%>
                    <%--<span class="icon-bar">1 </span>--%>
                    <%--<span class="icon-bar">2</span>--%>
                    <%--<span class="icon-bar">3</span>--%>
                <%--</button>--%>
                <%--<a class="navbar-brand" href="javascript:void(0)">web2</a>--%>
            <%--</div>--%>
            <%--&lt;%&ndash;导航栏内容&ndash;%&gt;--%>
            <%--<div id="navbar" class="collapse navbar-collapse">--%>
                <%--<ul class="nav navbar-nav">--%>
                    <%--<li class="active"><a href="javascript:">Home</a></li>--%>
                    <%--<li><a href="javascript:">About</a></li>--%>
                    <%--&lt;%&ndash;工作上的&ndash;%&gt;--%>
                    <%--<li class="dropdown">--%>
                        <%--<a data-target="#" href="javascript:" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">--%>
                            <%--工作上的练习<span class="caret"></span>--%>
                        <%--</a>--%>
    <%----%>
                        <%--<ul class="dropdown-menu" aria-labelledby="dLabel">--%>
                            <%--<li id="autoPerson"><a href="javascript:void(0);">审议会自动选人</a></li>--%>
                            <%--<li id="autoDate"><a href="javascript:void(0);">自动设置时间为下周二</a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                    <%--&lt;%&ndash;学习+练习&ndash;%&gt;--%>
                    <%--<li class="dropdown">--%>
                        <%--<a id="dLabel" data-target="#" href="javascript:" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">--%>
                          <%--练习<span class="caret"></span>--%>
                        <%--</a>--%>
    <%----%>
                        <%--<ul class="dropdown-menu" aria-labelledby="dLabel">--%>
                            <%--<li id="zTree"><a href="javascript:void(0);">zTree</a></li>--%>
                            <%--<li id="ifremFlush"><a href="javascript:void(0);">ifrem刷新</a></li>--%>
                            <%--<li id="floatBottom"><a href="javascript:void(0);">浮动在最下边</a></li>--%>
                            <%--<li id="daoTest"><a href="javascript:void(0);">daoTest</a></li>--%>
                            <%--<li id="jslx"><a href="javascript:void(0);">js练习</a></li>--%>
                            <%--<li id="collections"><a href="javascript:void(0);">js实现集合</a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li><a href="javascript:void(0);" onclick="openWindow('/sys/userAction!list.controller','用户列表',1000,600)">用户列表</a></li>--%>
                <%--</ul>--%>
    <%----%>
                <%--&lt;%&ndash;导航栏右侧&ndash;%&gt;--%>
                <%--<ul class="nav navbar-nav navbar-right">--%>
                    <%--<li class="dropdown"><a id="topBarLoginInfo" href="javascript:void(0);">欢迎你：<s:property value="#session.nickName" /> </a></li>--%>
                    <%--<li class="dropdown"><a id="currentDate" href="javascript:void(0);"></a></li>--%>
                    <%--<li class="dropdown">--%>
                        <%--<a id="dLabel1" data-target="#" href="javascript:void(0);" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">--%>
                            <%--我的操作--%>
                            <%--<span class="caret"></span>--%>
                        <%--</a>--%>
    <%----%>
                        <%--<ul class="dropdown-menu" aria-labelledby="dLabel">--%>
                            <%--<li id="userInfo"><a href="javascript:void(0);">我的资料</a></li>--%>
                            <%--<li id="headPicUpload"><a href="javascript:void(0);">头像上传</a></li>--%>
                            <%--<li role="separator" class="divider"></li>--%>
                            <%--<li><a id="loginOut" href="javascript:void(0);">注销</a></li>--%>
                            <%--<li><a href="javascript:void(0);">重置密码</a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li class="dropdown">--%>
                        <%--<a  data-target="#" href="javascript:void(0);" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">--%>
                            <%--系统信息--%>
                            <%--<span class="caret"></span>--%>
                        <%--</a>--%>
    <%----%>
                        <%--<ul class="dropdown-menu" aria-labelledby="dLabel">--%>
                            <%--<li id="druid"><a href="javascript:void(0);">druid</a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
    <%----%>
        <%--</div>--%>
    <%--</nav>--%>
    <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/jsp/base/main.jsp">Modern</a>
        </div>
        <%-- /.navbar-header --%>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i
                        class="fa fa-comments-o"></i><span class="badge">4</span></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-menu-header">
                        <strong>Messages</strong>

                        <div class="progress thin">
                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40"
                                 aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                <span class="sr-only">40% Complete (success)</span>
                            </div>
                        </div>
                    </li>
                    <li class="avatar">
                        <a href="#">
                            <img src="/img/1.png" alt=""/>

                            <div>New message</div>
                            <small>1 minute ago</small>
                            <span class="label label-info">NEW</span>
                        </a>
                    </li>
                    <li class="avatar">
                        <a href="#">
                            <img src="/img/2.png" alt=""/>

                            <div>New message</div>
                            <small>1 minute ago</small>
                            <span class="label label-info">NEW</span>
                        </a>
                    </li>
                    <li class="avatar">
                        <a href="#">
                            <img src="/img/3.png" alt=""/>

                            <div>New message</div>
                            <small>1 minute ago</small>
                        </a>
                    </li>
                    <li class="avatar">
                        <a href="#">
                            <img src="/img/4.png" alt=""/>

                            <div>New message</div>
                            <small>1 minute ago</small>
                        </a>
                    </li>
                    <li class="avatar">
                        <a href="#">
                            <img src="/img/5.png" alt=""/>

                            <div>New message</div>
                            <small>1 minute ago</small>
                        </a>
                    </li>
                    <li class="avatar">
                        <a href="#">
                            <img src="/img/pic1.png" alt=""/>

                            <div>New message</div>
                            <small>1 minute ago</small>
                        </a>
                    </li>
                    <li class="dropdown-menu-footer text-center">
                        <a href="#">View all messages</a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="/img/1.png"><span
                        class="badge">9</span></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-menu-header text-center">
                        <strong>Account</strong>
                    </li>
                    <li class="m_2"><a href="#"><i class="fa fa-bell-o"></i> Updates <span
                            class="label label-info">42</span></a></li>
                    <li class="m_2"><a href="#"><i class="fa fa-envelope-o"></i> Messages <span
                            class="label label-success">42</span></a></li>
                    <li class="m_2"><a href="#"><i class="fa fa-tasks"></i> Tasks <span
                            class="label label-danger">42</span></a></li>
                    <li><a href="#"><i class="fa fa-comments"></i> Comments <span class="label label-warning">42</span></a>
                    </li>
                    <li class="dropdown-menu-header text-center">
                        <strong>Settings</strong>
                    </li>
                    <li class="m_2"><a href="#"><i class="fa fa-user"></i> Profile</a></li>
                    <li class="m_2"><a href="#"><i class="fa fa-wrench"></i> Settings</a></li>
                    <li class="m_2"><a href="#"><i class="fa fa-usd"></i> Payments <span
                            class="label label-default">42</span></a></li>
                    <li class="m_2"><a href="#"><i class="fa fa-file"></i> Projects <span
                            class="label label-primary">42</span></a></li>
                    <li class="divider"></li>
                    <li class="m_2"><a href="#"><i class="fa fa-shield"></i> Lock Profile</a></li>
                    <li class="m_2"><a href="#"><i class="fa fa-lock"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
        <form class="navbar-form navbar-right">
            <input type="text" class="form-control" value="Search..." onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = 'Search...';}">
        </form>
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="/jsp/base/main.jsp"><i class="fa fa-dashboard fa-fw nav_icon"></i>Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-laptop nav_icon"></i>Layouts<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/jsp/base/grids.jsp">Grid System</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-indent nav_icon"></i>Menu Levels<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/jsp/base/graphs.jsp">Graphs</a>
                            </li>
                            <li>
                                <a href="/jsp/base/typography.jsp">Typography</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-envelope nav_icon"></i>Mailbox<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/jsp/base/inbox.jsp">Inbox</a>
                            </li>
                            <li>
                                <a href="/jsp/base/compose.jsp">Compose email</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="/jsp/base/widgets.jsp"><i class="fa fa-flask nav_icon"></i>Widgets</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-check-square-o nav_icon"></i>Forms<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/jsp/base/forms.jsp">Basic Forms</a>
                            </li>
                            <li>
                                <a href="/jsp/base/validation.jsp">Validation</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table nav_icon"></i>Tables<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/jsp/base/basic_tables.jsp">Basic Tables</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-fw nav_icon"></i>Css<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/jsp/base/media.jsp">Media</a>
                            </li>
                            <li>
                                <a href="/login.jsp">Login</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>
</body>
<script type="text/javascript">
    $(function (){
        //加载当前时间
//        currentDate();
//        //注销
//        $('#loginOut').click(function (){
//            window.location.href = '/login.jsp';
//        });
//        //我的资料
//        $('#userInfo').click(function(){
//            openWindow('/sys/userAction!userInfoEdit.controller','我的资料',500,400);
//        });
//        //druid配置
//        $('#druid').click(function(){
//            openWindow('/druid/index.html','druid信息',1280,788);
//        });
//        //zTree
//        $('#zTree').click(function(){
//            openWindow('/jsp/test/zTree/tree.jsp','zTree练习',1280,788);
//        });
//        //ifrem刷新
//        $('#ifremFlush').click(function(){
//            openWindow('/html/frame.html','ifrem刷新',1280,788);
//        });
//        //浮动在最下边
//        $('#floatBottom').click(function(){
//            openWindow('/jsp/float_bottom.jsp','浮动在最下边',1280,788);
//        });
//        //头像上传
//        $('#headPicUpload').click(function(){
//            openWindow('/jsp/uploadFile.jsp','头像上传',400,600);
//        });
//        //daoTest
//        $('#daoTest').click(function(){
//            openWindow('/jsp/test/commonDaoTest.jsp','daoTest',400,600);
//        });
//        //自动选人
//        $('#autoPerson').click(function(){
//            openWindow('/jsp/test/autoPeson.jsp','自动选人',900,600);
//        });
//        //自动设置时间为下周二
//        $('#autoDate').click(function(){
//            openWindow('/jsp/test/autoDate.jsp','自动设置时间为下周二',392,129);
//        });
//        //javascript test练习
//        $('#jslx').click(function(){
//            openWindow('/html/jslx1.html','javascript test练习',392,129);
//        });
//        //js实现集合
//        $('#collections').click(function(){
//            openWindow('/jsp/study/js/Collections.jsp','javascript test练习',900,600);
//        });
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
        return str < 10 ? '0' + str : str;
    }
</script>
</html>
