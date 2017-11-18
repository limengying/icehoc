$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击提交按钮
	$(".submitBtn").click(function() {
		var rinkName = $("#rinkName").val();
		var address = $("#address").val();
		var telephone = $("#telephone").val();
		var jigou = $("#jigou").val();
		var indoor = $("#indoor").val();
		var hasLocker = $("#hasLocker").val();
		var hasCarparks = $("#hasCarparks").val();
		var trainingDegree = $("#trainingDegree").val();
		var scale = $("#scale").val();
		var hasLandTrainingRoom = $("#hasLandTrainingRoom").val();
		var area = $("#area").val();
		var iceArea = $("#iceArea").val();
		var completionDate = $("#completionDate").val();
		var beginUseDate = $("#beginUseDate").val();
		var openTime = $("#openTime").val();
		var allowedSlip = $("#allowedSlip").val();
		var iceType = $("#iceType").val();

		var data = {
			operateType : "tianjiaRink",
			rinkName : rinkName,
			address : address,
			telephone : telephone,
			indoor : indoor,
			hasLocker : hasLocker,
			hasCarparks : hasCarparks,
			trainingDegree : trainingDegree,
			scale : scale,
			hasLandTrainingRoom : hasLandTrainingRoom,
			area : area,
			iceArea : iceArea,
			completionDate : completionDate,
			beginUseDate : beginUseDate,
			openTime : openTime,
			allowedSlip : allowedSlip,
			iceType : iceType
		};
		alert(JSON.stringify(data));
		jump(JIAOBINGBIBAIURL, data);
	});
});