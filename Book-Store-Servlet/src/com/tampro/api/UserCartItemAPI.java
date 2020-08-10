package com.tampro.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tampro.model.CartItem;
import com.tampro.service.CartItemService;
import com.tampro.service.impl.CartItemServiceImpl;

@WebServlet("/user/api/cartitem")
public class UserCartItemAPI  extends HttpServlet{
	CartItemService  cartItemService = new CartItemServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {	
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		
		int id = Integer.parseInt(req.getParameter("idOrder"));
		
		List<CartItem> listCartItem = cartItemService.getAllCartItemByIdOrder(id);
		listCartItem.forEach(item->{
			item.getBooks().setAuthor(null);
			item.getBooks().setComments(null);
			item.getBooks().setPublication_date(null);
			item.getBooks().setImages(null);
			item.getBooks().setISBN(null);
			item.getBooks().setCreate_Date(null);
		});
		PrintWriter writer = response.getWriter();
		
		Gson gson = new Gson();
		
		writer.print(gson.toJson(listCartItem));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}


}
