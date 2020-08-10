<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot</title>
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
                    <div class="col-sm-4 text-center">
                    	<div class="alert alert-success">
                    		Tìm lại mật khẩu
                    	</div>
                        <form action='<c:url value="/forgot-password"></c:url>' method="POST" >	                       		
                        	<div class="row">
                        		<div class="col-sm-2">
                        			Email
                        		</div>
                        		<div class="col-sm-8">
                        			<input id="email" maxlength="20" name="email" class="form-control" type="text" style="width: 300px;" required="required"> 
                        		</div>
                       		 </div>		
                        	<div class="forgot-email">
                        		<button  type="submit" class="btn btn-primary">Tìm Mật Khẩu</button> 		
                        	</div>             	                       	                                     
                        </form>                                                                   
                    </div>
                    <div class="col-sm-4">

                    </div>
                   </div>
               </div>
           </div>
<jsp:include page="footer.jsp"/>




</body>
</html>