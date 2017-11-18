/**
 * Created by Administrator on 2017/7/17.
 */
$(function() {
	var sportEvent = null;
	$('#left').on('click', function() {
		sportEvent = "leftHand";
		submit(sportEvent);
	});
	$('#right').on('click', function() {
		sportEvent = "rightHand";
		submit(sportEvent);
	});
	// 提交用户选择的信息
	function submit(sportEvent) {

		var data = {
			handlingValue : sportEvent,
		};
		//alert(JSON.stringify(data));
		jump(HANDLINGURL, data);

	}
});