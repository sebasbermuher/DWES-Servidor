package org.iesalixar.servidor.model;

import java.io.Serializable;

public class OrderDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Products products;
	private int quantityOrdered;
	private double priceEach;
	private int orderLineNumber;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(Products products, int quantityOrdered, double priceEach, int orderLineNumber) {
		super();
		this.products = products;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	
}
