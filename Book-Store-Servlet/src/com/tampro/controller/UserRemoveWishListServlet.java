package com.tampro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tampro.model.Users;
import com.tampro.service.WishListService;
import com.tampro.service.impl.WishListServiceImpl;
import com.tampro.utils.PathRequest;

/**
 * Servlet implementation class RemoveWishListServlet
 */
@WebServlet(PathRequest.REMOVE_WISH_LIST)
public class UserRemoveWishListServlet extends HttpServlet {
	
	
	WishListService wishListService = new WishListServiceImpl();
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  =  request.getSession();
		Users user = (Users) session.getAttribute("users");
		int id = Integer.parseInt(request.getParameter("id"));
		
		wishListService.deleteWishListByIdBookAndUsersId(id, user.getId());
		response.sendRedirect(request.getContextPath() + PathRequest.WISH_LIST);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
