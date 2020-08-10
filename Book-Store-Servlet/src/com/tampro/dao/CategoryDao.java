package com.tampro.dao;

import java.util.List;

import com.tampro.model.Category;

public interface CategoryDao {
	
	Category getCategoryById(int id);
	Category getCategoryByIdProduct(int idProduct);
	List<Category> getAllCategory();
	List<Category> getAllCategory(int start , int end);
	boolean deletCategoryById(int id);
	boolean updateCategory(Category category);
	boolean addCategory(Category category);

}
