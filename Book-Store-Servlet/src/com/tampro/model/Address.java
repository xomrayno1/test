package com.tampro.model;

public class Address {
	
	private int id;
	private String name;
	private Province province;
	private District district;
	private Ward ward;
	private String description;
	private String phone;
	private int users_Id;
	private int status; 
	
	
	public Address() {
		status = 0;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUsers_Id() {
		return users_Id;
	}
	public void setUsers_Id(int users_Id) {
		this.users_Id = users_Id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Province getProvince() {
		return province;
	}


	public void setProvince(Province province) {
		this.province = province;
	}


	public District getDistrict() {
		return district;
	}


	public void setDistrict(District district) {
		this.district = district;
	}


	public Ward getWard() {
		return ward;
	}


	public void setWard(Ward ward) {
		this.ward = ward;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return description + "," +ward.getPrefix()+" "+ ward.getName() +","+district.getPrefix()+" "+district.getName()+","+province.getName();
	}

	
	
	
	
	
	
}
