<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>搜索结果页面</title>
<link rel="stylesheet"
	href="../../css/part4/tianbingtianjiangzhuyemian.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part4/tianbingtianjiangzhuyemian.css" />
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>

<body>


	<div data-role="page" class="allpage">
		<div class="top">
			<div onClick="javascript :history.back(-1);" data-ajax="false"
				class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">搜索结果</div>
		</div>


		<div data-role="content" class="all">
			<div class="everyone">
				<div class="day"></div>
				<c:choose>
					<c:when test="${player!=null}">
						<div class="team">
							<div class="content_left">
							<input type="hidden" value="${player.playerId}" id="playerId"/>
								<div class="image">
									<img src="${player.image}" />
								</div>
							</div>

							<div class="content_mid">
								<div class="name">姓名:${player.name}</div>
								<div class="sex">
									性别:
									<c:if test="${player.sex eq true}">男</c:if>
									<c:if test="${player.sex eq false}">女</c:if>
								</div>
								<div class="height">身高:${player.height}cm</div>
							</div>
							<div class="content_right">
								<div class="weight">体重:${player.weight}kg</div>
								<div class="countryId">国籍:${country.nameChinese}</div>
								<div class="cityId">城市:${city.cityName}</div>
							</div>
						</div>

					</c:when>
					<c:otherwise>
						<p>不存在该运动员</p>
					</c:otherwise>
				</c:choose>
			</div>
				<div class="guanzhu">
			<input type="button" data-role='none' value="关注" id="guazhu" class="buttonguanzhu" />
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
	<script type="text/javascript" src="../../js/part4/sousuojieguo.js"></script>
</body>
</html>