/**
 * 
 */
$("#shenhe").click(function() {
		var data = {
				operateType : "bingchangtongguo",
				rinkId:$("#shenhe").val(),
			};
			 alert(JSON.stringify(data));
			jump(SHENHEBINGCHANGURL, data);
	});
$("#bohui").click(function() {
	var data = {
			operateType : "bingchangbohui",
			rinkId:$("#shenhe").val(),
		};
		 alert(JSON.stringify(data));
		jump(SHENHEBINGCHANGURL, data);
});