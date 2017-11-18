<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>添加俱乐部</title>
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part3/addClub.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>

<body style='overflow: scroll; overflow-y: hidden'>
	<div data-role="page" class="allpage">
		<div class="top">
			<div onClick="javascript :history.back(-1);" data-ajax="false"
				class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">添加俱乐部</div>
		</div>
		<div data-role="content" class="content">
			<div class="content_div">
				<div class="content_div_left">名称：</div>
				<div class="content_div_right">
					<input type="text" name="clubName" class="clubName" id="clubName"
						data-role='none' />
				</div>
			</div>
			<div class="content_div">
				<div class="content_div_left">成立时间：</div>
				<div class="content_div_right">
					<input type="date" name="buildTime" class="buildTime"
						id="buildTime" data-role='none' />
				</div>
			</div>
			<div class="content_div">
				<div class="content_div_left">简介：</div>
				<div class="content_div_right">
					<textarea name="errorMain" id="clubConstruction"
						class="clubConstruction" placeholder="请简要说明">
               			 </textarea>
				</div>
			</div>
			<input type="button" value="添加" data-role='none' class="submitBtn"
				name="imgupload" id="imgupload" />
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
	<script type="text/javascript" src="../../js/part3/addClub.js"></script>
</body>
</html>