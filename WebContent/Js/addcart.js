

$(function(){
	$("#quantity").keyup(function(){
		if(isNaN($(this).val()) || parseInt($(this).val())<1 ){
			$(this).val("1");
			$("#totalPrice").val($("#price").html());
			return;
		}
		var total = parseFloat($("#price").html())*parseInt($(this).val());
		$("#totalPrice").val(total.toFixed(2));
	})

	$("#quantity").blur(function(){
		
		if(isNaN($(this).val()) || parseInt($(this).val())<1 || $(this).val()==""){
			$(this).val("1");
			$("#totalPrice").val($("#price").html());
			return;
		}
		
	})
	
	$(".add").click(function(){ 
var num_add = parseInt($("#quantity").val())+1;
	if($("#quantity").val()==""){
		num_add = 1;
	}
	$("#quantity").val(num_add);
	var total = parseFloat($("#price").html())*parseInt($("#quantity").val());
	$("#totalPrice").val(total.toFixed(2));
 
}) 

	$(".min").click(function(){ 
	var num_dec = parseInt($("#quantity").val())-1;
	if(num_dec<1){
		//购买数量必须大于或等于1
		alert("数量不能少于1");
	}else{
		$("#quantity").val(num_dec);
		var total = parseFloat($("#price").html())*parseInt($("#quantity").val());
		$("#totalPrice").val(total.toFixed(2));
	}

}) 
})








