<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>注册页面</title>
<link rel="stylesheet" href="../../css/part1/qitadenglufangshi.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>

<body>
	<div data-role="page" class="allpage">


		<div class="top">
			<div href="#" onClick="javascript :history.back(-1);"
				data-ajax="false" class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">手机号注册</div>
		</div>
		<input type="text" data-role='none' class="phoneNumber"
			placeholder="输入手机号" id="phoneNumber" />
		<div class="yanbtn">
			<input type="text" data-role='none' class="verificationCode"
				placeholder="输入验证码" id="verificationCode" /> <input type="button"
				data-role='none' class="yanzhengma" id="yanzhengma" value="获取验证码">
		</div>
		<div>
			<input type="password" data-role='none' class="newPassword1"
				placeholder="请输入至少8位新密码" id="newPassword" />
		</div>
		<div>
			<input type="password" data-role='none' class="newPassword2"
				placeholder="再次输入密码" id="newPassword" />
		</div>
		<div>
			<input type="submit" data-role='none' value="注册" class="submitBtnone"></input>
		</div>
	</div>

	<script src="../../js/common/common.js"></script>
	<script src="../../js/urlApi/api.js"></script>
	<script src="../../js/part1/zhuceyemian.js"></script>
</body>
</html>