<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>基本信息修改</title>
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part8/addMangerCard.css" />

<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>

<body>
	<div data-role="page" class="allpage">
		<div class="top">
			<div onClick="javascript :history.back(-1);"
				data-ajax="false" class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">用户信息修改</div>

		</div>


		<div class="content">

			<div class="content_div">
				<div class="content_div_left">真实姓名：</div>
				<div class="content_div_right">
					<input type="text" name="name" class="name" id="name"
						data-role='none' />
				</div>
			</div>

			<div class="content_div">
				<div class="content_div_left">出生日期：</div>
				<div class="content_div_right">
					<input type="date" class="time" id="time" data-role='none' />
				</div>
			</div>



			<div class="content_div">
				<div class="content_div_left">家庭住址：</div>
				<div class="content_div_right">
					<textarea name="errorMain" id="home" class="errorMain"
						placeholder="请简要说明">
               					 </textarea>
				</div>
			</div>

			<input type="button" value="完成" data-role='none' class="submitBtn"
				name="imgupload" id="imgupload" />

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
	<script type="text/javascript" src="../../js/part8/addMangerCard.js"></script>
</body>
</html>