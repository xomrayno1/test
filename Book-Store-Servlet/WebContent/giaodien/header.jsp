<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:url value="/home" var="home" />
<c:url var="categoryUrl" value="/category?id=" />


<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" data-toggle="collapse" class="navbar-toggle"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href='<c:url value="/home"></c:url>' class="navbar-brand">Book
				Store</a>
		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav nav-menuchinh">
				<li><a href='<c:url value="/home"></c:url>'>Trang Chủ</a></li>
				<li class="dropdown"><a href="#">Thể Loại <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach items="${listcategory}" var="item">
							<li><a
								href='<c:url value="/category?id=${item.id}"></c:url>'>${item.description}</a></li>
						</c:forEach>

					</ul></li>
				<li><a href='<c:url value="/news"></c:url>'>Tin Tức</a></li>
				<li><a href='<c:url value="/add-contact"></c:url>'>Liên Hệ</a></li>
			</ul>
			<div class="navbar-form navbar-left">
				<div class="input-group">
					<form action='<c:url value="/search"></c:url>' method="GET">
						<div class="row">
							<input type="text" name="search" class="form-control" placeholder="Search" style="width: 150px">
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.users == null}">
					<li><a href='<c:url value="/login"></c:url>'><span
							class="glyphicon glyphicon-log-in"> Login</span></a></li>
				</c:if>
				<c:if test="${sessionScope.users != null}">
					<li class="dropdown"><a href='<c:url value="#"></c:url>'><span
							class="glyphicon glyphicon-user"> Tài khoản</span></a>
						<ul class="dropdown-menu info">
							<li><a href='<c:url value="/user/order"></c:url>'>Đơn hàng của tôi</a></li>
							<li><a href='<c:url value="/user/edituser"></c:url>'>Tài
									khoản của tôi</a></li>
							<li><a href='<c:url value="/logout"></c:url>'>Thoát tài
									khoán</a></li>
						</ul></li>
				</c:if>
				<li><a href='<c:url value="/cart-item"></c:url>'><span
						class="	glyphicon glyphicon-shopping-cart"> Cart
							${fn:length(sessionScope.listCartItems)}</span></a></li>
			</ul>
		</div>

	</div>
</nav>
