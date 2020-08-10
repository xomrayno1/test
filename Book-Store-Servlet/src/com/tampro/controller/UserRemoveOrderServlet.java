package com.tampro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.service.CartItemService;
import com.tampro.service.OrdersService;
import com.tampro.service.impl.CartItemServiceImpl;
import com.tampro.service.impl.OrdersServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.USER_REMOVE_ORDER)
public class UserRemoveOrderServlet  extends HttpServlet{
	OrdersService orderService = new OrdersServiceImpl();
	CartItemService cartItemService = new CartItemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		
		cartItemService.deleteByIdOrder(id);
		orderService.delete(id);
		resp.sendRedirect(req.getContextPath() + PathRequest.USER_ORDER);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
