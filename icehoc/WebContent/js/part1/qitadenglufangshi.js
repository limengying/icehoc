$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击登录
	$(".submitBtnone").click(function() {
		var phoneNumber = $("#phoneNumber").val();
		var optType = "login";
		var password = $("#newPassword").val();

		if (phoneNumber == "") {
			alert("请输入手机号码");
			return false;
		}
		if (password.length== "") {
			alert("请输入密码");
			return false;
		}
		// 请求后台服务
		var data = {
			phoneNumber : phoneNumber,
			optType : optType,
			newPassword : password
		};
		//alert(JSON.stringify(data));
		jump(LOGIN_API, data);
	});
});