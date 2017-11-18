/**
 * Created by Administrator on 2017/7/17.
 */
$(function() {

	var sportEvent = null;

	$("#qiuyuan").click(function() {
		// 每个按钮执行的操作
		sportEvent = "QY";
		submit(sportEvent);
	});

	$("#shoumen").click(function() {
		sportEvent = "SM";
		submit(sportEvent);
	});

	
	// 提交用户选择的信息
	function submit(sportEvent) {

		var data = {
			role : sportEvent,
		};
		jump(ROLEURL, data);

	}
});