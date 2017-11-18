function goto1(searchId, searchType) {
	var operateType = "";
	if (searchType == "club") {
		operateType = "clubToXiangxi";
	} else if (searchType == "competition") {
		operateType = "competitionToXiangxi";
	} else if (searchType == "schoolTeam") {
		operateType = "schoolTeamToXiangxi";
	}
	var data = {
		operateType : operateType,
		searchId : searchId,
	};
	// alert(JSON.stringify(data));

	jump(BINGTIANXUEDIURL, data);
}

$("#clubSubmitBtn").click(function() {
	// 请求后台服务
	var searchName = $("#clubSearch").val();
	var data = {
		operateType : "clubSearch",
		searchString : searchName,
	};
	// alert(JSON.stringify(data));
	jump(BINGTIANXUEDIURL, data);
});

$("#schoolTeamSubmitBtn").click(function() {
	// 请求后台服务
	var searchName = $("#schoolTeamSearch").val();
	var data = {
		operateType : "schoolTeamSearch",
		searchString : searchName,
	};
	// alert(JSON.stringify(data));
	jump(BINGTIANXUEDIURL, data);
});

$("#competitionSubmitBtn").click(function() {
	// 请求后台服务
	var searchName = $("#competitionSearch").val();
	var data = {
		operateType : "competitionSearch",
		searchString : searchName,
	};
	// alert(JSON.stringify(data));
	jump(BINGTIANXUEDIURL, data);
});

$(".club").click(function() {
	var data = {
		operateType : "zhukongToBingTianXueDi",
	};
	// alert(JSON.stringify(data));
	jump(BINGTIANXUEDIURL, data);
});

$(".schoolTeam").click(function() {
	var data = {
		operateType : "schoolTeamAll"
	};
	// alert(JSON.stringify(data));
	jump(BINGTIANXUEDIURL, data);
	// window.location.href = "schoolTeam.jsp";
});

$(".competition").click(function() {
	var data = {
		operateType : "competitionAll"
	};
	// alert(JSON.stringify(data));
	jump(BINGTIANXUEDIURL, data);
	// window.location.href = "bisaiyemian.jsp";
});

$(".clubAddBtn").click(function() {
	var data = {
		operateType : "clubAddBtn"
	};
	// alert(JSON.stringify(data));
	// jump(BINGTIANXUEDIURL, data);
	window.location.href = "addClub.jsp";
});

$(".schoolTeamAddBtn").click(function() {
	var data = {
		operateType : "schoolTeamAddBtn"
	};
	// alert(JSON.stringify(data));
	// jump(BINGTIANXUEDIURL, data);
	window.location.href = "addSchoolTeam.jsp";
});

$(".competitionAddtBtn").click(function() {
	var data = {
		operateType : "competitionAddtBtn"
	};
	// alert(JSON.stringify(data));
	// jump(BINGTIANXUEDIURL, data);
	window.location.href = "addCompetition.jsp";
});