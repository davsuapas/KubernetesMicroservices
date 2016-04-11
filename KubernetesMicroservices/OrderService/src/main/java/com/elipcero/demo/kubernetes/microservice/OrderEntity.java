package com.elipcero.demo.kubernetes.microservice;

import java.util.ArrayList;
import java.util.List;

public class OrderEntity {
	
	public OrderEntity() {
	}
	
	public OrderEntity(int number) {
		this.number= number;
		this.orderLines = new ArrayList<OrderLineEntity>();
	}
	
	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<OrderLineEntity> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLineEntity> orderLines) {
		this.orderLines = orderLines;
	}

	private List<OrderLineEntity> orderLines;
}
