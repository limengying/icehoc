<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>冰场详细信息</title>
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<link rel="stylesheet" href="../../css/part2/bingchangxiangxixinxi.css" />
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
		<!--标题-->
		<div class="top">
			<div onClick="javascript :history.back(-1);" data-ajax="false"
				class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">浇冰必拜</div>
			<div class="筛选"></div>
		</div>

		<div class="logo">
			<img src="${rink.rinkLogo}" />

		</div>

		<div data-role="content" class="all">
			<div class="name">冰场名称：${rink.rinkName}</div>
			<div class="location">位置:${rink.address}</div>
			<div class="tel">场地电话：${rink.telephone}</div>
			<div class="content_div">
				室内/室外:
				<c:if test="${rink.indoor eq true}">室内</c:if>
				<c:if test="${rink.indoor eq false}">室外</c:if>
			</div>
			<div class="content_div">
				有无更衣室:
				<c:if test="${rink.hasLocker eq true}">有</c:if>
				<c:if test="${rink.hasLocker eq false}">无</c:if>
			</div>
			<div class="content_div">
				有无停车场:
				<c:if test="${rink.hasCarpark eq true}">有</c:if>
				<c:if test="${rink.hasCarpark eq false}">无</c:if>
			</div>
			<div class="content_div">冰场训练等级:${rink.trainingDegree}</div>
			<div class="content_div">规模:${rink.scale}人使用</div>
			<div class="content_div">
				有无陆地训练室:
				<c:if test="${rink.hasLandTrainingRoom eq true}">有</c:if>
				<c:if test="${rink.hasLandTrainingRoom eq false}">无</c:if>
			</div>
			<div class="content_div">占地面积:${rink.area}平方米</div>
			<div class="content_div">冰面面积:${rink.iceArea}平方米</div>
			<div class="content_div">建成时间:${rink.completionDate}</div>
			<div class="content_div">投入使用时间：${rink.beginUseDate}</div>
			<div class="content_div">开放时间：${rink.openTime}</div>
			<div class="content_div">
				是否接受散滑：
				<c:if test="${rink.allowedSlip eq true}">是</c:if>
				<c:if test="${rink.allowedSlip eq false}">否</c:if>
			</div>
			<div class="content_div">冰面类型：${rink.iceType}</div>
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

</body>
<script src="../../js/common/common.js"></script>
<script src="../../js/urlApi/api.js"></script>
</html>
