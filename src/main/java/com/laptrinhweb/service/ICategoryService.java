package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.CategoryDTO;

public interface ICategoryService {
	CategoryDTO save(CategoryDTO categoryDTO);
	List<CategoryDTO> findAll();
	CategoryDTO findOneById(Long id);
}
