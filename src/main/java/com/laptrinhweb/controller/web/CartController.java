 package com.laptrinhweb.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laptrinhweb.converter.ProductConverter;
import com.laptrinhweb.dto.LineItemDTO;
import com.laptrinhweb.dto.ProductDTO;
import com.laptrinhweb.entity.AbstractEntity;
import com.laptrinhweb.entity.CategoryEntity;
import com.laptrinhweb.entity.LineItemEntity;
import com.laptrinhweb.entity.ProductEntity;
import com.laptrinhweb.service.IProductService;


@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet {
	@Inject
	private ProductConverter productConverter;
	
	@Inject
	private IProductService productService;
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("id");	
		Long id = null;	
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		Long totalPrice = (Long) session.getAttribute("totalPrice");
		if(totalPrice == null) {
			totalPrice = 0L;
		}		
		List<LineItemEntity> cart = (List<LineItemEntity>) session.getAttribute("cart");		
		if(param == null) {
			session.setAttribute("cart", cart);
			session.setAttribute("totalPrice", totalPrice);
			RequestDispatcher rd = request.getRequestDispatcher("views/web/cart.jsp");
			rd.forward(request, response);
		}
			
		if(param != null) {
			id = Long.parseLong(param);
			if(action!=null&&action.equals("deleteItem")) {
				int index = isExisting(id, cart);			
				totalPrice = totalPrice - (cart.get(index).getQuantity() * cart.get(index).getProductEntity().getPrice());
				cart.remove(index);
				session.setAttribute("cart", cart);
				session.setAttribute("totalPrice", totalPrice);
				response.sendRedirect(request.getContextPath() + "/cart");
			}
			else {
				ProductDTO product = productService.findOneById(id);
				LineItemEntity item = new LineItemEntity();
				item.setProductEntity(productConverter.toEntity(product));		
				if (cart == null) {
					cart = new ArrayList<>();
					item.setQuantity(1);
					cart.add(item);
					totalPrice = item.getProductEntity().getPrice();
				} else {			
					int index = isExisting(id, cart);
					if (index == -1) {
						item.setQuantity(1);
						cart.add(item);
						totalPrice = totalPrice + item.getProductEntity().getPrice();
					} else {
						int quantity = cart.get(index).getQuantity() + 1;
						cart.get(index).setQuantity(quantity);
						totalPrice = totalPrice + cart.get(index).getProductEntity().getPrice();
					}
					
				}
				session.setAttribute("cart", cart);
				session.setAttribute("totalPrice", totalPrice);
				RequestDispatcher rd = request.getRequestDispatcher("views/web/cart.jsp");
				rd.forward(request, response);
			}
		}
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private int isExisting(Long id, List<LineItemEntity> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProductEntity().getId() == id) {
				return i;
			}
		}
		return -1;
	}
}
