<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--	pageEncoding="UTF-8"%>--%>
<%--<%@include file="/common/taglib.jsp"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--<meta charset="UTF-8">--%>
<%--<title>Login</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--	<div class="form-box">--%>
<%--		<div class="button-box">--%>
<%--			<div id="btn"></div>--%>
<%--			<button type="button" class="toggle-btn" onclick="login()">Login</button>--%>
<%--			<button type="button" class="toggle-btn" onclick="register()">Register</button>--%>

<%--		</div>--%>

<%--		<form id="login" class="input-group" action = "dang-nhap" method="post"> --%>
<%--			<input type="email" class="input-field" placeholder="Email" required name="email"> --%>
<%--			<input type="password" class="input-field" placeholder="Enter password" name = "password" required>--%>

<%--			<input type="hidden" name="action" value="JoinNow">--%>
<%--			<c:if test="${wrong_password != null}">--%>
<%--				<c:if test="${wrong_password == '1'}">--%>
<%--					<p>Password sai</p>--%>
<%--				</c:if>--%>
<%--			</c:if>--%>
<%--			<button type="submit" class="submit-btn">Login</button>--%>
<%--			--%>
<%--		</form>--%>
<%--		--%>
<%--		--%>
<%--		<form id="register" class="input-group" action = "dang-ky" method="post"> --%>
<%--			<input type="email" class="input-field" placeholder="Email" name="email" required> --%>
<%--			<input type="text" class="input-field" placeholder="Full Name" name="fullname" required> --%>
<%--			<input type="text" class="input-field" placeholder="Address" name="address" required> --%>
<%--			<input type="password" class="input-field" placeholder="Enter Password" name="password" required>--%>
<%--			<input type="password" class="input-field" placeholder="Confirm Password" name="ConfirmPass"required>--%>
<%--			<c:if test="${already_have_account != null}">--%>
<%--				<c:if test="${already_have_account == '1'}">--%>
<%--					<br>--%>
<%--					<p class="center" style="text-align:center; color: red">Gmail của bạn đã được sử dụng!</p>--%>
<%--				</c:if>--%>
<%--			</c:if>--%>

<%--			<button type="submit" class="submit-btn" >Register</button>--%>
<%--			<input type="hidden" name="action" value="RegisterNow">--%>



<%--		</form>				--%>
<%--	</div>--%>
<%--	<script>--%>
<%--		var x = document.getElementById("login")--%>
<%--		var y = document.getElementById("register")--%>
<%--		var z = document.getElementById("btn")--%>
<%--		function register() {--%>
<%--			x.style.left = "-400px";--%>
<%--			y.style.left = "50px";--%>
<%--			z.style.left = "110px";--%>

<%--		}--%>
<%--		function login() {--%>
<%--			x.style.left = "50px";--%>
<%--			y.style.left = "450px";--%>
<%--			z.style.left = "0px";--%>

<%--		}--%>
<%--	</script>--%>
<%--</body>--%>
<%--</html>--%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
<div class="form-box">
	<div class="button-box">
		<div id="btn"></div>
		<button type="button" class="toggle-btn" onclick="login()">Login</button>
		<button type="button" class="toggle-btn" onclick="register()">Register</button>

	</div>

	<form id="login" class="input-group" action = "dang-nhap" method="post">
		<input type="email" class="input-field" placeholder="Email" required name="email">
		<input type="password" class="input-field" placeholder="Enter password" name = "password" required>

		<input type="hidden" name="action" value="JoinNow">
		<button type="submit" class="submit-btn">Login</button>
		<c:if test="${login_fail != null}">
			<c:if test="${login_fail == '1'}">
				<p style="text-align:center;margin-top: 15px; color: red">Tài khoản hoặc password sai</p>
			</c:if>
		</c:if>
	</form>


	<form id="register" class="input-group" action = "dang-ky" method="post">
		<input type="email" class="input-field" placeholder="Email" name="email" required>
		<input type="text" class="input-field" placeholder="Full Name" name="fullname" required>
		<input type="text" class="input-field" placeholder="Address" name="address" required>
		<input type="password" class="input-field" placeholder="Enter Password" name="password" required>
		<input type="password" class="input-field" placeholder="Confirm Password" name="ConfirmPass"required>

		<button type="submit" class="submit-btn" >Register</button>
		<input type="hidden" name="action" value="RegisterNow">

		<c:if test="${wrong_password != null}">
			<c:if test="${wrong_password == '1'}">
				<p>Password sai</p>
			</c:if>
		</c:if>

		<c:if test="${already_have_account != null}">
			<c:if test="${already_have_account == '1'}">
				<p style="text-align:center;margin-top: 15px; color: red">Tài khoản đã tồn tại</p>
			</c:if>
		</c:if>
	</form>
</div>
<script>
	var x = document.getElementById("login")
	var y = document.getElementById("register")
	var z = document.getElementById("btn")
	function register() {
		x.style.left = "-400px";
		y.style.left = "50px";
		z.style.left = "110px";

	}
	function login() {
		x.style.left = "50px";
		y.style.left = "450px";
		z.style.left = "0px";

	}
</script>
</body>
</html>