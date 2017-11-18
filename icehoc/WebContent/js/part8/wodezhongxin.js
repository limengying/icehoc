$(document).ready(function() {
	$(".manger_card").click(function() {
		// 请求后台服务
		var data = {
			operateType : "zhongxinToManager",
		};
		//alert(JSON.stringify(data));
		jump(WODEZHONGXINURL, data);
		// window.location.href = "mangerCard.jsp";
	});
	$(".player_card").click(function() {
		var data = {
				operateType : "zhongxinToPlayer",
			};
		//	alert(JSON.stringify(data));
			jump(WODEZHONGXINURL, data);
		
	});

});