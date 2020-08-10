package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tampro.dao.BookDao;
import com.tampro.dao.RootDao;
import com.tampro.dao.UsersDao;
import com.tampro.dao.WishListDao;
import com.tampro.model.Books;
import com.tampro.model.Users;
import com.tampro.model.WishList;

public class WishListDaoImpl  extends RootDao implements WishListDao{
	
	BookDao bookDao = new BookDaoImpl();
	UsersDao userDao = new UsersDaoImpl();

	@Override
	public List<WishList> getWishListByIdUsers(int idUsers) {
		String sql = "select * from wishlist where users_id = ? ";
		PreparedStatement statement = null;
		Connection  connection = null;
				
		try {
			connection = RootDao.getConnection();
			 statement = connection.prepareStatement(sql);
			statement.setInt(1, idUsers);
			ResultSet set = statement.executeQuery();
			List<WishList> list = new ArrayList<WishList>();
			while(set.next()) {
				WishList wishList = new WishList();
				int user_id = set.getInt("users_id");
				int book_id = set.getInt("books_id");
				Books books = bookDao.getBookById(book_id);
				Users user = userDao.getUserById(user_id);
				wishList.setBooks(books);
				wishList.setUsers(user);
				list.add(wishList);
			}
			return list;
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
	public boolean deleteWishListByIdBookAndUsersId(int idBooks, int idUser) {
		String sql = "delete from wishlist where users_id = ? and books_id = ?";
		PreparedStatement statement = null;
		Connection  connection = null;
		try {
			connection = RootDao.getConnection();
			 statement = connection.prepareStatement(sql);
			statement.setInt(1, idUser);
			statement.setInt(2, idBooks);
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
	public boolean updateWishList(WishList wishList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WishList getWishListByIdBookAndUsersId(int idBooks, int idUser) {
		String sql = "select * from wishlist where books_id = ?  and users_id = ? ";
		PreparedStatement statement = null;
		Connection  connection = null;
				
		try {
			connection = RootDao.getConnection();
			 statement = connection.prepareStatement(sql);
			statement.setInt(1, idBooks);
			statement.setInt(2, idUser);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				WishList wishList = new WishList();
				int user_id = set.getInt("users_id");
				int book_id = set.getInt("books_id");
				Books books = bookDao.getBookById(book_id);
				Users user = userDao.getUserById(user_id);
				wishList.setBooks(books);
				wishList.setUsers(user);
				return wishList;
			}
			
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
	public void addWishList(WishList wishList) {
		String sql = "insert into wishlist(users_id,books_id) values(?,?)  ";
		PreparedStatement statement = null;
		Connection  connection = null;
		try {
			connection = RootDao.getConnection();
			 statement = connection.prepareStatement(sql);
			statement.setInt(1, wishList.getUsers().getId());
			statement.setInt(2, wishList.getBooks().getId());
			statement.executeUpdate();
			
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
		
		
	}

	@Override
	public List<WishList> getWishListByIdUsersPagination(int idUsers, int start, int end) {
		String sql = "SELECT * FROM `wishlist` WHERE `users_id` = ? ORDER BY `books_id` DESC limit ?, ?";
		PreparedStatement statement = null;
		Connection  connection = null;
				
		try {
			connection = RootDao.getConnection();
			 statement = connection.prepareStatement(sql);
			statement.setInt(1, idUsers);
			statement.setInt(2, start);
			statement.setInt(3, end);
			ResultSet set = statement.executeQuery();
			List<WishList> list = new ArrayList<WishList>();
			while(set.next()) {
				WishList wishList = new WishList();
				int user_id = set.getInt("users_id");
				int book_id = set.getInt("books_id");
				Books books = bookDao.getBookById(book_id);
				Users user = userDao.getUserById(user_id);
				wishList.setBooks(books);
				wishList.setUsers(user);
				list.add(wishList);
			}
			return list;
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

}
