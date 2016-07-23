<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/taglib.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <title>用户列表</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="Modern"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>

</head>
<body>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">Modern</a>
        </div>
        <!-- /.navbar-header -->
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
                            <img src="images/1.png" alt=""/>

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
                <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="/img/1.png" alt=""/><span
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
                        <a href="index.html"><i class="fa fa-dashboard fa-fw nav_icon"></i>Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-laptop nav_icon"></i>Layouts<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="grids.jsp">Grid System</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-indent nav_icon"></i>Menu Levels<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="graphs.jsp">Graphs</a>
                            </li>
                            <li>
                                <a href="typography.jsp">Typography</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-envelope nav_icon"></i>Mailbox<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="inbox.jsp">Inbox</a>
                            </li>
                            <li>
                                <a href="compose.jsp">Compose email</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="widgets.jsp"><i class="fa fa-flask nav_icon"></i>Widgets</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-check-square-o nav_icon"></i>Forms<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="forms.jsp">Basic Forms</a>
                            </li>
                            <li>
                                <a href="validation.jsp">Validation</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table nav_icon"></i>Tables<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="basic_tables.jsp">Basic Tables</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-fw nav_icon"></i>Css<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="media.jsp">Media</a>
                            </li>
                            <li>
                                <a href="login.html">Login</a>
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
    <div id="page-wrapper">
        <div class="col-md-12 graphs">
            <div class="xs">
                <h3>用户查询列表</h3>
                <form id="queryFrom" action="/base/userAction!getUserList.action" method="post">
                    <table class="table table-bordered">
                        <tr>
                            <td class="text-center w2-td-l" style="font-size: 18px;">用户名</td>
                            <td>
                                <input id="userName" type="text" name="userName" class="form-control1 input-sm"
                                       placeholder="张三">
                            </td>
                            <td class="text-center w2-td-l" style="font-size: 18px;">昵称</td>
                            <td>
                                <input id="nickName" type="text" name="nickName" class="form-control1 input-sm"
                                       placeholder="有点甜">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4" style="text-align: center;">
                                <button id="queryBtn" type="button" class="btn btn-primary">查询</button>
                                <button id="clearBtn" type="button" class="btn btn-default">清空</button>
                            </td>
                        </tr>
                    </table>
                    <div id="contentTable" class="bs-example4" data-example-id="contextual-table">
                        <table class="table table-bordered table-hover table-striped">
                            <colgroup>
                                <col width="20%">
                                <col width="30%">
                                <col width="30%">
                                <col width="20%">
                            </colgroup>
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>用户名</th>
                                <th>昵称</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                    <%@ include file="/jsp/common/page.jsp" %>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $('#clearBtn').click(clearText);
        $('#queryBtn').click(queryForm);
        queryForm();
    });

    /**
     *查询表单
     * eval("(" + data + ")").list
     */
    function queryForm() {
        $("#queryFrom").asyncSubmit({}, addContent);
    }

    /**
     * 查询显示
     */
    function addContent(data) {
        if (data) {
            var contentTable = $('#contentTable').find('tbody');
            contentTable.empty();
            var record = '';
            if (data.list && data.list.length > 0) {
                $.each(data.list, function (i, obj) {
                    record += '<tr>';
                    record += '<td>' + (i + 1) + '</td>';
                    record += '<td>' + obj.userName + '</td>';
                    record += '<td>' + obj.nickName + '</td>';
                    record += '<td><input type="checkbox" class="checkbox"/></td>';
                    record += '</tr>';
                })
            } else {
                record += '<tr><td colspan="4" class="w2_text_center">暂无任何信息</td></tr>';
            }
            contentTable.append(record);
        }
    }

    /**
     * 清除文本框
     */
    function clearText() {
        $('#userName').val('');
        $('#nickName').val('');
    }
</script>
</html>
