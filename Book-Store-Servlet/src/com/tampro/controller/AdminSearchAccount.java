package com.tampro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Orders;
import com.tampro.model.Users;
import com.tampro.service.OrdersService;
import com.tampro.service.UserService;
import com.tampro.service.impl.OrdersServiceImpl;
import com.tampro.service.impl.UserServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.SEARCH_ACCOUNT_ADMIN)
public class AdminSearchAccount  extends HttpServlet{
	
	UserService userService = new UserServiceImpl();
	private static final int LIMIT = 5;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = request.getParameter("search");
		String role = request.getParameter("role");
		
		

		int pageCurrent = 1;
		if(request.getParameter("page") != null) {
			pageCurrent = Integer.parseInt(request.getParameter("page"));
		}
		int start = LIMIT * (pageCurrent - 1);
		int end =  LIMIT * pageCurrent;						
		List<Users> listUser = userService.getAllUsersBySearch(search, role);
		List<Users> listUserPagi = userService.getAllUsersBySearchPagi(search, role, start, end);
		request.setAttribute("listBook", listUserPagi);
		request.setAttribute("pageCurrent", pageCurrent);
		int soPage = 0;
		if(listUser != null) {
			if(listUser.size() % LIMIT == 0) {
				soPage = listUser.size() / LIMIT;
			}else {
				soPage = (listUser.size() / LIMIT) + 1;
			}
		}
		
		request.setAttribute("listUser", listUserPagi);
		request.setAttribute("soPage", soPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/admin/searchaccount.jsp");
		dispatcher.forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
	
	

}
