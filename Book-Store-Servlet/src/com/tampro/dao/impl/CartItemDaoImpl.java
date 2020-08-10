package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tampro.dao.CartItemDao;
import com.tampro.dao.RootDao;
import com.tampro.model.Books;
import com.tampro.model.CartItem;
import com.tampro.model.Orders;
import com.tampro.service.BookService;
import com.tampro.service.impl.BookServiceImpl;

public class CartItemDaoImpl extends RootDao  implements CartItemDao{
	
	BookService bookService = new BookServiceImpl();

	@Override
	public boolean add(CartItem cartItem) {
		String sql = "INSERT INTO ORDER_ITEMS(order_id,product_id,quantity,total_Price) VALUES(?,?,?,?)";
		
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cartItem.getOrder_Id());
			statement.setInt(2, cartItem.getBooks().getId());
			statement.setInt(3, cartItem.getQuantity());
			statement.setInt(4, cartItem.getTotal_Price());
			statement.executeUpdate();		
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean update(CartItem cartItem) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public List<CartItem> getAllCartItemByIdOrder(int id) {
		String sql = "select * from order_items where order_id = ? ";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			List<CartItem> listCartItem = new ArrayList<CartItem>();
			while(rs.next()) {
				Books books = bookService.getBookById(rs.getInt("product_id"));
				CartItem cartItem = new CartItem();
				cartItem.setBooks(books);
				cartItem.setOrder_Id(rs.getInt("order_id"));
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setTotal_Price(rs.getInt("total_Price"));
				listCartItem.add(cartItem);
			}
			return listCartItem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public List<CartItem> getAllCartItemByIdOrderPagi(int id, int start, int end) {
		String sql = "select * from order_items where order_id = ? limit ?,?";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, start);
			statement.setInt(3, end);
			ResultSet rs = statement.executeQuery();
			List<CartItem> listCartItem = new ArrayList<CartItem>();
			while(rs.next()) {
				Books books = bookService.getBookById(rs.getInt("product_id"));
				CartItem cartItem = new CartItem();
				cartItem.setBooks(books);
				cartItem.setOrder_Id(rs.getInt("order_id"));
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setTotal_Price(rs.getInt("total_Price"));
				listCartItem.add(cartItem);
			}
			return listCartItem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public CartItem getCartItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteByIdOrder(int id) {
		String sql = "delete from order_items where order_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			

			statement.setInt(1, id);
			
			statement.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
