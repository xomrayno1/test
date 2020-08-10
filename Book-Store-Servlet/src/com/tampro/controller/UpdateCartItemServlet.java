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
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.UPDATE_CART_ITEM)
public class UpdateCartItemServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		int sl = Integer.valueOf(req.getParameter("sl"));
		HttpSession session = req.getSession();
		List<CartItem> listCartItem = (List<CartItem>) session.getAttribute("listCartItems");
		for(CartItem item : listCartItem) {
			if(item.getBooks().getId()==id) {
				item.setQuantity(sl);
				item.setTotal_Price(item.getBooks().getPrice() *  item.getQuantity());
				break;
			}
		}
	
		session.setAttribute("listCartItems", listCartItem);
		resp.sendRedirect(req.getContextPath() + PathRequest.CART_ITEM);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.sendRedirect(req.getContextPath() + PathRequest.CART_ITEM);
	}

}
