<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			var username = $("#username").val();		
			var pwd = $("#pwd").val();			

			if (username != "" && pwd != "") {
				var url = "${pageContext.request.contextPath}/login/isExist";
				var args = {
					"username" : username,
					"pwd" : pwd,
					"time" : new Date()
				};

				$.post(url, args, function(data) {
					
					if (data.result==1) {
						
					window.location.href="${pageContext.request.contextPath}/student/getAllStudent";

					} else {
						alert("账号密码不存在，请重新登录！");
						return false;
					}
				},"json");
			} else {
				alert("账号密码不能为空！");
				return false;
			}

		});
		//	return true;

	});
</script>
</head>
<body>
	<div
		style="width: auto; height: 500px; text-align: center; padding-top: 200px;">
		<form action="" method="post">
			用户名：<input id="username" type="text" name="username"><br>
			<br> 密码：<input id="pwd" type="password" name="pwd"><br>
			<br> <input id="btn" type="button" value="登录"> <input
				type="reset" value="重置">
		</form>
	</div>
</body>
</html>