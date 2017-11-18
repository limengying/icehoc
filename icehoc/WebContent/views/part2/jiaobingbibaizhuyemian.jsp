<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>浇冰必拜主页面</title>

<link rel="stylesheet" href="../../css/part2/jiaobingbibaizhuyemian.css" />
<link rel="stylesheet"
	href="../../css/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/part1/allpagesame.css" />
<script type="text/javascript" src="../../js/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript"
	src="../../js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" class="allpage">
		<!--标题-->
		<div class="top">
			<div href="#" onClick="javascript :history.back(-1);"
				data-ajax="false" class="back">
				<img src="../../img/part1/back.png" />
			</div>
			<div class="biaoti">浇冰必拜</div>
			<div class="筛选"></div>

		</div>


		<div class="search_a">
			<div class="search_c">
				<input type="submit" data-role='none' value="添加" class="rinkAddBtn"></input>
			</div>

			<div class="search_b">
				<input type="text" data-role='none' name="search" id="search"
					class="search" placeholder="模糊查询">
			</div>

			<div class="search_d">
				<input type="submit" data-role='none' value="搜索" class="submitBtn"></input>
			</div>
		</div>

		<div data-role="content" class="all">
			<c:choose>
				<c:when test="${!empty rinks}">
					<c:forEach items="${rinks}" var="rink" varStatus="st">
						<div class="everyone" onclick="goto1('${rink.rinkId}')">
							<div class="place">
								<div class="content_left">
									<div class="img">
										<img src="${rink.rinkLogo}" />
									</div>

								</div>
								<div class="content_right">
									<div class="day">冰场名称：${rink.rinkName}</div>
									<div class="day">建成日期：${rink.completionDate}</div>
									<div class="huanjing">
										环境指数:${rink.environmentalIndex}
										<c:choose>
											<c:when test="${!empty rink.environmentalIndex}">
												<c:forEach var="s" begin="1"
													end="${rink.environmentalIndex}">

													<img src="../../img/part2/star.png" />
												</c:forEach>
											</c:when>
										</c:choose>
									</div>
									<div class="tel">冰场联系电话:${rink.telephone}</div>
									<div class="name">冰场地理位置:${rink.address}</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<P>没有记录</P>
				</c:otherwise>
			</c:choose>
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


	<!--
    	<div data-role="page" class="allpage">	
				<div class="top">	
					 <div href="#" onClick="javascript :history.back(-1);" data-ajax="false" class="back">	
                    	<img src="../../img/part1/back.png" />
				    </div>
					<div class="biaoti">
						浇冰必拜
					</div>
				</div>

		<div class="search">
			<div class="search_a">
				<div class="search_b">
					<input type="text" name="search" id="search" placeholder="精确查询">
				</div>
				<div class="search_c">
					<input type="submit" data-role='none' value="搜索" class="submitBtn"></input>
				</div>

			</div>

			<div class="playground">
				<c:choose>
					<c:when test="${!empty places}">
						
						<c:forEach items="${places}" var="place" varStatus="st">

							<div class="day">
								<li data-role="list-divider" class="day">开放日期：${place.openDate}</li>
							</div>

							<div class="name_content">

								<span><a onclick="goto1('${place.placeName}')">${place.placeName}</a></span>

								<div class="huanjing">
									<span>环境指数:</span> <img src="../../img/part2/star.png" /> <img
										src="../../img/part2/star.png" /> <img
										src="../../img/part2/star.png" /> <img
										src="../../img/part2/star.png" /> <img
										src="../../img/part2/star.png" />
								</div>
							</div>
							<div class="content">
								<div class="content_img">
									<img src="../../img/part2/c.jpg" />
									
								</div>
								<div class="content_div_right">
									<li class="content_top"><a href="">${place.placeName}</a></li>
									<div class="mid">${place.placeNumber}</div>
									<div class="content_bottom">${place.placeAddress}</div>
								</div>
							</div>

						</c:forEach>
					</c:when>
					<c:otherwise>
						<P>没有记录</P>
					</c:otherwise>
				</c:choose>

			</div>


		</div>

	</div>
	
	
	
	<div class="everyone" onclick="goto1('${rink.rinkId}')">
			<div class="place">
				<div class="content_left">
								<div class="img">
									<img src="../../img/part5/a.jpg" />
								</div>
								
				</div>


				<div class="content_right">
				            	<div class="day">冰场名称：</div>
								<div class="day">建成日期：</div>
								<div class="huanjing">环境指数:</div>
								<div class="tel">冰场联系电话:</div>
								<div class="name">冰场地理位置:</div>
				</div>		
			</div>	
		</div>

    -->


</body>
<script src="../../js/common/common.js"></script>
<script src="../../js/urlApi/api.js"></script>
<script src="../../js/part2/jiaobingbibaizhuyemian.js"></script>
<link rel="stylesheet" href="../../css/part2/jiaobingbibaizhuyemian.css" />
</html>
