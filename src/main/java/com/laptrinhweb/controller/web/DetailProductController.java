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

import com.laptrinhweb.dto.ProductDTO;
import com.laptrinhweb.service.IProductService;


@WebServlet(urlPatterns = {"/chi-tiet"})
public class DetailProductController extends HttpServlet {
	@Inject
	private IProductService productService;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("id");
		Long id = null;
		if(param != null)
		{
			id = Long.parseLong(param);
		}
		ProductDTO product = productService.findOneById(id);
		request.setAttribute("product", product);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/detail_product.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
