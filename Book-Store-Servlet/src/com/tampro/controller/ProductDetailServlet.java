package com.tampro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Books;
import com.tampro.model.Category;
import com.tampro.service.AuthorService;
import com.tampro.service.BookService;
import com.tampro.service.CategoryService;
import com.tampro.service.impl.AuthorServiceImpl;
import com.tampro.service.impl.BookServiceImpl;
import com.tampro.service.impl.CategoryServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.PRODUCT_DETAIL)
public class ProductDetailServlet extends HttpServlet {

	
	BookService bookService = new BookServiceImpl();
	AuthorService authorService = new AuthorServiceImpl();
	CategoryService cateogoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		Books book = bookService.getBookById(id);
		req.setAttribute("book", book);

		Category category = cateogoryService.getCategoryById(book.getCategory_Id());
		
		req.setAttribute("category", category);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("giaodien/productdetail.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
