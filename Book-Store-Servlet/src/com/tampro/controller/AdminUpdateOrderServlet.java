package com.tampro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Orders;
import com.tampro.service.OrdersService;
import com.tampro.service.impl.OrdersServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADMIN_UPDATE_ORDER)
public class AdminUpdateOrderServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OrdersService orderService = new OrdersServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int status = Integer.parseInt(req.getParameter("status"));
		Orders orders = orderService.getOrdersById(id);
		orders.setStatus(status);
		orderService.update(orders);
		resp.sendRedirect(req.getContextPath() + PathRequest.ORDER_ADMIN);
	}
}
