package com.tampro.model;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String content;
	
	
	
	
	
	public Contact(String name, String email, String content) {
		
		this.name = name;
		this.email = email;
		this.content = content;
	}
	public Contact() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	

}
