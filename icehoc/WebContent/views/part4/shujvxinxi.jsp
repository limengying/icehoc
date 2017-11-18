<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>数据信息</title>
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part4/shujvxinxi.css" />

<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" class="allpage">
		<div class="top">
			<div onClick="javascript :history.back(-1);"
				data-ajax="false" class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">添兵添将</div>
			<div class="jiechubingding">
				<input type="button" data-role='none' value="热图显示"
					class="jiechubangding"></input>
			</div>
		</div>
		<div class="shujv">
			<div class="top_div">
				<div class="top_div_left">
					<div class="image">
						<img src="../../img/part5/a.jpg" />
					</div>
				</div>

				<div class="top_div_right">
					<div class="name">姓名</div>
					<div class="position">位置</div>
					<div class="handlingId">持杆方式</div>
				</div>
			</div>

			<div class="mid_div">
				<div class="">比赛时间</div>
				<div class="">罚时</div>
				<div class="">防守</div>
				<div class="">捡球</div>
				<div class="">传球</div>
				<div class="">射门</div>
			</div>

			<div class="food_div">
				<div class="day">个人数据（最近三场比赛）</div>
				<div class="jinqiu">进球</div>
				<div class="laqiu">拉球</div>
				<div class="chuanqiu">传球</div>
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
</body>
</html>