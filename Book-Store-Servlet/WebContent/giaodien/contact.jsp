<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tin Tức</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
 	<script  type="text/script" src="js/bootstrap.min.js" ></script>
    <script  type="text/script" src="js/jquery.min.js" ></script>
    <link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"></c:url>'  >
    <link rel="stylesheet" href='<c:url value="/fonts/glyphicons-halflings-regular.eot"></c:url>'  >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
 	<link rel="stylesheet" href='<c:url value="/css/style1.css"></c:url>'  >


</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-heading">Liên Hệ - Góp Ý</div>
				<div class="panel-body">				
					<div class="col-sm-2">
					
					</div>				
					<div class="col-sm-8">
						<form action='<c:url value="/add-contact"></c:url>' method="POST">
								<div class="row">
								<div class="col-sm-6 form-group">
									<input class="form-control" type="text" name="name" placeholder="Họ Và Tên" required="required">
								</div>
								<div class="col-sm-6 form-group">
									<input name="email" type="email" required="required" class="form-control" placeholder="Email">
								</div>
								<div class="col-sm-12 form-group">								
									<textarea rows="8" cols="20" class="form-control" name="content" required="required" >
									</textarea>
								</div>	
							</div>
						<p class="error">${alert}</p>
						<div class="row">
							<div class="col-sm-12 form-group">
								<button class="btn pull-right" type="submit">Send</button>
							</div>
						</div>	
						</form>		
					</div>
					<div class="col-sm-2"></div>					
				</div>

			</div>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>