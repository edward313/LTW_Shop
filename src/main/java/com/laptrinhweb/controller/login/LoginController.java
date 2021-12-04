package com.laptrinhweb.controller.login;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.service.IUserService;
import com.laptrinhweb.utils.MailUtilLocal;

@WebServlet(urlPatterns = { "/dang-nhap", "/dang-ky" })
public class LoginController extends HttpServlet {
	private String host;
	private String port;
	private String username;
	private String pass;

	public void init() {
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		username = context.getInitParameter("username");
		pass = context.getInitParameter("pass");
	}

	@Inject
	private IUserService userService;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = "/views/login.jsp";
		String action = request.getParameter("action");
		if(action!=null) {
			if(action.equals("logout")) {
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/trang-chu");
			}
		}
		else {
			session.setAttribute("wrong_password", null);
			session.setAttribute("login_fail", null);
			session.setAttribute("already_have_account", null);
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		HttpSession session = request.getSession();
		String prev_action = (String) session.getAttribute("prev_action");

		String url = "/views/login.jsp";
		if (action.equals("RegisterNow")) {
			String login_fail = (String)session.getAttribute("login_fail");
			if(login_fail != null) {
				session.setAttribute("login_fail", null);
			}
			if (registerUser(request, response) == true) {
				String wrong_code = null;
				session.setAttribute("wrong_code", wrong_code);
				url = "views/web/verify.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}
		} else if(action.equals("checkCode")) {
			String wrong_code = null;
			if(checkCode(request,response) == true) {
				if (prev_action != null) {
					if (prev_action.equals("PaymentNow")) {
						session.removeAttribute("prev_action");
						response.sendRedirect(request.getContextPath() + "/thanh-toan");
					}
				}
				else {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				}
			}
			else {
				wrong_code = "1";
				session.setAttribute("wrong_code", wrong_code);
				url = "views/web/verify.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}
		}
		else if (action.equals("JoinNow")) {
			String wrong_password = (String)session.getAttribute("wrong_password");
			if(wrong_password != null) {
				session.setAttribute("wrong_password", null);
			}
			String already_have_account = (String)session.getAttribute("already_have_account");
			if(already_have_account != null) {
				session.setAttribute("already_have_account", null);
			}
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			UserEntity user = userService.findOneByUserName(email);
			if(user == null || !password.equals(user.getPassword())) {
				String login_fail = "1";
				session.setAttribute("login_fail", login_fail);
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}
			if (user != null && password.equals(user.getPassword())) {
				String login_fail = null;
				session.setAttribute("login_fail", login_fail);
				session.setAttribute("user", user);
				if (prev_action != null) {
					if (prev_action.equals("PaymentNow")) {
						session.removeAttribute("prev_action");
						response.sendRedirect(request.getContextPath() + "/cart");
					}
				} else response.sendRedirect(request.getContextPath() + "/trang-chu");
			}
		}
	}

	private boolean checkCode(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity)session.getAttribute("user_verify");
		if(code.equals(user.getCode())) {
			Long id = userService.saveUser(user);
			Cookie c = new Cookie("emailCookie", user.getEmail());
			c.setMaxAge(60*60*24*365*2);
			c.setPath("/"); response.addCookie(c);
			session.setAttribute("user", user);
			return true;
		}
		return false;
	}

	private boolean registerUser(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String already_have_account = null;
		String wrong_password = null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String address = request.getParameter("address");
		String confirmpass = request.getParameter("ConfirmPass");
		UserEntity new_user = new UserEntity();
		UserEntity user = userService.findOneByUserName(email);
		if (user == null) {
			if (password.equals(confirmpass)) {
				String code = MailUtilLocal.getRandom();
				new_user.setAddress(address);
				new_user.setFullname(fullname);
				new_user.setEmail(email);
				new_user.setPassword(password);
				new_user.setCode(code);
				session.setAttribute("user_verify", new_user);
				boolean test;
				try {
					test = MailUtilLocal.sendMail(host, port, username, pass, email, "Email Verification", "Registered successfully.Please verify your account using this code: " + new_user.getCode());
				}catch (Exception e) {
					String errorMessage
							= "ERROR: Unable to send email. "
							+ "Check Tomcat logs for details.<br>"
							+ "NOTE: You may need to configure your system "
							+ "as described in chapter 14.<br>"
							+ "ERROR MESSAGE: " + e.getMessage();
					request.setAttribute("errorMessage", errorMessage);
					this.log(
							"Unable to send email. \n"
									+ "Here is the email you tried to send: \n"
									+ "=====================================\n"
									+ "TO: " + email + "\n"
									+ "FROM: " + username + "\n"
									+ "SUBJECT: " + "Thanks for register" + "\n\n"
									+ "Thank for register in Technology Shop!!" + "\n\n");
					return false;
				}
				if(test) {
					return true;
				}
			}
			else {
				wrong_password = "1";
				session.setAttribute("wrong_password", wrong_password);
			}
		}
		else {
			already_have_account = "1";
			session.setAttribute("already_have_account", already_have_account);
		}
		return false;
	}

}
