package com.laptrinhweb.dto;

public class LineItemDTO extends AbstractDTO{
	private Long product_Id; 
	private int quantity;
	public Long getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(Long product_Id) {
		this.product_Id = product_Id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
