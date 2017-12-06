function goto1(para1) {
	layer.confirm('你要关注此比赛吗？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var data = {
			operateType : "guanzhuyaoqingsaishi",
			competitionId : para1
		};
		// layer.msg('关注成功！');
		//alert(JSON.stringify(data));
		jump(BINGLINCHENGXIAURL, data);
	}, function() {

	});
}