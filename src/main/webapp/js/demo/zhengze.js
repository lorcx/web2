function yz(){
	var str = $('#str').val();
	var lab = $('#lab');
	if(check(str)){
		lab.text("验证成功");
	}else{
		lab.val("验证失败");
		$('str').focus();
	}
}
//验证
function check(str){
	//创建正则表达式
	var regex = new RegExp("^[1-9]+\d*$");	
	return regex.test(str);
}
//java 中的正则
