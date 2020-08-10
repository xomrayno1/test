<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>

<title>Admin</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href='<c:url value="/css/style.css"></c:url>' rel="stylesheet">
<link href='<c:url value="/css/bootstrap.min.css"></c:url>'
	rel="stylesheet">
<script type="text/javascript"
	src='<c:url value="/js/jquery.min.js"></c:url>'>
	
</script>
<script type="text/javascript"
	src='<c:url value="/js/bootstrap.min.js"></c:url>'>
	
</script>

    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href='<c:url value="/css/style1.css"></c:url>'>

</head>

<body>

<jsp:include page="/giaodien/admin/header.jsp"></jsp:include>
<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<div class="list-group">		
					<a class="list-group-item " href='<c:url value="/admin/home"></c:url>'>Trang Chủ</a>
					<a class="list-group-item " href='<c:url value="/admin/account"></c:url>'>Quản lý tài khoản</a>
					<a class="list-group-item active"  href='<c:url value="/admin/book"></c:url>'>Quản lý sách</a>
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
			<!-- '<c:url value="/admin/book/manage?action=search"></c:url>' -->
			<form id="form-search" method="get" action='<c:url value="/admin/book/search"></c:url>'>
			
			</form>
			<div class="col-sm-10">
				<table class="table table-bordered table-hover text-center">
					<tr>
						<td colspan="2"> 
							<input name="name" id="nameSearch" class="form-control" type="text"  placeholder="Tìm kiếm" form="form-search"> 							
						</td>
						<td colspan="1"> 
							<select class="form-control" name="category" form="form-search" id="categorySearch">
								<option value="0">Chọn Danh Mục</option>
								<c:forEach items="${listCategory}" var="item">
									<option value="${item.id}">${item.description}</option>
								</c:forEach>
							</select>							
						</td>
						<td colspan="2" > 
							<input name="dateTo" class="form-control" type="date" form="form-search" id="dateTo">						
						</td>
						<td colspan="2"> 
							<input name="dateFrom" class="form-control" type="date" form="form-search" id="dateFrom">						
						</td>
						<td>
							<button class="btn" form="form-search" type="submit">Tìm kiếm</button>
						</td>
						<td>
							<p class="error" id="error_seacrh"></p>
						</td>
					
					</tr>
															
					<tr >
						<th width="5%" 	>STT</th>
						<th width="15%" >Ảnh Sách</th>
						<th width="18%" >Tên sách</th>
						<th width="10%" >ISBN</th>						
						<th width="10%" >Giá tiền</th>
						<th width="10%">Tác giả</th>
						<th width="10%" >Ngày ra sách</th>
						<th width="10%" >Ngày Tạo</th>
						<th width="12%" >+</th>
					</tr>
					<c:forEach items="${listBook}" var="item" varStatus="i">
						<tr>
							<td>${i.index +1 + (pageCurrent - 1) * 10}</td>
							<td><img src='<c:url value="${item.images}"></c:url>'
								style="width: 150px; height: 90px"></td>
							<td>${item.title}</td>
							<td>${item.ISBN}</td>
							<td><fmt:formatNumber  value="${item.price}" type="currency" />   </td>							
							<td>${item.author.initials}</td>
							<td>${item.publication_date}</td>
							<td>${item.create_Date}</td>
						

							<td><button data-toggle="modal" data-target="#modaldelete"
									type="button" class="btn btn-danger" title="Xóa Sách">Xóa</button>
								<button data-toggle="modal" data-target="#modaldelete"
									type="button" class="btn btn btn-warning" title="Sửa Sách">Sửa</button></td>
						</tr>
						
					</c:forEach>
						<tr>
							<td colspan="9">
								<ul class="pagination">
								<c:set value="${pageCurrent - 1}"  var="pre" />
								<c:if test="${pre < 1}">
									<c:set value="1"  var="pre" />
								</c:if>

									<li><a href='<c:url value="/admin/book?page=${pre}"></c:url>'>&laquo;</a>
									<c:forEach begin="1" end="${soPage}" var="item">
										<c:if test="${item != pageCurrent }">
											<li ><a href="<c:url value="/admin/book?page=${item}"></c:url>">${item}</a></li>
										</c:if>
										<c:if test="${item == pageCurrent }">
											<li class="active" ><a href="<c:url value="/admin/book?page=${item}"></c:url>">${item}</a></li>
										</c:if>
									</c:forEach> 
									
								<c:set value="${pageCurrent + 1}"  var="next" />	
								<c:if test="${next >= soPage}">
									<c:set value="${soPage}"  var="next" />
								</c:if>
								<li><a href='<c:url value="/admin/book?page=${next}"></c:url>'>&raquo;</a>
									
								</ul>
							</td>
						</tr>
						<tr>
							<td colspan="9"><button data-toggle="modal" data-target="#mymodal" class="btn btn-primary">Thêm</button></td>
						</tr>
				</table>
			</div>
		</div>
		
	</div>

<jsp:include page="/giaodien/admin/footer.jsp"></jsp:include>



	<div class="container">


	<div class="modal fade" id="mymodal">
		<div class="modal-dialog">
			<form method="POST"
				action='<c:url value="/admin/book/manage?action=add"></c:url>'
				enctype="multipart/form-data" id="form-addbook">
				<div class="modal-content">
					<div class="modal-header">
						<p class="modal-title">Thêm Sản Phẩm</p>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<div>
							<span>Title</span> <input name="title" class="form-control"
								type="text" id="title" required="required">
						</div>
						<div class="alert-error">
							<p id="alert-title" class="error"></p> 
						</div>
						<div>
							<span>Giá</span> <input type="text" name="price"
								class="form-control" id="price" required="required">
						</div>
						<div class="alert-error">
							<p id="alert-price" class="error"></p> 
						</div>
						<div>
							<span>Ngày phát hành</span> <input type="date" name="publication"
								class="form-control" id="publication" required="required">
						</div>
						<div>
							<span>ISBN</span> <input type="text" name="isbn"
								class="form-control" id="isbn" required="required">
						</div>
						<div class="alert-error">
							<p id="alert-isbn" class="error"></p> 
						</div>
						<div>
							<span>Chi tiết</span>
							<textarea name="comment" rows="5" cols="22" class="form-control"
								id="comment" ></textarea>
						</div>
						<div>
							<span>Chọn danh mục</span> 
							<select class="custom-select form-control" name="category" id="category">
								<option value="0">Chọn Danh Mục</option>
								<c:forEach items="${listCategory}" var="item">
									<option value="${item.id}">${item.description}</option>
								</c:forEach>
							</select>
						</div>						
						<div class="alert-error">
							<p id="alert-category" class="error"></p> 
						</div>
						<div>
							<span>Chọn tác giả</span> 
							<select class="custom-select form-control" name="author" id="author">
								<option value="0">Chọn Tác Giả</option>
								<c:forEach items="${listAuthor}" var="item">
									<option value="${item.id}">${item.initials}</option>
								</c:forEach>
							</select>
						</div>
						<div class="alert-error">
							<p id="alert-author" class="error"></p> 
						</div>
						<div>
							<span>Hình ảnh</span> <input type="file" name="images"
								class="form-control" id="images">
						</div>
						<div class="alert-error">
							<p id="alert-img" class="error"></p>
							<p  class="error">${error}</p> 
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary" id="addbook">Thêm</button>
						<button data-dismiss="modal" class="btn btn-danger" type="button">Thoát</button>
					</div>
				</div>
			</form>
		</div>
	</div>
		
	</div>
<script type="text/javascript">
	var form = document.getElementById('form-addbook');
	var category = document.getElementById('category');
	var author  = document.getElementById('author');
	var images = document.getElementById('images');
	var price = document.getElementById('price');
	var title = document.getElementById('title');
	var isbn = document.getElementById('isbn');
	
	var alertPrice = document.getElementById('alert-price');
	var alertISBN = document.getElementById('alert-isbn');
	var alertTitle = document.getElementById('alert-title')
	var alertCategory = document.getElementById('alert-category');
	var alertAuthor = document.getElementById('alert-author');
	var alertImg = document.getElementById('alert-img');
	
	form.addEventListener('submit',function(evt){
		if(category.value == 0 ){
			evt.preventDefault();
			alertCategory.innerHTML ="Vui lòng chọn danh mục";
		}else{
			alertCategory.innerHTML ="";
		}
		if(author.value == 0 ){
			evt.preventDefault();
			alertAuthor.innerHTML ="Vui lòng chọn tác giả";
		}else{
			alertAuthor.innerHTML = "";
		}
		if(images.value.length == 0){
			evt.preventDefault();
			alertImg.innerHTML ="Vui lòng thêm ảnh sách";
		}else{
			alertImg.innerHTML ="";
		}
		if(price.value.length == 0){
			evt.preventDefault();
			alertPrice.innerHTML ="Vui lòng thêm giá";
		}else{
			alertPrice.innerHTML ="";
		}
		if(title.value.length == 0){
			evt.preventDefault();
			alertTitle.innerHTML ="Vui lòng thêm tiêu đề";
		}else{
			alertTitle.innerHTML ="";
		}
		if(isbn.value.length == 0){
			evt.preventDefault();
			alertISBN.innerHTML ="Vui lòng thêm isbn";
		}else{
			alertISBN.innerHTML ="";
		}
	});
	category.addEventListener('change',function(){
		alertCategory.innerHTML ="";
	});
	author.addEventListener('change',function(){
		alertAuthor.innerHTML ="";
	});
	images.addEventListener('change',function(){
		alertImg.innerHTML ="";
	});
	price.addEventListener('change',function(){
		alertPrice.innerHTML ="";
	});
	isbn.addEventListener('change',function(){
		alertISBN.innerHTML ="";
	});
	title.addEventListener('change',function(){
		alertTitle.innerHTML ="";
	});
	
	
	var formSearch = document.getElementById('form-search');
	formSearch.addEventListener('submit',function(evt){
		var errorSearch = document.getElementById('error_seacrh');
		var name = document.getElementById('nameSearch');
		var category = document.getElementById('categorySearch');
		var dateFrom = document.getElementById('dateFrom');
		var dateTo = document.getElementById('dateTo');
		
		
		
			
	});
	
</script>


</body>
</html>