$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击提交按钮
	$(".submitBtn").click(function() {
		var clubName = $("#clubName").val();
		var buildTime = $("#buildTime").val();
		var clubConstruction = $("#clubConstruction").val();

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