<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty t}">
		<h1>${t}</h1>	
	here:<label value="${t}">${t} </label>
		<br>
	</c:if>
	<c:if test="${not empty test}">
	test:<label value="${test}">${ra}${test} </label>
		<br>
	</c:if>
	<c:if test="${not empty feng}">
		<label value="${feng}">${feng} </label>
	</c:if>
	
	<c:if test="${not empty parm}">
		<label value="${parm}">${parm} </label>
	</c:if>	
	<c:if test="${not empty parms}">
		<label value="${parm}">${parms} </label>
	</c:if>	
</body>
</html>