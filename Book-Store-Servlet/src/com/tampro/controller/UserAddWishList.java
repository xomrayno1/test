package com.tampro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tampro.model.Books;
import com.tampro.model.Users;
import com.tampro.model.WishList;
import com.tampro.service.BookService;
import com.tampro.service.WishListService;
import com.tampro.service.impl.BookServiceImpl;
import com.tampro.service.impl.WishListServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADD_WISH_LIST)
public class UserAddWishList extends HttpServlet{

	WishListService wishService = new WishListServiceImpl();
	BookService booksService = new BookServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int id = Integer.parseInt(request.getParameter("id"));
		WishList wishList = new WishList();
		Books book = booksService.getBookById(id);
		wishList.setBooks(book);
		wishList.setUsers(users);
		boolean flag = wishService.addWishList(wishList);
		response.sendRedirect(request.getContextPath() + PathRequest.WISH_LIST);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
