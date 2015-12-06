<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  
  <head>
    <title>ztree </title>
  </head>
  
  <body> 
	  	<div class="content">
	  		<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
	  	</div>
  </body>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/plug_in/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
  <style>
	  
  </style>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/plug_in/ztree/js/jquery.ztree.all-3.5.min.js"></script>
  <script type="text/javascript">
  
  		var nodes;
		var zTree; 
  
		var setting = {
		
			showLine: true,  //显示线
		    isSimpleData : true,  //使用array
		    selectedMulti: false,// 禁止多点同时选中的功能
		    
		    view:{
				addHoverDom:addHoverDom,
				removeHoverDom:removeHoverDom,
				selectedMulti:false
			},
		    
		    data :{
				simpleData : {
					enable : true,
					idKey : "id",
					pidKey : "pid",
					rootPid : -1
				}
			}, 
			
			edit: {
				enable: true,
				//editNameSelectAll:true,
				removeTitle:'删除',
				renameTitle:'重命名'
			},
	
			 async: {
				enable: true,
				url: "${pageContext.request.contextPath}/tree/treeAction!getBaseDate.action",
				autoParam: ["id","pid","name"]
			},
			
		 	callback : {
				onClick : ztreeClick,
				dataFilter: filter,
				asyncSuccess: zTreeOnAsyncSuccess,//异步加载成功的fun
				asyncError : zTreeOnAsyncError, //加载错误的fun 
				beforeClick : beforeClick, //捕获单击节点之前的事件回调函数 
				beforeRemove : beforeRemove//点击删除时触发，用来提示用户是否确定删除
			} 
			
		};
		function addHoverDom(treeId,treeNode){
				var sObj = $("#" + treeNode.tId + "_span");
				if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
				var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
					+ "' title='添加子节点' onfocus='this.blur();'></span>";
				sObj.after(addStr);
				var btn = $("#addBtn_"+treeNode.tId);
				if (btn) btn.bind("click", function(){
					//在这里向后台发送请求保存一个新建的叶子节点，父id为treeNode.id,让后将下面的100+newCount换成返回的id
					//zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"新建节点" + (newCount++)});
					var treeObj = $.fn.zTree.getZTreeObj("tree");
					var pId = 0;
				///	treeObj.addNodes(treeNode,{'id':4800,'pId':156,'name':'新建同级节点'});
					addData(treeNode,treeObj);
					
					/* art.dialog({
					    id: 'testID',
					    content: '您想要添加同级节点还是子节点？',
					    button: [
					        {
					            name: '同级节点',
					            callback: function () {
					            	if(!treeNode.isParent){
					            		art.dialog({
					            			content:'叶子节点不能建立同级节点',
					            			ok:function(){}
					            		});
					            		return;
					            	}
					               var parentNode = treeNode.getParentNode();
					               var pId = 0;
					               if(parentNode != null){
					            	   pId = parentNode.id;
					               }
					               zTree.addNodes(parentNode,{'id':(100+newCount),'pId':pId,'name':'新建同级节点','isParent':true});
					            },
					            focus: true
					        },
					        {
					            name: '子节点',
					            callback: function () {
					            	zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"新建子节点" + (newCount++)});
					            },
					            focus:true
					        },
					        {
					            name: '取消'
					        }
					    ]
					}); */
					return false;
				}); 
	   }
		function removeHoverDom(treeId,treeNode){
			$("#addBtn_"+treeNode.tId).unbind().remove();
		}
  		
  		function zTreeOnAsyncError(event, treeId, treeNode){
			alert("异步加载失败!");
		}
		
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg){
		
		} 
		
  		function filter(){
  		
  		}
  		
  		function beforeRemove(){
  		
  		}
  		
  		function beforeRemove(e,treeId,treeNode){
			return confirm("你确定要删除吗？");
		}
  		
  		function beforeEditName(treeId,treeNode){
		/* if(treeNode.isParent){
			alert("不准编辑非叶子节点！");
			return false;
		} */
			return true;
		}
		function beforeRename(treeId,treeNode,newName,isCancel){
			if(newName.length < 3){
				alert("名称不能少于3个字符！");
				return false;
			}
			return true;
		}
  		
  		function filter(treeId, parentNode, childNodes) {
		/* 	if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace('','');
			}
			return childNodes; */
		} 

		function beforeClick(treeId,treeNode){
			/* if(!treeNode.isParent){
				alert("请选择父节点");
				return false;
			}else{
				return true;
			} */
		} 
  		 
  		//ajax获取数据
  		 function addData(treeNode,treeObj){
		    var parentNode = treeNode.getParentNode();
		    var name = window.prompt("请输入名称");
		    //alert(parentNode.id);
 			var param = {'location.pid' : parentNode.id,'location.name' : name};	
 			$.ajax({
				cache : false,  
 				type : "POST",
 				data : param,
 				url : "${pageContext.request.contextPath}/tree/treeAction!addBaseDate.action",
 				dataType : "json",
 				success : function (data){
 					//if(data){
 					treeObj.addNodes(treeNode,data);
 					// alert(data);
 					//}
 				},
 				error : function (){
 					alert("获取数据失败！");
 				}
 			});
 
  		}  
  		
  		/**
  		 * treeId : 设置要显示的id
  		 * treeNode : 节点
  		 * e : event
  		 */
  		function ztreeClick (e,treeId,treeNode){
	 		 var treeObj = $.fn.zTree.getZTreeObj("tree");
	 		 var sNodes = treeObj.getSelectedNodes();
			 if (sNodes.length > 0) {
				 var level = sNodes[0].level;
				 var tid = sNodes[0].id;
				 
				 window.parent.frames[1].location.href = "${pageContext.request.contextPath}/tree/treeAction!editBaseData.action?tid="+tid+"&level="+level; 
			// 	alert(level);
			//	var isParent = sNodes[0].isParent;
			//	alert(isParent);
			 }
	 		
  		}
  		
  		
	   $(function (){
  		//	getData();
  			var tree = $("#tree"); 
  			$.fn.zTree.init(tree, setting, nodes);
  			var treeObj = $.fn.zTree.getZTreeObj("tree");
  			
  		});
  		
  </script>
</html>
