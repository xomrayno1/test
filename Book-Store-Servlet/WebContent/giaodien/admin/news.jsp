<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>

<title>Admin</title>
<script type="text/script" src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
<script type="text/script" src='<c:url value="/js/jquery.min.js"></c:url>'></script>
<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/fonts/glyphicons-halflings-regular.eot"></c:url>'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href='<c:url value="/css/style1.css"></c:url>'>
<script type="text/javascript" src='<c:url value="/ckeditor/ckeditor.js"></c:url>'></script>
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
					<a class="list-group-item"  href='<c:url value="/admin/order"></c:url>'>Quản lý đơn hàng</a>
					<a class="list-group-item active"  href='<c:url value="/admin/news"></c:url>'>Quản lý tin tức</a>
					<a class="list-group-item"  href='<c:url value="/admin/contact"></c:url>'>Quản lý liên hệ</a>
					<!-- <a class="list-group-item"  href='<c:url value="#"></c:url>'>Quản lý mã coupon</a> -->
					<a class="list-group-item"  href='<c:url value="/logout"></c:url>'>Thoát</a>
				</div>
			</div>
			<div class="col-sm-10">
					<table class="table table-bordered table-hover text-center">
					<tr style="text-align: center;">
						<th width="5%">STT</th>
						<th width="15%">Hình ảnh</th>
						<th width="20%">Tiêu Đề</th>
						<th width="35%">Nội Dung</th>
						<th width="10%">Ngày Tạo</th>
						<th width="15%">+</th>
					</tr>
					<c:forEach items="${listNewsPagi}" var="item" varStatus="i">
						<tr>
							<td>${i.index + 1 + (pageCurrent - 1) * 5}</td>
							<td><img alt="" src='<c:url value="${item.img}" ></c:url>' style="width: 150px; height: 90px"></td>
							<td>${item.title}</td>	
							<td><p class="line-content">${item.content}</p></td>	
							<td>${item.create}</td>															
							<td>
								<a href="#"><button class="btn " title="Chi tiết">!</button></a>
								<a href="#"><button class="btn btn btn-danger" title="Xóa Danh Mục">Xóa</button></a>
								<a href="#"><button class="btn btn btn-warning" title="Sửa Danh Mục">Sửa</button></a>	
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6">
							<ul class="pagination">
							<c:set value="${pageCurrent - 1}"  var="pre" />
								<c:if test="${pre < 1}">
									<c:set value="1"  var="pre" />
								</c:if>
							<li><a href='<c:url value="/admin/news?page=${pre}"></c:url>'>&laquo;</a>
								<c:forEach begin="1"  end="${soPage}" var="item">
									<c:if test="${pageCurrent != item}">
										<li  ><a href='<c:url value="/admin/news?page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									<c:if test="${pageCurrent == item}">
										<li class="active" ><a href='<c:url value="/admin/news?page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									
								</c:forEach>
								<c:set value="${pageCurrent + 1}"  var="next" />	
								<c:if test="${next >= soPage}">
									<c:set value="${soPage}"  var="next" />
								</c:if>
								
								<li><a href='<c:url value="/admin/news?page=${next}"></c:url>'>&raquo;</a>
							</ul>
						</td>
					</tr>
					<tr>
						<td colspan="6"><button data-toggle="modal" data-target="#modal-news" class="btn btn-primary">Thêm</button></td>
					</tr>
				</table>
			</div>			
		</div>
		
		<form action='<c:url value="/admin/news/create"></c:url>' method="POST" enctype="multipart/form-data">
			<div class="modal fade" id="modal-news">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<p class="modal-title">Thêm Trang Tin Tức</p>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<div>
							<span>Title</span> <input name="title" class="form-control"
								type="text" id="title" required="required" >
						</div>
						<div class="alert-error">
							<p id="alert-title" class="error"></p> 
						</div>
						<div>
							<span>Hình ảnh</span> <input type="file" name="images"
								class="form-control"  required="required" >
						</div>
						<div>
							<textarea rows="10" name="content" cols="70" id="editor"></textarea>
						</div>
						<div class="alert-error">
							<p id="alert-price" class="error"></p> 
						</div>
					</div>
					<div class="modal-footer">
						 <button type="submit" class="btn btn-primary" >Save changes</button>
        				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		
		</form>
		
		
	</div>




<jsp:include page="/giaodien/admin/footer.jsp"></jsp:include>

<script type="text/javascript">
	//CKEDITOR.replace('editor');

</script>
</body>
</html>