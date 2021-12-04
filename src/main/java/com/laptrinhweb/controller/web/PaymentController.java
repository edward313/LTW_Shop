package com.laptrinhweb.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laptrinhweb.entity.BillEntity;
import com.laptrinhweb.entity.LineItemEntity;
import com.laptrinhweb.entity.ProductEntity;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.service.IBillService;
import com.laptrinhweb.service.IUserService;
import com.laptrinhweb.utils.CookieUtil;


@WebServlet(urlPatterns = {"/thanh-toan"})
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IBillService billService;

	@Inject
	private IUserService userService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity)session.getAttribute("user");
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/dang-nhap");
		}
		else {
			List<LineItemEntity> cart = (List<LineItemEntity>) session.getAttribute("cart");
			if(cart == null || cart.size() == 0) {
				session.setAttribute("cartIsNull", 1);
			}
			else {
				Long totalPrice = (Long)session.getAttribute("totalPrice");
				BillEntity bill = new BillEntity();
				bill.setUserEntity(user);
				List<ProductEntity> listProduct = new ArrayList<>();
				for (LineItemEntity lineItemEntity : cart) {
					listProduct.add(lineItemEntity.getProductEntity());
				}
				bill.setProducts(listProduct);
				bill.setTotalPrice(totalPrice);
				Long id = billService.save(bill);
				System.out.println(id);
				session.setAttribute("cartIsNull", 0);
			}
			RequestDispatcher rd = request.getRequestDispatcher("views/web/payment.jsp");
			rd.forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}