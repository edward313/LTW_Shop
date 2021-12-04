package com.laptrinhweb.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.dto.ProductDTO;
import com.laptrinhweb.service.ICategoryService;
import com.laptrinhweb.service.IProductService;


@WebServlet(urlPatterns = {"/danh-muc"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;
	
	@Inject 
	private IProductService productService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("id");
		Long id = null;
		if(param != null) {
            id = Long.parseLong(param);
        }
		List<ProductDTO> products = productService.findAllByCategoryId(id);
		request.setAttribute("products", products);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/category.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
