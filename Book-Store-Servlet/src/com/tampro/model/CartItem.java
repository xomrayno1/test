package com.tampro.model;

import java.io.Serializable;

public class CartItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int order_Id;
	private int quantity;
	private Books books;
	private int total_Price;
	
    public CartItem() {
		
		
	}
	public CartItem(int order_Id, int quantity, Books books, int total_Price) {
		
		this.order_Id = order_Id;
		this.quantity = quantity;
		this.books = books;
		this.total_Price = total_Price;
	}
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public int getTotal_Price() {
		return total_Price;
	}
	public void setTotal_Price(int total_Price) {
		this.total_Price = total_Price;
	}
	
	
	
	

}
