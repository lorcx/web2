
var isIE = !!document.all;
function bindSelector(){
	for(var i = 0;i < arguments.length;i++){
		document.getElementById(arguments[i]).onmouseover = function(){
			this.getElementByTagName("ul")[0].style.display = "block";	
		};
		document.getElementById(arguments[i]).onmouseout = function (){
			this.getElementByTagName("ul")[0].style.display = "none";
		};
	}
}
function getStyle(el,name){
	return isIE ? el.currentStyle[name] : window.getComputedStyle(el, null)[name];
}

var curPage = $('#index').attr('value');
var totalPageCount = $(":input[name='page.totalPageCount']").val();
function firstPage(){
	document.searchForm.index.value = "0";
	document.searchForm.submit();
}
function lasgPage(){
	document.searchForm.index.value = totalPageCount;
	document.searchForm.submit();
}
function previousPage(){
	if(curPage > 0){
		document.searchForm.index.value = parseInt(curPage) - 1;
	}
	document.searchForm.submit();
}

function nextPage(){
	if(parseInt(curPage) < parseInt(totalPageCount)){
		document.searchForm.index.value = parseInt(curPage) + 1;
	}
	document.searchForm.submit();
}

function clickPage(index){
	if(parseInt(index) > 0 && parseInt(index) < parseInt(totalPageCount)){
		$('#index').attr("value",index);
	}
	document.searchForm.submit();
}

document.searchForm.onsubmit = function goPage(){
	if(parseInt(totalPageCount) > 0){
		var p = parseInt(document.searchForm.index.value);
		if(isNaN(p) || p < 0 || p > totalPageCount){
			alert("请输入正确的页码");
			return false;
		}else{
			document.searchForm.index.value = p; 
		}
	}else{
		return false;
	}
	
};