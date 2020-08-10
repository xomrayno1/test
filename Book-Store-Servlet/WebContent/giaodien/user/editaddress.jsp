<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
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
<style>
</style>
<body>
	<c:url value="/user/address/edit?id=${address.id}" var="url" />
	<jsp:include page="/giaodien/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="list-group">
					<a class="list-group-item"
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
					<div class="col-sm-2"></div>
					<div class="col-sm-8">
						<form action="${url}" method="POST" id="form-update">
							<table>
								<tr>
									<td>Họ và tên :</td>
									<td><input type="text" name="name" value="${address.name}"
										required="required" class="form-control" id="name"></td>
								</tr>
								<tr class="alert-error">
									<td colspan="2">
										<p id="alert-name" class="error"></p>
									</td>
								</tr>
								<tr>
									<td>Số điện thoại :</td>
									<td><input type="text" name="phone"
										value="${address.phone}" required="required" class="form-control" id="phone"></td>
								</tr>
								<tr class="alert-error">
									<td colspan="2">
										<p id="alert-phone" class="error"></p>
									</td>
								</tr>
								<tr>
									<td>Tỉnh/Thành phố :</td>
									<td>
										<select class="form-control" id="province"  name="province"> <!-- ${address.province.name} -->
											
										</select>
									</td>
								</tr>
								<tr class="alert-error">
									<td colspan="2">
										<p id="alert-provincial" class="error"></p>
									</td>
								</tr>
								<tr>
									<td>Quận huyện :</td>
									<td><select class="form-control" id="district"
										name="district">
											<!-- ${address.district.name} -->

									</select></td>
								</tr>
								<tr class="alert-error">
									<td colspan="2">
										<p id="alert-district" class="error"></p>
									</td>
								</tr>
								<tr>
									<td>Phường xã :</td>
									<td>
										<select class="form-control" id="ward"name="ward"> <!--${address.ward.name} -->
										</select>
									</td>	
								</tr>
								<tr class="alert-error">
									<td colspan="2">
										<p id="alert-ward" class="error"></p>
									</td>
								</tr>
								<tr>
									<td>Chi tiết :</td>
									<td><textarea rows="4" cols="22" name="description"
											required="required" class="form-control"   id="descript">${address.description}</textarea>
											</td> <!--${address.description} -->
								</tr>
								<tr class="alert-error">
									<td colspan="2"> <p id="alert-description" class="error"></p> </td>
								</tr>
								<c:if test="${address.status == 0}">
									<tr>
										<td colspan="2" style="text-align: center;"><input
											type="checkbox" name="status" value="1"> Đặt làm địa
											chỉ mặt định</td>
									</tr>
								</c:if>
								<tr>
									<td colspan="2" style="text-align: center;"><button
											class="btn btn-primary">Cập nhật</button></td>
								</tr>
							</table>
						</form>

					</div>
					<div class="col-sm-2"></div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="/giaodien/footer.jsp"></jsp:include>





<script type="text/javascript">
	$(document).ready(function(){
		var district = document.getElementById('district');
		var province = document.getElementById('province');
		
		loadProvincal(${address.province.id});
		
		function loadProvincal(idProvince){
			var xhttp = new XMLHttpRequest() || ActiveXObject();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {					
					var arr = JSON.parse(this.responseText);
					var provinceSelect = document.getElementById('province');
					var str= "<option value = "+0+">Chọn Tỉnh Thành</option>";
					for(var i = 0 ; i  < arr.length ; i++){
						if( arr[i].id == idProvince){
							str += "<option selected  value = "+arr[i].id+" >"+arr[i].name+"</option>";
						}else{
							str += "<option  value = "+arr[i].id+" >"+arr[i].name+"</option>";
						}
					}
					provinceSelect.innerHTML = str;
				}
			};			
			xhttp.open('GET','http://localhost:8080/Book-Store-Servlet/api/province',true);
			xhttp.send('data=true');				
		}		
		
		province.addEventListener('change',function(){
			
			var xhttp = new XMLHttpRequest() || ActiveXObject();
			xhttp.onreadystatechange = function() {
			
				if (this.readyState == 4 && this.status == 200) {					
					var arr = JSON.parse(this.responseText);
					var districtSelect = document.getElementById('district');
					var str= "<option value = "+0+" >Chọn Huyện</option>";
					for(var i = 0 ; i  < arr.length ; i++){
						str += "<option  value = "+arr[i].id+" >"+arr[i].name+"</option>";
					}
					districtSelect.innerHTML = str;
				}
			};
			xhttp.open('GET','http://localhost:8080/Book-Store-Servlet/api/district?id='+this.value,true);	
			xhttp.send('data=true');	
			var ward = document.getElementById('ward');
			ward.innerHTML = "<option value = "+0+" >Chọn Phường / Xã</option>";
		});	
		
		loadDistrict(${address.province.id},${address.district.id});
		
		function loadDistrict(idProvince,idDistrict){
			var xhttp = new XMLHttpRequest() || ActiveXObject();
			xhttp.onreadystatechange = function() {
				
				if (this.readyState == 4 && this.status == 200) {					
					var arr = JSON.parse(this.responseText);
					var districtSelect = document.getElementById('district');
					var str= "<option value = "+0+" >Chọn Huyện</option>";
					for(var i = 0 ; i  < arr.length ; i++){
						if(arr[i].id == idDistrict){
							str += "<option selected value = "+arr[i].id+" >"+arr[i].name+"</option>";
						}else{
							str += "<option  value = "+arr[i].id+" >"+arr[i].name+"</option>";
						}
					}
					districtSelect.innerHTML = str;
				}
			};
			xhttp.open('GET','http://localhost:8080/Book-Store-Servlet/api/district?id='+idProvince,true);	
			xhttp.send('data=true');	
			
		}
		
		district.addEventListener('change',function(){
			
			var Idprovince = document.getElementById('province').value;
			var xhttp = new XMLHttpRequest() || ActiveXObject();
			xhttp.onreadystatechange = function() {
				
				if (this.readyState == 4 && this.status == 200) {					
					var arr = JSON.parse(this.responseText);
					var ward = document.getElementById('ward');
					var str= "<option value = "+0+" >Chọn Phường / Xã</option>";
					for(var i = 0 ; i  < arr.length ; i++){
						str += "<option  value = "+arr[i].id+" >"+arr[i].name+"</option>";
					}
					ward.innerHTML = str;
				}
			};
			
			xhttp.open('GET','http://localhost:8080/Book-Store-Servlet/api/ward?province='+Idprovince+'&&district='+this.value,true);			
			xhttp.send('data=true');			
		});
			
		loadWard(${address.province.id},${address.district.id},${address.ward.id});
		
		function loadWard(idProvince,idDistrict,idWard){
				var Idprovince = document.getElementById('province').value;
				var xhttp = new XMLHttpRequest() || ActiveXObject();
				xhttp.onreadystatechange = function() {
					
					if (this.readyState == 4 && this.status == 200) {					
						var arr = JSON.parse(this.responseText);
						var ward = document.getElementById('ward');
						var str = "<option value = "+0+" >Chọn Phường / Xã</option>";
						for(var i = 0 ; i  < arr.length ; i++){
							if(arr[i].id == idWard){
								str += "<option selected value = "+arr[i].id+" >"+arr[i].name+"</option>";
							}else{
								str += "<option  value = "+arr[i].id+" >"+arr[i].name+"</option>";
							}
						}
						ward.innerHTML = str;
					}
				};
				
				xhttp.open('GET','http://localhost:8080/Book-Store-Servlet/api/ward?province='+idProvince+'&&district='+idDistrict,true);			
				xhttp.send('data=true');	
			}
			
			
			
		var name = document.getElementById('name');
		var phone = document.getElementById('phone');
		var ward = document.getElementById('ward');
		var descript = document.getElementById('descript');
		var formAddress = document.getElementById('form-update');
		
		var alertName = document.getElementById('alert-name');
		var alertPhone = document.getElementById('alert-phone');
		var alertDescript = document.getElementById('alert-description');
		var alertProvince  = document.getElementById('alert-provincial');
		var alertDistrict = document.getElementById('alert-district');
		var alertWard = document.getElementById('alert-ward');
		
		name.addEventListener('change',function(){
			if(this.value.length < 2 || this.value.length > 40){ // 2-40
				alertName.innerHTML  =  "Tên quá dài hoặc quá ngắn"; 
			}else{
				alertName.innerHTML  = "";
			}
		});
		phone.addEventListener('change',function(){
			if(this.value.length < 8 || this.value.length > 12){ // 8- 42
				alertPhone.innerHTML  =  "Số điện thoại từ 08 - 12 kí tự";
			}else{
				alertPhone.innerHTML = "";
			}
		});
		descript.addEventListener('change',function(){
			if(this.value.length < 2 || this.value.length > 50){ // 2 - 50;
				alertDescript.innerHTML  =  "Chi tiết quá ngắn hoặc quá dài";
			}else{
				alertDescript.innerHTML = "";
			}
		});
		formAddress.addEventListener('submit',function(evt){
			if(name.value.length < 2 || name.value.length > 40){ // 2-40
				evt.preventDefault();
			}
			if(phone.value.length < 8 || phone.value.length > 12){ // 8- 42
				evt.preventDefault();
			}
			if(descript.value.length < 2 || descript.value.length > 50){ // 8- 42
				evt.preventDefault();
			}
			if(province.value == 0){				
				alertProvince.innerHTML = "Vui lòng chọn Thành Phố / Tỉnh";
				evt.preventDefault();
			}
			if(district.value == 0){
				alertDistrict.innerHTML = "Vui lòng chọn Quận / Huyện";
				evt.preventDefault();
				
			}
			if(ward.value == 0){
				alertWard.innerHTML = "Vui lòng chọn Phường / Xã";
				evt.preventDefault();
				return false;
			}		
		});
		
		
	});

		


</script>




</body>
</html>