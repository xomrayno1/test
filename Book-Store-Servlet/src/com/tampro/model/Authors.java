package com.tampro.model;

public class Authors {
	private int id;
	private String first_Name;
	private String initials;
	private  String last_Name;
	
	
	public Authors() {
		
	}
	
	public Authors(String first_Name, String initials, String last_Name) {
		this.first_Name = first_Name;
		this.initials = initials;
		this.last_Name = last_Name;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}


	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}


	public String getInitials() {
		return initials;
	}


	public void setInitials(String initials) {
		this.initials = initials;
	}


	public String getLast_Name() {
		return last_Name;
	}


	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getFullName() {
		return this.first_Name + last_Name;
	}
	 
	

}
