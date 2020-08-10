package com.tampro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Books;
import com.tampro.service.BookService;
import com.tampro.service.CategoryService;
import com.tampro.service.impl.BookServiceImpl;
import com.tampro.service.impl.CategoryServiceImpl;
import com.tampro.utils.PathRequest;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {PathRequest.HOME})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static CategoryService categoryService = new CategoryServiceImpl();
	static BookService bookService = new BookServiceImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		List<Books> listBooks = bookService.getAllBooksNews();
		request.setAttribute("listP", listBooks);
		
//		List<Books> listBooksViewed  =  new ArrayList<Books>();
//		Cookie[] cookie = request.getCookies();
//		for(int i = cookie.length - 1 ; i >= 1 ; i--) {
//			Books books = bookService.getBookById(Integer.parseInt(cookie[i].getValue()));
//			listBooksViewed.add(books);
//		}
//		
//		request.setAttribute("listBooksViewed", listBooksViewed);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("giaodien/index.jsp");
		dispatcher.forward(request, response);
		
	}

//	public static void main(String[] args) {
//		System.out.println();
//		for(Category category : categoryService.getAllCategory()) {
//			System.out.println(category.getDescription());
//			
//		}
//	}
	

}
