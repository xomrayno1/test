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
import com.tampro.service.CartItemService;
import com.tampro.service.OrdersService;
import com.tampro.service.impl.CartItemServiceImpl;
import com.tampro.service.impl.OrdersServiceImpl;
import com.tampro.utils.FormatUtils;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADMIN_ORDER_SEARCH)
public class AdminSearchOrder  extends HttpServlet{
	
	CartItemService cartItemService = new CartItemServiceImpl();
	OrdersService orderService = new OrdersServiceImpl();
	private static final int LIMIT = 5;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int status = Integer.parseInt(request.getParameter("status"));
		

		int pageCurrent = 1;
		if(request.getParameter("page") != null) {
			pageCurrent = Integer.parseInt(request.getParameter("page"));
		}
		int start = LIMIT * (pageCurrent - 1);
		int end =  LIMIT * pageCurrent;						
		List<Orders> listOrder = orderService.getAllOrderByStatus(status);
		List<Orders> listOrderPagi = orderService.getAllOrderByStatusPagi(status, start, end);
		
		int soPage = 0;
		if(listOrder.size() % LIMIT == 0) {
			soPage = listOrder.size() / LIMIT;
		}else {
			soPage = (listOrder.size() / LIMIT)+1;
		}
		request.setAttribute("listOrderPagi", listOrderPagi);
		request.setAttribute("pageCurrent", pageCurrent);
		request.setAttribute("soPage", soPage);
		request.setAttribute("status", FormatUtils.getDisplayStatus(status));
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/admin/searchorder.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

