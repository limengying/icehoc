$(document).ready(function() {
	$(".manger_card").click(function() {
		// 请求后台服务
		var data = {
			operateType : "zhongxinToManager",
		};
		// alert(JSON.stringify(data));
		jump(WODEZHONGXINURL, data);
		// window.location.href = "mangerCard.jsp";
	});
	$(".player_card").click(function() {
		var data = {
			operateType : "zhongxinToPlayer",
		};
		// alert(JSON.stringify(data));
		jump(WODEZHONGXINURL, data);

	});

	// 签到卡片
	$(".qiandao").click(function() {
		var data = {
			operateType : "qiandao",
		};
		jump(WODEZHONGXINURL, data);
	});

});