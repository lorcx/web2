<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Graphs</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="/plug_in/bootstrap/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="/css/style.css" rel='stylesheet' type='text/css' />
<link href="/css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="/plug_in/jquery/jquery-1.12.1.min.js"></script>
<!----webfonts--->
<link href='/css/web2-font.css' rel='stylesheet' type='text/css'>
<!---//webfonts--->  
<!-- chart -->
<script src="/plug_in/chart/Chart.js"></script>
<!-- //chart -->
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
	        		<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-comments-o"></i><span class="badge">4</span></a>
	        		<ul class="dropdown-menu">
						<li class="dropdown-menu-header">
							<strong>Messages</strong>
							<div class="progress thin">
							  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
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
	        		<a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="/img/1.png" alt=""/><span class="badge">9</span></a>
	        		<ul class="dropdown-menu">
						<li class="dropdown-menu-header text-center">
							<strong>Account</strong>
						</li>
						<li class="m_2"><a href="#"><i class="fa fa-bell-o"></i> Updates <span class="label label-info">42</span></a></li>
						<li class="m_2"><a href="#"><i class="fa fa-envelope-o"></i> Messages <span class="label label-success">42</span></a></li>
						<li class="m_2"><a href="#"><i class="fa fa-tasks"></i> Tasks <span class="label label-danger">42</span></a></li>
						<li><a href="#"><i class="fa fa-comments"></i> Comments <span class="label label-warning">42</span></a></li>
						<li class="dropdown-menu-header text-center">
							<strong>Settings</strong>
						</li>
						<li class="m_2"><a href="#"><i class="fa fa-user"></i> Profile</a></li>
						<li class="m_2"><a href="#"><i class="fa fa-wrench"></i> Settings</a></li>
						<li class="m_2"><a href="#"><i class="fa fa-usd"></i> Payments <span class="label label-default">42</span></a></li>
						<li class="m_2"><a href="#"><i class="fa fa-file"></i> Projects <span class="label label-primary">42</span></a></li>
						<li class="divider"></li>
						<li class="m_2"><a href="#"><i class="fa fa-shield"></i> Lock Profile</a></li>
						<li class="m_2"><a href="#"><i class="fa fa-lock"></i> Logout</a></li>	
	        		</ul>
	      		</li>
			</ul>
			<form class="navbar-form navbar-right">
              <input type="text" class="form-control" value="Search..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search...';}">
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
        <div class="graphs">
	    <div class="graph_box">
			<div class="col-md-4 grid_2"><div class="grid_1">
				<h3>Circular</h3>
				<canvas id="doughnut" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
			</div></div>
			<div class="col-md-4 grid_2"><div class="grid_1">
				<h3>Line</h3>
				<canvas id="line" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
			</div></div>
			<div class="col-md-4 grid_2"><div class="grid_1">
				<h3>PolarArea</h3>
				<canvas id="polarArea" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
			</div></div>
			<div class="clearfix"> </div>
	    </div>
	    <div class="graph_box1">
			<div class="col-md-4 grid_2"><div class="grid_1">
				<h3>Bar</h3>
				<canvas id="bar" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
			</div></div>
			<div class="col-md-4 grid_2"><div class="grid_1">
				<h3>Pie</h3>
				<canvas id="pie" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
			</div></div>
			<div class="col-md-4 grid_2"><div class="grid_1">
				<h3>Radar</h3><canvas id="radar" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
			</div></div>
			<div class="clearfix"> </div>
		</div>
    <script>

		var doughnutData = [
				{
					value: 30,
					color:"#ef553a"
				},
				{
					value : 50,
					color : "#9358ac"
				},
				{
					value : 100,
					color : "#3b5998"
				},
				{
					value : 40,
					color : "#00aced"
				},
				{
					value : 120,
					color : "#4D5360"
				}
			
			];
		var lineChartData = {
			labels : ["","","","","","",""],
			datasets : [
				{
					fillColor : "#00aced",
					strokeColor : "#00aced",
					pointColor : "#00aced",
					pointStrokeColor : "#fff",
					data : [65,59,90,81,56,55,40]
				},
				{
					fillColor : "#3b5998",
					strokeColor : "#3b5998",
					pointColor : "#3b5998",
					pointStrokeColor : "#fff",
					data : [28,48,40,19,96,27,100]
				}
			]
			
		};
		var pieData = [
				{
					value: 30,
					color:"#ef553a"
				},
				{
					value : 50,
					color : "#00aced"
				},
				{
					value : 100,
					color : "#69D2E7"
				}
			
			];
		var barChartData = {
			labels : ["January","February","March","April","May","June","July"],
			datasets : [
				{
					fillColor : "#ef553a",
					strokeColor : "#ef553a",
					data : [65,59,90,81,56,55,40]
				},
				{
					fillColor : "#00aced",
					strokeColor : "#00aced",
					data : [28,48,40,19,96,27,100]
				}
			]
			
		};
	var chartData = [
			{
				value : Math.random(),
				color: "#D97041"
			},
			{
				value : Math.random(),
				color: "#C7604C"
			},
			{
				value : Math.random(),
				color: "#21323D"
			},
			{
				value : Math.random(),
				color: "#9D9B7F"
			},
			{
				value : Math.random(),
				color: "#7D4F6D"
			},
			{
				value : Math.random(),
				color: "#9358ac"
			}
		];
		var radarChartData = {
			labels : ["","","","","","",""],
			datasets : [
				{
					fillColor : "#3b5998",
					strokeColor : "#3b5998",
					pointColor : "#3b5998",
					pointStrokeColor : "#fff",
					data : [65,59,90,81,56,55,40]
				},
				{
					fillColor : "#ef553a",
					strokeColor : "#ef553a",
					pointColor : "#ef553a",
					pointStrokeColor : "#fff",
					data : [28,48,40,19,96,27,100]
				}
			]
			
		};
	new Chart(document.getElementById("doughnut").getContext("2d")).Doughnut(doughnutData);
	new Chart(document.getElementById("line").getContext("2d")).Line(lineChartData);
	new Chart(document.getElementById("radar").getContext("2d")).Radar(radarChartData);
	new Chart(document.getElementById("polarArea").getContext("2d")).PolarArea(chartData);
	new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
	new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);
	
	</script>
	<div class="copy_layout">
         <p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
        </div>	
   </div>
      </div>
      <!-- /#page-wrapper -->
   </div>
    <!-- /#wrapper -->
    <!-- Nav CSS -->
<link href="/css/custom.css" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src="/plug_in/metisMenu/metisMenu.min.js"></script>
<script src="/js/custom.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="/plug_in/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
