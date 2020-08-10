<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>

<title>Admin Contact</title>
<script type="text/script" src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
<script type="text/script" src='<c:url value="/js/jquery.min.js"></c:url>'></script>
<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"></c:url>'>

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
					<a class="list-group-item" href='<c:url value="/admin/home"></c:url>'>Trang Chủ</a>
					<a class="list-group-item"  href='<c:url value="/admin/account"></c:url>'>Quản lý tài khoản</a>
					<a class="list-group-item"  href='<c:url value="/admin/book"></c:url>'>Quản lý sách</a>
					<a class="list-group-item"  href='<c:url value="/admin/author"></c:url>'>Quản lý tác giả</a>
					<a class="list-group-item "  href='<c:url value="/admin/category"></c:url>'>Quản lý danh mục</a>
					<!-- <a class="list-group-item"  href='<c:url value="#"></c:url>'>Quản lý tác giả</a> -->
					<a class="list-group-item "  href='<c:url value="/admin/order"></c:url>'>Quản lý đơn hàng</a>
					<a class="list-group-item"  href='<c:url value="/admin/news"></c:url>'>Quản lý tin tức</a>
					<a class="list-group-item active"  href='<c:url value="/admin/contact"></c:url>'>Quản lý liên hệ</a>
					<!-- <a class="list-group-item"  href='<c:url value="#"></c:url>'>Quản lý mã coupon</a> -->
					<a class="list-group-item"  href='<c:url value="/logout"></c:url>'>Thoát</a>
				</div>
			</div>
			<div class="col-sm-10">
					<table class="table table-bordered table-hover text-center">

					<tr style="text-align: center;">
						<th width="10%">STT</th>
						<th width="15%">Tên</th>
						<th width="15%">Email</th>
						<th width="40%">Content</th>
						<th width="20%">+</th>
					</tr>
					<c:forEach items="${listContact}" var="item" varStatus="i">
						<tr>
							<td>${i.index + 1 + (pageCurrent - 1) * 5}</td>
							<td>${item.name}</td>	
							<td>${item.email}</td>
							<td>
								<p class="line-content">
									${item.content}
								</p>
							</td>
																				
							<td>
								<a href="#"><button class="btn btn btn-danger" title="Xóa Danh Mục">Xóa</button></a>
								<a href="#"><button class="btn btn btn-warning" title="Sửa Danh Mục">Sửa</button></a>	
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5">
							<ul class="pagination">
							<c:set value="${pageCurrent - 1}"  var="pre" />
								<c:if test="${pre < 1}">
									<c:set value="1"  var="pre" />
								</c:if>
							<li><a href='<c:url value="/admin/contact?page=${pre}"></c:url>'>&laquo;</a>
								<c:forEach begin="1"  end="${soPage}" var="item">
									<c:if test="${pageCurrent != item}">
										<li  ><a href='<c:url value="/admin/contact?page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									<c:if test="${pageCurrent == item}">
										<li class="active" ><a href='<c:url value="/admin/contact?page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									
								</c:forEach>
								<c:set value="${pageCurrent + 1}"  var="next" />	
								<c:if test="${next >= soPage}">
									<c:set value="${soPage}"  var="next" />
								</c:if>
								
								<li><a href='<c:url value="/admin/contact?page=${next}"></c:url>'>&raquo;</a>
							</ul>
						</td>
					</tr>
					<tr>
						<td colspan="5"><button data-toggle="modal" data-target="#mymodal" class="btn btn-primary">Thêm</button></td>
					</tr>
				</table>
			</div>			
		</div>
	</div>




<jsp:include page="/giaodien/admin/footer.jsp"></jsp:include>


</body>
</html>