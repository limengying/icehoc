
function guanzhu(para) {
	var playerId = para;
	var data = {
		operateType : "guanzhuqiuyuan",
		playerId : playerId,
	};
	//alert(JSON.stringify(data));
	jump(TIANBINGTIANJIANGURL, data);
}