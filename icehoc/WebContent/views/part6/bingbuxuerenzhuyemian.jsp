<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>冰步雪刃主页面</title>
<link rel="stylesheet" href="../../css/part6/bingbuxuerenzhuyemian.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<body>
	<div data-role="page" class="allpage">
		<!--标题-->
		<div class="top">
			<div onClick="javascript :history.back(-1);" data-ajax="false"
				class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">冰步雪刃</div>
		</div>

		<div class="button2">
			<div id="xunlian" name="button2" onclick="xunlianClick()" isCheck="">
				训练</div>
			<div id="bisai" name="button2" onclick="bisaiClick()" isCheck="">
				比赛</div>
		</div>


		<div class="renyuanxuanze">人员选择</div>

		<div class="renyuan">
			<c:choose>
				<c:when test="${!empty players}">
					<c:forEach items="${players}" var="player" varStatus="st">
						<input type="hidden" value="${player.playerId}" id="playerId" />
						<div class="everyone_div" playerId = "${player.playerId}">
							<div class="image">
								<c:if test="${player.sex eq true}">
									<img src="../../img/part4/man.png" />
								</c:if>
								<c:if test="${player.sex eq false}">
									<img src="../../img/part4/lady.png" />
								</c:if>
							</div>
							<div class="name">${player.name}</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<P class="tishi">没有记录</P>
				</c:otherwise>
			</c:choose>

		</div>
		<div class="button3" id="next">下一步</div>



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
<script src="../../js/part6/bingbuxuerenzhuyemian.js"></script>
</html>