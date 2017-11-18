$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击提交按钮
	$(".submitBtn").click(function() {
		var competitionName = $("#competitionName").val();
		var competitionConstruction = $("#competitionConstruction").val();

		var data = {
			operateType : "tianjiaCompetition",
			competitionName : competitionName,
			competitionConstruction : competitionConstruction
			
		};
		//alert(JSON.stringify(data));
		jump(BINGTIANXUEDIURL, data);
	});
});