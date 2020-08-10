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
				<div class="panel-heading">Tin Tức</div>
				<div class="panel-body">
				<c:forEach items="${listNewsPagi}" var="item">
					<div class="row">
					<div class="col-sm-4">
					<img class="news_img" alt="" src='<c:url value="${item.img}"></c:url>'>
					</div>
					<div class="col-sm-8">
					<h5 class="news_title"><a href="#">${item.title}</a></h5>
					<p class="line-content">
						${item.content}
					</p>
					</div>				
				</div>
				<hr>
				</c:forEach>

			
			
				<div class="panel-footer text-center">
												<ul class="pagination">
							<c:set value="${pageCurrent - 1}"  var="pre" />
								<c:if test="${pre < 1}">
									<c:set value="1"  var="pre" />
								</c:if>
							<li><a href='<c:url value="/news?page=${pre}"></c:url>'>&laquo;</a>
								<c:forEach begin="1"  end="${soPage}" var="item">
									<c:if test="${pageCurrent != item}">
										<li  ><a href='<c:url value="/news?page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									<c:if test="${pageCurrent == item}">
										<li class="active" ><a href='<c:url value="/news?page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									
								</c:forEach>
								<c:set value="${pageCurrent + 1}"  var="next" />	
								<c:if test="${next >= soPage}">
									<c:set value="${soPage}"  var="next" />
								</c:if>
								
								<li><a href='<c:url value="/news?page=${next}"></c:url>'>&raquo;</a>
							</ul>
				</div>
			</div>
		</div>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>