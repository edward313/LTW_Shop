<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
</head>
<body>
	<div class="Padding"></div>

	<div class="Detailproduct">
			<div class="containerDT">
				<div class="imgProDetail">
					<span class="slide_imgDT"> <img itemprop="image"
						src="${product.thumbnail}" alt="" />
					</span>
				</div>
				<div class="infoProDetail">
					<div class="nameProDetail">
						<h1>${product.name}</h1>
						<span> ${product.shortDescription} </span>
					</div>
					
					<div class="addtoCartDT">	
					<form action="cart" method="get">				
						<button>
							<i class="fa fa-cart-plus" aria-hidden="true" type="submit"></i>Add to cart
						</button>
					<input type="hidden" name="id" value="${product.id}">
					</form>
					</div>
					
				</div>
			</div>
		<div class="overviewPro">
			<div class="containerOverview">
				<h2>Đánh giá chi tiết</h2>
				<div class="infoOverview">
					<p>${product.content}</p>
					<!-- <div class="imgOverview">
						<span><img
							src="https://lumen.thinkpro.vn/backend/uploads/editor/v2/acer-nitro-5-h45-thinkpro-2.jpg"
							alt="" /> </span>
					</div> -->
				</div>
			</div>
		</div>
		<div class="Binhluan">
			<div class="containerBL">
				<h2>Bình luận</h2>
				<div class="textboxBL">
					<div class="text-TimKiem">
						<input type="text" placeholder="Mời bạn để lại bình luận"
							maxlength="50" autocomplete="off" />
						<button>Gửi</button>
					</div>
				</div>
			</div>
		</div>

	</div>


</body>
</html>