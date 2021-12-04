<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category</title>

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
					alt="" />
				<div class="infoSlide">
					<span>Hot deal lorem ipsum dolor sit amet</span>
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
					<span>Hot deal lorem ipsum dolor sit amet</span>
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
				<img src="template/web/images/products/sumsung/samsung6.jpeg" alt="" />
				<div class="infoSlide">
					<span>Hot deal lorem ipsum dolor sit amet</span>
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
				<img src="template/web/images/products/iPhone/iphone2.jpeg" alt="" />
				<div class="infoSlide">
					<span>Hot deal lorem ipsum dolor sit amet</span>
					<div class="sliderShopNow">
						<div class="shopNow">
							<a href="" class="iconShopNow">Show now <i
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
	<div class="categoryPro">
		<div class="categoryName">
			<h3>Điện thoại thông minh</h3>
		</div>
		<div class="detailpro_CT">
			<div class="detailpro_left">
				<ul class="subnav_CT">
					<li><a href="danh-muc?id=1"><span>Điện thoại thông
								minh</span></a></li>
					<li><a href="danh-muc?id=2"><span>Máy tính bảng</span></a></li>
					<li><a href="danh-muc?id=3"><span>Đồng hồ thông
								minh</span></a></li>
				</ul>
			</div>
			<div class="detailpro_right">
				<div class="containerCT">
					<div class="Content">
						<c:forEach var="item" items="${products}">
							<div class="contentCard">
								<div class="imgContent">
									<img src="${item.thumbnail}" alt="" />
									<ul class="actionCT">
										<li><a class="fa fa-eye" aria-hidden="true"
											href="chi-tiet?id=${item.id}"></a> <span>View Details</span></li>
										<li>
											<form action="cart" method="get">
												<button class="fa fa-cart-plus" aria-hidden="true"
													type="submit"></button>
												<span>Add to Cart</span> <input type="hidden" name="id"
													value="${item.id}">
											</form>
										</li>
									</ul>
								</div>
								<div class="infoContent">
									<div class="proNameCT">
										<h3>${item.name}</h3>
									</div>
									<div class="priceProCT">
										<h2>${item.price}</h2>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>