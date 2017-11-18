//这个方法是获得页面url的某个url参数的方法
var comm = {
	getUrlParameter : function(name) {
		var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
		var r = window.location.search.substr(1).match(reg);
		if (r != null) {
			return unescape(r[2]);
		}
		return null;
	}
};

// 访问后台函数
function jump(url, data) {
	// var data = {};
	var myForm = document.createElement("form");
	myForm.method = "post";
	myForm.action = url;
	myForm.style.display = "none";
	for ( var k in data) {
		var myInput = document.createElement("input");
		myInput.name = k;
		myInput.value = data[k];
		myForm.appendChild(myInput);
	}
	document.body.appendChild(myForm);
	myForm.submit();
	return myForm;
}

// 导航栏跳转
$(".shouye").click(function() {
	var data = {
		operateType : "shouye",
	};
	jump(DAOHANGLANURL, data);
});
$(".zhanshu").click(function() {
	window.location.href="";
//	var data = {
//		operateType : "zhanshu",
//	};
//	jump(DAOHANGLANURL, data);
});
$(".zhandui").click(function() {
	window.location.href="";
//	var data = {
//		operateType : "zhandui",
//	};
//	jump(DAOHANGLANURL, data);
});
$(".wode").click(function() {
	var data = {
		operateType : "wode",
	};
	jump(DAOHANGLANURL, data);
});

//屏幕适配
(function(doc, win) {
	var docEl = doc.documentElement, resizeEvt = 'orientationchange' in window ? 'orientationchange'
			: 'resize', recalc = function() {
		var clientWidth = docEl.clientWidth;
		if (!clientWidth)
			return;
		docEl.style.fontSize = 16 * (clientWidth / 720) + 'px';
	};

	if (!doc.addEventListener)
		return;
	win.addEventListener(resizeEvt, recalc, false);
	doc.addEventListener('DOMContentLoaded', recalc, false);
})(document, window);
/*
width=device-width ：表示宽度是设备屏幕的宽度 
initial-scale - 初始的缩放比例
minimum-scale - 允许用户缩放到的最小比例
maximum-scale - 允许用户缩放到的最大比例
user-scalable - 用户是否可以手动缩放
*/