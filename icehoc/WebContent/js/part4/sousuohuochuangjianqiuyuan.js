
	$(document).ready(function() {
		$("#searchbtn").click(function() {
			var searchName = $("#search").val();
			if (searchName == "") {
				alert("请输入完整的球员名");
				return false;
			}
			var data = {
				operateType : "jingquesousuo",//精确搜索
				playerName : searchName,
			};
			//alert(JSON.stringify(data));
			jump(TIANBINGTIANJIANGURL, data);
		});
		$("#new_btn").click(function() {
			window.location.href = "gender.jsp";
		});

	});