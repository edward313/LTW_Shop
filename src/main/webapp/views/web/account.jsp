<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân</title>
</head>
<body>
	<section class="account-item-content">
		<div class="account-underlined-title">
			<div class="editContent">
				<h1 class="text-center latestitems">WELLCOME ${user.fullname }</h1>
			</div>
			<div class="wow-hr type_short">
				<span class="wow-hr-h"> <i class="fa fa-star"></i> <i
					class="fa fa-star"></i> <i class="fa fa-star"></i>
				</span>
			</div>
		</div>
		<div id="edd_account_form_wrap ">
				<fieldset id="edd_checkout_user_info">
					<legend>THÔNG TIN CÁ NHÂN</legend>
					<div class="edd_account_form_info">
						<label class="edd-label" for="edd-first"> Full Name <span
							class="edd-required-indicator">: </span>
						</label> <label class="edd-input account-fullname-input required"
							id="edd-first">${user.fullname}</label>
						<br>

<%--						</label> <label class="edd-input account-fullname-input required"--%>
<%--										id="edd-first">${user.email}</label>--%>
<%--						<label class="edd-label" for="edd-first"> Full Name <span--%>
<%--								class="edd-required-indicator">: </span>--%>
<%--						</label> <label class="edd-input account-fullname-input required"--%>
<%--										id="edd-first">${user.address}</label>--%>
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
<%--					<div class="end_account_form_info">--%>
<%--						<label class="end-label" for="edd-first"> Email Address <span--%>
<%--							class="end-required-indicator">: </span>--%>
<%--						</label>--%>
<%--						<label class="end-input account-fullname-input required"--%>
<%--							id="end-first">Email Address :${user.email}</label>--%>
<%--					</div>--%>
<%--					<div class="end_account_form_info">--%>
<%--						<label class="end-label" for="edd-first"> Your Address <span--%>
<%--							class="end-required-indicator">: </span>--%>
<%--						</label><label class="edd-input account-fullname-input required"--%>
<%--							id="edd-first">${user.address}</label>--%>
<%--					</div>--%>
				</fieldset>
				<fieldset id="edd_change_user_password">
					<legend>ĐỔI MẬT KHẨU</legend>
					<form action="thong-tin" method="post">
						<div class="edd_password_form_info">
						
							<div class="edd_current_password">
								<label class="edd-label" for="edd-first"> Current
									Password <span class="edd-required-indicator">: </span>
								</label> <input class="edd-input required" type="password"
									name="current_password" placeholder="Current Password" id="edd-first"
									value="" required="">
							</div>
							<div class="edd_new_password">
								<label class="edd-label" for="edd-last"> New Password <span
									class="edd-required-indicator">: </span></label> 
									<input class="edd-input" type="password" name="new_password"  id="edd-last" placeholder="New Password" value="">
							</div>
							<input type="hidden" name="action" value="changePassword">
							
						</div>
<%--						<div class="text-center">--%>
<%--							<form action="thanh-toan" method="get">--%>
<%--								<button type="submit" class="color-button">Thanh toán</button>--%>
<%--							</form>--%>
<%--						</div>--%>

						<div class="account_confirm_password">
							<button  class="color-button">Xác nhận</button>
						</div>

					</form>
					<c:if test="${changedPass_sucess == 1 }">
							<h1>ĐỔI PASS THÀNH CÔNG!!!</h1>
						</c:if>
						<c:if test="${changedPass_sucess == 0 }">
							<h1>ĐỔI PASS KHÔNG THÀNH CÔNG!!!</h1>
						</c:if>
				</fieldset>
				<form class="account-logout-form" action="dang-nhap" method="get">
					<button class="color-button" type="submit">Log out</button>
					<input type="hidden" name="action" value="logout">	
				</form>
		</div>
	</section>
	<script src="template/web/js/script.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script src="template/web/js/jsCarttotal.js"></script>
</body>
</html>