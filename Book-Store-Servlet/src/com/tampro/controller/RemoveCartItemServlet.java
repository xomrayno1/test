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
import com.tampro.service.BookService;
import com.tampro.service.impl.BookServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.REMOVE_CART_ITEM)
public class RemoveCartItemServlet  extends HttpServlet{

	BookService booksService = new BookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		HttpSession session = req.getSession();
		
		List<CartItem>  listCartItem = (List<CartItem>) session.getAttribute("listCartItems");
		if(listCartItem != null) {
			for(CartItem items : listCartItem) {
				if(items.getBooks().getId() == id) {
					listCartItem.remove(items);
					break;
				}
			}
		}
		if(listCartItem.isEmpty()) {
			session.removeAttribute("listCartItems");
		}else {
			session.setAttribute("listCartItems", listCartItem);
		}
		
		
		resp.sendRedirect(req.getContextPath() + PathRequest.CART_ITEM);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
