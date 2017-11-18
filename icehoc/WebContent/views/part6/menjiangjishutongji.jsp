<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>门将技术统计</title>
<link rel="stylesheet" href="../../css/part6/menjiangjishutongji.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script>
		(function(doc, win) {
			var docEl = doc.documentElement, resizeEvt = 'orientationchange' in window ? 'orientationchange'
					: 'resize', recalc = function() {
				var clientWidth = docEl.clientWidth;
				if (!clientWidth)
					return;
				docEl.style.fontSize = 16 * (clientWidth / 720) + 'px';
			};

			if (!doc.addEventListener)
				return;
			win.addEventListener(resizeEvt, recalc, false);
			doc.addEventListener('DOMContentLoaded', recalc, false);
		})(document, window);
		</script>
</head>
<body>
	<div data-role="page" class="main">
		<h1 class="head">门将技术统计-待开发</h1>
		<div class="button1" onclick="javascript:history.back(-1);">
			<img src="../../img/part8/back.png" />
		</div>
		<div class="backgroundimage">
			<img src="../../img/part6/imag1.png" height="84%" width="100%"/>
		</div>
		<!--<div id="saishigundong">
			<span>赛事滚动</span>
		</div>
		<div class="button1">
			<div onclick="diyijieClick()">
				<span>第一节</span>
			</div>
			<div onclick="dierjieClick()">
				<span>第二节</span>
			</div>
			<div onclick="disanjieClick()">
				<span>第三节</span>
			</div>
			<div onclick="disijieClick()">
				<span>第四节</span>
			</div>
			<div onclick="diwujieClick()">
				<span>第五节</span>
			</div>
		</div>-->
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
</html>
