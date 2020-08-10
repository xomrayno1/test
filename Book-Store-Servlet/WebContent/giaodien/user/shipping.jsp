<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>
<head>
<title>Thanh toán</title>
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
	<div class="alert alert-info">Địa Chỉ</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">Địa Chỉ Giao Hàng</div>
					<div class="panel-body">
						<div class="row " style="margin-left: 20px">
							<c:forEach items="${listAddress}" var="address">
								<div class="col-sm-6">
									<div class="panel">
										<div class="panel-body panel-shipping">
											<span class="header-address">${address.name}</span>
											<c:if test="${address.status == 1}">
												<i class="address-default"><span
													class="glyphicon glyphicon-ok-circle"></span> Địa chỉ mặt
													định</i>
											</c:if>
											<p>Địa chỉ : ${address.toString()}</p>
											<p>Điện thoại: ${address.phone}</p>
											<a href='<c:url value="/user/payment?id=${address.id}"></c:url>'><button
													class="btn btn-primary">Giao đên địa chỉ này</button></a> <a
												class="modify"
												href='<c:url value="/user/address/edit?id=${address.id}"></c:url>'><button
													class="btn ">Sửa</button></a>
													
													
											
												<c:if test="${address.status == 0 }">
													<button class="btn delete"    data-toggle="modal" data-target="#modalDelete" >Xóa</button>
												</c:if>
											
											<input type="hidden" name="id" id="id" value="${address.id}">
										</div>
									</div>
								</div>

							</c:forEach>
						</div>
					</div>
					<div class="panel-footer">
						<p>
							Bạn có muốn giao hàng đến địa chỉ khác ?<a
								href='<c:url value="/user/address/create"></c:url>'>Thêm địa
								chỉ giao hàng mới</a>
						</p>
					</div>
				</div>
			</div>

		</div>

		<form action='<c:url value="/user/address/remove"></c:url>' method="POST">
			<div class="modal" id="modalDelete">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						Xóa địa chỉ
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Bạn muốn xoá địa chỉ này ra khỏi sổ
						địa chỉ?</div>
					<div class="modal-footer">
						<input type="hidden" name="id" id="id">
						<button class="btn" data-dismiss="modal">Không</button>
						<button type="submit" class="btn btn-primary" id="btn-dongy">Đồng Ý</button>
					</div>
				</div>
			</div>
		</div>
		</form>
		
	</div>


	<jsp:include page="/giaodien/footer.jsp"></jsp:include>

<script type="text/javascript">
	//var btnDelete = document.getElementById('delete');
	//btnDelete.addEventListener('click',function(){
	//	var id = document.getElementById('id').value;
	//	alert(id);
	//}); 

	$(document).ready(function(){
		$(".delete").on('click',function(){
			var id =  $(this).parent().find('#id').val();
			
			$('#modalDelete #id').val(id);
		});
	});
</script>


</body>
</html>



