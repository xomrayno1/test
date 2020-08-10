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
					<a class="list-group-item"  href='<c:url value="#"></c:url>'>Quản lý tác giả</a>
					<a class="list-group-item active"  href='<c:url value="/admin/order"></c:url>'>Quản lý đơn hàng</a>
					<a class="list-group-item"  href='<c:url value="/admin/news"></c:url>'>Quản lý tin tức</a>
					<a class="list-group-item"  href='<c:url value="/admin/contact"></c:url>'>Quản lý liên hệ</a>
					<a class="list-group-item"  href='<c:url value="#"></c:url>'>Quản lý mã coupon</a>
					<a class="list-group-item"  href='<c:url value="/logout"></c:url>'>Thoát</a>
				</div>
			</div>
			<div class="col-sm-10">
					<table class="table table-bordered table-hover text-center">
					<tr>
					
						<td colspan="2">
						<input id="idStatus" type="hidden" value="${param.status}">
							<form action='<c:url  value="/admin/order/search"></c:url>' method="get" id="formSearch">
							<select name="status" class="form-control" id="select_status">
								<option value="0">--Chọn Tình Trạng--</option>
								<option value="2">Thành Công</option>
								<option value="3">Đang Xử Lý</option>
								<option value="1">Hủy Đơn Hàng</option>
							</select>
							</form>
						</td>	
						<td colspan="2">
							<button class="btn" form="formSearch">Tìm Kiếm</button>
						</td>
						<td colspan="2"> Kết quả tìm kiếm : ${status}</td>						
					</tr>
					<tr style="text-align: center;">
						<th width="10%">STT</th>
						<th width="10%">Mã Đơn Hàng</th>
						<th width="20%">Tài Khoản</th>
						<th width="10%">Tổng Tiền</th>
						<th width="15%">Ngày Tạo</th>
						<th width="15%">Tình Trạng</th>
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
								<input type="hidden" value="${item.id}"  id="idOrder">
								<input type="hidden" value="${item.idAddress}"  id="address_id">
								<input type="hidden" value="${item.users.id}"  id="user_id">
								
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
							<li><a href='<c:url value="/admin/order/search?status=${param.status}&&page=${pre}"></c:url>'>&laquo;</a>
								<c:forEach begin="1"  end="${soPage}" var="item">
									<c:if test="${pageCurrent != item}">
										<li  ><a href='<c:url value="/admin/order/search?status=${param.status}&&page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									<c:if test="${pageCurrent == item}">
										<li class="active" ><a href='<c:url value="/admin/order/search?status=${param.status}&&page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									
								</c:forEach>
								<c:set value="${pageCurrent + 1}"  var="next" />	
								<c:if test="${next >= soPage}">
									<c:set value="${soPage}"  var="next" />
								</c:if>
								
								<li><a href='<c:url value="/admin/order/search?status=${param.status}&&page=${next}"></c:url>'>&raquo;</a>
							</ul>
						</td>
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
								 <option value="0">Tình Trạng Đơn Hàng</option>
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

	var btnInfo = document.getElementsByClassName('btn-info');
	var btnUpdate = document.getElementsByClassName('btn-update');	  
	for(var i = 0 ; i < btnInfo.length ; i++){
		btnInfo[i].addEventListener('click',function(){
			var idOrder = $(this).parent().find('#idOrder');
			var idAddress = $(this).parent().find('#address_id');
			var idUser = $(this).parent().find('#user_id');
			
			var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			     var arr = JSON.parse(this.responseText);
			     var table = document.getElementById('table');
			     var str = "<tr><td width='50%'>Tên sách</td><td width='15%'>Giá sách</td><td width='15%'>Số lượng</td><td width='20%'>Tạm tính</td></tr>";
			     var total = 0;
			     var quantity = 0;
			     for(var j = 0 ; j < arr.length ; j++){
			    	 str += "<tr><td>"+arr[j].books.title+"</td><td>"+arr[j].books.price+"</td><td>"+arr[j].quantity+"</td><td>"+arr[j].total_Price+"</td></tr>";
			    	 total += arr[j].total_Price;
			    	 quantity += arr[j].quantity;
			     }
			     str += "<tr><td>THÀNH TIỀN</td><td></td><td>"+quantity+"</td><td>"+total+"</td></tr>";
			     table.innerHTML = str;			       		     			     
			    }
			  };			  			  
			  xhttp.open("GET", "http://localhost:8080/Book-Store-Servlet/admin/api/cartitem?idOrder="+idOrder.val(), true);
			  xhttp.send();
			  
			  
			
				var xhttp = new XMLHttpRequest();
				  xhttp.onreadystatechange = function() {
				    if (this.readyState == 4 && this.status == 200) {
				     var arr = JSON.parse(this.responseText);
				   	var tableAddress = document.getElementById('table-address');
				   	 var straddress = "<tr><td> Tên : "+arr.name+"</td></tr>" + "<td> Phone : "+arr.phone+"</td></tr>";
				  	 	 straddress  += "<tr><td> Địa Chỉ : "+ arr.province.name +" , "+ arr.district.prefix +" "+arr.district.name +" , "+arr.ward.prefix+" "+arr.ward.name +" , "+arr.description+"</td></tr>" ;
				   		tableAddress.innerHTML = straddress;
				    }
				  };
				  xhttp.open("GET", "http://localhost:8080/Book-Store-Servlet/admin/api/address?action=get&&address="+idAddress.val()+"&&user="+idUser.val(), true);
				  xhttp.send();			   						
		});		
		
		
		btnUpdate[i].addEventListener('click',function(){
			var id = $(this).parent().find('#idOrder').val();		
			$("#idOd").val(id);
			var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			     var arr = JSON.parse(this.responseText);			   
			   	 var select_Status = document.getElementById('select_status');
			   	select_Status.value = arr.status;
			   	 var user_update = document.getElementById('user_update');
			   	 var str = "<li class='list-group-item'> Tài khoản đặt hàng  : "+arr.users.userName+"</li><li class='list-group-item'>Mã đơn hàng :"+ arr.id +"</li>";
			   	 	str += "<li class='list-group-item'> Ngày Tạo : "+arr.date+"</li>"
			   	user_update.innerHTML = str ;
			  
			    }
			  };
			  xhttp.open("GET", "http://localhost:8080/Book-Store-Servlet/admin/order/api?id="+id, true);
			  xhttp.send();	
		});
	}
	var idStatus = document.getElementById('idStatus').value;
	var selectStatus = document.getElementById('select_status');
	selectStatus.value =  idStatus;
	

</script>



</body>
</html>