<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng Kí</title>
 	<script  type="text/script" src="js/bootstrap.min.js" ></script>
    <script  type="text/script" src="js/jquery.min.js" ></script>
    <link rel="stylesheet" href="css/bootstrap.min.css"  >
    <link rel="stylesheet" href="fonts/glyphicons-halflings-regular.eot"  >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
 	<link rel="stylesheet" href='<c:url value="/css/style1.css"></c:url>'  >
</head>
<body>
<jsp:include page="header.jsp"/>
           <div class="row">
               <div class="panel panel-default">
                   <div class="panel-body">
                    <div class="col-sm-4">

                    </div>
                    <div class="col-sm-8">
                        <form action='<c:url value="/register"></c:url>' method="POST" id="form-register">
                        	<div>
                        		Username  <input  name="username" id="username" class="form-control" type="text" style="width: 300px;" maxlength="20" required="required">
                        		<p id="error-username" class="error"></p>
                        	</div>
                            <div>
                            	Password  <input  name="password"  id="password" class="form-control" type="password" style="width: 300px;"  maxlength="20" required="required">
                            	<p id="error-password" class="error"></p> 
                            </div>
                            <div>
                            	Name  <input  name="name"  id="name" class="form-control" type="text" style="width: 300px;" maxlength="30"  required="required">
                            	<p id="error-name" class="error"></p>
                            </div>
                            <div>
                            	Phone  <input  name="phone" id="phone" class="form-control" type="text" style="width: 300px;" maxlength="20"  required="required">
                            	<p id="error-phone" class="error"></p>
                            </div>
                            <div>
                            	Email  <input  name="email" id="email" class="form-control" type="email" style="width: 300px;" maxlength="30"  required="required">
                            	<p id="error-email" class="error"></p>
                            </div>
                            <div>
                            	<p class="error">${error}</p>
                            </div>                           
                        </form>
                         <button  type="submit" class="btn btn-primary" form="form-register">Đăng Ký</button>
                          <a href='<c:url value="/login"></c:url>'><button class="btn btn-link">Đăng Nhập</button></a>
                    </div>
                   </div>
               </div>
           </div>
<jsp:include page="footer.jsp"/>
		<script>
            var username = document.getElementById('username');
            var password = document.getElementById('password');
            var names = document.getElementById('name');
            var email = document.getElementById('email');
            var phone = document.getElementById('phone');
          
            var formLogin = document.getElementById('form-register');

            var errorUsername = document.getElementById('error-username');
            var errorPassword = document.getElementById('error-password');
            var errorName = document.getElementById('error-name');
            var errorEmail = document.getElementById('error-email');
            var errorPhone = document.getElementById('error-phone');    
            
            username.addEventListener('change',changeUsername);
            password.addEventListener('change',changePassword);
            names.addEventListener('change',changeName);
            email.addEventListener('change',changeEmail);
            phone.addEventListener('change',changePhone);

           


            formLogin.addEventListener('submit',function(evt){
                if(username.value.length >= 15 || username.value.length  <= 6){
                    evt.preventDefault();
                }
                if(password.value.length >= 15 || password.value.length  <= 3){
                    evt.preventDefault();
                }
                if(names.value.length >= 25 || names.value.length  <= 3 ){
                    evt.preventDefault();
                }
                if(email.value.length >= 30 || email.value.length  <= 6) {
                    evt.preventDefault();
                }
                if(phone.value.length <= 9 || phone.value.length  >= 13) {
                    evt.preventDefault();
                }
            });

            

            function changeUsername(){
                if(username.value.length >= 15 || username.value.length  <= 6){
                    errorUsername.innerHTML = "Tài khoản phải lớn hơn 6 và bé hơn 15";
                }else{
                    errorUsername.innerHTML = ""
                }
            }
            function changePassword(){
                if(password.value.length >= 15 || password.value.length  <= 3){
                    errorPassword.innerHTML = "Mật khẩu phải lớn hơn 3 và bé hơn 15";
                }else{
                    errorPassword.innerHTML = ""
                }
            }
            function changeName(){
                if(names.value.length >= 25 || names.value.length  <= 3){
                    errorName.innerHTML = "Tên phải lớn hơn 3 và bé hơn 25";
                }else{
                    errorName.innerHTML = ""
                }
            }
            function changeEmail(){
                if(email.value.length >= 30 || email.value.length  <= 6) {
                    errorEmail.innerHTML = "Email phải  lớn hơn 6 và bé hơn 30";
                }else{
                    errorEmail.innerHTML = ""
                }
            }
            function changePhone(){
                 if(phone.value.length <= 9 || phone.value.length  >= 13) {
                	errorPhone.innerHTML = "Số điện thoại phải lớn hơn 9 và bé hơn 13";
                 }else{
        	        errorPhone.innerHTML = ""
                }
    }


        </script>

	
</body>
</html>