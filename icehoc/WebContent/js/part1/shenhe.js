$(document).ready(function() {
	$(".bingchang").click(function() {
		var data = {
				operateType : "shenheToshenhebingchang",
			};
			// alert(JSON.stringify(data));
			jump(SHENHEBINGCHANGURL, data);
	});
	$(".club").click(function() {
		var data = {
				operateType : "shenheToshenhejulebu",
			};
			// alert(JSON.stringify(data));
			jump(SHENHEJULEBUURL, data);
	});
	$(".xiaodui").click(function() {
		var data = {
				operateType : "schoolTeamAll",
			};
			// alert(JSON.stringify(data));
			jump(SHENHEXIAODUIURL, data);
	});

});