<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>审核冰场页面</title>

<link rel="stylesheet" href="../../css/part1/shenhebingchang.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<script type="text/javascript" src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript"
	src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" class="allpage">
		<!--标题-->
		<div class="top">
			<div href="#" onClick="javascript :history.back(-1);"
				data-ajax="false" class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">审核冰场</div>
			<div class="筛选"></div>

		</div>


		<div data-role="content" class="all">
			<c:choose>
				<c:when test="${!empty rinks}">
					<c:forEach items="${rinks}" var="rink" varStatus="st">
						<div class="everyone" onclick="goto2('${rink.rinkId}')">
							<div class="place">
								<div class="content_left">
									<div class="img">
										<img src="${rink.rinkLogo}" />
									</div>

								</div>
								<div class="content_right">
									<div class="day">冰场编号：${rink.rinkId}</div>
									<div class="day">冰场名称：${rink.rinkName}</div>
									<div class="content_div">
										是否审核:
										<c:if test="${rink.checkId eq 1}">已审核</c:if>
										<c:if test="${rink.checkId eq -1}">未审核</c:if>
										<c:if test="${rink.checkId eq 0}">驳回</c:if>
									</div>
									<div class="day">建成日期：${rink.completionDate}</div>
									<div class="huanjing">
										环境指数:${rink.environmentalIndex}
										<c:choose>
											<c:when test="${!empty rink.environmentalIndex}">
												<c:forEach var="s" begin="1"
													end="${rink.environmentalIndex}">

													<img src="../../img/part2/star.png" />
												</c:forEach>
											</c:when>
										</c:choose>
									</div>
									<div class="tel">冰场联系电话:${rink.telephone}</div>
									<div class="name">冰场地理位置:${rink.address}</div>	
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

	</div>



</body>
<script src="../../js/common/common.js"></script>
<script src="../../js/urlApi/api.js"></script>
<script src="../../js/part1/shenhebingchang.js"></script>
<link rel="stylesheet" href="../../css/part1/shenhebingchang.css" />
</html>
