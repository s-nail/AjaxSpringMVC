<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
    String path = request.getContextPath();
%>
<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

</head>
<body>
<div  style="width:auto;height:500px;text-align:center;padding-top:200px;" >
 <h4><a href="/SpringMVC/student/toAddStudent">添加学生</a></h4>  
 <div align="center">
    <table border="1">  
        <tbody>  
        <tr>  
            <th>姓名</th>  
            <th>学号</th>  
            <th>班级</th>                
            <th>年龄</th>  
            <th>操作</th>  
            <th>查询成绩</th> 
        </tr>  
        <c:if test="${!empty studentList }">  
            <c:forEach items="${studentList }" var="student">  
                <tr>  
                    <td>${student.name }</td>
                     <td>${student.num }</td>  
                      <td>${student.classes }</td>    
                    <td>${student.age }</td>  
                    <td>  
                        <a href="/SpringMVC/student/getStudent?id=${student.id }">编辑</a>  
                        <a href="/SpringMVC/student/delStudent?id=${student.id }" onclick="return confirm('您确认要删除吗？');">删除</a>  
                    </td>  
                       <td>  
                        <a href="/SpringMVC/student/getScore?num=${student.num}">查询</a>                        
                    </td>  
                </tr>               
            </c:forEach>  
        </c:if>  
    </tbody>  
</table>  
</div>
</div>
</body>
</html>