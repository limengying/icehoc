$(document).ready(function() {

	$(".guanzhu").click(function() {
		var playerId = $("#playerId").val();
		var data = {
			operateType : "guanzhuqiuyuan",
			playerId : playerId,
		};
	//	alert(JSON.stringify(data));
		jump(TIANBINGTIANJIANGURL, data);
	});
});