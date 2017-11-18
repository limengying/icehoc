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
<link rel="stylesheet" href="../../css/part2/tianjiabingchang.css" />
<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>

<body style='overflow:scroll;overflow-y:hidden'>
	<div data-role="page" class="allpage">
		<div class="top">
			<div onClick="javascript :history.back(-1);" data-ajax="false"
				class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">添加冰场</div>

		</div>

		<div  data-role="content"  class="content">
				<div class="content_div">
					<div class="content_div_left">冰场名称：</div>
					<div class="content_div_right">
						<input type="text" name="rinkName" class="rinkName" id="rinkName"
							data-role='none' />
					</div>
				</div>
				
				<div class="content_div">
					<div class="content_div_left">位置：</div>
					<div class="content_div_right">
						<input type="text" name="heiaddressght" class="address" id="address"
							data-role='none' />
					</div>
				</div>
				
				<div class="content_div">
					<div class="content_div_left">场地电话：</div>
					<div class="content_div_right">
						<input type="text" name="telephone" class="telephone" id="telephone"
							data-role='none' />
					</div>
				</div>

				<div class="content_div">
					<div class="content_div_left">室内/室外:</div>
					<div class="content_div_right">
						<select data-role='none' id="indoor" class="select_div">
							<option class="option" value='1'>室内</option>
							<option class="option" value='0'>室外</option>
						</select>
					</div>
				</div>
				
				<div class="content_div">
					<div class="content_div_left">有无更衣室:</div>
					<div class="content_div_right">
						<select data-role='none' id="hasLocker" class="select_div">
							<option class="option" value='1'>有</option>
							<option class="option" value='0'>无</option>
						</select>
					</div>
				</div>
				
				<div class="content_div">
					<div class="content_div_left">有无停车场:</div>
					<div class="content_div_right">
						<select data-role='none' id="hasCarparks" class="select_div">
							<option class="option" value='1'>有</option>
							<option class="option" value='0'>无</option>
						</select>
					</div>
				</div>
				
	
				<div class="content_div">
					<div class="content_div_left">冰场训练等级:</div>
					<div class="content_div_right">
						<select data-role='none' id="trainingDegree" class="select_div">
							<option class="option" >初级</option>
							<option class="option" >进阶</option>
							<option class="option" >专业</option>
						</select>
					</div>
				</div>
				
				<div class="content_div">
					<div class="content_div_left">规模：</div>
					<div class="content_div_right">
							<select data-role='none' id="scale" class="select_div">
							<option class="option" value='100'>100人以上</option>
							<option class="option" value='500'>500人以上</option>
							<option class="option" value='1000'>1000人以上</option>
						</select>
					</div>
				</div>
				
				<div class="content_div">
					<div class="content_div_left">有无陆地训练室:</div>
					<div class="content_div_right">
						<select data-role='none' id="hasLandTrainingRoom" class="select_div">
							<option class="option" value='1'>有</option>
							<option class="option" value='0'>无</option>
						</select>
					</div>
				</div>
					

				<div class="content_div">
					<div class="content_div_left">占地面积：</div>
					<div class="content_div_right">
						<input type="text" name="area" class="area" id="area"
							data-role='none' />
					</div>
				</div>
				
				<div class="content_div">
					<div class="content_div_left">冰面面积：</div>
					<div class="content_div_right">
						<input type="text" name="iceArea" class="iceArea" id="iceArea"
							data-role='none' />
					</div>
				</div>
				
				<div class="content_div">
					<div class="content_div_left">建成时间：</div>
					<div class="content_div_right">
						<input type="date" name="completionDate" class="completionDate" id="completionDate"
							data-role='none' />
					</div>
				</div>
				
				<div class="content_div">
					<div class="content_div_left">投入使用时间：</div>
					<div class="content_div_right">
						<input type="date" name="beginUseDate" class="beginUseDate" id="beginUseDate"
							data-role='none' />
					</div>
				</div>
				
				<div class="content_div">
					<div class="content_div_left">开放时间：</div>
					<div class="content_div_right">
						<input type="date" name="openTime" class="openTime" id="openTime"
							data-role='none' />
					</div>
				</div>
				
				<div class="content_div">
					<div class="content_div_left">是否接受散滑:</div>
					<div class="content_div_right">
						<select data-role='none' id="allowedSlip" class="select_div">
							<option class="option" value='1'>是</option>
							<option class="option" value='0'>否</option>
						</select>
					</div>
				</div>				
				
				<div class="content_div">
					<div class="content_div_left">冰面类型：</div>
					<div class="content_div_right">
					<select data-role='none' id="iceType" class="select_div">
							<option class="option">真冰</option>
							<option class="option">仿冰</option>
						</select>
						
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
	<script type="text/javascript" src="../../js/part2/tianjiabingchang.js"></script>
</body>
</html>