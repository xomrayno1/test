package com.tampro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tampro.model.CartItem;
import com.tampro.model.Orders;
import com.tampro.model.Users;
import com.tampro.service.CartItemService;
import com.tampro.service.OrdersService;
import com.tampro.service.impl.CartItemServiceImpl;
import com.tampro.service.impl.OrdersServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADD_ORDER)
public class AddOrderServlet  extends HttpServlet{
	
	CartItemService cartItemService = new CartItemServiceImpl();
	OrdersService orderService = new OrdersServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session  = req.getSession();
		List<CartItem> listCartItems =  (List<CartItem>) session.getAttribute("listCartItems");
		Users user = (Users) session.getAttribute("users");
		
		int idAddress = Integer.parseInt(req.getParameter("address"));
		
		Orders orders = new Orders();
		orders.setUsers(user);
		orders.setIdAddress(idAddress);
		int totalPrice = 0 ;
		orders.setListCartItem(listCartItems);
		for(CartItem  item : listCartItems) {
			totalPrice += item.getTotal_Price();
			orders.setTotalPrice(totalPrice);
		}
		int id = orderService.addOrder(orders);
		
		listCartItems.forEach(item->{
			item.setOrder_Id(id);
			cartItemService.add(item);
		});
		session.removeAttribute("listCartItems");		
		resp.sendRedirect(req.getContextPath() + PathRequest.CART_ITEM);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
