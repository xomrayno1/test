package com.tampro.model;

import java.sql.Date;
import java.time.LocalDate;

public class Books {
	private int id;
	private String ISBN;
	private String title;
	private Date publication_date;
	private String comments;
	private String images;
	private Date create_Date;
	private int price;
	private Authors author;
	private int category_Id;
	private int status;  //1 còn dùng , hêt dung`;
	
	
	
     public Books() {
    	 this.create_Date = Date.valueOf(LocalDate.now());
		status = 1;
	}
	
	public Books(String iSBN, String title, Date publication_date, String comments,String images, int price,Authors author, int category_Id, int status) {
		
		ISBN = iSBN;
		this.title = title;
		this.publication_date = publication_date;
		this.comments = comments;
		this.images = images;
		this.price =price;
		this.author = author;
		this.category_Id = category_Id;
		this.create_Date = Date.valueOf(LocalDate.now());
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(Date publication_date) {
		this.publication_date = publication_date;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Authors getAuthor() {
		return author;
	}
	public void setAuthor(Authors author) {
		this.author = author;
	}
	public int getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public String getDisplay() {
		if(this.status == 1) {
			return "Không hỗ trợ";
		}
		return "Còn hỗ trợ";
	}
	

}
