<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<title>Admin</title>
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
					<a class="list-group-item active"  href='<c:url value="/admin/order"></c:url>'>Quản lý đơn hàng</a>
					<a class="list-group-item"  href='<c:url value="/admin/news"></c:url>'>Quản lý tin tức</a>
					<a class="list-group-item"  href='<c:url value="/admin/contact"></c:url>'>Quản lý liên hệ</a>
					<!-- <a class="list-group-item"  href='<c:url value="#"></c:url>'>Quản lý mã coupon</a> -->
					<a class="list-group-item"  href='<c:url value="/logout"></c:url>'>Thoát</a>
				</div>
			</div>
			<div class="col-sm-10">
					<table class="table table-bordered table-hover text-center">
					<tr>
					
						
						<td colspan="2">
							<button class="btn" form="formSearch">Tìm Kiếm</button>
						</td>
										
					</tr>
					<tr style="text-align: center;">
						<th width="10%">STT</th>
						<th width="20%">FirstName</th>
						<th width="30%">Initials</th>
						<th width="20%">LastName</th>
						<th width="20%">+</th>
					</tr>
					<c:forEach items="${listOrderPagi}" var="item" varStatus="i">

						<tr>
							<td>${i.index + 1 + (pageCurrent - 1) * 5}</td>
							<td>${item.id}</td>
							<td>${item.users.userName}</td>		
							<td> <fmt:formatNumber  value="${item.totalPrice}" type="currency" /></td>		
							<td>${item.date}</td>
							<td >${item.getStatusDisplay() }</td> <!-- Đang Xử lý , Hủy, Thành Công -->																
							<td>

								
								<button id="#btn-info" class="btn btn-primary btn-info" title="Xem chi tiết" data-toggle="modal" data-target="#order-info">!</button>								
								<button data-toggle="modal" data-target="#order-update" class="btn btn btn-warning btn-update" title="Cập Nhật Tình Trạng">Cập Nhật</button>	
							</td>
							
						</tr>
					</c:forEach>
					<tr>
						<td colspan="7">
							<ul class="pagination">
							<c:set value="${pageCurrent - 1}"  var="pre" />
								<c:if test="${pre < 1}">
									<c:set value="1"  var="pre" />
								</c:if>
							<li><a href='<c:url value="/admin/order?page=${pre}"></c:url>'>&laquo;</a>
								<c:forEach begin="1"  end="${soPage}" var="item">
									<c:if test="${pageCurrent != item}">
										<li  ><a href='<c:url value="/admin/order?page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									<c:if test="${pageCurrent == item}">
										<li class="active" ><a href='<c:url value="/admin/order?page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									
								</c:forEach>
								<c:set value="${pageCurrent + 1}"  var="next" />	
								<c:if test="${next >= soPage}">
									<c:set value="${soPage}"  var="next" />
								</c:if>
								
								<li><a href='<c:url value="/admin/order?page=${next}"></c:url>'>&raquo;</a>
							</ul>
						</td>
					</tr>
					<tr>
							<td colspan="5"><button data-toggle="modal" data-target="#mymodal" class="btn btn-primary">Thêm</button></td>
						</tr>

				</table>
			</div>			
		</div>
		
		<div class="modal fate" id="order-info">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					Thông Tin
				</div>
				<div class="modal-body">
					<div class="panel panel-primary">
						<div class="panel-heading">
							Chi tiết hóa đơn
						</div>
						<div class="panel-body">
							<table class="table" id="table">
								
								
							</table>
						</div>
					</div>
					<table class="table " id="table-address">
					</table>
				</div>
				<div class="modal-footer">
					 <button type="submit" class="btn btn-primary" >Xuất Đơn</button>
        			<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>				
				</div>
			</div>
		</div>
		<div class="modal fate" id="order-update">
			<div class="modal-dialog" >
				<div class="modal-content">
				<div class="modal-header">
					Cập nhật
				</div>
				<div class="modal-body">
				<div class="row">
				<div class="col-sm-2"></div>
					<div class="col-sm-8">
						
						<ul class="list-group" id="user_update">
							
						</ul>
						<form	action='<c:url value="/admin/order/update"></c:url>' method="POST" id="form-status">
							<select class="form-control select_status" name="status" id="select_status" >						
								<option value="3">Đang Xử Lý</option>
								<option value="2">Thành Công</option>
								<option value="1">Hủy Đơn Hàng</option>
							</select>
							<input type="hidden" name="id" id="idOd">
						</form>
					</div>
					<div class="col-sm-2"></div>
					</div>
				</div>
				<div class="modal-footer">
						 <button type="submit" class="btn btn-primary" form="form-status">Cập nhật</button>
        				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>				
				</div>
			</div>
		</div>
		
	</div>




<jsp:include page="/giaodien/admin/footer.jsp"></jsp:include>

<script type="text/javascript">

	

</script>



</body>
</html>