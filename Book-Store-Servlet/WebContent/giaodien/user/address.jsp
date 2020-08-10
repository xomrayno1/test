<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>

<title>Địa Chỉ</title>
<link href='<c:url value="/css/style.css"></c:url>' rel="stylesheet">
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
					<a class="list-group-item "
						href='<c:url value="/user/edituser"></c:url>'>Thông tin tài
						khoản</a> <a class="list-group-item"
						href='<c:url value="/user/order"></c:url>'>Quản lý đơn hàng</a>
					<a class="list-group-item active"
						href='<c:url value="/user/address"></c:url>'>Sổ địa chỉ</a> <a
						class="list-group-item"
						href='<c:url value="/user/wishlist"></c:url>'>Sản phẩm yêu
						thích</a>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-sm-10">
						<div class="panel panel-default">
							<div class="panel-body text-center">
								<a href='<c:url value="/user/address/create"></c:url>'> +
									Thêm địa chỉ mới</a>
							</div>

						</div>

						<c:forEach items="${listAddress}" var="item">
							<div class="panel panel-default panel-address">
								<div class="panel-body">
									<div class="row">
										<div class="col-sm-10">
											<span class="header-address">${item.name}</span>
											<c:if test="${item.status == 1}">											
												<i class="address-default"><span class="glyphicon glyphicon-ok-circle"></span>Địa chỉ mặt định</i>
											</c:if>
											<p>Địa chỉ : ${item.toString()}</p>
											<p>Điện thoại: ${item.phone}</p>
										</div>
										<div class="col-sm-2">
											<a href='<c:url value="/user/address/edit?id=${item.id}"></c:url>'>Chỉnh Sửa</a>
											<c:if test="${item.status == 0}">
												<p>
													<input type="hidden" id="idAddress" value="${item.id}">
													<button class="btn btn-delete"  data-toggle="modal" data-target="#modal_remove">Xóa</button>
												</p>
											</c:if>
										</div>

									</div>
								</div>
							</div>
						</c:forEach>
						<c:if test="${error != null}">
							<div class="alert alert-danger"> 
								${error}
							</div>
						</c:if>


					</div>
					<div class="col-sm-1"></div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="modal_remove">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<p class="modal-title">Xóa</p>
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						Bạn có chắc chắn muốn xóa không ?
					</div>
					<div class="modal-footer">
						<form action='<c:url value="/user/address/remove" ></c:url>' method="get" id="form-remove">
							<input  name="id" id="id" type="hidden">
					
						
						</form>
						<button class="btn btn-primary" type="submit"  form="form-remove">Có</button>
						<button class="btn" data-dismiss="modal">Không</button>
					</div>
				</div>
			</div>
		</div>

	</div>





	<jsp:include page="/giaodien/footer.jsp"></jsp:include>


<script type="text/javascript">

	var url = "/user/address/remove?id=${item.id}";
	var btnDelete = document.getElementsByClassName('btn-delete');
	for(var i = 0 ; i < btnDelete.length ; i++){
		btnDelete[i].addEventListener('click',function(){
			var idAddress = $(this).parent().find('#idAddress').val();
			$('#id').val(idAddress);
			
		});
	}
	



</script>




</body>
</html>