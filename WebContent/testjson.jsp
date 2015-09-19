<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试json</title><!-- 测试json传参以及其他事项 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
function ch_showError(errorMsg){
	//String errorMsg="两次密码不相同";
    $("#address_new_error").append("<font>"+errorMsg+"</font>");
    $("#address_new_error").show();
}
function preCheck(){
    $("#address_new_error").hide();
    $("#address_new_error").empty();
}
function confirm(){
	//alert("nihao");
	//ch_showError()
	preCheck();
	var name =$("#name").val().trim();
	var pwd1 =$("#pwd1").val().trim();
	var pwd2 =$("#pwd2").val().trim();
	var rights =$("#rights").val().trim();
	var math =$("#math").val().trim();
	var english =$("#english").val().trim();
	var chinese =$("#chinese").val().trim();
	if(pwd1!=pwd2){
		ch_showError("两次密码不相同");
		return
	}
    //json参数
    var webUserAddress = {
        "name" :name,
        "password":pwd1,
        "rights":rights,
        "math":math,
        "english":english,
        "chinese":chinese
    };
    $.ajax({
        type:"post",
        url:"${pageContext.request.contextPath}/json/test",
        dataType:"json",
        data: webUserAddress,
        success:function(data){
            if(data!=null){
            	alert(data.data);   
            	alert(data.msg);
	          	ch_showError(data.data+data.msg);
               }
            }
    });
}
/* 取form的id，点击按钮响应函数 */
function myform(){
	alert("haha");
	$("#myform").attr("action","${pageContext.request.contextPath}/json/redirect");
	$("#myform").submit();
}

/*60秒获取验证码
 * 
 
//点击获取验证码
 function sendCode(){

     reg_preCheck();
     $('#regcode').val('');
     var regmobile = $("#regmobile").val();
     if (regmobile == "") {
         reg_showError("请输入您的手机号！")
         return
     }
     if(regmobile.length < 11){
         reg_showError("请检查手机号格式！")
         return
     }
     if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(regmobile))){
         reg_showError("请检查手机号格式！");
         return
     }

     //验证手机号是否已注册
     $.ajax({
         type : "get",
         url : "/dj/s/user/checkMobile?regmobile="+regmobile,
         success : function(data){
             if(true == data){
                 //发送验证码
                 $.ajax({
                     type : "get",
                     url : "/dj/s/user/sendValidateCode?regmobile="+regmobile,
                     success : function(data){

                         var time = 60;
                         var countdown = setInterval(CountDown, 1000);
                         function CountDown() {
                             $('#reg_code').attr("Class", "reg-code-send");
                             $("#reg_code").attr("disabled", true);
                             $("#reg_code").val(time + "秒后再次获取");
                             if (time == 0) {
                                 $("#reg_code").val("获取验证码").removeAttr("disabled");
                                 $('#reg_code').attr("Class", "reg-code");
                                 clearInterval(countdown);
                             }
                             time--;
                         }
                     }
                 });
             }else{
                 reg_showError("该账户已经存在!")
                 return
             }
         }
     });


 }
 */
 /*60秒获取验证码*/
function intervala(){
	 var time = 60;
     var countdown = setInterval(CountDown, 1000);
     function CountDown() {
         $('#reg_code').attr("Class", "reg-code-send");
         $("#reg_code").attr("disabled", true);
         $("#reg_code").val(time + "秒后再次获取");
         if (time == 0) {
             $("#reg_code").val("获取验证码").removeAttr("disabled");
             $('#reg_code').attr("Class", "reg-code");
             clearInterval(countdown);  /*  setInterval() 方法可按照指定的周期（以毫秒计）来调用函数或计算表达式。
                                            clearInterval() 方法可以取消该周期性的方法调用。*/
         }
         time--;
     }
}
 function testHead(){
	 $.ajax({
	        type:"post",
	        url:"${pageContext.request.contextPath}/json/testHead",
	        dataType:"json",
	        success:function(data){
	            if(data!=null){
	            	var i=data.result;
	            	alert(i.msg);   
	            	alert(data.result.data);
		          	ch_showError(data.result.data+data.result.msg);
	               }
	            }
	    });
 }
</script>	
</head>
<body>
<form action="">
账号：<input type="text" id="name"><br><br>
密码：<input type="password" id="pwd1"><br><br>
确认密码：<input type="password" id="pwd2">
<!-- 密码错误提示区 -->
<div><label id="address_new_error" style="display: none"></label></div>
<br><br>
权限：<input type="text" id="rights"><br><br>
数学：<input type="text" id="math"><br><br>
英语：<input type="text" id="english"><br><br>
语文：<input type="text" id="chinese"><br><br>
<input type="button" value="提交" onclick="confirm()">
</form>
<form action="${pageContext.request.contextPath}/json/redirect">
<input type="submit" value="Redirect">
</form>

<form id="myform" action="">
<input type="button" value="#id" onclick="myform()">
</form>

</form>
<form action="${pageContext.request.contextPath}/json/modelAttributeTest">
<input type="text" name="parm">
<input type="text" name="parms">
<input type="submit" value="modelAttributeTest">
</form>
<!-- <label id="reg_code"></label> -->
<input type="button" class="reg-code" onclick="intervala();" id="reg_code" value="发送验证码">
<!-- 验证Head（包json数据包起来） -->
<form action="">
<input type="button" value="testHead" onclick="testHead()">
</form>
</body>
</html>
