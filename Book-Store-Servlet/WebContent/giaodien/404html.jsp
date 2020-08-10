<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/home" var="home" />
	<h1>
		Vui Lòng Truy Cập Vào Trang Chủ <a href="${home}">home</a>
	</h1>
</body>
</html>