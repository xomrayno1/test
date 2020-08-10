package com.tampro.dao;

import java.util.List;

import com.tampro.model.CartItem;

public interface CartItemDao {
	
	
	boolean add(CartItem cartItem);
	boolean update(CartItem cartItem);
	boolean delete(int id);
	boolean deleteByIdOrder(int id);
	List<CartItem> getAllCartItemByIdOrder(int id);
	List<CartItem> getAllCartItemByIdOrderPagi(int id,int start, int end);
	CartItem getCartItemById(int id);

}
