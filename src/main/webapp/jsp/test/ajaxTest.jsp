<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-CN" class="no-js">
<head>
<meta charset="utf-8">
<title>无标题文档</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plug_in/jquery/jquery-1.12.1.min.js"></script>
	<script type="text/javascript">
    	$(function (){
			<%--$.ajax({--%>
				<%--type:'POST',--%>
				<%--url:"<%=request.getContextPath()%>/ajax!getAjax.controller",--%>
				<%--timeout:5000,--%>
				<%--cache:false,--%>
				<%--async:true,--%>
				<%--dataType:"json",--%>
			    <%--success: function(msg){--%>
					<%--if(null != msg){--%>
					   <%--alert(msg.msg);--%>
					   <%--ajsGridPager.init(msg.Pager,gridId,pagerPanelId);--%>
					<%--}else{--%>
						<%--alert("没有返回消息！");--%>
					<%--}--%>
				<%--}, 	  --%>
				<%--error:function (XMLHttpRequest){--%>
					<%--alert("操作失败！");--%>
				<%--}		--%>
			<%--});--%>
		});

		function toReset() {
			$('#frm input').each(function () {
				var frmElement = $(this);
				var propName = frmElement.prop('name');
				var reg = /_op|_like|_min|_max$/;
				if (reg.test(propName)) {
					frmElement.val('');
				}
			});
		}
    </script>
</head>

<body>
	<h3>ajax</h3>
	<form id="frm" name="frm" action="">
		<input type="text" name="p1/_op" id="t1"/>
		<input type="text" name="p2/_like" id="t2"/>
		<input type="text" name="p2/_min" id="t7"/>
		<input type="text" name="p2/_max" id="t8"/>
		<input type="checkbox" id="t3"/>
		<input type="radio" id="t4"/>
		<input type="number" id="t5"/>
		<input type="hidden" id="t6" value="1111"/>
	</form>
	<input type="button" onclick="toReset();" value="清除2"/>
</body>
</html>
