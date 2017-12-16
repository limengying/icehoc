<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>门将技术统计</title>
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<link rel="stylesheet" href="../../css/part6/menjiangjishutongji.css" />
</head>
<body>
	<div data-role="page" class="allpage">
		<div class="top">
			<div onClick="javascript :history.back(-1);" data-ajax="false"
				class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">门将技术统计</div>
		</div>
		<div data-role="content" class="all">
			<div class="">
				<div class="a">冰球入射方位:</div>
				<select data-role='none' class="option" placeholder=""
					id="bingqiurushefangwei">
					<option value='1'>右上</option>
					<option value='2'>右下</option>
					<option value='3'>左上</option>
					<option value='4'>左下</option>
					<option value='5'>左腋下</option>
					<option value='6'>右腋下</option>
					<option value='7'>裆下</option>
				</select>
			</div>

			<div class="">
				<div class="a">门将移动方式:</div>
				<select data-role='none' class="option" placeholder=""
					id="menjiangyidong">
					<option value='1'>侧移</option>
					<option value='2'>滑跪</option>
					<option value='3'>跪滑</option>
				</select>
			</div>

			<div class="">
				<div class="a">球员进攻方式:</div>
				<select data-role='none' class="option" placeholder=""
					id="qiuyuanjingong">
					<option value='1'>一板射击</option>
					<option value='2'>挑射</option>
					<option value='3'>拉杆射门</option>
					<option value='4'>弹射</option>
					<option value='5'>假动作晃门</option>
					<option value='6'>掂射</option>
					<option value='7'>补射</option>
				</select>
			</div>

			<div class="">
				<div class="a">正杆反杆:</div>
				<select data-role='none' class="option" placeholder=""
					id="zhengganfangan">
					<option value='1'>正杆</option>
					<option value='2'>反杆</option>
				</select>
			</div>

			<div class="">
				<div class="a">比赛阶段:</div>
				<select data-role='none' class="option" placeholder=""
					id="bisaijieduan">
					<option value='1'>第一节</option>
					<option value='2'>第二节</option>
					<option value='3'>第三节</option>
					<option value='4'>加时赛</option>
					<option value='5'>点球</option>
				</select>
			</div>

			<div class="">
				<div class="a">进球是否:</div>
				<select data-role='none' class="option" placeholder=""
					id="jinqiushifou">
					<option value='1'>是</option>
					<option value='2'>否</option>
				</select>
			</div>

			<div class="queren">
				<input type="button" data-role='none' value="取消" class="backButton"></input>
				<input type="button" data-role='none' value="确认" class="nextButton"></input>
			</div>

		</div>


		<div class="button">
			<div class="shouye" onclick="shouyeClick()">
				<span class="ch">首页</span>
			</div>
			<div class="zhanshu" onclick="zhanshuClick()">
				<span class="ch">战术</span>
			</div>
			<div class="zhandui" onclick="zhanduiClick()">
				<span class="ch">战队</span>
			</div>
			<div class="wode" onclick="wodeClick()">
				<span class="ch">我的</span>
			</div>
		</div>
	</div>
	<script src="../../js/common/common.js"></script>
	<script src="../../js/urlApi/api.js"></script>
	<script src="../../js/part6/menjiangjishutongji.js"></script>
</body>
</html>