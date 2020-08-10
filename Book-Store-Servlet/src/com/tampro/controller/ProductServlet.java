package com.tampro.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Books;
import com.tampro.service.BookService;
import com.tampro.service.impl.BookServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.CATEGORY)
public class ProductServlet extends HttpServlet{
	
	BookService booksService = new BookServiceImpl();
	static final int LIMIT = 12;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idCategory = Integer.parseInt(req.getParameter("id"));
		int page = 0;
		if(req.getParameter("page") == null) {
			page = 1;
		}else {
			page = Integer.parseInt(req.getParameter("page"));
		}
		int start = LIMIT * (page -1 );
		int end = LIMIT * page;
		
		List<Books> lists = booksService.getAllBookByIdCategoryPagination(idCategory, start, end);
		List<Books> listBooksCategory = booksService.getAllBookByIdCategory(idCategory);
		int soPage = 0;
		if(listBooksCategory.size() % 12  != 0) {
			soPage = (listBooksCategory.size() / 12) + 1;
		}else{
			soPage  = listBooksCategory.size() / 12;
		}
		req.setAttribute("soPage", soPage);
		req.setAttribute("pageCurrent", page);
		req.setAttribute("listP", lists);

		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("giaodien/product.jsp");
		dispatcher.forward(req, resp);
	}

	
	
	
}
