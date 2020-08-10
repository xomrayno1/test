<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>

<title>Tìm Kiếm Account</title>
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
					<a class="list-group-item " href='<c:url value="/admin/home"></c:url>'>Trang Chủ</a>
					<a class="list-group-item active" href='<c:url value="/admin/account"></c:url>'>Quản lý tài khoản</a>
					<a class="list-group-item"  href='<c:url value="/admin/book"></c:url>'>Quản lý sách</a>
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
			<div class="col-sm-10">
			
			<table class="table table-bordered table-hover text-center ">
					<tr>
						<td colspan="3"> 
							<form action='<c:url value="/admin/account/search"></c:url>' method="get" id="form-search">
								<input class="form-control" type="text" name="search"  placeholder="Tìm kiếm" id="search_user">
							</form> 							
						</td >
						<td colspan="1">
							<input type="hidden" id="roleUser" value="${param.role}">
							<input type="hidden" id="searchUser" value="${param.search}">
							<select class="form-control" name="role" form="form-search" id="role_user">
								<option value="">Chọn Role </option>
								<option value="ROLE_USER">Role_User</option>
								<option value="ROLE_ADMIN">Role_Admin</option>
							</select>
						</td>
						<td colspan="1">
							<button class="btn" form="form-search">Tìm kiếm</button>
						</td>
						<td colspan="4">
							Kết quả tìm kiếm :  <span id="resultSearch"></span>
						</td>
										
					</tr>
					<tr >
						<th >STT</th>
						<th>Username</th>
						<th>Tên</th>
						<th>Email</th>
						
						<th>Role</th>
						<th>Ngày Tạo</th>
						<th>Ngày Cập Nhật</th>
						<th>Trạng thái</th>
						<th>+</th>
					</tr>
					<c:forEach items="${listUser}" var="item" varStatus="i">
						<tr>
							<td width="3">${i.index + 1 + (pageCurrent - 1) * 5}</td>	
							<td width="15%">${item.userName}</td>													
							<td width="12%">${item.name}</td>
							<td width="15%">${item.email}</td>
						
							<td width="10%">${item.role}</td>
							<td width="10%">${item.create_Date}</td>
							<td width="10%">${item.modify_Date}</td>
								<td width="10%">${item.getDisplay()}</td>							
							<td width="15%">
							
							<input id="id_User" type="hidden" value="${item.id}"> 	
							
							<a href="#"><button class="btn btn_info" title="Xem Địa Chỉ" data-toggle="modal" data-target="#modal-info">!</button></a>
							<a href="#"><button class="btn btn btn-warning btn_update" title="Sửa Tài Khoản" data-toggle="modal" data-target="#modal-update">Sửa</button></a>							
							</td>							
						</tr>
					</c:forEach>
					<tr>
						<td colspan="9">
							<ul class="pagination">
								<c:set value="${pageCurrent - 1}"  var="pre" />
								<c:if test="${pre < 1}">
									<c:set value="1"  var="pre" />
								</c:if>
								<li><a href='<c:url value="/admin/account/search?search=${param.search}&role=${param.role}&page=${pre}"></c:url>'>&laquo;</a>
								<c:forEach begin="1" end="${soPage}" var="item">
									<c:if test="${item == pageCurrent}">
										<li class="active"><a href='<c:url value="/admin/account/search?search=${param.search}&role=${param.role}&page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									<c:if test="${item != pageCurrent}">
										<li ><a href='<c:url value="/admin/account/search?search=${param.search}&role=${param.role}&page=${item}"></c:url>'>${item}</a> </li>
									</c:if>
								</c:forEach>
								<c:set value="${pageCurrent + 1}"  var="next" />	
								<c:if test="${next >= soPage}">
									<c:set value="${soPage}"  var="next" />
								</c:if>
								<li><a href='<c:url value="/admin/account/search?search=${param.search}&role=${param.role}&page=${next}"></c:url>'>&raquo;</a>
							</ul>
						</td>
					</tr>
					<tr>
						<td colspan="9">
							<button data-toggle="modal" data-target="#modal_add" id="add" class="btn btn-primary">Thêm</button>
						</td>
					</tr>
				</table>		
			
			</div>
		</div>
		
		
	<div class="modal fade " id="modal-info">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<p class="modal-title">Địa Chỉ</p>		
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row" id="address_user">
						<div class="panel panel-primary">
								<div class="panel-body">
										<ul class="list-group">
											<li class="list-group-item">Tên </li>
											<li class="list-group-item">Số Điện Thoại</li>
											<li class="list-group-item">Địa Chỉ</li>
										</ul>
								</div>
						</div>
						<div class="panel panel-primary">
								<div class="panel-body">
										<ul class="list-group">
											<li class="list-group-item">Tên </li>
											<li class="list-group-item">Số Điện Thoại</li>
											<li class="list-group-item">Địa Chỉ</li>
										</ul>
								</div>
						</div>
					</div>									
				</div>
				<div class="modal-footer">
					<button class="btn btn-danger"  type="button" data-dismiss="modal">Close</button>
					
				</div>
			</div>
		</div>
	
	</div>
		<div class="modal fade " id="modal-update">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<p class="modal-title">Cập Nhật Tài Khoản</p>		
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-8">
							<form action='<c:url value="/admin/account?action=update"></c:url>' method="POST" id="form-update">
							Username
							<input  class="form-control" type="text" id="username"  readonly="readonly"  >	
							Password
							<input  class="form-control" type="password" id="password" name="password" required="required">
							<p class="error"  id="password-error"></p>	
							Tên
							<input  class="form-control" type="text" id="name" name="name" required="required">
							<p class="error"  id="name-error"></p>	
							Điện Thoại
							<input  class="form-control" type="text" id="phone" name="phone" required="required">
							<p class="error"  id="phone-error"></p>	
							Role
							<select class="form-control" id="roleAccount" name="role" >
								<option value="ROLE_NULL">Chọn Role</option>
								<option value="ROLE_USER">ROLE_USER</option>
								<option value="ROLE_ADMIN">ROLE_ADMIN</option>
							</select>
							<p class="error"  id="role-error"></p>	
							<input type="hidden" id="idus" name="iduser">	
							Trạng thái
							<select class="form-control" id="status" name="status" >								
								<option value="1">Không Khóa</option>
								<option value="0">Khóa</option>
							</select>
							</form>
						</div>
						<div class="col-sm-2"></div>
					</div>							
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary"  type="submit" form="form-update">Save</button>
					<button class="btn btn-danger"  type="button" data-dismiss="modal">Close</button>
					
				</div>
			</div>
		</div>
	
	</div>	
	
	
	<div class="modal fade " id="modal_add">
		<div class="modal-dialog">
						<div class="modal-content">
				<div class="modal-header">
					<p class="modal-title">Thêm Tài Khoản</p>		
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-8">
							<form action='<c:url value="/admin/account?action=create"></c:url>' method="POST" id="form-add">
							Username
							<input  class="form-control" type="text"   id="username_add"   name="username" >
							<p class="error"  id="username_error"></p>		
							Password
							<input  class="form-control" type="password" id="password_add" name="password" required="required">
							<p class="error"  id="password_error"></p>	
							Tên
							<input  class="form-control" type="text" id="name_add" name="name" required="required">
							<p class="error"  id="name_error"></p>
							Email
							<input  class="form-control" type="email" id="email_add" name="email" required="required">
							<p class="error"  id="email_error"></p>	
							Điện Thoại
							<input  class="form-control" type="text" id="phone_add" name="phone" required="required">
							<p class="error"  id="phone_error"></p>	
							Role
							<select class="form-control" id="role_add" name="role" >
								<option value="ROLE_NULL">Chọn Role</option>
								<option value="ROLE_USER">ROLE_USER</option>
								<option value="ROLE_ADMIN">ROLE_ADMIN</option>
							</select>
							<p class="error"  id="role_error"></p>							
							</form>
						</div>
						<div class="col-sm-2"></div>
					</div>							
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary"  type="submit"  form="form-add">Save</button>
					<button class="btn btn-danger"  type="button" data-dismiss="modal">Close</button>					
				</div>
			</div>
		</div>
	
	</div>	
		
		
		
</div>




<jsp:include page="/giaodien/admin/footer.jsp"></jsp:include>

<script type="text/javascript">
var btnInfo = document.getElementsByClassName('btn_info');
var btnUpdate = document.getElementsByClassName('btn_update');
	var names = document.getElementById('name');
 	var password = document.getElementById('password');
 	var phone = document.getElementById('phone');
 	var roleAccount = document.getElementById('roleAccount');
 	var statuss = 	  document.getElementById('status');
 	
 	var errorPassword = document.getElementById('password-error');
 	var errorName = document.getElementById('name-error');
 	var errorPhone = document.getElementById('phone-error');
 	var roleAccountError = document.getElementById('role-error');
 	
for(var i = 0 ; i < btnInfo.length ; i++){
	btnInfo[i].addEventListener('click',function(){		
		var idUser = $(this).parents('tr').find('#id_User');
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		     var arr = JSON.parse(this.responseText);
		     var addressUser = document.getElementById("address_user");
		     var str = "";
		     
		 	for(var i = 0 ; i < arr.length ; i++){
		 		str += "<div class='panel panel-primary'>";
		 		str +=  	"<div class='panel-body'>";
		 		str +=			"<div class='list-group'>";
		 		str +=				"<li class='list-group-item'>"+arr[i].name+"</li>";
		 		str +=				"<li class='list-group-item'>"+arr[i].phone+"</li>";
		 		str +=				"<li class='list-group-item'>"+arr[i].province.name+" , "+arr[i].district.prefix+" "+arr[i].district.name+" , "+arr[i].ward.prefix+" "+arr[i].ward.name+" , "+arr[i].description+"</li>";
		 		str +=			"</div>";
		 		str +=       "</div>";
		 		str +=  "</div>";		 		
		 		}		     
		 	addressUser.innerHTML = str;		     
		    }
		  };			  			  
		  xhttp.open("GET", "http://localhost:8080/Book-Store-Servlet/admin/api/address?action=getall&&id="+idUser.val(), true);
		  xhttp.send();
	});
	
	btnUpdate[i].addEventListener('click',function(){
		var idUser = $(this).parents('tr').find('#id_User').val();
		$("#idus").val(idUser);
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		     var users = JSON.parse(this.responseText);	
		     ressetError ();
		     
		 	names.value = users.name;
		 	username.value = users.userName;
		 	password.value = users.passWord;
		 	phone.value = users.phone;
		 	roleAccount.value = users.role;
		 	
		 	statuss.value = users.status.toString();
			 	
			 	
	 
		  }
		 }
		  xhttp.open("GET", "http://localhost:8080/Book-Store-Servlet/admin/user/api?id="+idUser, true);
		  xhttp.send();
		
		    
		});
	
 	
 	password.addEventListener('change',function(){
		
	 		 if(password.value.length >= 15 || password.value.length  <= 3){
                    errorPassword.innerHTML = "Mật khẩu phải lớn hơn 3 và bé hơn 15";
                }else{
                    errorPassword.innerHTML = ""
                }
	 	});
	 	names.addEventListener('change',function(){
			
			if(names.value.length >= 25 || names.value.length  <= 3){
				errorName.innerHTML = "Tên phải lớn hơn 3 và bé hơn 25";
            }else{
            	errorName.innerHTML = ""
            }
		 	});
	 	phone.addEventListener('change',function(){
	 		
	 		var check = regexPhone(phone.value);
	 		if(phone.value.length <= 9 || phone.value.length  >= 13 || check == false) {
                	errorPhone.innerHTML = "Số điện thoại phải là số lớn hơn 9 và bé hơn 13";
                 }else{
        	        errorPhone.innerHTML = ""
                }
		 	});
	 	roleAccount.addEventListener('change',function(){
			
			 if(roleAccount === 'ROLE_NULL') {
				 roleAccountError.innerHTML = "Vui Lòng Chọn Quyền";
                 }else{
                	 roleAccountError.innerHTML = ""
                }
		 	});  

	 var form = document.getElementById('form-update');
	 form.addEventListener('submit',function(evt){
		 
			 var check = regexPhone(phone.value);
            if(password.value.length >= 15 || password.value.length  <= 3){
                evt.preventDefault();
            }
            if(names.value.length >= 25 || names.value.length  <= 3 ){
                evt.preventDefault();
            }
            if(phone.value.length <= 9 || phone.value.length  >= 13 || check == false   ) {
                evt.preventDefault();
            }
            if(roleAccount == 'ROLE_NULL') {
            	evt.preventDefault();
            }
	 });
	 	

	function ressetError (){
		errorName.innerHTML = "";
		errorPassword.innerHTML = "";
		roleAccountError.innerHTML = "";
		errorPhone.innerHTML = "";
	}
	function regexPhone(value){
		var regex = /[A-Za-z]/g;
		var found = value.match(regex);
		if(found != null){
			return false;
		}
		return true;
	}
	
	var selectRole = document.getElementById('role_user');
	var roleUser = document.getElementById('roleUser');
	
	
	var searchUser = document.getElementById('searchUser')
	var textSearch = document.getElementById('search_user');
	selectRole.value = roleUser.value;
	
	
	var resultSearch = document.getElementById('resultSearch');
	
	resultSearch.innerHTML =  searchUser.value;
	textSearch.value = searchUser.value;
	
	
	var usernameAdd = document.getElementById('username_add');
	var passwordAdd = document.getElementById('password_add');
	var nameAdd = document.getElementById('name_add');
	var emailAdd = document.getElementById('email_add');
	var phoneAdd = document.getElementById('phone_add');
	var roleAdd = document.getElementById('role_add');
	
	var usernameError = document.getElementById('username_error');
	var passwordError = document.getElementById('password_error');
	var nameError = document.getElementById('name_error');
	var emailError = document.getElementById('email_error');
	var phoneError = document.getElementById('phone_error');
	var roleError = document.getElementById('role_error');
	
	function resetTextAndError(){
		usernameAdd.value = "";
		passwordAdd.value = "";
		nameAdd.value = "";
		emailAdd.value = "";
		phoneAdd.value = "";
		roleAdd.value ="ROLE_NULL";
		
		usernameError.innerHTML = "";
		passwordError.innerHTML = "";
		nameError.innerHTML = "";
		phoneError.innerHTML = "";
		emailError.innerHTML = "";
		roleError.innerHTML = "";
			 
		 
	}
	usernameAdd.addEventListener('change',function(){
		if(usernameAdd.value.length >= 15 || usernameAdd.value.length  <= 6){
			usernameError.innerHTML = "Tài khoản phải lớn hơn 6 và bé hơn 15";
        }else{
        	usernameError.innerHTML = ""
        }
	});
	passwordAdd.addEventListener('change',function(){
		
		 if(passwordAdd.value.length >= 15 || passwordAdd.value.length  <= 3){
			 passwordError.innerHTML = "Mật khẩu phải lớn hơn 3 và bé hơn 15";
           }else{
        	   passwordError.innerHTML = ""
           }
	});
	nameAdd.addEventListener('change',function(){
		
		if(nameAdd.value.length >= 25 || nameAdd.value.length  <= 3){
			nameError.innerHTML = "Tên phải lớn hơn 3 và bé hơn 25";
       }else{
    	   nameError.innerHTML = ""
       }
	 	});
	
	phoneAdd.addEventListener('change',function(){	
		var check = regexPhone(phoneAdd.value);
		if(phoneAdd.value.length <= 9 || phoneAdd.value.length  >= 13 || check == false) {
				phoneError.innerHTML = "Số điện thoại phải là số lớn hơn 9 và bé hơn 13";
            }else{
            	phoneError.innerHTML = ""
           }
	 	});
	roleAdd.addEventListener('change',function(){
		
		 if(roleAdd.value == 'ROLE_NULL') {
				 roleError.innerHTML = "Vui Lòng Chọn Quyền";
            }else{
            	roleError.innerHTML = ""
           }
	 	});  
	emailAdd.addEventListener('change',function(){
		 if(emailAdd.value.length >= 30 || emailAdd.value.length  <= 6) {
			 emailError.innerHTML = "Email phải  lớn hơn 6 và bé hơn 30";
         }else{
        	 emailError.innerHTML = ""
         }
	})
	
	var add = document.getElementById('add');
	add.addEventListener('click',resetTextAndError);
	
	var formAdd = document.getElementById('form-add');
	formAdd.addEventListener('submit',function(evt){
		 if(usernameAdd.value.length >= 15 || usernameAdd.value.length  <= 6){
			
             evt.preventDefault();
         }
         if(passwordAdd.value.length >= 15 || passwordAdd.value.length  <= 3){
        	
             evt.preventDefault();
         }
         if(nameAdd.value.length >= 25 || nameAdd.value.length  <= 3 ){
        	 
             evt.preventDefault();
         }
         if(emailAdd.value.length >= 30 || emailAdd.value.length  <= 6) {
        	
             evt.preventDefault();
         }
         if(phoneAdd.value.length <= 9 || phoneAdd.value.length  >= 13) {
        	 
             evt.preventDefault();
         }
         if(roleAdd.value == 'ROLE_NULL') {
        	 roleError.innerHTML = "Vui Lòng Chọn Quyền";
         	evt.preventDefault();
         }
	});
	
	
	
}
</script>



</body>
</html>