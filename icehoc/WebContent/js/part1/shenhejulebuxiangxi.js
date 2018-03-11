/**
 * 
 */
$("#shenhe").click(function() {
		var data = {
				operateType : "julebutongguo",
				clubId:$("#shenhe").val(),
			};
			// alert(JSON.stringify(data));
			jump(SHENHEJULEBUURL, data);
	});
$("#bohui").click(function() {
	var data = {
			operateType : "julebubohui",
			clubId:$("#shenhe").val(),
		};
		// alert(JSON.stringify(data));
		jump(SHENHEJULEBUURL, data);
});