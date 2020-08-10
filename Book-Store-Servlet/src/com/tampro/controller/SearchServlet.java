package com.tampro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Books;
import com.tampro.service.BookService;
import com.tampro.service.impl.BookServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.SEARCH)
public class SearchServlet  extends HttpServlet{
	static final int LIMIT = 12;
	BookService booksService  = new BookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = req.getParameter("search");
		int page ;
		if(req.getParameter("page") == null) {
			page = 1;
		}else {
			page = Integer.parseInt(req.getParameter("page"));
		}
		int start = LIMIT * (page -1 );
		int end = LIMIT * page;
		
		List<Books> lists = booksService.getAllBookBySearchPagination(search, start, end);
		List<Books> listBooks = booksService.getAllBookBySearch(search);
		int soPage = 0;
		if(listBooks.size() % 12  != 0) {
			soPage = (listBooks.size() / 12) + 1;
		}else{
			soPage  = listBooks.size() / 12;
		}
		req.setAttribute("soPage", soPage);
		req.setAttribute("listP", lists);
		System.out.println("đã chạy");
		req.setAttribute("pageCurrent", page);
		RequestDispatcher dispatcher = req.getRequestDispatcher("giaodien/searchproduct.jsp");
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
