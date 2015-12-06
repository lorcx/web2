<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>My JSP 'qiye_upload_reports.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/${style}/css_layout.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/${style}/css_columns.css" />
</head>
<script type="text/javascript">
  		var process = 1;
		var u = 100;
		var msg = "1";
		function action(){
			$('sd').html("<b>正在同步中,已同步<font color=red>"+process+"%</font></b>");
			  if (process<100){
			    process++;
			    setTimeout(action,u);
			  }else{
			  	 process = 1;
			 	$('#synDiv').hide();
			 	alert("同步成功！");
			 }
		}
		function tb(){
			$('#synDiv').show();
			 $.ajax({
					type: "POST",
					url:"/usersyn/usersyn!systemSyn.action",
					dataType: "json",
					async: true,
					timeOut:3000,
					beforeSend:function(){
						action();
					},
					success: function(data) {
						if(data.msg =="1"){
							u = 10;
					    }else{
					    	alert("导入失败！");
					    }
					},
					error: function(data) {
						$('#synDiv').hide();
						alert("发送请求失败！");
					}
				});
		 	action();  
		 	
		}
		function usersyn(){
			if(confirm("确认同步")){
				tb();
			}
  		}
 </script>
<script type="text/javascript">
	   function checkAll(obj){
	   		var objCheckbox = document.form1.itemId;
			var checkBos;
			for(var i =0;i<objCheckbox.length;i++){
				checkBos = objCheckbox[i];
				if(!obj.checked)
					checkBos.checked = false;
				else
					checkBos.checked = true;
			}
	   }
        </script>
<body>
	<FORM id="form1" name="form1"
		action="<%=request.getContextPath()%>/jsp/module/usersyn/user_syn_log.jsp"
		method="post">
		<input type='hidden' name='rows' value='15'>
		<div align="center">
			<div id="synDiv" style="display:none"></div>
			<div class="center_main" id="centerdiv">
				<br />
				<br />

				<table cellpadding="0" cellspacing="0" class="tab1_head">
					<tr>
						<td width="10"></td>
						<td class="tab1_title" align="left">同步记录日志列表</td>
						<td width="200" 　class="tab1_btn"><img
							src="<%=request.getContextPath()%>/images/ico/ico-pan.gif"
							width="16" height="16" /><a href="#" onclick="usersyn()">手动同步记录</a>
							<img src="<%=request.getContextPath()%>/images/${style}/del.gif"
							width="12" height="12" /> <a href="#" id="del" onclick="del()">删除</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</FORM>
</body>
</html>
