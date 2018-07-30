$(document).ready(function()
{
$("#userName").blur(function()
	{
		$("#td_1 span").remove();
		if($(this).val().length==0)
		{
			var error=$("<span style='color:red;font-size:15px'>用户名不能为空</span>");
			$("#td_1").append(error);
		}
	});
	$("#pwd1").blur(function()
	{
		$("#td_2 span").remove();
		if($(this).val().length==0)
		{
			var error1=$("<span style='color:red;font-size:15px'>密码不能为空</span>");
			$("#td_2").append(error1);
		}
		if($(this).val().length>0 && $(this).val().length<6)
		{
			var error2=$("<span style='color:red;font-size:15px'>密码少于六位</span>");
			$("#td_2").append(error2);
		}
	});
	$('#pwd2').blur(function()
	{
		$("#td_3 span").remove();
		if($(this).val().length==0)
		{
			var error3=$("<span style='color:red;font-size:15px'>确认密码不能为空</span>");
			$("#td_3").append(error3);
		}
		if($(this).val()!=$("#pwd1").val())
		{
			var error4=$("<span style='color:red;font-size:15px'>确认密码与密码不一致</span>");
			$("#td_3").append(error4);
		}
	});
});