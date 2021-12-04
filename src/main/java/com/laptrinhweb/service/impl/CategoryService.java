package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.converter.CategoryConverter;
import com.laptrinhweb.dao.ICategoryDAO;
import com.laptrinhweb.dto.CategoryDTO;
import com.laptrinhweb.entity.CategoryEntity;
import com.laptrinhweb.service.ICategoryService;

public class CategoryService implements ICategoryService{

	@Inject
	private ICategoryDAO categoryDAO;
	
	@Inject
	private CategoryConverter categoryConverter;
	
	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		CategoryEntity entity = categoryConverter.toEntity(categoryDTO); 
		entity = categoryDAO.save(entity); 
		return categoryConverter.toDTO(entity);
	}

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> resultList = new ArrayList<>();
		List<CategoryEntity> entities = categoryDAO.findAll();
		for (CategoryEntity categoryEntity : entities) {
			resultList.add(categoryConverter.toDTO(categoryEntity));
		}
		return resultList;
	}

	@Override
	public CategoryDTO findOneById(Long id) {
		CategoryEntity category = categoryDAO.findOneCategoryById(id);
		return categoryConverter.toDTO(category);
	}
	
	
}
