<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>身高</title>

	<link rel="stylesheet" href="../../css/part1/allpagesame.css"/>

<link rel="stylesheet" href="../../css/part4/height.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />

<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".back1").click(function() {
			window.location.href = "gender.jsp";
		});
		
	});
</script>
</head>

<body>
	<div data-role="page" class="allpage">		
				<div class="top">	
					 <div onClick="javascript :history.back(-1);" data-ajax="false" class="back">	
                    	<img src="../../img/part1/back.png" />
				    </div>
					<div class="biaoti">
						添兵添将
					</div>
				</div>

			<div class="text">
					我们会根据您的身体资料<br /> 优化您的运动算法
			</div>


			<div class="weight_image" align="center">
				<img src="../../img/part4/manAll.png" />
			</div>
			
			
			<div data-role="fieldcontain" class="fieldcontain">
				<input type="range" name="points" id="points" value="160" min="120"
					max="200" data-popup-enabled="true">
			</div>
			
			

			<div class="height">
				CM
			</div>
			
			
			<div class="btn">
				<div>
					<input type="button" data-role='none'  value="上一步"  class="back1"/>
				</div>
				
				<div>
					<input type="button" data-role='none' value="下一步"class="next" />
				</div>
				
				
				
				
				
				<!--
                	<a href="#" onClick="javascript :history.back(-1);" data-ajax="false" data-role="button" data-corners="true" data-transition="slide" class="back"> <span>上一步</span></a> 
				<a href="#" data-ajax="false" data-role="button"
					data-corners="true" data-transition="slide" class="next"> <span>下一步</span>
				</a>
                -->
				
				
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
	<script src="../../js/part4/height.js"></script>
</body>
</html>