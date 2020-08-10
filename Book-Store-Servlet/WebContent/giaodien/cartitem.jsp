<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Giỏ Hàng</title>
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
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">


		
		<c:if test="${sessionScope.listCartItems != null }">
		<div class="alert alert-info">Danh sách giỏ hàng</div>
			<div class="row">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-sm-2 text-center">Hình ảnh</div>
							<div class="col-sm-2">Tên sản phẩm</div>
							<div class="col-sm-2">Giá sản phẩm</div>
							<div class="col-sm-2">Số lượng</div>
							<div class="col-sm-2">Tạm tính</div>
							<div class="col-sm-2"></div>
						</div>

					</div>					
					<div class="panel-body">
						<c:forEach items="${listGioHang}" var="item">
							<div class="row">
								
								<div class="col-sm-2 text-center">
									<a href="product-detail?id=${item.books.id}"> <img
										class="img-cartitem"
										src='<c:url value="${item.books.images}"></c:url>'>
									</a>
								</div>
								<div class="col-sm-2">
									<a href="product-detail?id=${item.books.id}">${item.books.title}</a>
								</div>
								<div class="col-sm-2">
									<fmt:formatNumber type="currency" value="${item.books.price}" />
								</div>
								<form action='<c:url value="/update-cart-item"></c:url>' method="POST"
									id="quantity-update">
									<div class="col-sm-2">
										<div class="iaIXXn">
											<span class="qty-decrease">-</span>
											<input type="text" name="sl" value="${item.quantity}" class="qty" id="qty">
											 <input type="hidden" name="id" value="${item.books.id}">
											<span class="qty-increase">+</span>
										</div>										
									</div>
									<div class="col-sm-2">
										<fmt:formatNumber value="${item.total_Price}" type="currency" />
									</div>
									<div class="col-sm-2">
										<button class="btn btn-danger" formmethod="get"
											formaction='<c:url value="/remove-cart-item?id=${item.books.id}"   ></c:url>'>Xóa</button>
										<button class="btn btn-info">Sửa</button>
									</div>
									
									<input class="id" name="id" type="hidden" id="id" value="1"> 
								</form>
								

							</div>
							<br>

							<c:set var="price" value="${price + item.total_Price}" />
						</c:forEach>
					</div>
					
					
					
					<div class="panel-footer">
						<div class="row">
							<div class="col-sm-3 text-center">
								<h4>Thành tiền</h4>
							</div>
							<div class="col-sm-2"></div>
							<div class="col-sm-2"></div>
							<div class="col-sm-1"></div>
							<div class="col-sm-2">
								<fmt:formatNumber value="${price}" type="currency" />
							</div>
							<div class="col-sm-2"></div>
						</div>

					</div>
					<div class="panel-footer">
						<div class="row">
							<div class="col-sm-6">
							<a href='<c:url value="/user/shipping"></c:url>'><button
								class="btn btn-info">Tiến Hành Đặt Hàng</button></a> <a
							href='<c:url value="/home"></c:url>'><button
								class="btn btn-warning">Tiếp tục mua</button></a> <a
							href='<c:url value="/remove-cart"></c:url>'><button
								class="btn btn-danger">Hủy giỏ hàng</button></a>
							</div>
						</div>
						
					</div>
					<div class="panel-footer "> 
						<div class="row">							
							<div  class="col-sm-6">
								<p>Mã giảm giá / Quà tặng</p>
							</div>
						</div>
						<div class="row codeSale">
							<div  class="col-sm-6">
								<input type="text" name="code" class="form-control" placeholder="Nhập ở đây..."> <button class="btn btn-warning">Đồng Ý</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			
			
		</c:if>
		<c:if test="${sessionScope.listCartItems == null }">
			<div class="alert alert-danger">
				<span class="glyphicon glyphicon-remove-sign"> </span> Giỏ hàng không có sản phẩm. Vui lòng thực hiện lại.
			</div>
			<div class="row">
				<div class="panel">
					<div class="panel-heading">
					</div>
					<div class="panel-body">
						<div class="cart-empty">
							<img alt="" src='<c:url value="/images/mascot@2x.png"></c:url>'  class="empty_img">
							<p class="empty_note">Không có sản phẩm nào trong giỏ hàng của bạn.</p>
							<a class="empty_btn" href='<c:url value="/home"></c:url>' >Tiếp tục mua sắm</a>
						</div>
					</div>
				</div>
			</div>
		
		</c:if>
		
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">

		$(document).ready(function(){
			var qtyIncrease = document.getElementsByClassName('qty-increase');
			var qtyDecrease = document.getElementsByClassName('qty-decrease');
			var qty = document.getElementsByClassName('qty');

			for(var i = 0 ; i < qtyIncrease.length ; i++){
				qtyIncrease[i].addEventListener('click',function(){				
					var x =  $(this).parent().find('#qty');
					var value = parseInt(x.val(),10)+1;
					x.val(value);
					if(x.val() > 10){
						x.val(10);
						alert("Số lượng mua tối đa sản phẩm này là 10 ");
					}
					
						
				});
				qtyDecrease[i].addEventListener('click',function(){				
					var x =  $(this).parent().find('#qty');
					var value = parseInt(x.val(),10)-1;
					x.val(value);
					if(x.val() <= 1 ){
						x.val(1);
					}
				});
			}
			for(var i = 0 ; i < qty.length ; i++){  //change
				qty[i].addEventListener('change',function(){
					var numberValue = parseInt(this.value,10);
					if(numberValue >= 10){
						this.value = 10;
						alert("Số lượng mua tối đa sản phẩm này là 10 ");
					}else if(numberValue <= 1){
						this.value = 1;
					}
					
				});
			}
		});

		
	</script>
	

</body>
</html>