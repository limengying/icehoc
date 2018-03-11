<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>校队详细信息</title>
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<link rel="stylesheet" href="../../css/part3/club.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"
	type="text/javascript"></script>
</head>


<body>
	<div data-role="page" class="allpage">

		<div class="top">
			<div onClick="javascript :history.back(-1);" data-ajax="false"
				class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">审核校队详细信息</div>
		</div>

		<div data-role="content" class="all">
			<div class="name">球队名：${schoolTeam.teamName}</div>
			<div class="introduce">队长：${schoolTeam.leaderName}</div>
			<div class="introduce">球队地址：${schoolTeam.teamAddress}</div>
			<div class="introduce">成立时间： ${schoolTeam.buildTime}</div>
			<div class="introduce">简介:${schoolTeam.construction}</div>
		</div>
		<button type="button" id="shenhe" value="${schoolTeam.teamId}">通过审核</button>
		<button type="button" id="bohui">驳回</button>

	</div>

</body>
<script src="../../js/common/common.js"></script>
<script src="../../js/urlApi/api.js"></script>
<script src="../../js/part1/shenhexiaoduixiangxi.js"></script>
</html>