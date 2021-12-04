package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.converter.ProductConverter;
import com.laptrinhweb.dao.ICategoryDAO;
import com.laptrinhweb.dao.IProductDAO;
import com.laptrinhweb.dto.ProductDTO;
import com.laptrinhweb.entity.CategoryEntity;
import com.laptrinhweb.entity.ProductEntity;
import com.laptrinhweb.service.IProductService;

public class ProductService implements IProductService {

	@Inject
	private IProductDAO productDAO;
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Inject
	private ProductConverter productConverter;

	@Override
	public ProductDTO save(ProductDTO productDTO) {
		CategoryEntity categoryEntity = categoryDAO.findOneCategoryById(productDTO.getCategoryId());
		ProductEntity productEntity = productConverter.toEntity(productDTO);
		productEntity.setCategoryEntity(categoryEntity);
		productEntity = productDAO.save(productEntity);
		return productConverter.toDTO(productEntity);
	}

	
	  @Override 
	public List<ProductDTO> findAll() { 
		List<ProductDTO> resultList = new ArrayList<>();
		List<ProductEntity> entities = productDAO.findAll();
		for (ProductEntity productEntity : entities) {
			resultList.add(productConverter.toDTO(productEntity));
		}
		return resultList;
	 }


	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		CategoryEntity categoryEntity = categoryDAO.findOneCategoryById(productDTO.getCategoryId());
		ProductEntity entity = productConverter.toEntity(productDTO);
		entity.setCategoryEntity(categoryEntity);
		productDAO.UpdateProduct(entity);
		entity = productDAO.findOneProductById(productDTO.getId());
		return productConverter.toDTO(entity);
	}


	@Override
	public List<ProductDTO> findAllByCategoryId(Long id) {
		List<ProductDTO> results = new ArrayList<>();
		CategoryEntity category = categoryDAO.findOneCategoryById(id);
		ProductEntity entity = new ProductEntity();
		entity.setCategoryEntity(category);
		List<ProductEntity> products = productDAO.findAllByCategoryId(entity);
		for (ProductEntity productEntity : products) {
			results.add(productConverter.toDTO(productEntity));
		}
		return results;
	}


	@Override
	public ProductDTO findOneById(Long id) {
		return productConverter.toDTO(productDAO.findOneProductById(id));
	}	  	
}
