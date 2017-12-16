function goto1(para1) {
	layer.confirm('你要选择此比赛吗？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		// 请求后台服务
		var data = {
			operateType : "shujvcaijixuanzesaishi",
			competitionId : para1
		};
		alert(JSON.stringify(data));
		jump(BINGBUXUERENURL, data);
	}, function() {

	});
}