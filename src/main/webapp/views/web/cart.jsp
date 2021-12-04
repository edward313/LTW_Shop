<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<div class="container">
		<div class="container-fluid">
			<div class="row">

				<aside class="col-lg-9">
					<div class="card">
						<div class="table-responsive">
							<table class="table table-borderless table-shopping-cart">
								<thead class="text-muted">
									<tr class="small text-uppercase">
										<th scope="col">Product</th>
										<th scope="col" width="120">Quantity</th>
										<th scope="col" width="120">Price</th>
										<th scope="col" 
											width="200"></th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${cart != null }">
										<c:forEach var="item" items="${cart}">
											<tr>
												<td>
													<figure class="itemside align-items-center">
														<div class="aside">
															<img src="${item.productEntity.thumbnail}" class="img-sm">
														</div>
														<figcaption class="info">
															<a href="#" class="title text-dark" data-abc="true">${item.productEntity.name}</a>
														</figcaption>
													</figure>
												</td>
												<td><label class="form-control">
														${item.quantity} </label></td>
												<td>
													<div class="price-wrap">
														<var class="price">$${item.productEntity.price*item.quantity}
														</var>
														<small class="text-muted">
															$${item.productEntity.price} each </small>
													</div>
												</td>
												<td>
													<form action="cart" method="get">
														<button type="submit" class="btn btn-light" data-abc="true">Remove</button>
														<input type="hidden" name="action" value="deleteItem">
														<input type="hidden" name="id" value="${item.productEntity.id}">
													</form> 
												</td>
											</tr>
										</c:forEach>
									</c:if>
								</tbody>
							</table>
						</div>
					</div>
				</aside>


				<div class="col-25">
					<div class="card-total">
						<h4>
							Cart <span class="price" style="color: black"> </span>
						</h4>
						<p>
							Total <span class="price" style="color: black"><b>$${totalPrice}</b></span>
						</p>
						<div class="text-center">
							<form action="thanh-toan" method="get">
								<button type="submit" class="color-button">Thanh toán</button>
							</form>
							<form action="trang-chu" method='get'>
								<button type="submit" class="color-button">Tiếp tục mua
									sắm</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>