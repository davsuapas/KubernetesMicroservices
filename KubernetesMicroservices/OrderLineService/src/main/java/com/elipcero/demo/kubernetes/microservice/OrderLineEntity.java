package com.elipcero.demo.kubernetes.microservice;

public class OrderLineEntity {
	
	public OrderLineEntity() {
	}
	
	public OrderLineEntity(int number, String productName) {
		this.number = number;
		this.productName = productName;
	}
	
	private int number;
	
	private String productName;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
