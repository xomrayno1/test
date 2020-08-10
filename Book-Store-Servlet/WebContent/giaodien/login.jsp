<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng Nhập</title>
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
                        <form action='<c:url value="/login"></c:url>' method="POST" id="form-login">
                           <div>
                           		 Username : <input id="username" maxlength="20" name="username" class="form-control" type="text" style="width: 300px;" required="required"> 
                           	 	<p id="error-username" class="error"></p>
                           </div>
                            <div>
                           	 	Password : <input id="password" maxlength="20"  name="password" class="form-control" type="password" style="width: 300px;" required="required">
                            	<p id="error-password" class="error"></p>
                            </div>
                            <div>
                            	<p class="error" id="err">${error}</p>
                            </div>                         
                        </form>
                      <button  type="submit" class="btn btn-primary" form="form-login">Đăng Nhập</button> 
                      <a href='<c:url value="/register"></c:url>'><button class="btn btn-link">Đăng Ký</button></a>
                       <a href='<c:url value="/forgot-password"></c:url>'><button class="btn btn-link">Quên mật khẩu</button></a>
                    </div>
                   </div>
               </div>
           </div>
<jsp:include page="footer.jsp"/>

		<script type="text/javascript">
		var password = document.getElementById("password");
		var username = document.getElementById("username");	
		var errorPass = document.getElementById("error-password");
		var errorUser = document.getElementById("error-username");
		var form = document.getElementById('form-login');
		var err = document.getElementById("err");
		
		username.addEventListener("change",usernameChange);
			
		password.addEventListener("change",passwordChange);
		
		username.addEventListener("click",function(){
			err.innerHTML = "";
		});
		
		
		password.addEventListener("click",function(){
			err.innerHTML = "";
		});
		
		
		form.addEventListener('submit',function(evt){
			if(username.value.length <= 6  || username.value.length >= 15){
				evt.preventDefault();
			}
			if(password.value.length <= 3 || password.value.length >= 15 ){
				evt.preventDefault();
			}
			
		});
		
		function usernameChange(){						
			if(username.value.length <= 6  || username.value.length >= 15){
				errorUser.innerHTML = "Username phải lớn hơn 6 và nhỏ hơn 15";
			}else{
				errorUser.innerHTML ="";
			}					
			return;
		}
		function passwordChange(){		
			if(password.value.length <= 3  || password.value.length >= 15){
				errorPass.innerHTML = "Password phải lớn hơn 3 và nhỏ hơn 15";
			}else{
				errorPass.innerHTML ="";
			}		
			return;
		}

	
	</script>


</body>
</html>