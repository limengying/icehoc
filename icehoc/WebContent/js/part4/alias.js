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
		var name = $("#name").val();
		var idnum = $("#idnum").val();
		
		if (name == "") {
			alert("请输入您的真实姓名!");
			return false;
		}

		if (idnum == "") {
			alert("请输入您的身份证号!");
			return false;
		}
		$("#formimgupload").append($("#touxiang"));
		$("#formimgupload").hide();
		$("#formimgupload").submit();
	});

});
function callback(content) {
	var name = $("#name").val();
	var idnum = $("#idnum").val();
	// 请求后台服务
	var data = {
		touxiang : content,
		name : name,
		idnum : idnum
	};
	//alert(JSON.stringify(data));
	jump(ALIASURL, data);
}