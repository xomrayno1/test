package com.tampro.model;

import java.sql.Date;

public class Coupon {
	private int id;
	private String code;
	private int percent;
	private Date create;
	private Date start;
	private Date end;
	private int status;
	
	
	public Coupon() {
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getStatus() {
		return status;
	}

	
	
	
}
