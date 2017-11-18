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
<title>添加训练赛</title>
<link rel="stylesheet" href="../../css/part5/tianjiaxunliansai.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />

</head>

<body>
	<div data-role="page" class="allpage">
		<div class="top">
			<div href="#" onClick="javascript :history.back(-1);"
				data-ajax="false" class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">兵临城下</div>
		</div>
		<div class="content">
		
			<div class="button3">
				<div class="a">时间:</div>
				<input type="date" class="time" placeholder="" id="time"
					data-role='none' />
			</div>
			
			<div class="button3">
				<div class="a">场地:</div>
				<select data-role='none' class="changdi" placeholder="" id="address">
					<c:choose>
						<c:when test="${!empty rinks}">
							<c:forEach items="${rinks}" var="rink" varStatus="st">
								<option value='${rink.rinkId}'>${rink.rinkName}</option>
							</c:forEach>
						</c:when>
					</c:choose>
				</select>
			</div>
			
			<div class="button4">
				<div class="a">对阵双方:</div>
				<select data-role='none' class="teama" placeholder="" id="clubAName">
				<option value='-1'>--请选择主场俱乐部--</option>
					<c:choose>
						<c:when test="${!empty clubs}">
							<c:forEach items="${clubs}" var="club" varStatus="st">
								<option value='${club.clubId}'>${club.clubName}</option>
							</c:forEach>
						</c:when>
					</c:choose>
				</select>
				<div class="vs">VS</div>
				<select data-role='none' class="teamb" placeholder="" id="clubBName">
				<option value='-1'>--请选择客场俱乐部--</option>
					<c:choose>
						<c:when test="${!empty clubs}">
							<c:forEach items="${clubs}" var="club" varStatus="st">
								<option value='${club.clubId}'>${club.clubName}</option>
							</c:forEach>
						</c:when>
					</c:choose>
				</select>
			</div>
			<div class="button5">
				<div class="a">备注:</div>
				<div>
					<textarea class="beizhu" name="beizhu" id="beizhu">
				</textarea>
				</div>
			</div>
			<div class="queren">
				<input type="submit" data-role='none' value="提交" class="submitBtn"></input>
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

</body>
<script src="../../js/common/common.js"></script>
<script src="../../js/urlApi/api.js"></script>
<script src="../../js/part5/tianjiaxunliansai.js"></script>
</html>