package com.tampro.model;

import java.sql.Date;
import java.time.LocalDate;

public class News {
	private int id;
	private String title;
	
	private String content;
	private Date create;
	private int idUser;
	private String img;
	
	public News() {
		create = Date.valueOf(LocalDate.now());
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	

}
