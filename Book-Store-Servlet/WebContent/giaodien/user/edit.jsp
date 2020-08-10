<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tài Khoản</title>

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
</head>

<body>

	<jsp:include page="/giaodien/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="list-group">		
					<a class="list-group-item active" href='<c:url value="/user/edituser"></c:url>'>Thông tin tài khoản</a>
					<a class="list-group-item" href='<c:url value="/user/order"></c:url>'>Quản lý đơn hàng</a>
					<a class="list-group-item"  href='<c:url value="/user/address"></c:url>'>Sổ địa chỉ</a>
					<a class="list-group-item"  href='<c:url value="/user/wishlist"></c:url>'>Sản phẩm yêu thích</a>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8">
					<form action='<c:url value="/user/edituser"></c:url>' method="POST" id="form-update-user"  >
					
					
							<table style="width: 100%">
							
								<tr>									
									<td >Họ Tên</td>
									<td><input id="name" type="text" name="name" value="${user.name}" required="required" ></td>									
								</tr>
								<tr class="alert-error">
									<td colspan="2"> <p id="alert-name" class="error"></p> </td>
								</tr>
								<tr>
									<td	>Điện Thoại</td>
									<td><input id="phone" type="text" name="phone" value="${user.phone}" required="required" ></td>									
								</tr>
								<tr class="alert-error">
									<td colspan="2"> <p id="alert-phone" class="error"></p> </td>
								</tr>
								<tr>
									<td >Email</td>
									<td><input id="email" type="email" name="email" value="${user.email}" required="required" ></td>									
								</tr>
								<tr class="alert-error">
									<td colspan="2"> <p id="alert-email" class="error"></p> </td>
								</tr>
								<tr></tr>
								<tr style="text-align: center;">
									<td><input type="checkbox" id="checkb" name="checkb">Thay đổi mật khẩu</td>
								</tr>
								<tr id="old">
									
								</tr>
								<tr class="alert-error" id="trOld">
									
								</tr>
								<tr id="news">
									
								</tr>
								<tr class="alert-error" id="trNews">
									
								</tr>
								<tr id="repeat">
																	
								</tr>
								<tr class="alert-error" id="trRepeat">
									
								</tr>
								<tr class="alert-error" id="div">
									<td><p id="eror" class="error">${error}</p></td>
								</tr>
								<tr style="text-align: center;">
									<td > <button class="btn btn-primary">Cập Nhật</button></td>
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
		var checkbox = document.getElementById('checkb');
		var old = document.getElementById('old'); <!-- <tr>  -->
		var news = document.getElementById('news'); <!-- <tr>  -->
		var repeat = document.getElementById('repeat'); <!-- <tr>  -->
		
		var trOld = document.getElementById('trOld'); <!-- <tr>  -->
		var trNews = document.getElementById('trNews'); <!-- <tr>  -->
		var trRepeat = document.getElementById('trRepeat'); <!-- <tr>  -->
		
		var form = document.getElementById('form-update-user'); <!-- form  -->
		var alertName = document.getElementById('alert-name'); <!-- <p> errr -->
		var alertPhone = document.getElementById('alert-phone'); <!-- <p> errpr -->
		var alertEmail = document.getElementById('alert-email'); <!-- <p> errpr -->
		
		
		var names =  document.getElementById('name'); <!-- <input>  -->
		var phone = document.getElementById('phone'); <!-- <input>  -->
		var email = document.getElementById('email'); <!-- <input>  -->
		
		var eror = document.getElementById('eror');
		
		var flag = false;
		
		checkbox.addEventListener('click', checkboxClick);
		
		function checkboxClick() {
			flag = checkbox.checked;
			if (flag) {
				old.innerHTML = "<td >Mật khẩu cũ</td><td><input   type="+"password"+" name="+"passwordold"+" required="+"required"+" id = "+"passwordOld"+" ></td>   ";
				news.innerHTML = "<td >Mật khẩu mới</td><td><input type="+"password"+" name="+"passwordnew"+" required="+"required"+" id = "+"passwordNews"+"></td>   ";
				repeat.innerHTML = "<td >Nhập lại </td><td><input type="+"password"+" name="+"passwordrepeat"+" required="+"required"+" id = "+"passwordRepeat"+"></td>";
				
				trOld.innerHTML = "<td><p id = "+"alert-old"+" class="+"error"+"></p></td>";
				trNews.innerHTML = "<td><p id = "+"alert-news"+" class="+"error"+"></p></td>";
				trRepeat.innerHTML = "<td><p id = "+"alert-repeat"+" class="+"error"+"></p></td>";
				
				var passwordOld = document.getElementById('passwordOld'); <!-- <input>  -->
				var passwordNews = document.getElementById('passwordNews'); <!-- <input>  -->
				var passwordRepeat = document.getElementById('passwordRepeat'); <!-- <input>  -->
				
				passwordOld.addEventListener('change',changePasswordOld);
				passwordNews.addEventListener('change',changePasswordNews);
				passwordRepeat.addEventListener('change',changePasswordRepeat);
				
				
				eror.innerHTML = "";
			} else {
				old.innerHTML = "";
				news.innerHTML = "";
				repeat.innerHTML = "";
				trOld.innerHTML = "";
				trNews.innerHTML = "";
				trRepeat.innerHTML = "";
			}
		}
		names.addEventListener('change',changeName);
		function changeName(){
			if(names.value.length >= 25 || names.value.length  <= 3){
				alertName.innerHTML = "Tên phải lớn hơn 3 và bé hơn 25";
            }else{
            	alertName.innerHTML = "";
            }
		}
		phone.addEventListener('change',changePhone);
		function changePhone(){
			 if(phone.value.length <= 9 || phone.value.length  >= 13) {
				 alertPhone.innerHTML = "Số điện thoại phải lớn hơn 9 và bé hơn 13";
             }else{
           	 	 alertPhone.innerHTML = "";
            }
		}
		email.addEventListener('change',changeEmail);
		function changeEmail(){
			if(email.value.length >= 30 || email.value.length  <= 6) {
				alertEmail.innerHTML = "Email phải  lớn hơn 6 và bé hơn 30";
            }else{
            	alertEmail.innerHTML = "";
            }
		}
			
		function changePasswordOld(){
			var alertOld = document.getElementById('alert-old'); <!-- <p> errpr -->
			 if(passwordOld.value.length >= 15 || passwordOld.value.length  <= 3){
				 alertOld.innerHTML = "Password cần lớn hơn 3 và bé hơn 15";
				 
            }else{
           	 	 alertOld.innerHTML = "";
            }
		}
		
		function changePasswordNews(){
			var alertNews = document.getElementById('alert-news'); <!-- <p> errpr -->
			if(passwordNews.value.length >= 15 || passwordNews.value.length  <= 3){
				 alertNews.innerHTML = "Mật khẩu mới phải lớn hơn 3 và bé hơn 15";
            }else{
            	 alertNews.innerHTML = "";
            }
		}
		
		
		function changePasswordRepeat(){
			var alertRepeat = document.getElementById('alert-repeat'); <!-- <p> errpr -->
				
			if(passwordRepeat.value != passwordNews.value){
				alertRepeat.innerHTML = "Mật khẩu nhập lại không đúng";
				
			}else{
				alertRepeat.innerHTML = "";
				
			}
		}
		form.addEventListener('submit',function(evt){
			if(names.value.length >= 25 || names.value.length  <= 3){
				evt.preventDefault();
			}
			if(phone.value.length <= 9 || phone.value.length  >= 13) {
				evt.preventDefault();
			}
			if(email.value.length >= 30 || email.value.length  <= 6) {
				evt.preventDefault();
			}
			if(passwordOld.value.length >= 15 || passwordOld.value.length  <= 3){
				evt.preventDefault();
			}
			if(passwordNews.value.length >= 15 || passwordNews.value.length  <= 3){
				evt.preventDefault();
			}
			if(passwordRepeat.value != passwordNews.value){
				evt.preventDefault();
			}
		});
		

		
				
		
	</script>


</body>
</html>