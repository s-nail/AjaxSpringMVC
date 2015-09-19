<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生界面</title>
<!-- <script type="text/javascript" src="/springMVC/WebContent/js/jquery-1.9.1.min.js"></script> 
<script type="text/javascript"> 
$(document).ready(function(){ 
    $("#add").click(function(){
         var username = $("#username").val(); 
        var num = $("#num").val(); 
        var classes = $("#class").val(); 
        var age = $("#num").val(); 
         var studentJosn = {"username":username,"num":num,"classes":classes,"age":age};
         $.ajax({ 
             url:"/student/addStudent", 
             type:"post", 
             data:studentJosn, 
             success: function(data){ 
                alert(data.username); 
             }
         });
    });
});
</script> -->
<!-- <script type="text/javascript">  
function addStudent(){  
    var form = document.forms[0];  
    form.action = "/SpringMVC/student/addStudent";  
    form.method="post";  
    form.submit();  
}  
</script> -->
<script language="javascript">
function checkForm() {
if(Form.name.value == "") {
alert("请填写姓名");
return false;
}

if(Form.num.value == "") {
	alert("请填写学号");
	return false;
	}
if(Form.classes.value == "") {
	alert("请填写班级");
	return false;
	}
if(Form.age.value == "") {
	alert("请填写年龄");
	return false;
	}

Form.submit();
}
</script>
</head>
<body>
<div style="width:auto;height:500px;text-align:center;padding-top:180px;">
<h1>添加学生</h1>  
<form name="Form" action="/SpringMVC/student/addStudent" method="post">  
   Name：<input type="text" name="name"><br><br>
   Num：<input type="text" name="num"><br><br>
   Class：<input type="text" name="classes"><br><br>
    Age：  <input type="text" name="age"><br><br> 
    <input  type="button" value="Submit" onclick="checkForm()">  
    <input type="reset" value="Reset">
</form>  
</div>
</body>
</html>