/**
 * 20170920bylmy
 */
function goto1(para) {
	var data = {
		operateType : "zhuyemianToXiangxi",
		playerId : para,
	};
	// alert(JSON.stringify(data));
	jump(TIANBINGTIANJIANGURL, data);
}

$(".submitBtn").click(function() {
	// 搜索当前页面
	var searchName = $("#search").val();
	var data = {
		operateType : "mohusousuo",
		playerName : searchName,
	};
//	alert(JSON.stringify(data));
	jump(TIANBINGTIANJIANGURL, data);
});
