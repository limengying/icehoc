<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>身份选择</title>


<link rel="stylesheet" href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part1/allpagesame.css"/>
<link rel="stylesheet" href="../../css/part4/gender.css" />

<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>

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
					请告诉我们您的用杆习惯
			</div>


			<div class="gender">
				<div class="left_div">
					<img src="../../img/part4/qiuyuan.png" id="left" /> 右手杆
				</div>

				<div class="right_div">
					<img src="../../img/part4/shoumenyuan.png" id="right" /> 左手杆
				</div>
			</div>

<!--
	<div class="chiganfangshi_bottom">
				<div class="chiganfangshi_left">
					<div>
						<img src="../../img/part4/zuoshougan.png" id="left" /> <span>左手杆</span>
					</div>
				</div>
				<div class="chiganfangshi_right">
					<div>
						<img src="../../img/part4/youshougan.png" id="right" /> <span>右手杆</span>
					</div>
				</div>
			</div>
-->
			

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
	<script src="../../js/part4/handling.js"></script>
	
</body>
</html>