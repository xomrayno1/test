package com.tampro.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Users {
	private int id;
	private String userName;
	private String passWord;
	private String name;
	private List<Address>  dsAddress;
	private String phone;
	private String email;
	private String role;
	private Date create_Date;
	private Date modify_Date;
	private int status;
	
	public Users() {
		this.role = "ROLE_USER";
		this.create_Date =  Date.valueOf(LocalDate.now());
		this.modify_Date =  Date.valueOf(LocalDate.now());
		status = 1;
		
	}
	public Users(String userName, String passWord, String name, String phone, String email) {
		
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		
		this.phone = phone;
		this.email = email;
		this.role = "ROLE_USER";
		this.create_Date =  Date.valueOf(LocalDate.now());
		this.modify_Date =  Date.valueOf(LocalDate.now());
		status = 1;
		
	}
	public Users(String userName, String passWord, String name, String phone, String email,String role) {
		
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		
		this.phone = phone;
		this.email = email;
		this.role = role;
		this.create_Date =  Date.valueOf(LocalDate.now());
		this.modify_Date =  Date.valueOf(LocalDate.now());
		status = 1;
	}
	
	
	public Users(String userName, String passWord, String name, List<Address> dsAddress, String phone, String email,
			String role, Date create_Date, Date modify_Date) {
		
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		this.dsAddress = dsAddress;
		this.phone = phone;
		this.email = email;
		this.role = role;
		this.create_Date = create_Date;
		this.modify_Date = modify_Date;
		status = 1;
	}
	public Date getCreate_Date() {
		return create_Date;
	}
	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}
	public Date getModify_Date() {
		return modify_Date;
	}
	public void setModify_Date(Date modify_Date) {
		this.modify_Date = modify_Date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address> getDsAddress() {
		return dsAddress;
	}
	public void setDsAddress(List<Address> address) {
		this.dsAddress = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getDisplay() {
		if(status == 1) {
			return "Không Khóa";
		}else {
			return "Đã Khóa";
		}
	}

}
