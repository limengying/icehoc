<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />

<title>球员卡片</title>

<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />

<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<link rel="stylesheet" href="../../css/part8/playerCard.css" />

<script type="text/javascript">
	$(document).ready(function() {
		$(".").click(function() {
			window.location.href = "";
		});
		$(".").click(function() {
			window.location.href = "";
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
			<div class="biaoti">球员卡片</div>
		</div>

		<div data-role="content" class="all">
			<c:choose>
				<c:when test="${!empty players}">
					<c:forEach items="${players}" var="player" varStatus="st">
						<div class="everyone" onclick="goto1('${player.playerId}')">
							<div class="day">所属俱乐部：</div>
							<div class="team">
								<div class="content_left">
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
									<div class="height">身高:${player.height}</div>
								</div>

								<div class="content_right">
									<div class="weight">体重:${player.weight}</div>
									<div class="countryId">国籍:${player.countryId}</div>
									<div class="cityId">城市:${player.cityId}</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
			</c:choose>
		</div>
		<div class="button">
			<div class="shouye" onclick="shouyeClick()">
				<span class="ch">首页</span>
			</div>
			<div class="zhanshu" onclick="zhanshuClick()">
				<span class="ch">战术</span>
			</div>
			<div class="zhandui" onclick="zhanduiClick()">
				<span class="ch">战队</span>
			</div>
			<div class="wode" onclick="wodeClick()">
				<span class="ch">我的</span>
			</div>
		</div>
	</div>
	<script src="../../js/common/common.js"></script>
	<script src="../../js/urlApi/api.js"></script>
</body>
</html>