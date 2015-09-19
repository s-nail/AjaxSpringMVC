<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩界面</title>
</head>
<body>
<div  style="width:auto;height:500px;text-align:center;padding-top:200px;" >
<div align="center" >
    <table border="1">  
        <tbody>  
        <tr>  
            <th>姓名</th>               
            <th>班级</th>                
            <th>高数</th> 
            <th>英文</th> 
            <th>中文</th>              
        </tr>  
      
            <c:forEach items="${scoreList }" var="score">  
                <tr>  
                    <td>${score[0]}</td>
                    <td>${score[1] }</td>  
                    <td>${score[2] }</td>    
                    <td>${score[3] }</td>
                    <td>${score[4] }</td>   
                 
                </tr>               
            </c:forEach>  
     
    </tbody>  
</table>  <br><br><br>
<a href="/SpringMVC/student/getAllStudent">返回首页</a>
</div>
</div>
</body>
</html>