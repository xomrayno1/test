<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
 	<script  type="text/script" src="js/bootstrap.min.js" ></script>
    <script  type="text/script" src="js/jquery.min.js" ></script>
    <link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"></c:url>'  >
    <link rel="stylesheet" href='<c:url value="/fonts/glyphicons-halflings-regular.eot"></c:url>'  >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
 	<link rel="stylesheet" href='<c:url value="/css/style1.css"></c:url>'  >


</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="alert alert-success">NÊN sao chép, chia sẻ, KHÔNG
			NÊN thương mại hoá.</div>
		<div class="row">

			<div class="col-sm-10">
				<div class="panel panel-primary">
					<div class="panel-heading">Sách Mới Nhất</div>
					<div class="panel-body">
						<div class="row text-center">
						<c:forEach items="${listP}" var="item">
							<div class="col-sm-3">
								<div class="thumbnail" style="height: 284px;">
									<img src='<c:url value="${item.images}"></c:url>'>
									<p><a href="product-detail?id=${item.id}">${item.title}</a></p>
									<p>Giá : <fmt:formatNumber value="${item.price}" type="currency" /></p>
									<div class="row" >
										<a href='<c:url value="/add-cart-item?id=${item.id}"></c:url>'><button class="btn btn-default">Đặt Mua</button></a>
										<a href='<c:url value="/user/wishlist/add?id=${item.id}"></c:url>'><button class="btn btn-default btn-wish">Yêu Thích</button></a>
									</div>
									<input type="hidden" name="id" id="id" class="id" value="${item.id}">
								</div>
							</div>
						
						</c:forEach>

						</div>

					</div>

				</div>

			</div>

			<div class="col-sm-2">
				<div class="panel panel-primary">
					<div class="panel-heading">Tìm Kiếm Giá</div>
					<div class="panel-body panel-search-price"> 
						<ul class="list-group search-price"> 
							<li class="list-group-item"><a href="#">Dưới 100.000</a></li>
							<li class="list-group-item"><a href="#">Từ 100.000 - 150.000</a></li>
							<li class="list-group-item"><a href="#">Từ 150.000 - 200.000</a></li>
							<li class="list-group-item"><a href="#">Từ 200.000 - 300.000</a></li>
							<li class="list-group-item"><a href="#">Lớn hơn 300.000</a></li>
						</ul>
					</div>
				</div>
				<div class="panel panel-primary ">
					<div class="panel-heading">Thể Loại Sách</div>
					<div class="panel-body panel-search-category">
						<ul class="list-group search-category ">
							<c:forEach items="${listcategory}" var="item"> 
								<li class="list-group-item"><a href='<c:url value="/category?id=${item.id}"></c:url>'>${item.description}</a></li>
							</c:forEach>
						</ul>
					


					</div>
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-10">
				<div class="panel panel-primary">
				<div class="panel-heading">
					Sản phẩm vừa xem
				</div>
				
				<div class="panel-body">
					<div class="row text-center">
					<c:forEach items="${listBooksViewed}" var="item">
						<div class="col-sm-3">
							<div class="thumbnail" style="height: 284px;">								
									<img src='<c:url value="${item.images}"></c:url>'>
									<p><a href="product-detail?id=${item.id}">${item.title}</a></p>
									<p>Giá : <fmt:formatNumber value="${item.price}" type="currency" /></p>
									<div class="row" >
										<a href='<c:url value="/add-cart-item?id=${item.id}"></c:url>'><button class="btn btn-default">Đặt Mua</button></a>
										<a href='<c:url value="/user/wishlist/add?id=${item.id}"></c:url>'><button class="btn btn-default btn-wish">Yêu Thích</button></a>
									</div>
									<input type="hidden" name="id" id="id" class="id" value="${item.id}">														
							</div>
						</div>					
					</c:forEach>
					</div>	 
				</div>					 
			</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
	
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

<c:if test="${sessionScope.users != null}">
	<script type="text/javascript">
	
	$(document).ready(function(){
		ajaxListWish();
		function ajaxListWish(){
			var xhttp = new XMLHttpRequest() || ActiveXObject();
			xhttp.onreadystatechange = function() {
				//Kiem tra neu nhu da gui request thanh cong
				if (this.readyState == 4 && this.status == 200) {					
					var arr = JSON.parse(this.responseText);
					var btnWish = document.getElementsByClassName("btn-wish");
					var id = document.getElementsByClassName("id");
						
					for(var i = 0 ; i < arr.length ; i++){
						
						for(var j = 0 ; j < id.length ; j++){
							
							if(arr[i].bookId.toString() == id[j].value){								
								btnWish[j].disabled = true;
							}
						}
					}
				}
			};
			//cau hinh request
			xhttp.open('GET','http://localhost:8080/Book-Store-Servlet/user/wishlist/api',true);
			//cau hinh header cho request
			//xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			//gui request
			xhttp.send('data=true');
			
		}
		
		
	});
			
					
	</script>

</c:if>

</body>
</html>