<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		
		<title>我的中心</title>
		
		<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
		<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
		<link rel="stylesheet" href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css"/>

		<link rel="stylesheet" href="../../css/part1/allpagesame.css"/>
		<link rel="stylesheet" href="../../css/part8/wodezhongxinyemian.css" />
			
		<script type="text/javascript">
			$(document).ready(function(){
				$(".manger_card").click(function(){
				   window.location.href="mangerCard.jsp";
				 });
				$(".player_card").click(function(){
				   window.location.href="playercard.jsp";
				 });
			});
		</script>     
	</head>

	<body>
		<div data-role="page" class="allpage">		
				<div class="top">	
					 <div href="#" onClick="javascript :history.back(-1);" data-ajax="false" class="back">	
                    	<img src="../../img/part1/back.png" />
				    </div>
					<div class="biaoti">
						我的中心
					</div>
					<div class="meiriqiandao">
						<input type="button" data-role='none' value="每日签到" class="qiandao"></input>
				    </div>
				</div>


		<div class="card">
			<div class="manger_card">
				<div>管理员卡片</div>	
			</div>
			
			<div class="user_image">
				<div class="img">
					<img src="../../img/part3/qiuyuan.png">	
				</div>
				<div>上传头像</div>
			</div>
			
			
			
			<div class="player_card">
				<div>球员卡片</div>
				<!--    ${player.num}     管理员所管理的球员个数       -->
				<div>${player.num}</div>
	
			</div>
		</div>
		
		
		
		<div class="list">
			<div class="list1" onclick="wodezhengjianClick()">
				<div class="a">邀请好友</div> 
				<div class="next1">
					<img src="../../img/part8/next1.png">	
				</div>	
			</div>
			
			<div class="list1" onclick="wodezhengjianClick()">
				<div class="a">查看消息</div> 
				<div class="next1">
					<img src="../../img/part8/next1.png">	
				</div>		
			</div>
			
			<div class="list1" onclick="wodezhengjianClick()">
				<div class="a">查看用户协议</div> 
				<div class="next1">
					<img src="../../img/part8/next1.png">	
				</div>		
			</div>
			
			<div class="list1" onclick="wodezhengjianClick()">
				<div class="a">意见反馈</div> 
				<div class="next1">
					<img src="../../img/part8/next1.png">	
				</div>		
			</div>
			
			
			<div class="list1" onclick="wodezhengjianClick()">
				<div class="a">设置</div> 
				<div class="next1">
					<img src="../../img/part8/next1.png">	
				</div>	
			</div>
			
			
			<div class="list1" onclick="wodezhengjianClick()">
				<div class="a">退出登录</div> 
				<div class="next1">
					<img src="../../img/part8/next1.png">	
				</div>
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
</html>