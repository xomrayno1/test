package com.tampro.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tampro.model.Orders;
import com.tampro.service.OrdersService;
import com.tampro.service.impl.OrdersServiceImpl;

@WebServlet("/admin/order/api")	
public class OrderAPI  extends HttpServlet{

	OrdersService orderService = new OrdersServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		int id = Integer.parseInt(req.getParameter("id"));
		Orders orders =  orderService.getOrdersById(id);
		PrintWriter writer =    response.getWriter();
		Gson gson = new Gson();
	
		writer.print(gson.toJson(orders));
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		super.doGet(req, resp);
	};
}
