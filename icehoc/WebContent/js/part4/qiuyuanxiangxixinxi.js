/**
 * Created by Administrator on 2017/7/4.
 */
$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});
	$(".jiechubangding").click(function() {
		// 搜索当前页面
		var se = confirm("你确认要解除绑定吗!");
		if (se == true) {
			alert("你按下的是【确认】");
			var playerId = $(".playerId").val();
			var data = {
				operateType : "quxiaoguanzhu",
				playerId : playerId,
			};
		//	alert(JSON.stringify(data));
			jump(TIANBINGTIANJIANGURL, data);
		} else {
			alert("你按下的是【取消】");
		}

	});
	$(".jiben").click(function() {
		var playerId = $(".playerId").val();
		var data = {
			operateType : "jibexinxi",
			playerId : playerId,
		};
		//alert(JSON.stringify(data));
		jump(TIANBINGTIANJIANGURL, data);
		//window.location.href = "jibenxinxi.jsp";
	});

	$(".shujv").click(function() {
		window.location.href = "shujvxinxi.jsp";
	});
});
