
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>审核校队主页面</title>
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<link rel="stylesheet" href="../../css/part3/bingtianxuedizhuyemian.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"
	type="text/javascript"></script>
 
</head>

<body style='overflow: scroll; overflow-x: hidden'>
	<div  data-role="page"  class="allpage">
		<!--标题-->
		<div class="top">
			<div onClick="javascript :history.back(-1);" data-ajax="false"
				class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">审核校队</div>
		</div>


		<div data-role="content" class="all">
			<c:choose>
				<c:when test="${!empty schoolTeams}">
					<c:forEach items="${schoolTeams}" var="schoolTeam" varStatus="st">
						<div class="everyone"
							onclick="goto1('${schoolTeam.teamId}','schoolTeam')" id="schoolTeam">
							<div class="name">${schoolTeam.teamName}</div>
							<div class="content_div">
										是否审核:
										<c:choose>
											<c:when test="${schoolTeam.checkId eq 0}">驳回</c:when>
											<c:when test="${schoolTeam.checkId eq -1}">未审核</c:when>
											<c:otherwise>已审核</c:otherwise>
										</c:choose>
									</div>
							<div class="introduce">成立时间： ${schoolTeam.buildTime}</div>
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
	<script src="../../js/part1/shenhexiaodui.js"></script>
</html>