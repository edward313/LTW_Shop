package com.laptrinhweb.dao.impl;

import java.util.List;

import com.laptrinhweb.dao.ICategoryDAO;
import com.laptrinhweb.entity.CategoryEntity;


public class CategoryDAO extends AbstractDAO<CategoryEntity> implements ICategoryDAO {

	@Override
	public CategoryEntity save(CategoryEntity categoryEntity) {
		return insert(categoryEntity);
	}
	
	@Override
	public List<CategoryEntity> findAll() {
		String sql = "SELECT c FROM CategoryEntity c";
		return query(sql);
	}

	@Override
	public CategoryEntity findOneCategoryById(Long id) {
		return findOneById(CategoryEntity.class,id);
	}
	
}
