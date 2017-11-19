$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击提交按钮
	$(".submitBtn").click(function() {
		var SchoolTeamName = $("#SchoolTeamName").val();
		var buildTime = $("#buildTime").val();
		var schoolTeamConstruction = $("#schoolTeamConstruction").val();

		if (SchoolTeamName == "") {
			alert("请输入校队名称！");
			return false;
		}

		if (buildTime == "") {
			alert("请输入校队建立时间");
			return false;
		}

		var data = {
			operateType : "tianjiaSchoolTeam",
			SchoolTeamName : SchoolTeamName,
			buildTime : buildTime,
			schoolTeamConstruction : schoolTeamConstruction
			
		};
		//alert(JSON.stringify(data));
		jump(BINGTIANXUEDIURL, data);
	});
});