<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
						khoản</a> <a class="list-group-item active" 
						href='<c:url value="/user/order"></c:url>'>Quản lý đơn hàng</a>
					<a class="list-group-item"
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
							<table class="table">
								<tr>
									<td width="5%">STT</td>
									<td width="15%">Mã Đơn</td>
									<td width="20%">Tổng Tiền</td>
									<td width="20%">Ngày Tạo</td>
									<td width="20%">Tình Trạng</td>
									<td width="20%">+</td>
								</tr>
								<c:forEach items="${listOrderPagi}" var="item" varStatus="i">
								<tr>
									<td>${i.index + 1 + ((pageCurrent - 1) * 5)}</td>
									<td>${item.id}</td>
									<td><fmt:formatNumber value="${item.totalPrice}" type="currency" /> </td>
									<td>${item.date}</td>
									<td>${item.getStatusDisplay()}</td>
									<td>
										<input id="idOrder" type="hidden" value="${item.id}">
										<input id="idAddress" type="hidden" value="${item.idAddress}">
										<button class="btn btn_info" title="Xem Chi Tiết" data-toggle="modal" data-target="#modal_info">!</button>
										<c:if test="${item.status == 3}">
											
										<button class="btn btn-danger btn_cancel" data-target="#modal_remove"  data-toggle="modal" title="Hủy Đơn Hàng">Hủy</button>
										</c:if>
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
							<li><a href='<c:url value="/user/order?page=${pre}"></c:url>'>&laquo;</a>
								<c:forEach begin="1"  end="${soPage}" var="item">
									<c:if test="${pageCurrent != item}">
										<li  ><a href='<c:url value="/user/order?page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									<c:if test="${pageCurrent == item}">
										<li class="active" ><a href='<c:url value="/user/order?page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									
								</c:forEach>
								<c:set value="${pageCurrent + 1}"  var="next" />	
								<c:if test="${next >= soPage}">
									<c:set value="${soPage}"  var="next" />
								</c:if>
								
								<li><a href='<c:url value="/user/order?page=${next}"></c:url>'>&raquo;</a>
							</ul>
									</td>
								
								</tr>
							</table>

						</div>
					<div class="col-sm-1"></div>
				</div>
			</div>
		</div>
		
		
		 
		<div class="modal fade" id="modal_remove">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<p>Xóa sản phẩm</p>
						<button class="close" data-dismiss="modal" data-toggle="modal">&times;</button>
					</div>
					<div class="modal-body">
						Bạn có chắc chắn muốn hủy đơn hàng này không ? 
					</div>
					<div class="modal-footer">
					<form action='<c:url value="/user/order/remove"></c:url>' method="get" id="form-remove">
						<input id="idOd" type="hidden" name="id">
					</form>
						
						<button class="btn btn-primary" form="form-remove" type="submit">Có</button>
						<button class="btn btn-danger" data-dismiss="modal">Không</button>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="modal_info">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<p class="modal-title">Chi Tiết Đơn Hàng</p>
						<button class="close" data-dismiss="modal">&times;</button>
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
						<button class="btn" data-dismiss="modal" >Close</button>
					</div>
				</div>
			</div>
		</div>

	</div>





	<jsp:include page="/giaodien/footer.jsp"></jsp:include>


<script type="text/javascript">
 var btnCancel = document.getElementsByClassName('btn_cancel');
 var btnInfo = document.getElementsByClassName('btn_info');
 for(var i = 0; i < btnCancel.length ; i++){
	 btnCancel[i].addEventListener('click',function(){
		 var idOrder = $(this).parent().find('#idOrder').val();
		 $('#idOd').val(idOrder);
	 });
 }
 for(var i  = 0 ;  i < btnInfo.length ; i++){
	 btnInfo[i].addEventListener('click',function(){
		 var idOrder = $(this).parent().find('#idOrder').val();
		 
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
			  xhttp.open("GET", "http://localhost:8080/Book-Store-Servlet/user/api/cartitem?idOrder="+idOrder, true);
			  xhttp.send();
			  
			  
			  
			  var idAddress = $(this).parent().find('#idAddress').val();
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
			  xhttp.open("GET", "http://localhost:8080/Book-Store-Servlet/user/api/address?id="+idAddress, true);
			  xhttp.send();	
	 });
	 
	 
 }



</script>




</body>
</html>