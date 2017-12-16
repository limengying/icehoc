
$(document).ready(function() {
	$('inputp[name=checkbox]').click(function() {
		$(this).attr('checked', 'checked').siblings().removeAttr('checked');
	});

	$("#next").click(function() {
		// 判断 训练 和 比赛 是否存在
		var bisaiIsCheck = $("#bisai").attr("isCheck");
		var xunlianIsCheck = $("#xunlian").attr("isCheck");
		if (bisaiIsCheck == "" && xunlianIsCheck == "") {
			alert("请选择训练或者比赛!");
			return;
		}

		var checkNum = 0;
		var playerId;
		$(".everyone_div").each(function(index, item) {
			var isImageCheck = $(item).attr("isImageCheck");
			if (isImageCheck == "Y") {
				checkNum++;
				playerId = $(item).attr("playerId");
			}
		})

		if (checkNum != 1) {
			alert("请选择一名运动员!");
			return;
		}

		var type = "1"; // 比赛
		if (xunlianIsCheck == "isCheck") {
			type = "0"; // 训练
		}

		// 请求后台服务
		var data = {
			operateType : "xiayibu",
			playerId : playerId,
			competitionType : type
		};
		//alert(JSON.stringify(data));
		jump(BINGBUXUERENURL, data);
	});

	$(".everyone_div").click(function() {
		var isImageCheck = $(this).attr("isImageCheck");
		if (isImageCheck != undefined && isImageCheck == "Y") {
			$(this).attr("isImageCheck", "");
		} else {
			$(this).attr("isImageCheck", "Y");
			// 将其他 节点不选中
			$(this).siblings().attr("isImageCheck", "");
		}
	})

});

// 提交的参数校验 1. 点击下一步 训练 和 比赛 要存在一个选中
function checkParam() {
	var bisaiIsCheck = ("#bisai").attr("isCheck", "");
	var xunlianIsCheck = $("#xunlian").attr("isCheck");
	if (bisaiIsCheck == "" && xunlianIsCheck == "") {
		return ""
	}
}

// 点击训练 事件
function xunlianClick() {
	// $("#xunlian").addClass("xunlian");
	$("#bisai").css("background", "rgb(100,149,237)")
	$("#bisai").attr("isCheck", "");
	var isCheck = $("#xunlian").attr("isCheck");
	if (isCheck == "isCheck") {
		$("#xunlian").css("background", "rgb(100,149,237)")
		$("#xunlian").attr("isCheck", "");
	} else {
		$("#xunlian").css("background", "yellowgreen")
		$("#xunlian").attr("isCheck", "isCheck");
	}
}

// 点击比赛 事件
function bisaiClick() {
	$("#xunlian").css("background", "rgb(100,149,237)")
	$("#xunlian").attr("isCheck", "");
	var isCheck = $("#bisai").attr("isCheck");
	if (isCheck == "isCheck") {
		$("#bisai").css("background", "rgb(100,149,237)")
		$("#bisai").attr("isCheck", "");
	} else {
		$("#bisai").css("background", "yellowgreen")
		$("#bisai").attr("isCheck", "isCheck");
	}
}
