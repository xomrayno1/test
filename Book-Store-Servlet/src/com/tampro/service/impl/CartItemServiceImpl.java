package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.CartItemDao;
import com.tampro.dao.impl.CartItemDaoImpl;
import com.tampro.model.CartItem;
import com.tampro.service.CartItemService;

public class CartItemServiceImpl  implements CartItemService{
	
	CartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public boolean add(CartItem cartItem) {
		// TODO Auto-generated method stub
		return cartItemDao.add(cartItem);
	}

	@Override
	public boolean update(CartItem cartItem) {
		// TODO Auto-generated method stub
		return cartItemDao.update(cartItem);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return cartItemDao.delete(id);
	}

	@Override
	public List<CartItem> getAllCartItemByIdOrder(int id) {
		// TODO Auto-generated method stub
		return cartItemDao.getAllCartItemByIdOrder(id);
	}

	@Override
	public List<CartItem> getAllCartItemByIdOrderPagi(int id, int start, int end) {
		// TODO Auto-generated method stub
		return cartItemDao.getAllCartItemByIdOrderPagi(id, start, end);
	}

	@Override
	public CartItem getCartItemById(int id) {
		// TODO Auto-generated method stub
		return cartItemDao.getCartItemById(id);
	}

	@Override
	public boolean deleteByIdOrder(int id) {
		// TODO Auto-generated method stub
		return cartItemDao.deleteByIdOrder(id);
	}

}
