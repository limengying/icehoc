<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<div class="name">球队名：${team.teamName}南航冰球队</div>
			<div class="introduce">队长：${team.leaderName}小明</div>
			<div class="introduce">球队地址：${team.teamAddress}江苏省南京市</div>
			<div class="introduce">成立时间： ${team.buildTime}2018年2月11日</div>
			<div class="introduce">简介:${team.construction}1954年齐齐哈尔冰球队正式成立，参加每年的全国比赛，并逐渐成为国家的主力。以齐齐哈尔市队员为主的国家冰球队分别获得第一届、第二届亚冬会冠军；并代表中国7次打入世界锦标赛B组；齐齐哈尔先后为国家输入冰球队员500余人次。1956年，中国冰球队开始参加国际比赛</div>
		</div>
		<c:if test="${team.checkId eq -1}">
			<button type="button" id="shenhe" value="${team.teamId}">通过审核</button>
			<button type="button" id="bohui">驳回</button>
		</c:if>

	</div>

</body>
<script src="../../js/common/common.js"></script>
<script src="../../js/urlApi/api.js"></script>
<script src="../../js/part1/shenhexiaoduixiangxi.js"></script>
</html>