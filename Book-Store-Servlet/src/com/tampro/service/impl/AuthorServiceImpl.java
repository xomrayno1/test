package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.AuthorDao;
import com.tampro.dao.impl.AuthorDaoImpl;
import com.tampro.service.AuthorService;
import com.tampro.model.Authors;


public class AuthorServiceImpl implements AuthorService {
	
	AuthorDao authorDao = new AuthorDaoImpl();

	@Override
	public Authors getAuthorsById(int id) {
		// TODO Auto-generated method stub
		return authorDao.getAuthorsById(id);
	}

	@Override
	public List<Authors> getAllAuthors() {
		// TODO Auto-generated method stub
		return authorDao.getAllAuthors();
	}

	@Override
	public boolean deleteAuthorsById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAuthors(Authors authors) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAuthors(Authors authors) {
		// TODO Auto-generated method stub
		return authorDao.addAuthors(authors);
	}
	
 
}
