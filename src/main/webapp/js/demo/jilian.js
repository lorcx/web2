//级联js

	//创建数组
	var cityArray = new Array();
	window.onload = function (){
		cityArray['安徽省'] = ['合肥','宿州','淮北','阜阳','蚌埠','淮南','滁州','马鞍山',
		                '芜湖','铜陵','安庆','黄山','六安','巢湖','池州','宣城','亳州'];
		cityArray['河北'] = ['石家庄','廊坊','秦皇岛','保定','沧州','承德','邯郸','衡水','唐山','邢台','张家口'];
		cityArray['宁夏'] = ['银川','固原','石嘴山','吴忠','中卫'];
		
		var s1 = document.getElementById("s1");
		for(var c in  cityArray){
			//add 如果第二个参数是null则在上一个后面添加
			s1.add(new Option(c),null);
		}
	};

	function cityChange(){
		var s = document.getElementById("s1").value;
		var s2 = document.getElementById("s2");
		s2.options.length = 0;
		for(var c in  cityArray){
			if(c == s){
				for(var c1 in cityArray[c]){
					s2.add(new Option(cityArray[c][c1]),null);
				}
			}
		}
	}