package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tampro.dao.CategoryDao;
import com.tampro.dao.RootDao;
import com.tampro.model.Category;

public class CategoryDaoImpl extends RootDao implements CategoryDao{

	@Override
	public Category getCategoryById(int id) {
		String sql  = "select * from book_categories where  book_category_code = ? ";
		PreparedStatement statement = null;
			Connection connection =  null;	
		try {
			connection  = getConnection();
			 statement = connection.prepareStatement(sql);
			 statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("book_category_code"));
				category.setDescription(rs.getString("book_cateogry_description"));
				return category;
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
	public Category getCategoryByIdProduct(int idProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategory() {
		String sql  = "select * from book_categories";
		PreparedStatement statement = null;
			Connection connection =  null;	
		try {
			connection  = getConnection();
			 statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Category> list = new ArrayList<Category>();
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("book_category_code"));
				category.setDescription(rs.getString("book_cateogry_description"));
				list.add(category);
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
	public boolean deletCategoryById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Category> getAllCategory(int start, int end) {
		String sql  = "select * from book_categories order by  book_category_code desc limit ?,? ";
		PreparedStatement statement = null;
			Connection connection =  null;	
		try {
			connection  = getConnection();
			 statement = connection.prepareStatement(sql);
			 statement.setInt(1, start);
			 statement.setInt(2, end);
			ResultSet rs = statement.executeQuery();
			List<Category> list = new ArrayList<Category>();
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("book_category_code"));
				category.setDescription(rs.getString("book_cateogry_description"));
				list.add(category);
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
