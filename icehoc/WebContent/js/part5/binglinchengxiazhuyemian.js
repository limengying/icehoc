/**
 * 
 */
$(document).ready(function() {

	$(".zengjia").click(function() {// 添加赛事
		var data = {
			operateType : "tianjianxunliansai"
		};
		//alert(JSON.stringify(data));
		jump(BINGLINCHENGXIAURL, data);
		// window.location.href = "tianjiaxunliansai.jsp";
	});

	$(".yiguanzhu").click(function() {
		var data = {
			operateType : "BingLinChengXia"
		};
		//alert(JSON.stringify(data));
		jump(BINGLINCHENGXIAURL, data);
		// window.location.href = "binglinchengxiazhuyemian.jsp";
	});
	$(".saishixuanze").click(function() {
		var data = {
			operateType : "yaoqingsaishichakan"
		};
		//alert(JSON.stringify(data));
		jump(BINGLINCHENGXIAURL, data);
		// window.location.href = "binglinchengxiazhuyemian.jsp";
	});
});