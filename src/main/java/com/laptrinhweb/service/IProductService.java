package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.ProductDTO;

public interface IProductService {
	ProductDTO save(ProductDTO productDTO);
	List<ProductDTO> findAll(); 
	ProductDTO updateProduct(ProductDTO productDTO);
	List<ProductDTO> findAllByCategoryId(Long id);
	ProductDTO findOneById(Long id);
}
