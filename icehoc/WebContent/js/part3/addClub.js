$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击提交按钮
	$(".submitBtn").click(function() {
		var clubName = $("#clubName").val();
		var buildTime = $("#buildTime").val();
		var clubConstruction = $("#clubConstruction").val();
	
		if (clubName == "") {
			alert("请输入俱乐部名称！");
			return false;
		}

		if (buildTime == "") {
			alert("请输入俱乐部建立时间");
			return false;
		}
		var data = {
			operateType : "tianjiaClub",
			clubName : clubName,
			buildTime : buildTime,
			clubConstruction : clubConstruction
			
		};
		//alert(JSON.stringify(data));
		jump(BINGTIANXUEDIURL, data);
	});
});