<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<header class="header" id="header">
	<!-- Navigation -->
	<div class="navigation">
		<div class="container">
			<nav class="nav">
				<div class="nav__logo">
					<a href="trang-chu" class="scroll-link"> SHOP 123</a>
				</div>
				
				<div class="nav__menu">
					<ul class="nav__list">
						<li class="nav__item"><a href="trang-chu"
							class="nav__link scroll__link">Home</a></li>
						<li class="nav__item"><a href="#category"
							class="nav__link scroll__link">Category</a>
							<ul class="subnav">
								<li><a href="danh-muc?id=1"><span>Điện thoại thông minh</span></a></li>
								<li><a href="danh-muc?id=2"><span>Máy tính bảng</span></a></li>
								<li><a href="danh-muc?id=3"><span>Đồng hồ thông minh</span></a></li>
							</ul></li>
						<li class="nav__item"><a href="#news"
							class="nav__link scroll__link">Blog</a></li>
						<li class="nav__item"><a href="#contact"
							class="nav__link scroll__link">Contact</a></li>
					</ul>
				</div>
				
				<div class="nav__icons">
					<a href="thong-tin" class="icon__item"> <i class="fa fa-user"
						aria-hidden="true"></i>
					</a> 
					
					<a href="cart" class="icon__item item-cart"> <i
						class="fa fa-shopping-cart" aria-hidden="true">
						</i> 
						<c:if test="${cart == null}">
						<span id="cart__total"> 0				
						</span> <!------- cart------->				
						</c:if>		
						<c:if test="${cart != null}">
						<span id="cart__total"> ${fn:length(cart)}				
						</span> <!------- cart------->				
						</c:if>	
					</a>
				</div>
			</nav>
		</div>
	</div>
</header>