$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击登录
	$(".submitBtn").click(function() {
		var name = $("#name").val();
		var time = $("#time").val();
		var home = $("#home").val();

		if (name == "") {
			alert("请输入名字");
			return false;
		}

		if (time == "") {
			alert("请输入出生年月");
			return false;
		}
		// 请求后台服务
		var data = {
			operateType : "xiugaixinxi",
			name : name,
			birthday : time,
			address : home
		};
		//alert(JSON.stringify(data));
		jump(WODEZHONGXINURL, data);
	});
});