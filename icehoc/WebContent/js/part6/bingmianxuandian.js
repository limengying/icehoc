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
		   layer.confirm('你将选择添加一次助攻', {
            btn: ['确定','取消'] //按钮
        }, function(){
        	var playerId = $(".playerId").val();
			var data = {
			operateType : "bingmianxuandian",
			type : "zhugong"
		};
		//alert(JSON.stringify(data));
		jump(BINGBUXUERENURL, data);
			
        }, function(){
            
        });	
	})
	
	$("#fangui").click(function() {
		   layer.confirm('你将选择添加一次犯规', {
            btn: ['确定','取消'] //按钮
        }, function(){
        	var playerId = $(".playerId").val();
			var data = {
			operateType : "bingmianxuandian",
			type : "fangui"
		};
		//alert(JSON.stringify(data));
		jump(BINGBUXUERENURL, data);
			
        }, function(){
            
        });	
	})


});
