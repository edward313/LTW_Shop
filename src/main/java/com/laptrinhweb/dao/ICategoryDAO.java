package com.laptrinhweb.dao;

import java.util.List;

import com.laptrinhweb.entity.CategoryEntity;

public interface ICategoryDAO {
	CategoryEntity save(CategoryEntity categoryEntity);
	List<CategoryEntity> findAll();
	CategoryEntity findOneCategoryById(Long Id);
	
}
