/**
 * Created by Administrator on 2017/7/4.
 */
$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});
	

	
	$(".jiechubangding").click(function() {
        layer.confirm('你确认要解除绑定吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
        	var playerId = $(".playerId").val();
			var data = {
				operateType : "quxiaoguanzhu",
				playerId : playerId,
			};
			jump(TIANBINGTIANJIANGURL, data);
			layer.msg('解除绑定！');
        }, function(){
            
        });

	
			/*
		
	$(".jiechubangding").click(function() {
        layer.confirm('您是如何看待前端开发？', {
            btn: ['重要','奇葩'] //按钮
        }, function(){
            layer.msg('的确很重要', {icon: 1});
        }, function(){
            layer.msg('也可以这样', {
                time: 2000, //2s后自动关闭
                btn: ['明白了', '知道了']
            });
        });
		
		layer.confirm("你确认要解除绑定吗!", { title: "解除绑定提示" }, function (index) {  
             layer.close(index);  
               $.post("/admin/customer/DeleteCustomer", { gid: $(e.currentTarget).data("gid") }, function (data) {  
                   layer.alert(data, {  
                   
                        btn: ['确定']  
                    },  
                       function (index, item) {  
                            //layer.close(index);  
                            location.reload();  
                        });  
                });  
            });   

		/*
		// 搜索当前页面
		var se = confirm("你确认要解除绑定吗!");
		if (se == true) {
			alert("你按下的是【确认】");
			var playerId = $(".playerId").val();
			var data = {
				operateType : "quxiaoguanzhu",
				playerId : playerId,
			};
		//	alert(JSON.stringify(data));
			jump(TIANBINGTIANJIANGURL, data);
		} else {
			alert("你按下的是【取消】");
		}*/

	});
	$(".jiben").click(function() {
		var playerId = $(".playerId").val();
		var data = {
			operateType : "jibexinxi",
			playerId : playerId,
		};
		//alert(JSON.stringify(data));
		jump(TIANBINGTIANJIANGURL, data);
		//window.location.href = "jibenxinxi.jsp";
	});

	$(".shujv").click(function() {
		window.location.href = "shujvxinxi.jsp";
	});
});
