<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>搜索或创建球员</title>
<link rel="stylesheet"
	href="../../css/part4/sousuohuochuangjianqiuyuan.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>

</head>

<body>
<body>
	<div data-role="page" class="allpage">
		<div class="top">
			<div onClick="javascript :history.back(-1);" data-ajax="false"
				class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">添兵添将</div>
		</div>


		<div class="content">
			<div data-role="fieldcontain">
				<label for="search" class="text">请输入您想搜索的姓名：</label> 
				<input data-role="" type="search" name="search" id="search" placeholder="">
			</div>

			<div class="search_b">
				<input type="submit" data-role='none' value="搜索" class="submitBtn"
					id="searchbtn"></input>
			</div>

			<div id="new_btn">
				<input type="button" data-role='none' value="创建新球员" class="button1"></input>
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
	<script type="text/javascript"
		src="../../js/part4/sousuohuochuangjianqiuyuan.js"></script>
</body>
</html>