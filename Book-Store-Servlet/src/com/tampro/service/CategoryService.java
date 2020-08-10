package com.tampro.service;

import java.util.List;

import com.tampro.model.Category;

public interface CategoryService {
	Category getCategoryById(int id);
	Category getCategoryByIdProduct(int idProduct);
	List<Category> getAllCategory();
	List<Category> getAllCategory(int start , int end);
	boolean deletCategoryById(int id);
	boolean updateCategory(Category category);
	boolean addCategory(Category category);

}
