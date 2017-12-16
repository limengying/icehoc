$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	$(".backButton").click(function() {
		// jump(, data);
	})

	$(".nextButton").click(function() {
		var bingqiurushefangwei = $("#bingqiurushefangwei").val();
		var menjiangyidong = $("#menjiangyidong").val();
		var qiuyuanjingong = $("#qiuyuanjingong").val();
		var zhengganfangan = $("#zhengganfangan").val();
		var bisaijieduan = $("#bisaijieduan").val();
		var jinqiushifou = $("#jinqiushifou").val();

		if (bingqiurushefangwei == "") {
			alert("请选择冰球入射方位");
			return false;
		}

		if (menjiangyidong == "") {
			alert("请选择门将移动方式");
			return false;
		}

		if (qiuyuanjingong == "") {
			alert("请选择球员进攻方式");
			return false;
		}

		if (zhengganfangan == "") {
			alert("请选择正杆反杆");
			return false;
		}
		if (bisaijieduan == "") {
			alert("请选择比赛阶段");
			return false;
		}
		if (jinqiushifou == "") {
			alert("请选择进球是否");
			return false;
		}

		var data = {
			operateType : "",
			bingqiurushefangwei : bingqiurushefangwei,
			menjiangyidong : menjiangyidong,
			qiuyuanjingong : qiuyuanjingong,
			zhengganfangan : zhengganfangan,
			bisaijieduan : bisaijieduan,
			jinqiushifou : jinqiushifou
		};
		alert(JSON.stringify(data));
		// jump(, data);
	});
});