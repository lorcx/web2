<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<style type="text/css">
		.content{
			width: 400px;
			margin : 0 auto;
			height: 400px;
		
		}
	</style>
  </head>
  
  <body>
   		<table  class="content">
   		
   			<tr>
   				<td>名称 ${locLevel}  </td>
   				<td> 
   				<!-- 
   					<input type="text" name="location.name" id="name" value='<s:property value="location.name"/>'/>
 				 -->
 					 <s:textfield  name="location.name" id="name"  theme="simple"/>
   				</td>
   				<td>英文名称</td>
   				<td> 
   					 <s:textfield   name="location.nameEn" id="nameEn" theme="simple" />
   				</td>
   			</tr>
   			<tr>
   				<td>拼音名称</td>
   				<td>  
   					<s:textfield  name="location.namePinyin" id="namePinyin" theme="simple" />
   				</td>
   				<td>编号</td>
   				<td> 
   					<s:textfield name="location.code" id="code"  theme="simple"/>
   				</td>
   			</tr>
   			<tr>
   				<td>货币</td>
   				<td> 
   					<s:textfield  name="location.currency" id="currency"  theme="simple"/>
   				</td>
   				<td>是否热门</td>
   				<td> 
   					<s:textfield   name="location.favorite" id="favorite"  theme="simple"/>
   				</td>
   			</tr>
   			<tr>
   				<td colspan="2" align="center"><input type="button" value="提交" /></td>
   			</tr>
   		</table>
   			
  </body>
</html>
