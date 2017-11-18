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
<title>兵临城下主页面</title>
<link rel="stylesheet"
	href="../../css/part5/binglinchengxiazhuyemian.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />

<style>
.ui-page-theme-a .ui-btn {
	text-decoration: none;
	color: white;
	background-color: rgb(0, 43, 47);
	border-color: rgb(0, 47, 47);
}
</style>


</head>
<body>
	<div data-role="page" class="allpage">
		<!--标题-->
		<div class="top">
			<div onClick="javascript :history.back(-1);" data-ajax="false"
				class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">兵临城下</div>
			<div class="zengjia" >
				<img src="../../img/part5/plus.png" />
			</div>
		</div>

		<!--导航栏-->
		<div class="navbar">
			<div class="yiguanzhu">已关注</div>
			<div class="saishixuanze">赛事选择</div>
		</div>

		<!--导航栏下面内容-->
		<div data-role="content" class="all">
			<c:choose>
				<c:when test="${!empty duiKangs}">
					<c:forEach items="${duiKangs}" var="duiKang" varStatus="st">
						<div class="everyone">
							<div class="day">比赛时间：${duiKang.pkDate}</div>
							<!--年月日时间 -->

							<div class="changdi">比赛场地：${duiKang.rinkName}</div>
							<div class="huanjing">
								环境指数:${duiKang.environmentalIndex}
								<c:choose>
									<c:when test="${!empty duiKang.environmentalIndex}">
										<c:forEach var="s" begin="1"
											end="${duiKang.environmentalIndex}">
											<img src="../../img/part2/star.png" />
										</c:forEach>
									</c:when>
								</c:choose>
							</div>
							<div class="team">
								<div class="content_left">
									<div class="img">
										<img src="${duiKang.clubALogo}" />
									</div>
									<div class="name">${duiKang.clubAName}</div>
								</div>

								<div class="content_mid">
									<div class="">${duiKang.competitionDegreeName}</div>
									<div class="">${duiKang.pkTime}</div>
									<!--时、分时间 -->
									<div class="">第${duiKang.round}轮</div>

								</div>

								<div class="content_right">
									<div class="img">
										<img src="${duiKang.clubBLogo}" />
									</div>
									<div class="name">${duiKang.clubBName}</div>
								</div>
							</div>
						</div>

					</c:forEach>
				</c:when>
				<c:otherwise>
					<P>没有记录</P>
				</c:otherwise>
			</c:choose>
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
<script src="../../js/part5/binglinchengxiazhuyemian.js"></script>
</html>
