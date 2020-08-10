package com.tampro.dao;

import java.util.List;

import com.tampro.model.Books;

public interface BookDao {
	
	Books getBookById(int id);
	Books getBookByIdBook(int idBook);
	List<Books> getAllBook();
	List<Books> getAllBookByIdCategory(int idCategory);
	boolean deletBookById(int id);
	boolean updateBook(Books book);
	boolean addBook(Books book);
	List<Books> getAllBooksNews();
	List<Books> getAllBookByIdCategoryPagination(int idCategory,int start, int end);
	List<Books> getAllBookBySearch(String name);
	List<Books> getAllBookBySearchPagination(String name,int start, int end);
	List<Books> getAllBook(int start , int end);
	
	List<Books> getAllBookAdminSearchPagi(String name,int category, String dateTo,String dateFrom ,int start, int end);
	List<Books> getAllBookAdminSearch(String name,int category, String dateTo,String dateFrom );
}
