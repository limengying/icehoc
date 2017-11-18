$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});
	$('.next').click(function() { // ---> 注意function为小写
		var weight = $("#points").val();// 滑块的值使用value属性获取。得到weight的值
		submit(weight);
	});

	function submit(weight) {
		var data = {
			weight : weight,
		};
		//alert(JSON.stringify(data));
		jump(WEIGHTURL, data);
		
	}
});
