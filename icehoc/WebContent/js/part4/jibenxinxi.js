$(document).ready(function() {

	$(".edit").click(function() {
		var data = {
			operateType : "jibenxinxiToxiugai",
		};
		//alert(JSON.stringify(data));
		jump(TIANBINGTIANJIANGURL, data);
		//window.location.href = "jibenxinxixiugai.jsp";
	});
});
