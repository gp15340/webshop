

$(function(){
	$("input[name=orderlist]").click(function () {
		// $("#total2").html() = GetCount($(this));
		GetCount();
	

	});

// 全选        
	$("#allChecks").click(function () {
		if ($(this).attr("checked")){
			$("input[name=orderlist]").each(function () {
			$(this).attr("checked",true);
			// $(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
		});
		GetCount();
	}else{
		$("input[name=orderlist]").each(function () {
			$(this).attr("checked", false);
			// $(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
		});
		GetCount();
	}
	});

	
	function GetCount() {
	var conts = 0;
	
	$("input[name=orderlist]").each(function () {
		if ($(this).attr("checked")) {
			for (var i = 0; i < $(this).length; i++) {
				var wa=$(this).val();
				var kk=wa.split(";");
				conts += parseFloat(kk[0]);
				
			}
		}
	});
	
	$("#totalPrice").val((conts).toFixed(2));
	
}
	

}) 








