<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>js验证</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
/* $(function(){
	$("#btn").click(function() {
		var telephone=$("#telephone").val();
		alert(telephone);
	});
}); */
function validation(){
	var mobile=$("#telephone").val();
	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(mobile)) || mobile.length < 11) {
	    alert("输入正确的手机号");
        return
    }
	else{
	alert(mobile);
	}
}
</script>

</head>
<body>
<form action="">
<input type="text" id="telephone">
<input type="button" id="btn" value="button" onclick="validation()">
</form>
</body>
</html>