package com.tampro.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Authors;
import com.tampro.model.Books;
import com.tampro.model.Category;
import com.tampro.service.AuthorService;
import com.tampro.service.BookService;
import com.tampro.service.CategoryService;
import com.tampro.service.impl.AuthorServiceImpl;
import com.tampro.service.impl.BookServiceImpl;
import com.tampro.service.impl.CategoryServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.BOOK_ADMIN)
public class ManageBookServlet  extends HttpServlet{
	
	BookService bookService = new BookServiceImpl();
	AuthorService authorService = new AuthorServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	private static final int LIMIT = 10;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Authors> listAuthor = authorService.getAllAuthors();
		List<Category> listCategory = categoryService.getAllCategory();
		req.setAttribute("listAuthor", listAuthor);
		req.setAttribute("listCategory", listCategory);
		int pageCurrent = 1;
		if(req.getParameter("page") != null) {
			pageCurrent = Integer.parseInt(req.getParameter("page"));
		}
		int start = LIMIT * (pageCurrent - 1);
		int end =  LIMIT * pageCurrent;	
		
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		String dateTo = req.getParameter("dateTo");
		String dateFrom = req.getParameter("dateFrom");
		if(name == null && category == null && dateTo == null  && dateFrom == null ) {
			List<Books> listBookPagi = bookService.getAllBook(start,end);
			List<Books> listBook = bookService.getAllBook();
			req.setAttribute("listBook", listBookPagi);
			req.setAttribute("pageCurrent", pageCurrent);
			int soPage = 0;
			if(listBook.size() % LIMIT == 0) {
				soPage = listBook.size() / LIMIT;
			}else {
				soPage = (listBook.size() / LIMIT) + 1;
			}			
			req.setAttribute("soPage", soPage);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/giaodien/admin/books.jsp");
			dispatcher.forward(req, resp);
		}else {				
			List<Books> listBookPagi = bookService.getAllBook(start,end);
			List<Books> listBook = bookService.getAllBook();
			req.setAttribute("listBook", listBookPagi);
			req.setAttribute("pageCurrent", pageCurrent);
			int soPage = 0;
			if(listBook.size() % LIMIT == 0) {
				soPage = listBook.size() / LIMIT;
			}else {
				soPage = (listBook.size() / LIMIT) + 1;
			}			
			req.setAttribute("soPage", soPage);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/giaodien/admin/searchbook.jsp");
			dispatcher.forward(req, resp);
		}	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
