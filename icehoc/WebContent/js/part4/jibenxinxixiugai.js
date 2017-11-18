/**
 * Created by Administrator on 2017/7/4.
 */
$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击'完成'按钮
	$("#imgupload").click(function() {

		var touxiang = $("#touxiang").val();
		var height = $("#height").val();
		var weight = $("#weight").val();
		var pos = $("#position").val();
		var role = $("#role").val();
		var handling = $("#handling").val();
		var time = $("#time").val();

		$("#formimgupload").append($("#touxiang"));
		$("#formimgupload").hide();
		$("#formimgupload").submit();
	});

});

function callback(content) {
	var playerId = $("#playerId").val();
	var height = $("#height").val();
	var weight = $("#weight").val();
	var position = $("#position").val();
	var category = $("#role").val();
	var handling = $("#handling").val();
	var birthday = $("#time").val();
	// 请求后台服务
	var data = {
		operateType : "tijiaoxiugai",
		playerId : playerId,
		image : content,
		weight : weight,
		height : height,
		position : position,
		categoryId : category,
		handlingId : handling,
		birthday : birthday
	};
	// alert(content.length)
	alert(JSON.stringify(data));
	jump(TIANBINGTIANJIANGURL, data);
}