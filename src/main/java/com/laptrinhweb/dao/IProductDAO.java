package com.laptrinhweb.dao;

import java.util.List;

import com.laptrinhweb.entity.ProductEntity;

public interface IProductDAO {
	ProductEntity save(ProductEntity productEntity);
	List<ProductEntity> findAll();
	void UpdateProduct(ProductEntity productEntity);
	ProductEntity findOneProductById(Long id);
	List<ProductEntity> findAllByCategoryId(ProductEntity productEntity);
}
