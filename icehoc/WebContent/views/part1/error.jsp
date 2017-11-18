<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>登录遇到的问题</title>
<link rel="stylesheet" href="../../css/part1/error.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part1/.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />


</head>

<body>
	<div data-role="page" class="allpage">
		<div class="top">
			<div href="#" onClick="javascript :history.back(-1);"
				data-ajax="false" class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">登录遇到的问题:</div>
		</div>

		<div class="content">
			<div>请选择遇到的问题</div>


			<input type="radio" name="error" class="error">
			<div>无登录记录</div>
			</input> <input type="radio" name="error" class="error">
			<div>手机收不到验证码</div>
			</input> <input type="radio" name="error" class="error">
			<div>其他注册或问题</div>
			</input>

		</div>

		<div class="content1">
			<textarea name="errorMain" id="" class="errorMain"
				placeholder="请简要说明">
                </textarea>

			<div class="phone">
				<input type="text" placeholder="你的联系方式：手机号或邮箱">
			</div>

			<input type="button" value="提交" class="submitBtn" data-role="none" />

		</div>
</body>
<script src="../../js/common/common.js"></script>
<script src="../../js/urlApi/api.js"></script>
<script src="../../js/part5/tianjiaxunliansai.js"></script>
</html>