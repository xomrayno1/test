<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chi Tiết sản phẩm</title>
<link href="css/style.css" rel="stylesheet">
<script type="text/script" src="js/bootstrap.min.js"></script>
<script type="text/script" src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="fonts/glyphicons-halflings-regular.eot">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href='<c:url value="/css/style1.css"></c:url>'>

</head>
<body>
	<c:url value="add-cart-item" var="addcartitem" />
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="alert alert-success">NÊN sao chép, chia sẻ, KHÔNG
			NÊN thương mại hoá.</div>

		<div class="row">
			<div class="col-sm-10">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-4">
								<img src='<c:url value="${book.images}"></c:url>'
									class="img-thumbnail">
							</div>
							<div class="col-sm-8">
								<h3>
									<a href="#">${book.title}</a>
								</h3>
								<p>Tác giả : ${book.author.initials}</p>
								<p>
									Thể loại : <a
										href='<c:url value="/category?id=${book.category_Id}"></c:url>'>${category.description}</a>
								</p>
								<p>Ngày xuất bản : ${book.publication_date}</p>
								<p>
									Giá tiền :
									<fmt:formatNumber value="${book.price}" type="currency" />
								</p>
								<form action="add-cart-item?id=${book.id}" method="POST"
									style="margin-bottom: 20px;" id="form-quantity">
									Số Lượng : <input type="number" name="sl" value="1"
										style="width: 50px;" min="1" max="10">
								</form>
								<button type="submit" class="btn btn-primary"
									form="form-quantity">Đặt Mua</button>
								<a
									href='<c:url value="/user/wishlist/add?id=${book.id}"></c:url>'><button
										class="btn btn-warning btn-wish">Yêu Thích</button></a>
							</div>
						</div>
						<div class="row text-center">
							<hr>
							<hr>
							<p class="chi-tiet">
							<p>${book.comments}</p>

						</div>

					</div>

				</div>


			</div>
			<div class="col-sm-2">
				<div class="panel panel-primary">
					<div class="panel-heading">Danh Ngôn Hay</div>
					<div class="panel-body">Đằng sau người đàn ông thành công là
						bóng hình của một người phụ nữ. Còn đằng sau người phụ nữ thành
						công là sự cô đơn.</div>

				</div>
				<div class="panel panel-primary panel-category">
					<div class="panel-heading">Thể Loại Sách</div>
					<div class="panel-body">
						<div class="nav flex-column nav-pills nav-category">
							<c:forEach items="${listcategory}" var="item">
								<a href='<c:url value="/category?id=${item.id}"></c:url>'
									class="nav-link">${item.description}</a>
							</c:forEach>
						</div>

					</div>
				</div>
			</div>

		</div>


		<div class="row">
			<div class="col-sm-10">
				<div class="panel panel-primary">
					<div class="panel-heading">Sản phẩm vừa xem</div>

					<div class="panel-body">
						<div class="row text-center">
							<c:forEach items="${listBooksViewed}" var="item">
								<div class="col-sm-3">
									<div class="thumbnail" style="height: 284px;">
										<img src='<c:url value="${item.images}"></c:url>'>
										<p>
											<a href="product-detail?id=${item.id}">${item.title}</a>
										</p>
										<p>
											Giá :
											<fmt:formatNumber value="${item.price}" type="currency" />
										</p>
										<div class="row">
											<a
												href='<c:url value="/add-cart-item?id=${item.id}"></c:url>'><button
													class="btn btn-default">Đặt Mua</button></a> <a
												href='<c:url value="/user/wishlist/add?id=${item.id}"></c:url>'><button
													class="btn btn-default btn-wish">Yêu Thích</button></a>
										</div>
										<input type="hidden" name="id" id="id" class="id"
											value="${item.id}">
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


	<c:if test="${sessionScope.users }">
		<script type="text/javascript">
	
	$(document).ready(function(){
		ajaxListWish();
		function ajaxListWish(){
			var xhttp = new XMLHttpRequest() || ActiveXObject();
			xhttp.onreadystatechange = function() {
				//Kiem tra neu nhu da gui request thanh cong
				if (this.readyState == 4 && this.status == 200) {					
					var arr = JSON.parse(this.responseText);
					console.log(arr);
					if(arr.bookId == ${book.id}){
						var btnWish = document.getElementsByClassName("btn-wish");
						for(var j = 0 ; j < btnWish.length ; j++){							
							btnWish[j].disabled = true;
							break;
						}
					}
				}
			};
			//cau hinh request
			xhttp.open('GET','http://localhost:8080/Book-Store-Servlet/user/wishlist/api?id='+${book.id},true);
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