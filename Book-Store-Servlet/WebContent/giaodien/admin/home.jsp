<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>

<title>Admin</title>
<script type="text/script" src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
<script type="text/script" src='<c:url value="/js/jquery.min.js"></c:url>'></script>
<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/fonts/glyphicons-halflings-regular.eot"></c:url>'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href='<c:url value="/css/style1.css"></c:url>'>
	

</head>

<body>
<jsp:include page="/giaodien/admin/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<div class="list-group">		
					<a class="list-group-item active" href='<c:url value="/admin/home"></c:url>'>Trang Chủ</a>
					<a class="list-group-item" href='<c:url value="/admin/account"></c:url>'>Quản lý tài khoản</a>
					<a class="list-group-item"  href='<c:url value="/admin/book"></c:url>'>Quản lý sách</a>
					<a class="list-group-item"  href='<c:url value="/admin/author"></c:url>'>Quản lý tác giả</a>
					<a class="list-group-item"  href='<c:url value="/admin/category"></c:url>'>Quản lý danh mục</a>
					<!-- <a class="list-group-item"  href='<c:url value="#"></c:url>'>Quản lý tác giả</a> -->
					<a class="list-group-item"  href='<c:url value="/admin/order"></c:url>'>Quản lý đơn hàng</a>
					<a class="list-group-item"  href='<c:url value="/admin/news"></c:url>'>Quản lý tin tức</a>
					<a class="list-group-item"  href='<c:url value="/admin/contact"></c:url>'>Quản lý liên hệ</a>
					<!-- <a class="list-group-item"  href='<c:url value="#"></c:url>'>Quản lý mã coupon</a> -->
					<a class="list-group-item"  href='<c:url value="/logout"></c:url>'>Thoát</a>
				</div>
			</div>
			<div class="col-sm-10"></div>
		</div>
	</div>




<jsp:include page="/giaodien/admin/footer.jsp"></jsp:include>


</body>
</html>