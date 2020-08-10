package com.tampro.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;  

public class Orders {
	private int id;
	private Users users;
	private int totalPrice;
	private Date date;	
	private List<CartItem> listCartItem;
	private int idAddress;
	private int status; // 2 Thành Công , 3 Đang Xử Lý , 1 Hủy Đơn Hàng
	
	
	public Orders() {
		 listCartItem = new ArrayList<CartItem>();
		 date = Date.valueOf(LocalDate.now());
		 status = 3;
	}
	




	public int getIdAddress() {
		return idAddress;
	}





	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}



	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}



	public List<CartItem> getListCartItem() {
		return listCartItem;
	}



	public void setListCartItem(List<CartItem> listCartItem) {
		this.listCartItem = listCartItem;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public String getStatusDisplay() {
		if(this.status ==  2) {
			return "Thành công";
		}else if(this.status == 3){
			return "Đang xử lý";
		}else{
			return "Hủy đơn hàng";
		}
	}
	

}
