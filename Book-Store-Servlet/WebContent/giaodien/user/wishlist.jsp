<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tài Khoản</title>
<script type="text/script"
	src='<c:url value="js/bootstrap.min.js"></c:url>'></script>
<script type="text/script"
	src='<c:url value="js/jquery.min.js"></c:url>'></script>
<link rel="stylesheet"
	href='<c:url value="/css/bootstrap.min.css"></c:url>'>
<link rel="stylesheet"
	href='<c:url value="/fonts/glyphicons-halflings-regular.eot"></c:url>'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href='<c:url value="/css/style1.css"></c:url>'>
</head>

<body>

	<jsp:include page="/giaodien/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="list-group">
					<a class="list-group-item"
						href='<c:url value="/user/edituser"></c:url>'>Thông tin tài
						khoản</a> <a class="list-group-item"
						href='<c:url value="/user/order"></c:url>'>Quản lý đơn hàng</a>
					<a class="list-group-item"
						href='<c:url value="/user/address"></c:url>'>Sổ địa chỉ</a> <a
						class="list-group-item active"
						href='<c:url value="/user/wishlist"></c:url>'>Sản phẩm yêu
						thích</a>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="row">
					<div class="panel panel-primary">
						<div class="panel-heading">Danh sách sản phẩm yêu thích</div>
						<div class="panel-body">
							<c:forEach items="${listWishList}" var="wishlist">
								<div class="row">
									<div class="col-sm-3">
										<img style="width: 100px; height: 80px;" alt=""
											src='<c:url value="${wishlist.books.images}"></c:url>'>
									</div>
									<div class="col-sm-5">
										<a
											href='<c:url value="/product-detail?id=${wishlist.books.id}"></c:url>'>${wishlist.books.title}</a>
										<p>
											<a href="#"><i>${wishlist.books.author.initials}</i></a>
										</p>
									</div>
									<div class="col-sm-2">
										<p>
											<fmt:formatNumber type="currency"
												value="${wishlist.books.price}" />
										</p>
									</div>
									<div class="col-sm-2">
										<a
											href='<c:url value="/user/wishlist/remove?id=${wishlist.books.id}"></c:url>'><button
												class="btn btn-danger">Xóa</button></a>
									</div>
								</div>
								<br>

							</c:forEach>

						</div>
					<div class="panel-footer text-center">
						<ul class="pagination">
							<c:set var="pre" value="${pageCurrent - 1 }"></c:set>
							<c:if test="${pageCurrent == 1 }">
								<c:set var="pre" value="1"></c:set>
							</c:if>
						
							<li><a href='<c:url value="/user/wishlist?page=${pre}"></c:url>'>&laquo;</a></li>      
							<c:forEach begin="1" end="${soPage}" var="vl">
								<c:if test="${vl == pageCurrent}">
									<li class="active"><a href='<c:url value="/user/wishlist?page=${vl}"></c:url>'>${vl}</a></li>
								</c:if>
								<c:if test="${vl != pageCurrent}">
									<li><a href='<c:url value="/user/wishlist?page=${vl}"></c:url>'>${vl}</a></li>
								</c:if>
							</c:forEach>
							<c:set var="next" value="${pageCurrent + 1}"></c:set>
							<c:if test="${pageCurrent == soPage}">
								<c:set var="next" value="${soPage}"></c:set>
							</c:if>
														
							<li><a href='<c:url value="/user/wishlist?page=${next}"></c:url>'>&raquo;</a></li>
						</ul>
					</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="/giaodien/footer.jsp"></jsp:include>




















</body>
</html>