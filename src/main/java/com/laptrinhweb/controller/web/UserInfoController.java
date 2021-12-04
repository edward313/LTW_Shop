package com.laptrinhweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.service.IUserService;


@WebServlet(urlPatterns = {"/thong-tin"})
public class UserInfoController extends HttpServlet {
	@Inject
	private IUserService userService;
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/views/web/account.jsp";
 		HttpSession session = request.getSession();
		UserEntity user = (UserEntity)session.getAttribute("user");
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/dang-nhap");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current_password = request.getParameter("current_password");
		String new_password = request.getParameter("new_password");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity)session.getAttribute("user");
		if(action.equals("changePassword")) {
			String old_password = user.getPassword();
			int changedPass = 0;
			if(current_password.equals(old_password)) {				
				user.setPassword(new_password);
				userService.updateUser(user);
				changedPass = 1;				
			}
			session.setAttribute("changedPass_sucess", changedPass);			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/account.jsp");
		rd.forward(request, response);
	}

}
