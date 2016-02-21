<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
	<script type="text/javascript" src="../../js/jquery/jquery-1.8.2.js"></script>
	<script type="text/javascript">
    	$(function (){
			$.ajax({
				type:'POST',
				url:"<%=request.getContextPath()%>/ajax!getAjax.action",
				timeout:5000,
				cache:false,
				async:true,
				dataType:"json",
			    success: function(msg){
					if(null != msg){
					   alert(msg.msg);
					   ajsGridPager.init(msg.Pager,gridId,pagerPanelId);
					}else{
						alert("没有返回消息！");
					}
				}, 	  
				error:function (XMLHttpRequest){
					alert("操作失败！");
				}		
			});
		});
    
    </script>
</head>

<body>
	<h3>ajax</h3>
</body>
</html>
