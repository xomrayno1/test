package com.tampro.dto;

public class WishListDTO {
	private int userId;
	private int bookId;
	
	
	public WishListDTO() {
		
	}
	
	
	public WishListDTO(int userId, int bookId) {
		
		this.userId = userId;
		this.bookId = bookId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	

}
