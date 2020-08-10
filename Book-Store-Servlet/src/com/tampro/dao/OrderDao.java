package com.tampro.dao;

import java.util.List;

import com.tampro.model.Orders;

public interface OrderDao {
	
	boolean add(Orders orders);
	boolean update(Orders orders);
	boolean delete(int  id);
	List<Orders> getAllOrder(); 
	List<Orders> getAllOrderByIdUser(int idUser); 
	List<Orders> getAllOrderByIdUser(int idUser,int start, int end); 
	List<Orders> getAllOrder(int start,int end);
	List<Orders> getAllStatistical(int start, int end);
	List<Orders> getAlStatistical();
	List<Orders> getAllOrderByStatus(int status); 
	List<Orders> getAllOrderByStatusPagi(int status,int start,int end);
	Orders getOrdersById(int id);
	int addOrder(Orders orders); 
	boolean checkOrderIdAddress(int idAddress);
}
