<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán</title>
</head>
<body>

	<div class="Padding"></div>
	<c:if test="${cartIsNull == 1}">
<%--		<h1>GIỎ HÀNG ĐANG TRỐNG NHÉ</h1>--%>
		<div class="container">
			<div class="container-fluid">
				<div class="row">


					<div class="col-25">
						<div class="text-center"> <i class="fas fa-cart-plus" style="font-size: 100px;margin-bottom: 20px;"></i></div>

						<h1  class="text-center" >Hiện tại giỏ hàng của bạn đang trống</h1>

						<hr>


						<form action="trang-chu" method='get'>
							<div class="row">
							<div class="col text-center">
								<button type="submit" class="color-button">Tiếp tục mua
									sắm</button>
							</div>
							</div>

						</form>
					</div></div>
			</div>
		</div>
		</div>
		</div>
		</div>
		</div>
	</c:if>
	<c:if test="${cartIsNull != 1}">
		<section class="item content">
			<div class="container toparea">
				<div class="underlined-title">
					<div class="editContent">
						<h1 class="text-center latestitems">Hóa đơn thanh toán</h1>
					</div>
					<div class="wow-hr type_short">
						<span class="wow-hr-h"> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i>
						</span>
					</div>
				</div>
				<div id="edd_checkout_wrap" class="col-md-8 col-md-offset-2">
					<form id="edd_checkout_cart_form" method="post">
						<div id="edd_checkout_cart_wrap">
							<table id="edd_checkout_cart" class="ajaxed">
								<thead>
									<tr class="edd_cart_header_row">
										<th class="edd_cart_item_name">Tên Sản Phảm</th>
										<th class="edd_cart_item_price">Đơn giá</th>
										<th class="edd_cart_volume">Số lượng</th>
										<th class="edd_cart_total_1">Thành Tiền</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${cart}">
										<!-- San Pham CUa ban -->
										<tr class="edd_cart_item" id="edd_cart_item_0_25"
											data-download-id="25">
											<td class="edd_cart_item_name">
												<div class="edd_cart_item_image">
													<img width="80" height-min="50"
														src="${item.productEntity.thumbnail}" alt="">
												</div> <span class="edd_checkout_cart_item_title">${item.productEntity.name}</span>
											</td>
											<td class="edd_cart_item_price">$${item.productEntity.price}</td>
											<td class="edd_cart_volume">${item.quantity}</td>
											<td class="edd_cart_total_1">$${item.productEntity.price*item.quantity}</td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>

									<tr class="edd_cart_footer_row edd_cart_discount_row"
										style="display: none;">
										<th colspan="5" class="edd_cart_discount"></th>
									</tr>
									<tr class="edd_cart_footer_row">
										<th colspan="5" class="edd_cart_total">Total: <span
											class="edd_cart_amount" data-subtotal="11.99"
											data-total="11.99">$${totalPrice}</span>
										</th>
									</tr>
								</tfoot>
							</table>
						</div>
					</form>
					<div id="edd_checkout_form_wrap" class="edd_clearfix">
						<form id="edd_purchase_form" class="edd_form" action="#"
							method="POST">
                            <fieldset id="edd_checkout_user_info">
								<legend>Thông Tin Khách Hàng</legend>
                                <div class="edd_account_form_info">
                                    <label class="edd-label" for="edd-first"> Full Name <span
                                            class="edd-required-indicator">: </span>
                                    </label> <label class="edd-input account-fullname-input required"
                                                    id="edd-first">${user.fullname}</label>
                                    <br>


                                </div>
                                <div class="edd_account_form_info">
                                    <label class="edd-label" for="edd-first"> Email Address<span
                                            class="edd-required-indicator">: </span>
                                    </label> <label class="edd-input account-fullname-input required"
                                                    id="edd-first">${user.email}</label>
                                    <br>
                                </div>
                                <div class="edd_account_form_info">
                                    <label class="edd-label" for="edd-first">  <span
                                            class="edd-required-indicator">Your Address : </span>
                                    </label> <label class="edd-input account-fullname-input required"
                                                    id="edd-first">${user.address}</label>
                                    <br>
                                </div>
							</fieldset>
						</form>
					</div>
					<div>
					<form action="trang-chu" method='get'>
						<div class="col text-center">
						<button type="submit" class="color-button">Tiếp tục mua
							sắm</button>
							</div>
					</form>

				    </div>


			</div>
		</section>
	</c:if>
</body>
</html>