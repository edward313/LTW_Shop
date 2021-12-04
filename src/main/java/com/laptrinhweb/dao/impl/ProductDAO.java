package com.laptrinhweb.dao.impl;

import java.util.List;

import com.laptrinhweb.dao.IProductDAO;
import com.laptrinhweb.entity.ProductEntity;

public class ProductDAO extends AbstractDAO<ProductEntity> implements IProductDAO{

	@Override
	public ProductEntity save(ProductEntity productEntity) {
		return insert(productEntity);
	}
	
	@Override
	public List<ProductEntity> findAll() {
		String sql = "SELECT p FROM ProductEntity p";
		return query(sql);
	}

	@Override
	public void UpdateProduct(ProductEntity productEntity) {
		update(productEntity);
	}

	@Override
	public ProductEntity findOneProductById(Long id) {
		return findOneById(ProductEntity.class,id);
	}

	@Override
	public List<ProductEntity> findAllByCategoryId(ProductEntity productEntity) {
		String sql = "SELECT p FROM ProductEntity p" + " WHERE p.categoryEntity=?1";
		return query(sql, productEntity.getCategoryEntity());
	}

}
