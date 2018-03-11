$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击提交按钮
	$(".submitBtn").click(function() {
		var rinkName = $("#rinkName").val();
		var address = $("#address").val();
		var telephone = $("#telephone").val();
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

		if(rinkName==""){
			alert("请输入冰场名称");
			return false;
		}
		if(address==""){
			alert("请输入冰场地址");
			return false;
		}
		if(telephone==""){
			alert("请输入冰场电话");
			return false;
		}
		if(area==""){
			area=0;
		}
		if(completionDate==""){
			alert("请输入建成时间");
			return false;
		}
		if(beginUseDate==""){
			alert("请输入投入使用时间");
			return false;
		}
		if(openTime==""){
			alert("请输入开放时间");
			return false;
		}
		if(iceArea==""){
			iceArea=0;
		}
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
		//alert(JSON.stringify(data));
		jump(JIAOBINGBIBAIURL, data);
	});
});