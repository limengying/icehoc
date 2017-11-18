$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击注册
	$(".submitBtnone").click(function() {
		var optType = "register";
		var phoneNumber = $("#phoneNumber").val();		
		var password = $("#newPassword").val();
		var newPassword1 = $(".newPassword1").val();
		var newPassword2 = $(".newPassword2").val();
		if (phoneNumber == "") {
			alert("请输入手机号码");
			return false;
		}
		if (password.length== "") {
			alert("请输入密码");
			return false;
		}
		if (password.length== "") {
			alert("请输入密码");
			return false;
		}
		if (newPassword1!=newPassword2) {
			alert("两次密码不一致");
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