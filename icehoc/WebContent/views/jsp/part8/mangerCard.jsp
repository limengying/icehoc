<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		
		<title>管理员卡片</title>
		
		<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
		<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
		<link rel="stylesheet" href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css"/>

		<link rel="stylesheet" href="../../css/part1/allpagesame.css"/>
		<link rel="stylesheet" href="../../css/part8/mangerCard.css" />
			
		<script type="text/javascript">
			$(document).ready(function(){
				$(".XG").click(function(){
				   window.location.href="addMangerCard.jsp";
				 });
				$(".").click(function(){
				   window.location.href="";
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
						管理员卡片
					</div>
				</div>
				
				<div class="content">
					<div>用户真实姓名：${user.userName}
					
					</div>
					
					<div>出生日期:${user.birthday}
						
					</div>
					
					<div class="IDCard">
						<div>
							身份证正面:
						</div>     
                        <div class="img">
                        	<img src="${user.IDCardZ}"/>
                        </div>
                       
					</div>
					
					<div class="IDCard">
						<div>
							身份证反面:
						</div>
						 <div class="img">
                        	<img src="${user.IDCardF}"/>
                        </div>
						
					</div>
					
					<div>国籍:${user.countryId}
						
					</div>
					
					<div>籍贯:${user.cityId}
						
					</div>
					
					<div>住址:${user.address}
						
					</div>

				</div>
				
				<div class="xiugai">
					<input type="button" data-role="none" value="修改" class="XG" />
				</div>
				
				
				
				<div class="button">
					<div class="shouye" onclick="shouyeClick()">
						<span class="ch">首页</span>		
					</div>

					<div  class="zhanshu" onclick="zhanshuClick()">
						<span class="ch">战术</span>		
					</div>

					<div  class="zhandui" onclick="zhanduiClick()">
						<span class="ch">战队</span>	
					</div>

					<div class="wode" onclick="wodeClick()">
						<span class="ch">我的</span>	
					</div>
			   </div>			
        </div>
        
        <script src="../../js/common/common.js"></script>
		<script src="../../js/urlApi/api.js"></script>
		
		
	</body>

</html>ml>