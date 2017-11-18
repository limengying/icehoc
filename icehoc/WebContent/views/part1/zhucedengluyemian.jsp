<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">	
		
		<title>注册登录页面</title>
		<link rel="stylesheet" href="../../css/part1/zhucedengluyemain.css" />
		
		<link rel="stylesheet" href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css"/>
		<script src="../../js/jQuery/jquery-2.2.3.min.js"></script>
		<script src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>	
		
		
		<script type="text/javascript">
			$(document).ready(function(){
				$(".button1").click(function(){
			    window.location.href="";
			  });
			  $(".button2").click(function(){
			    window.location.href="qitadenglufangshi.jsp";
			  });
			});
		</script>      
	</head>
	
	<body style='overflow:scroll;overflow-y:hidden'>
		<div data-role="page" class="main">
				 <div data-role="content">	 	
				 	<div  class="btn">
						  	<div class="button1">
						  		<img src="../../img/part1/weixindenglu.png" />
						  	</div>

						    <div class="button2" >
						  	    <img src="../../img/part1/qitafangshi.png" />
						  	</div>
				 	</div>
				</div>		  
		</div>
	</body>
</html>