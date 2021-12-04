package com.laptrinhweb.converter;

import com.laptrinhweb.dto.ProductDTO;
import com.laptrinhweb.entity.ProductEntity;

public class ProductConverter {
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setShortDescription(dto.getShortDescription());
		entity.setContent(dto.getContent());
		entity.setPrice(dto.getPrice());
		entity.setThumbnail(dto.getThumbnail());
		return entity;
	}
	
	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setShortDescription(entity.getShortDescription());
		dto.setContent(entity.getContent());
		dto.setPrice(entity.getPrice());
		dto.setThumbnail(entity.getThumbnail());
		return dto;
	}
}
