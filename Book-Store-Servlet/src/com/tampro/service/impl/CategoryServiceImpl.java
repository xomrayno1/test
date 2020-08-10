package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.CategoryDao;
import com.tampro.dao.impl.CategoryDaoImpl;
import com.tampro.model.Category;
import com.tampro.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryById(id);
	}

	@Override
	public Category getCategoryByIdProduct(int idProduct) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryByIdProduct(idProduct);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategory();
	}

	@Override
	public boolean deletCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.deletCategoryById(id);
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.updateCategory(category);
	}

	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.addCategory(category);
	}

	@Override
	public List<Category> getAllCategory(int start, int end) {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategory(start, end);
	}

	

}
