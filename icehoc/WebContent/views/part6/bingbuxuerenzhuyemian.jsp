<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>冰步雪刃主页面</title>
<link rel="stylesheet" href="../../css/part6/bingbuxuerenzhuyemian.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>

<body>
	<div data-role="page" class="main">
		<div class="button1" onclick="javascript:history.back(-1);">
			<img src="../../img/part8/back.png" />
		</div>

		<h1 class="head">冰步雪刃</h1>
		<div class="button2">
			<div id="xunlian" onclick="xunlianClick()">
				<span>训练</span>
			</div>
			<div id="bisai" onclick="bisaiClick()">
				<span>比赛</span>
			</div>
		</div>
		<div class="renyuanxuanze">人员选择</div>
		<div class="renyuan">
			<div class="renyuan1" onclick="renyuan1Click()"></div>
			<div class="renyuan2" onclick="renyuan2Click()"></div>
			<div class="renyuan3" onclick="renyuan3Click()"></div>
			<div class="renyuan4" onclick="renyuan4Click()"></div>
			<div class="renyuan5" onclick="renyuan5Click()"></div>
		</div>
		<div class="button3" onclick="xiayibuClick()">
			<span>下一步</span>
		</div>
		<div class="daikaifa">
<!-- 			<span>未知关联页面入口</span> -->
			<div class="saishixuanze" onclick="saishixuanzeClick()">
<!-- 				<span>数据采集-赛事选择</span> -->
			</div>
			<div class="bingmianxuandian" onclick="bingdianxuanzeClick()">
<!-- 				<span>数据采集-冰点选择</span> -->
			</div>
			<div class="menjiangjishutongji" onclick="menjiangjishutongjiClick()">
				<span>门将技术统计</span>
			</div>
			<div class="qiuyuanjishutongji" onclick="qiuyuanjishutongjiClick()">
				<span>球员技术统计</span>
			</div>
		</div>
		<div class="button">
							<div class="shouye" onclick="shouyeClick()">
								<span class="ch">首页</span>
								<span class="en">	Home</span>
							</div>
							<div  class="zhanshu" onclick="zhanshuClick()">
								<span class="ch">战术</span>
								<span class="en">Tactical</span>
							</div>
							<div  class="zhandui" onclick="zhanduiClick()">
								<span class="ch">战队</span>
								<span class="en">Team</span>
							</div>
							<div class="wode" onclick="wodeClick()">
								<span class="ch">我的</span>
								<span class="en">Mine</span>
							</div>
				   </div>	

	</div>

</body>
<script src="../../js/common/common.js"></script>
<script src="../../js/urlApi/api.js"></script>
<script src="../../js/part6/bingbuxuerenzhuyemian.js"></script>
</html>