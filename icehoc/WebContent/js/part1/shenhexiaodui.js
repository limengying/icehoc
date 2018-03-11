/**
 * 
 */
function goto1(searchId) {
	var data = {
		operateType : "shenhexiaoduiToshenhexiaoduixiangxi",
		searchId : searchId,
	};
	//alert(JSON.stringify(data));
	jump(SHENHEXIAODUIURL, data);
}