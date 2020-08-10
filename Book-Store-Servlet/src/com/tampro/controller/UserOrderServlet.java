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

import com.tampro.model.Orders;
import com.tampro.model.Users;
import com.tampro.service.OrdersService;
import com.tampro.service.impl.OrdersServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.USER_ORDER)
public class UserOrderServlet extends HttpServlet{
	
	OrdersService orderService = new OrdersServiceImpl();
	private static final int LIMIT = 5;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		
		int pageCurrent = 1;
		if(request.getParameter("page") != null) {
			pageCurrent = Integer.parseInt(request.getParameter("page"));
		}
		int start = LIMIT * (pageCurrent - 1);
		int end =  LIMIT * pageCurrent;						
		List<Orders> listOrder = orderService.getAllOrderByIdUser(users.getId());
		List<Orders> listOrderPagi = orderService.getAllOrderByIdUser(users.getId(),start,end);
		
		int soPage = 0;
		if(listOrder.size() % LIMIT == 0) {
			soPage = listOrder.size() / LIMIT;
		}else {
			soPage = (listOrder.size() / LIMIT)+1;
		}
		request.setAttribute("listOrderPagi", listOrderPagi);
		request.setAttribute("pageCurrent", pageCurrent);
		request.setAttribute("soPage", soPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/user/order.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
