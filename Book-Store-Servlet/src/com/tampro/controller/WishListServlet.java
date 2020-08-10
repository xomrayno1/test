package com.tampro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tampro.model.Users;
import com.tampro.model.WishList;
import com.tampro.service.AuthorService;
import com.tampro.service.WishListService;
import com.tampro.service.impl.AuthorServiceImpl;
import com.tampro.service.impl.WishListServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.WISH_LIST)
public class WishListServlet extends HttpServlet {

	private static final int LIMIT = 6;

	WishListService wishListService = new WishListServiceImpl();
	AuthorService authorService = new AuthorServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");

		int pageCurrent = 0 ;

		if(request.getParameter("page") == null) {
			pageCurrent = 1;		
		}else {
			pageCurrent = Integer.parseInt(request.getParameter("page"));
		}
		int start = LIMIT * (pageCurrent -1);
		int end = LIMIT * pageCurrent;
		List<WishList> allWishList = wishListService.getWishListByIdUsers(users.getId());
		List<WishList> wishList = wishListService.getWishListByIdUsersPagination(users.getId(),start,end);
		int soPage = 0;
		if(allWishList.size() % LIMIT == 0 ) {
			soPage = allWishList.size() / LIMIT;
		}else{
			soPage = (allWishList.size() / LIMIT) + 1;
		}
		
		request.setAttribute("listWishList", wishList);
		request.setAttribute("pageCurrent", pageCurrent);
		request.setAttribute("soPage", soPage);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/user/wishlist.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
