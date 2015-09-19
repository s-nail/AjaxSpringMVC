<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息界面</title>
<!-- <script language="javascript">
function checkForm() {
	if(form.username.value == "") {
		alert("姓名为空！");
		return;
	}
	if(form.num.value == "") {
		alert("学号为空！");
		return;
	}
	if(form.classes.value == "") {
		alert("班级为空！");
		return;
		}
	if(form.age.value == "") {
		alert("年龄为空！");
		return;
		}
	
	form.submit()
}
</script> -->
</head>
<body>
<div style="width:auto;height:500px;text-align:center;padding-top:200px;">
<form name="form" action="/SpringMVC/student/updateStudent" method="post" onSubmit="return confirm('您确定要修改吗？');">
ID:&nbsp; &nbsp;<input type="text" name="id" value="${student.id}" readonly="readonly"><br><br>
Name:&nbsp; &nbsp;<input type="text" name="name" value="${student.name}"><br><br>
Num:&nbsp; &nbsp;<input type="text" name="num" value="${student.num}"><br><br>
Class:&nbsp; &nbsp;<input type="text" name="classes" value="${student.classes}"><br><br>
Age:&nbsp; &nbsp;<input type="text" name="age" value="${student.age}"><br><br>
<input type="submit" value="确定修改">
</form>
</div>
</body>
</html>