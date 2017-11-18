$(function() {
	// 男生是1，女生是0
	$("#man").click(function() {
		submit('1');
		//window.location.href = "weight.jsp";
	});

	// 性别"lady"击事件
	$("#lady").click(function() {
		submit('0');
		//window.location.href = "weight.jsp";
	});

	// 请求后台服务
	function submit(gender) {
		var data = {
			gender : gender
		};
		alert(JSON.stringify(data));
		jump(GENDERURL, data);
	}
});
