package com.tampro.model;

public class District {
	private int id;
	private String name;
	private String prefix;
	private int provinceId;
	
	
	
	
	
	public District() {
		
	}
	
	
	
	public District(String name, String prefix, int provinceId) {
		
		this.name = name;
		this.prefix = prefix;
		this.provinceId = provinceId;
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
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	
	
	
	
	

}
