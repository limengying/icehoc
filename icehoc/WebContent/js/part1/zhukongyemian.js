$(document).ready(function() {
	$(".a").click(function() {// 主页面跳转浇冰必拜主页面
		// 请求后台服务
		var data = {
			operateType : "zhukongToJiaoZhu",
		};
		//alert(JSON.stringify(data));
		jump(JIAOBINGBIBAIURL, data);
	});
	$(".b").click(function() {
		var data = {
			operateType : "zhukongToBingTianXueDi",
		};
		//alert(JSON.stringify(data));
		jump(BINGTIANXUEDIURL, data);
		// window.location.href = "../part3/bingtianxuedizhuyemian.jsp";
	});
	$(".c").click(function() {// 主页面跳转到添兵添将主页面
		// 请求后台服务
		var data = {
			operateType : "zhukongToTianBingTianJiang",
		};
		jump(TIANBINGTIANJIANGURL, data);
	});
	$(".d").click(function() {// 主页面跳转兵临城下主页面
		// 请求后台服务
		var data = {
			operateType : "BingLinChengXia",
		};
		jump(BINGLINCHENGXIAURL, data);
	});
	$(".e").click(function() {
		window.location.href = "../part6/bingbuxuerenzhuyemian.jsp";
	});

});