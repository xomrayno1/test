
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thông tin thanh toán</title>
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
	<div class="alert alert-info">Thông tin thanh toán</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-sm-10">
								Đơn hàng
							</div>
							<div class="col-sm-2">
								<a href="#" style="text-align: right;"><button class="btn">Sửa</button></a>
							</div>
						</div>
						
					</div>
					<div class="panel-body">
						<c:forEach items="${listGioHang}" var="item">
							<div class="col-sm-8">
								<p>${item.quantity} x ${item.books.title}</p>
							</div>
							
							<div class="col-sm-4">
							<fmt:formatNumber  value="${item.books.price}" type="currency" />
							</div>
						<c:set var="total" value="${total +item.books.price}" />			
						</c:forEach>
						
					</div>
					<div class="panel-footer">
						<div class="row">
							<div class="col-sm-8">
								<p>Tạm tính</p>
							</div>
							
							<div class="col-sm-4">								
								<fmt:formatNumber  value="${total}" type="currency" />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-8">
								<p>Phí vận chuyển</p>
							</div>
							
							<div class="col-sm-4">
								
								<fmt:formatNumber  value="${0}" type="currency" />
							</div>
						</div> 
						<hr class="hr-shipping">
						<div class="row">
							<div class="col-sm-8">
								<p>Thành tiền</p>
							</div>
							
							<div class="col-sm-4">								
								<fmt:formatNumber  value="${total + 0}" type="currency" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-sm-10">
								Địa chỉ giao hàng
							</div>
							<div class="col-sm-2">
								<a href='<c:url value="/user/address/edit?id=${address.id}"></c:url>' ><button class="btn">Sửa</button></a>
							</div>
						</div>
					</div>
					<div class="panel-body">
										<div class="panel-body panel-shipping">
											<span class="header-address">${address.name}</span>
											<p>Địa chỉ : ${address.toString()}</p>
											<p>Điện thoại: ${address.phone}</p> 
										</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<a href='<c:url value="/user/add-order?address=${address.id}"></c:url>'><button class="btn btnOrder" >Đặt Mua</button></a>
		</div>
		<div class="row" style="margin-bottom: 30px">
			<i >(Xin vui lòng kiểm tra lại đơn hàng trước khi Đặt Mua.)</i>
		</div>
		
	</div>
<jsp:include page="/giaodien/footer.jsp"></jsp:include>


<script type="text/javascript">



</script>

</body>
</html>