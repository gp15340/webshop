$(document).ready(function(){ 
	$("#province").change(function(){

	var s0=$("#province").find("option:selected").text();
 	$("#province1").val(s0);

 	var s1=$("#city").find("option:selected").text();
 	$("#city1").val(s1);

 	var s2=$("#district").find("option:selected").text();
 	$("#district1").val(s2);
	})

	$("#city").change(function(){

	var s0=$("#province").find("option:selected").text();
 	$("#province1").val(s0);

 	var s1=$("#city").find("option:selected").text();
 	$("#city1").val(s1);

 	var s2=$("#district").find("option:selected").text();
 	$("#district1").val(s2);

	})

	$("#district").change(function(){

	var s0=$("#province").find("option:selected").text();
 	$("#province1").val(s0);

 	var s1=$("#city").find("option:selected").text();
 	$("#city1").val(s1);

 	var s2=$("#district").find("option:selected").text();
 	$("#district1").val(s2);

	})


})




