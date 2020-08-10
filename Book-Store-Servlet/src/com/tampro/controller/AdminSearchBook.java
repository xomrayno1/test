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

@WebServlet(PathRequest.ADMIN_BOOK_SEARCH)
public class AdminSearchBook  extends HttpServlet{
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
		int category = Integer.parseInt(req.getParameter("category"));
		String dateTo = req.getParameter("dateTo");
		String dateFrom = req.getParameter("dateFrom");
		List<Books> listBookPagi = bookService.getAllBookAdminSearchPagi(name, category, dateTo, dateFrom, start, end);
		List<Books> listBook = bookService.getAllBookAdminSearch(name, category, dateTo, dateFrom);
		req.setAttribute("listBook", listBookPagi);
		req.setAttribute("pageCurrent", pageCurrent);
		int soPage = 0;
		if(listBook != null) {
			if(listBook.size() % LIMIT == 0) {
				soPage = listBook.size() / LIMIT;
			}else {
				soPage = (listBook.size() / LIMIT) + 1;
			}	
		}
		req.setAttribute("soPage", soPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/giaodien/admin/searchbook.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
