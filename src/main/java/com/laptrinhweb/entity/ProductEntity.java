package com.laptrinhweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity extends AbstractEntity{
	@ManyToMany(mappedBy = "products")
	List<BillEntity> bills = new ArrayList<>();


	@Column(name="name")
	private String name;

	@Column(name="price")
	private Long price;

	@Column(name="shortdescription", columnDefinition = "TEXT")
	private String shortDescription;

	@Column(name="content", columnDefinition = "TEXT")
	private String content;

	@Column(name="thumbnail")
	private String thumbnail;

	@ManyToOne
	@JoinColumn(name="category_id")
	private CategoryEntity categoryEntity;


	@OneToMany(mappedBy="productEntity")
	private List<LineItemEntity>lineItem = new ArrayList<>();


	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public List<BillEntity> getBills() {
		return bills;
	}
	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}
	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}
	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


}