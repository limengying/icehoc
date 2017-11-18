<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>身份选择</title>


<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<link rel="stylesheet" href="../../css/part4/gender.css" />

<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#shoumen").click(function() {
			window.location.href = "handling.jsp";
		});
		$("#qiuyuan").click(function() {
			window.location.href = "handling.jsp";
		});
	});
</script>
</head>

<body>
	<div data-role="page" class="allpage">
		<div class="top">
			<div href="#" onClick="javascript :history.back(-1);"
				data-ajax="false" class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">添兵添将</div>
		</div>


		<div class="text">请选择您的身份</div>


		<div class="gender">
			<div class="left_div">
				<img src="../../img/part4/qiuyuan.png" id="qiuyuan" /> 球员
			</div>

			<div class="right_div">
				<img src="../../img/part4/shoumenyuan.png" id="shoumen" /> 守门员
			</div>
		</div>
		
		<div class="button">
			<div class="shouye" onclick="shouyeClick()">
				<span>首页</span>
			</div>
			<div class="zhanshu" onclick="zhanshuClick()">
				<span>战术</span>
			</div>
			<div class="zhandui" onclick="zhanduiClick()">
				<span>战队</span>
			</div>
			<div class="wode" onclick="wodeClick()">
				<span>我的</span>
			</div>
		</div>

	</div>

	<script src="../../js/common/common.js"></script>
	<script src="../../js/urlApi/api.js"></script>
	<script type="text/javascript" src="../../js/part4/role.js"></script>
</body>
</html>