//$('inputp[name=checkbox]').click(function() {
//	$(this).attr('checked', 'checked').siblings().removeAttr('checked');
//});
var playerId = "";
var competitionType = "";
function goto1(para) {
	playerId = para;
}
function xunlianClick() {
	competitionType = "xunlian";
}
function bisaiClick() {
	competitionType = "bisai";
}
function xiayibuClick() {
	if (competitionType == "") {
		alert("请选择比赛或者训练");
		return false;
	}
	if (playerId == "") {
		alert("请选择一名球员");
		return false;
	}
	// 请求后台服务
	var data = {
		operateType : "xiayibu",
		playerId : playerId,
		competitionType : competitionType
	};
	alert(JSON.stringify(data));
	jump(BINGBUXUERENURL, data);
}
