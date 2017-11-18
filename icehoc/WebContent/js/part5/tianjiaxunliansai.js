$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击登录
	$(".submitBtn").click(function() {
		var time = $("#time").val();
		var address = $("#address").val();
		var clubAName = $("#clubAName").val();
		var clubBName = $("#clubBName").val();
		var beizhu = $("#beizhu").val();

		if (time == "") {
			alert("请选择比赛时间");
			return false;
		}

		if (address == "") {
			alert("请输入比赛场地");
			return false;
		}

		if (clubAName == ""||clubAName==-1) {
			alert("请输入主场俱乐部A");
			return false;
		}

		if (clubBName == ""||clubBName==-1) {
			alert("请输入客场俱乐部B");
			return false;
		}
		if (clubAName==clubBName) {
			alert("主场和客场俱乐部相同");
			return false;
		}
		// 请求后台服务
		var data = {
			operateType : "tijiaolinshisaishi",
			rinkId : address,
			teamAId : clubAName,
			teamBId : clubBName,
			remark : beizhu,
			time : time
		};
		//alert(JSON.stringify(data));
		jump(BINGLINCHENGXIAURL, data);
	});
});