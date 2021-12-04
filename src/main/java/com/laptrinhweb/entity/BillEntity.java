package com.laptrinhweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class BillEntity extends AbstractEntity {
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity userEntity;

	@ManyToMany
	@JoinTable(
			name = "bill_product",
			joinColumns = @JoinColumn(name = "bill_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	List<ProductEntity> products = new ArrayList<>();


	@Column(name="totalprice")
	private float totalPrice;


	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}



}