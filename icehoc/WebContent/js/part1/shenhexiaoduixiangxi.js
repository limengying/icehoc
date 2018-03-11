/**
 * 
 */
$("#shenhe").click(function() {
		var data = {
				operateType : "xiaoduitongguo",
				teamId:$("#shenhe").val(),
			};
			// alert(JSON.stringify(data));
			jump(SHENHEXIAODUIURL, data);
	});
$("#bohui").click(function() {
	var data = {
			operateType : "xiaoduibohui",
			teamId:$("#shenhe").val(),
		};
		// alert(JSON.stringify(data));
		jump(SHENHEXIAODUIURL, data);
});