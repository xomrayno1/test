package com.tampro.service;

import java.util.List;

import com.tampro.model.Orders;

public interface OrdersService {
	
	boolean add(Orders orders);
	boolean update(Orders orders);
	
	boolean delete(int  id);
	List<Orders> getAllOrder(); 
	Orders getOrdersById(int id);
	int addOrder(Orders orders);
	public List<Orders> getAllOrder(int start, int end);
	List<Orders> getAllOrderByIdUser(int idUser); 
	List<Orders> getAllOrderByIdUser(int idUser,int start, int end); 
	
	List<Orders> getAllOrderByStatus(int status); 
	List<Orders> getAllOrderByStatusPagi(int status,int start,int end); 
	boolean checkOrderIdAddress(int idAddress);

}
