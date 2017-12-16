$(function() {
	$("#imgDom").click(function(e) {
		var pageX = e.pageX, pageY = e.pageY;
		console.log("pageX: " + pageX + "---" + "pageY: " + pageY);
		$("#divChoose").show().css({
			top : pageY,
			left : pageX
		});
	});
	// $("#divChoose").hide();
	$("#shemen").click(function() {
		var data = {
			operateType : "bingmianxuandian",
			type : "shemen"
		};
		//alert(JSON.stringify(data));
		jump(BINGBUXUERENURL, data);
	})

	$("#zhugong").click(function() {
		var data = {
			operateType : "bingmianxuandian",
			type : "zhugong"
		};
		//alert(JSON.stringify(data));
		jump(BINGBUXUERENURL, data);
	})

	$("#fangui").click(function() {
		var data = {
			operateType : "bingmianxuandian",
			type : "fangui"
		};
		//alert(JSON.stringify(data));
		jump(BINGBUXUERENURL, data);
	})

});
