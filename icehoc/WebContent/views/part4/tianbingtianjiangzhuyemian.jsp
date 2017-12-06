<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>添兵添将主页面</title>
<link rel="stylesheet" href="../../css/part2/jiaobingbibaizhuyemian.css" />
<link rel="stylesheet"
	href="../../css/part4/tianbingtianjiangzhuyemian.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".submitBtn1").click(function() {
			window.location.href = "sousuohuochuangjianqiuyuan.jsp";
		});

	});
</script>
</head>
<body>
	<div data-role="page" id="pageone" class="allpage">
		<!--标题-->
		<div class="top">
			<div onClick="javascript :history.back(-1);" data-ajax="false"
				class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">添兵添将</div>
		</div>
		<!--查询框-->

		<div class="search_a">
			<div class="search_c">
				<input type="submit" data-role='none' value="添加" class="submitBtn1"></input>
			</div>
			<div class="search_b">
				<input type="text" data-role='none' name="search" id="search"
					class="search" placeholder="输入球员姓名模糊查询">
			</div>
			<div class="search_d">
				<!--搜索之后在当前页面显示  -->
				<input type="submit" data-role='none' value="搜索" class="submitBtn"></input>
			</div>
		</div>
		<div data-role="content" class="all">
			<c:choose>
				<c:when test="${!empty players}">
					<c:forEach items="${players}" var="player" varStatus="st">
						<div class="everyone" onclick="goto1('${player.playerId}')">
							<div class="day">
								<!-- 所属俱乐部 -->
							</div>
							<div class="team">
								<div class="content_left">
									<div class="image">
										<c:if test="${player.sex eq true}">
											<img src="../../img/part4/man.png" />
										</c:if>
										<c:if test="${player.sex eq false}">
											<img src="../../img/part4/lady.png" />
										</c:if>

									</div>
								</div>
								<div class="content_mid">
									<div class="name">姓名:${player.name}</div>

									<div class="height">身高:${player.height}cm</div>

								</div>
								<div class="content_right">
									<div class="sex">
										性别:
										<c:if test="${player.sex eq true}">男</c:if>
										<c:if test="${player.sex eq false}">女</c:if>
									</div>
									<div class="weight">体重:${player.weight}kg</div>

								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<P class="tishi">没有记录</P>
				</c:otherwise>
			</c:choose>
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
	<script src="../../js/common/common.js"></script>
	<script src="../../js/urlApi/api.js"></script>
	<script src="../../js/part4/tianbingtianjiangzhuyemian.js"></script>
</body>
</html>