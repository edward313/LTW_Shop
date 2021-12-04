package com.laptrinhweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.dto.ProductDTO;
import com.laptrinhweb.service.IProductService;
import com.laptrinhweb.utils.HttpUtils;


@WebServlet("/api-admin-product")
public class ProductAPI extends HttpServlet {
	@Inject
	private IProductService productService;
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ProductDTO productDTO = HttpUtils.Of(request.getReader()).toModel(ProductDTO.class);
		productDTO = productService.save(productDTO);
		objectMapper.writeValue(response.getOutputStream(), productDTO);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ProductDTO productDTO = HttpUtils.Of(request.getReader()).toModel(ProductDTO.class);
		productDTO = productService.updateProduct(productDTO);
		mapper.writeValue(response.getOutputStream(), productDTO);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ProductDTO productDto = HttpUtils.Of(request.getReader()).toModel(ProductDTO.class);
		
	}
}
