package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.BookDao;
import com.tampro.dao.impl.BookDaoImpl;
import com.tampro.model.Books;
import com.tampro.service.BookService;

public class BookServiceImpl  implements BookService{
	
	BookDao bookDao = new BookDaoImpl();

	@Override
	public Books getBookById(int id) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(id);
	}

	@Override
	public Books getBookByIdBook(int idBook) {
		// TODO Auto-generated method stub
		return bookDao.getBookByIdBook(idBook);
	}

	@Override
	public List<Books> getAllBook() {
		// TODO Auto-generated method stub
		return bookDao.getAllBook();
	}

	@Override
	public List<Books> getAllBookByIdCategory(int idCategory) {
		// TODO Auto-generated method stub
		return bookDao.getAllBookByIdCategory(idCategory);
	}

	@Override
	public boolean deletBookById(int id) {
		// TODO Auto-generated method stub
		return bookDao.deletBookById(id);
	}

	@Override
	public boolean updateBook(Books book) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(book);
	}

	@Override
	public boolean addBook(Books book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}

	@Override
	public List<Books> getAllBooksNews() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooksNews();
	}

	@Override
	public List<Books> getAllBookByIdCategoryPagination(int idCategory, int start, int end) {
		// TODO Auto-generated method stub
		return bookDao.getAllBookByIdCategoryPagination(idCategory, start, end);
	}

	@Override
	public List<Books> getAllBookBySearch(String name) {
		// TODO Auto-generated method stub
		return bookDao.getAllBookBySearch(name);
	}

	@Override
	public List<Books> getAllBookBySearchPagination(String name, int start, int end) {
		// TODO Auto-generated method stub
		return bookDao.getAllBookBySearch(name);
	}

	@Override
	public List<Books> getAllBook(int start, int end) {
		// TODO Auto-generated method stub
		return bookDao.getAllBook(start, end);
	}

	@Override
	public List<Books> getAllBookAdminSearchPagi(String name, int category, String dateTo, String dateFrom, int start,
			int end) {
		// TODO Auto-generated method stub
		return bookDao.getAllBookAdminSearchPagi(name, category, dateTo, dateFrom, start, end);
	}

	@Override
	public List<Books> getAllBookAdminSearch(String name, int category, String dateTo, String dateFrom) {
		// TODO Auto-generated method stub
		return bookDao.getAllBookAdminSearch(name, category, dateTo, dateFrom);
	}


}
