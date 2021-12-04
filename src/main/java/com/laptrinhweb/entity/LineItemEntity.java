package com.laptrinhweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lineitem")
public class LineItemEntity extends AbstractEntity{
	@Column(name="quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name="bill_id")
	private BillEntity billEntity;

	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity productEntity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}


}