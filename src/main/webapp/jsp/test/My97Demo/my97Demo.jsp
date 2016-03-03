<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>my97Demo学习</title>
    <style type="text/css">
    	*{margin:0;padding: 0}
    	.container{width:500px;margin:0 auto;}
    </style>
  </head>
  
  <body>
	 <div class="container" >
	  	<!-- 1.除了支持常规在input单击或获得焦点调用外,还支持使用其他的元素如:<img><div>等触发WdatePicker函数来调用弹出日期框 
	  		 2.可以使用 onfocus 和 onclick触发事件
	  		 如果el的值是this,可省略,即所有的el:this都可以不写
			日期框设置为disabled时,禁止更改日期(不弹出选择框)
			如果没有定义onpicked事件,自动触发文本框的onchange事件
			如果没有定义oncleared事件,清空时,自动触发onchange事件
			
			设置readOnly属性,可指定日期框是否只读
			设置highLineWeekDay属性,可指定是否高亮周末
			设置isShowOthers属性,可指定是否显示其他月的日期
			加上class="Wdate"就会在选择框右边出现日期图标
	  	-->
	  	
	  	
	  	<!-- 1常规调用 -->
	  	常规调用 :
	   	<input id="d11" type="text" onClick="WdatePicker()"/><br/>
	   	
	   	
	   	<!-- 2图标触发 -->
	   	图标触发:
	   	<div >
		   	<input id="d12" type="text" />
		   	<img  onclick="WdatePicker({el:'d12'})" alt="absmiddle" width="16" height="25" src="../../My97DatePickerBeta/My97DatePicker/skin/datePicker.gif">
	   	</div>
	   	
	   	
	   	<!-- 3周显示 -->
	   	周显示:
	   	<input id="d13" type="text" onClick="WdatePicker({isShowWeek:true})"/>
	   	<br/>
	   	
	   	<!-- 4：将周显示给另一个文本框 -->
	   	将周显示给另一个文本框：
	   	<input type="text" class="Wdate" id="d122" onFocus="WdatePicker({isShowWeek:true,onpicked:function() {$dp.$('d122_1').value=$dp.cal.getP('W','W');$dp.$('d122_2').value=$dp.cal.getP('W','WW');}})"/>
	   	今天是第<input type="text" id="d122_1" style="width:30px"/>周<input type="text" id="d122_2" style="width:30px"/>
	   	<br/>
	   	
	    <!-- 5：只读开关和高亮显周末  -->
	   	只读开关和高亮显周末 ：
	   	<input type="text" class="Wdate" onfocus="WdatePicker({readOnly:true,highLineWeekDay:true,isShowWeek:true})"/>
	   	<br/>
	   	<!-- 6:操作按钮自定义  -->
	   	操作按钮自定义 :如隐藏清空按钮
	   	<input type="text" class="Wdate" onfocus="WdatePicker({isShowClear:false,readOnly:true})"/>
	   	<br/>
	   	
	   	
	   	<!-- 7:自定义弹出位置  -->
	   	自定义弹出位置 
	   	<input class="Wdate" type="text" id="d16" onfocus="WdatePicker({position:{left:200,top:300}})"/>
	    <br/>
	    
	    <!-- 8:自定义星期的第一天  -->
	          自定义星期的第一天:如让周一为第一天
	    <input class="Wdate" type="text" id="d17" onfocus="WdatePicker({firstDayOfWeek:1})"/>
	    <br/>
	    
	    <!-- 9:平面显示  -->
	    <div id="div1"></div>
	    <br/>
	    
	    <!-- 10:支持多种容器   -->
	   	 支持多种容器 :
	    <span id="demospan">2008-01-01</span> 
	    <img onClick="WdatePicker({el:'demospan'})" width="16" height="22"  style="cursor:pointer"   src="../../My97DatePickerBeta/My97DatePicker/skin/datePicker.gif" />
	 	<br/>
	 	
	 	
	 	 <!-- 11:起始日期   -->
	 	  起始日期:
	 	 <input type="text" id="d221" onFocus="WdatePicker({startDate:'1999-05-01'})"/>
	 	 <br/>
	 	 <!-- 文本框中的日期是任何时，都为开始日期 -->
	 	 alwaysUseStartDate属性应用:
	 	 <input type="text" id="d223" onFocus="WdatePicker({startDate:'1999-05-01',alwaysUseStartDate:true})"/>
	 	 <br/>
	 	 
	 	 
		<!-- 12:内置参数  -->
	 	年月日使用当年当月的1日,时分秒使用00:00:00作为起始时间:
	 	<input type="text" id="d224" onFocus="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})"/>
	    <br/>
	 	
	 	
	 	<!-- 13:显示时分秒  -->
	 	显示时分秒 ：
	 	<input type="text" id="d241" onfocus="WdatePicker({dateFmt:'yyyy年-MM月-dd日  HH时:mm分:ss秒'})"/>
	 	<br/>
	 	
	 	时分秒+皮肤修改:
	 	<input type="text" id="d234" onfocus="WdatePicker({skin:'default',dateFmt:'H:mm:ss'})" class="Wdate"/>
	 	<br/>
	 	
	 	年月日+皮肤修改:
	 	<input type="text" id="d243" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月'})" class="Wdate"/>
	 	<br/>
	 	
	 	<!-- 13:获取系统识别的日期值  -->
	 	获取系统识别的日期值   vel指向 hidden控件：
	 	<br/>
	 	<input id="d244" type="text" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy年MM月',vel:'d244_2'})" />
	 	<input id="d244_2" type="text" />
	 	<br/>
	 	
	 	<!-- 14:星期, 月 日, 年(4.6新增) -->
	 	星期, 月 日, 年(4.6新增)
	 	<input type="text" id="d245" onfocus="WdatePicker({dateFmt:'DD, MMMM d, yyyy'})" class="Wdate"/>
	 	<br/>
	 	
	 	<!-- 15:双月日期功能 -->
	 	双月日期功能 :
	 	<input class="Wdate" type="text" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd'})"/>
	 	<br/>
	 	
	 	
	 	<!-- 16:自动纠错模式 errDealMode = 1 在输入错误日期时,自动恢复前一次正确的值-->
	 	自动纠错模式 errDealMode = 1 在输入错误日期时,自动恢复前一次正确的值:
	 	<br/>
	 	<input class="Wdate" type="text" onfocus="WdatePicker({errDealMode:1})"/>
	 	<br/>
	 	
	 	<!-- 17:民国年演示-->
	 	民国年演示
	 	<input class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyy/MM/dd'})"/>
	 	
	 	
	 	<!-- 18:多语言   默认情况lang='auto',即根据浏览器的语言自动选择语言.-->
	 	多语言:
	 	<br/>
	 	繁体中文
	 	<input class="Wdate" type="text" onfocus="WdatePicker({lang:'zh-tw'})"/>
	 	<br/>
	 	英文
	 	<input class="Wdate" type="text" onfocus="WdatePicker({lang:'en'})"/>
	 	简体中文:
	 	<input class="Wdate" type="text" onfocus="WdatePicker({lang:'cn'})"/>
	 	<br/>
	 	
	 	<!-- 19:皮肤-->
	 	皮肤:
	 	<input class="Wdate" type="text" onfocus="WdatePicker({skin:'ext'})"/>
	 	<br/>
	 	
	 	
	 	
	 	<!-- 20:日期范围限制-->
	 	<!-- 日期范围限制-->	 	
	 	 静态限制:
	 	<input class="Wdate" type="text" onfocus="WdatePicker({skin:'ext',minDate:'2001-01-01',maxDate:'2015-03-07'})"/>
	 	<br/>
	 	限制日期的范围:
	 	<input type="text" class="Wdate" id="d412" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'2008-03-08 11:30:00',maxDate:'2008-03-10 20:59:30'})" value="2008-03-09 11:00:00"/>
	 	<br/>
	 	动态限制:
	 	<input id="d421" class="Wdate" type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"/>
	 	<br/>
	 	使用运算表达式，只能选择今天以后的
	 	<input id="d422" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d+1}'})"/>
	 	<br/>
	 	只能选择本月的日期1号至本月最后一天
	 	<input id="d422" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-03',maxDate:'%y-%M-%ld'})"/>
	 	<br/>
	 	只能选择今天7:00:00至明天21:00:00的日期
	 	<input id="d422" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d 07:00:00',maxDate:'%y-%M-{%d+1} 21:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
	 	<br/>
	 	只能选择 20小时前 至 30小时后 的日期
	 	<input id="d422" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d {%H-20}:%m:%s',maxDate:'%y-%M-%d {%H+30}:%m:%s',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
	 	<br/>
	 	
	 	
 		<!-- 脚本自定义限制
 		#F{$dp.$D(\'d4312\')||\'2020-10-01\'} 表示当 d4312 为空时, 采用 2020-10-01 的值作为最大值
 		-->
	 	脚本自定义限制:
	 	<br/>
	 	合同的有效期为:
	 	<input id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2015-01-01\'}'})"/>
	 	<input id="d4312" class="Wdate" type="text" onFocus="WdatePicker({mixDate:'#F{$dp.$D(\'d4311\')}'})"/>
	 	<br/>
	 	 前面的日期+3天 不能大于 后面的日期：
	 	<input id="d123" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d234\'),{%d:-3};}'})"/>
	 	<input id="d234" class="Wdate" type="text" onFocus="WdatePicker({mixDate:'#F{$dp.$D(\'d123\'),{%d:+3};}'})"/>
	 	<br/>
	 	
	 	前面的日期+3月零2天 不能大于 后面的日期 且 前面日期都不能大于 2020-4-3减去3月零2天 后面日期 不能大于 2020-4-3
	 	<input type="text" class="Wdate" id="d4331" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4332\',{M:-3,d:-2})||$dp.$DV(\'2020-4-3\',{M:-3,d:-2})}'})"/>
		<input type="text" class="Wdate" id="d4332" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4331\',{M:3,d:2});}',maxDate:'2020-4-3'})"/>
	 	<br/>
	 	
	 	
	 	定义任何你想要的日期限制
	 	<input type="text" class="Wdate" id="1234" onFocus="var date = randomDate();WdatePicker({maxDate:date+1,minDate:date})"/>
	 	<br/>
	 	
	 	禁用 周六 所对应的日期
	 	<input type="text" class="Wdate"  onFocus="WdatePicker({disabledDays:[0]})"/>
	 	<br/>
	 	禁用 周六 周日 所对应的日期
	 	<input type="text" class="Wdate"  onFocus="WdatePicker({disabledDays:[0,6]})"/>
	 	<br/>
	 	
	 	无效日期:禁用 每个月份的 5日 15日 25日
	 	<!-- 
		 	用法(正则匹配):
			如果你熟悉正则表达式,会很容易理解下面的匹配用法
			如果不熟悉,可以参考下面的常用示例
			['2008-02-01','2008-02-29'] 表示禁用 2008-02-01 和 2008-02-29
			['2008-..-01','2008-02-29'] 表示禁用 2008-所有月份-01 和 2008-02-29
			['200[0-8]]-02-01','2008-02-29'] 表示禁用 [2000至2008]-02-01 和 2008-02-29
			['^2006'] 表示禁用 2006年的所有日期
			
			此外,您还可以使用 %y %M %d %H %m %s 等变量, 用法同动态日期限制 注意:%ld不能使用
			['....-..-01','%y-%M-%d'] 表示禁用 所有年份和所有月份的第一天和今天
			['%y-%M-{%d-1}','%y-%M-{%d+1}'] 表示禁用 昨天和明天
			
			当然,除了可以限制日期以外,您还可以限制时间
			['....-..-.. 10\:00\:00'] 表示禁用 每天10点 (注意 : 需要 使用 \: ) 
	 	 -->
	 	<input type="text" class="Wdate"  onFocus="WdatePicker({disabledDates:['5$']})"/>
	 	<br/>
	 	
	 	禁用 所有早于2000-01-01的日期
	 	<input id="d452" type="text" class="Wdate" onFocus="WdatePicker({disabledDates:['^19']})"/>
	 	<br/>
	 	
	 	配合min/maxDate使用,可以把可选择的日期分隔成多段
	 	<input id="d453" type="text" class="Wdate" onFocus="WdatePicker({minDate:'%y-%M-01',maxDate:'%y-%M-%ld',disabledDates:['0[4-7]$','1[1-5]$','2[58]$']})"/>
	 	<br/>
	 	
	 	
	 	min/maxDate disabledDays disabledDates 配合使用 即使在要求非常苛刻的情况下也能满足需求
	 	<input id="d454" type="text" class="Wdate" onFocus="WdatePicker({minDate:'%y-%M-01',maxDate:'%y-%M-%ld',disabledDates:['0[4-7]$','1[1-5]$','2[58]$'],disabledDays:[1,3,6]})"/>
	 	<br/>
	 	
	 	
	 	 #F{}也是可以使用的
	 	<input id="d454" type="text" class="Wdate" onFocus="WdatePicker({dateFmt:'HH:mm:ss',disabledDates:'#F{randomH()}'})"/>
	 	<br/>
	 	
	 	有效日期
	 	<input id="d46" type="text" class="Wdate" onFocus="WdatePicker({opposite:true,disabledDates:['5$']})"/>
	 	<br/>
	 	
	 	
	 	特殊天和特殊日期
	 	<br/>
	 	高亮每周 周一 周五
		<input id="d471" type="text" class="Wdate" onFocus="WdatePicker({specialDays:[1,5]})"/> 
	 	<br/>
	 	 高亮每月 1号 15号
	 	<input id="d473" type="text" class="Wdate" onFocus="WdatePicker({specialDates:['....-..-01','....-..-15']})"/> 
	 	<br/>
	 	
	 	
	 	
	 	自定义事件
	 	 <!-- 
	 		this: 指向文本框
			dp: 指向$dp
			dp.cal: 指向日期控件对象
	 	 -->
	 	 
	 	 onpicking 和 onpicked 事件
	 	 <br/>
	 	 <input type="text" id="5421" onFocus="WdatePicker({onpicking:function(dp){if(!confirm('日期框原来的值为:'+dp.cal.getDateStr()+', 要用新选择的值:'+ dp.cal.getNewDateStr() +'覆盖吗?')){return false;}}})"/>
	 	  使用onpicked实现日期选择联动
	 	 <br/>
	 	 
	 	 
	 	 使用onpicked实现日期选择联动
		 <!-- 注意:$dp.$是一个内置函数,相当于document.getElementById -->
	 	 <br/>
	 	 <input id="d5221" class="Wdate" type="text" onFocus="var d5222=$dp.$('d5222');WdatePicker({onpicked:function(){d5222.focus();}, maxDate:'#F{$dp.$D(\'d5222\')}'})"/>
	 	 <input id="d5222" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d5221\')}'})"/>
	 	 <br/>
	 	 
	 	 
	 	 
	 	 将选择的值拆分到文本框 
	 	<input type="text" id="d523_y" size="5"/> 年
		<input type="text" id="d523_M" size="3"/> 月
		<input type="text" id="d523_d" size="3"/> 日
		<input type="text" id="d523_HH" size="3"/> 时
		<input type="text" id="d523_mm" size="3"/> 分
		<input type="text" id="d523_ss" size="3"/> 秒
		<input type="text" id="d523" />
	 	<img onclick="WdatePicker({el:'d523',dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked:pickedFunc})" src="../../My97DatePickerBeta/My97DatePicker/skin/datePicker.gif"/>
	 	 <br/>
	 	
	 	
	 	使用onclearing事件取消清空操作
	 	<input type="text" class="Wdate" id="d531" onFocus="WdatePicker({onclearing:function(){if(!confirm('日期框的值为:'+this.value+', 确实要清空吗?'))return true;}})"/>
	 	<br/>
	 	
	 	
	 	使用cal对象取得当前日期所选择的月份(使用了 dp.cal)
	 	<input type="text" class="Wdate" id="d532" onFocus="WdatePicker({oncleared:function(dp){alert('当前日期所选择的月份为:'+dp.cal.date.M);}})"/>
	 	<br/>
	 	
	 	
	 	
	 	综合使用两个事件
	 	<input type="text" class="Wdate" id="d533" onFocus="d533_focus(this)"/>
	 	<br/>
	  </div>	
  </body>
  <!-- 引入该js库 -->
  <script type="text/javascript" src="../../../plug_in/My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript">
  	WdatePicker({eCont:'div1',onpicked:function(dp){
  					alert('您选择的日期是：'+dp.cal.getDateStr());
  				}});
  				
  				
  	//返回一个随机的日期
	function randomDate(){
		var Y = 2000 + Math.round(Math.random() * 10);
		var M = 1 + Math.round(Math.random() * 11);
		var D = 1 + Math.round(Math.random() * 27);
		return Y+'-'+M+'-'+D;
	}			
  				
    //返回一个随机时间
    function randomH(){
    	//随机23个数
    	var H = Math.round(Math.random()*23);//round四舍五入
    	if(H < 10){
    		H = "0"+H;
    	}
    	return H;
    }
    // 将选择的值拆分到文本框   $dp.$是一个内置函数,相当于document.getElementById 
    function pickedFunc(){
    	$dp.$('d523_y').value == $dp.cal.getP("y");
    	$dp.$('d523_M').value == $dp.cal.getP("M");
    	$dp.$('d523_d').value == $dp.cal.getP("d");
    	$dp.$('d523_HH').value == $dp.cal.getP("H");
    	$dp.$('d523_mm').value == $dp.cal.getP("m");
    	$dp.$('d523_ss').value == $dp.cal.getP("s");
    	
    	
    }
    function d533_focus(element){
		var clearingFunc = function(){ if(!confirm('日期框的值为:'+this.value+', 确实要清空吗?')) return true; };//清空前
		var clearedFunc = function(){ alert('日期框已被清空'); };//清空后
		WdatePicker({el:element,onclearing:clearingFunc,oncleared:clearedFunc});
	}
    
  </script>
</html>
