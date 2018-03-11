/**
 * 
 */
function goto2(para) {
	var data = {
		operateType : "shenbingTOshenbingxiang",
		rinkId : para,
	};
	//alert(JSON.stringify(data));
	jump(SHENHEBINGCHANGURL, data);
}

//$(".submitBtn").click(function() {
//	// 请求后台服务
//	var searchName = $("#search").val();
//	var data = {
//		operateType : "sousuo",
//		rinkName : searchName,
//	};
//	//alert(JSON.stringify(data));
//	jump(JIAOBINGBIBAIURL, data);
//});
//$(".rinkAddBtn").click(function() {
//	// 请求后台服务
//	// var data = {
//	// operateType : "rinkAddBtn",
//	// };
//	//alert(JSON.stringify(data));
//	//jump(JIAOBINGBIBAIURL, data);
//	window.location.href = "tianjiabingchang.jsp";
//});