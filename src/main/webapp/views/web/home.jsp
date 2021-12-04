<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<!--image slider start-->
	<div class="slider">
		<div class="slides">
			<!--radio buttons start-->
			<input type="radio" name="radio-btn" id="radio1" /> <input
				type="radio" name="radio-btn" id="radio2" /> <input type="radio"
				name="radio-btn" id="radio3" /> <input type="radio"
				name="radio-btn" id="radio4" />
			<!--radio buttons end-->
			<!--slide images start-->
			<div class="slide first">
				<img src="template/web/images/products/headphone/headphone10.jpeg"
					alt="hình tai nghe" />
				<div class="infoSlide">
					<span>Sản phẩm hiện đại mới nhất hiện nay </span>
					<div class="sliderShopNow">
						<div class="shopNow">
							<a href="" class="iconShopNow">Show now <i
								class="fa fa-shopping-cart" aria-hidden="true"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="slide">
				<img src="template/web/images/products/iPhone/iphone4.jpeg" alt="" />
				<div class="infoSlide">
					<span>Sản phẩm hiện đại mới nhất hiện nay </span>
					<div class="sliderShopNow">
						<div class="shopNow">
							<a href="danh-muc?id=2" class="iconShopNow">Show now <i
								class="fa fa-shopping-cart" aria-hidden="true"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="slide">
				<img src="template/web/images/products/sumsung/samsung6.jpeg" alt="" />
				<div class="infoSlide">
					<span>Sản phẩm mới nhất hiên nay </span>
					<div class="sliderShopNow">
						<div class="shopNow">
							<a href="danh-muc?id=1" class="iconShopNow">Show now <i
								class="fa fa-shopping-cart" aria-hidden="true"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="slide">
				<img src="template/web/images/products/iPhone/iphone2.jpeg" alt="" />
				<div class="infoSlide">
					<span>Sản phẩm mới nhất hiện nay </span>
					<div class="sliderShopNow">
						<div class="shopNow">
							<a href="danh-muc?id=1" class="iconShopNow">Show now <i
								class="fa fa-shopping-cart" aria-hidden="true"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
			<!--slide images end-->
			<!--automatic navigation start-->
			<div class="navigation-auto">
				<div class="auto-btn1"></div>
				<div class="auto-btn2"></div>
				<div class="auto-btn3"></div>
				<div class="auto-btn4"></div>
			</div>
			<!--automatic navigation end-->
		</div>
		<!--manual navigation start-->
		<div class="navigation-manual">
			<label for="radio1" class="manual-btn"></label> <label for="radio2"
				class="manual-btn"></label> <label for="radio3" class="manual-btn"></label>
			<label for="radio4" class="manual-btn"></label>
		</div>
		<!--manual navigation end-->
	</div>
	<script type="text/javascript">
		var counter = 1;
		setInterval(function() {
			document.getElementById("radio" + counter).checked = true;
			counter++;
			if (counter > 4) {
				counter = 1;
			}
		}, 5000);
	</script>
	<!--Chuyển sang content-->
	<div class="ChangeArea">
		<span>Sán phẩm giảm giá</span>
	</div>

	<!--Content area-->
	<form type="hidden" id="mov-chi-tiet" aria-hidden="true"
		action="chi-tiet"></form>
	<div class="containerCT">
		<div class="Content">
			<c:forEach var="item" items="${products}">
				<c:if test="${item.id <=8 }">
					<div class="contentCard">
						<div class="imgContent">
							<a href="chi-tiet?id=${item.id}" target="_self"><img src="${item.thumbnail}" alt=""/></a>
							<ul class="actionCT">
								<li>
								<form action="chi-tiet" method="get">
									<button class="fa fa-eye" aria-hidden="true" target="_self" type="submit"></button> 
									<span>View Details</span>
									<input type="hidden" name="id" value="${item.id}">
								</form>
								</li>
								
								<li>
								<form action="cart" method="get">
									<button class="fa fa-cart-plus" aria-hidden="true" type="submit">
									</button><span>Add to Cart</span>
									<input type="hidden" name="id" value="${item.id}">
								</form>
								</li>
								
							</ul>
						</div>

						<div class="infoContent">
							<div class="proNameCT">
								<h3>${item.name}</h3>
							</div>
							<div class="priceProCT">
								<h2>$${item.price}</h2>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<div class="ChangeArea_SP">
		<span>Sản phẩm mới nhất</span>
	</div>

	<div class="containerCT">
		<div class="Content">
			<c:forEach var="item" items="${products}" varStatus="loop">
				<c:if test="${item.id >8 }">
					<div class="contentCard">
						<div class="imgContent">
							<a href="chi-tiet?id=${item.id}" target="_self"><img src="${item.thumbnail}" alt="" /></a>
							<ul class="actionCT">
								<li>
								<form action="chi-tiet" method="get">
									<button class="fa fa-eye" aria-hidden="true" target="_self" type="submit"></button> 
									<span>View Details</span>
									<input type="hidden" name="id" value="${item.id}">
								</form>
								</li>
								
								<li>
								<form action="cart" method="get">
									<button class="fa fa-cart-plus" aria-hidden="true" type="submit">
									</button><span>Add to Cart</span>
									<input type="hidden" name="id" value="${item.id}">
								</form>
								</li>
							</ul>
						</div>
						<div class="infoContent">
							<div class="proNameCT">
								<h3>${item.name}</h3>
							</div>
							<div class="priceProCT">
								<h2>$${item.price}</h2>
							</div>
						</div>
					</div>

				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>