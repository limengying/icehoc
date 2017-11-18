<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>基本信息修改</title>
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part4/jibenxinxixiugai.css" />

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
			<div class="biaoti">基本信息修改</div>

		</div>


		<div data-role="content" class="content">
			<!--上传用户头像-->
			<input type="hidden" value="${player.playerId}" class="playerId" id="playerId"/>
			<form action="">
				<!--头像-->
				<div class="change_image">
					<div>头像修改:</div>
					<div class="uploadImg">
						<input type="file" data-role="none" accept="image/png"
							name="touxiang" class="touxiang" id="touxiang" /> <img
							src="../../img/part4/user-photo.png" class="image" />
					</div>
				</div>

				<!--身高-->

				<div class="content_div">
					<div class="content_div_left">身高：</div>
					<div class="content_div_right">
						<input type="text" name="height" class="height" id="height"
							data-role='none' />
					</div>
				</div>

				<!--体重-->
				<div class="content_div">
					<div class="content_div_left">体重：</div>
					<div class="content_div_right">
						<input type="text" name="weight" class="weight" id="weight"
							data-role='none' />
					</div>
				</div>

				<!--位置-->
				<div class="content_div">
					<div class="content_div_left">位置：</div>
					<div class="content_div_right">
						<select data-role='none' id="position" class="select_div">
							<option class="option">前锋</option>
							<option class="option">后卫</option>
							<option class="option">边锋</option>
							<option class="option">守门</option>
						</select>
					</div>
				</div>

				<!--角色-->
				<div class="content_div">
					<div class="content_div_left">角色：</div>
					<div class="content_div_right">
						<select data-role='none' id="role" class="select_div">
							<c:choose>
								<c:when test="${!empty categories}">
									<c:forEach items="${categories}" var="category" varStatus="st">
										<option class="option" value='${category.categoryId}'>${category.categoryName}</option>
									</c:forEach>
								</c:when>
							</c:choose>
						</select>
					</div>
				</div>

				<!--持杆方式-->
				<div class="content_div">
					<div class="content_div_left">持杆方式：</div>
					<div class="content_div_right">
						<select data-role='none' id="handling" class="select_div">
							<c:choose>
								<c:when test="${!empty handlings}">
									<c:forEach items="${handlings}" var="handling" varStatus="st">
										<option class="option" value='${handling.handlingId}'>${handling.handlingName}</option>
									</c:forEach>
								</c:when>
							</c:choose>
						</select>
					</div>
				</div>



				<div class="content_div">
					<div class="content_div_left">出生日期：</div>
					<div class="content_div_right">
						<input type="date" class="time" placeholder="" id="time"
							data-role='none' />
					</div>
				</div>

				<input type="button" value="保存" data-role='none' class="submitBtn"
					name="imgupload" id="imgupload" />
			</form>

			<form id="formimgupload" action="../../ImageUploadServlet"
				method="post" target="hidden_frame" enctype="multipart/form-data">
			</form>
			<iframe name="hidden_frame" id="hidden_frame" style="display: none;"></iframe>

		

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
	<script type="text/javascript" src="../../js/part4/jibenxinxixiugai.js"></script>
</body>
</html>