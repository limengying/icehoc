$(document).ready(function() {
	$(".saishixuanze").click(function(){
		window.location.href = "../../views/part5/binglinchengxiazhuyemian.jsp";
	});
	$(".bingmianxuandian").click(function(){
		window.location.href = "../../views/part6/bingmianxuandian.jsp";
	});
	$(".menjiangjishutongji").click(function(){
		window.location.href = "../../views/part6/menjiangjishutongji.jsp";
	});
	$(".qiuyuanjishutongji").click(function(){
		window.location.href = "../../views/part6/qiuyuanjishutongji.jsp";
	});
	$(".button3").click(function(){
		// 请求后台服务
		var data = {
			operateType : "BingLinChengXia",
		};
		jump(BINGLINCHENGXIAURL, data);
	});
});