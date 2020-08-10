package com.tampro.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Books;
import com.tampro.model.Category;
import com.tampro.service.BookService;
import com.tampro.service.CategoryService;
import com.tampro.service.WishListService;
import com.tampro.service.impl.BookServiceImpl;
import com.tampro.service.impl.CategoryServiceImpl;
import com.tampro.service.impl.WishListServiceImpl;

public class CategoryFilter  implements Filter{
	CategoryService categoryService = new CategoryServiceImpl();
	WishListService wishListService = new WishListServiceImpl();
	BookService  bookService = new  BookServiceImpl();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest ar1, ServletResponse ar2, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) ar1;
		HttpServletResponse response = (HttpServletResponse) ar2;
		List<Category> category = categoryService.getAllCategory();
		request.setAttribute("listcategory", category);

		
//		List<Books> listBooksViewed  =  new ArrayList<Books>();
//		Cookie[] cookie = request.getCookies();
//		if(cookie != null) {
//			for(int i = cookie.length - 1 ; i >= 1 ; i--) {
//				Books books = bookService.getBookById(Integer.parseInt(cookie[i].getValue()));
//				listBooksViewed.add(books);
//			}
//			
//			request.setAttribute("listBooksViewed", listBooksViewed);
//		}

		chain.doFilter(request, response);
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
