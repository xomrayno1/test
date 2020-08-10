package com.tampro.model;

public class Ward {
	private int id;
	private String name;
	private String prefix;
	private int provinceId;
	private int districtId;
	
	public Ward(String name, String prefix, int provinceId, int districtId) {
		
		this.name = name;
		this.prefix = prefix;
		this.provinceId = provinceId;
		this.districtId = districtId;
	}

	public Ward() {
		
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

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	
	
	

}
