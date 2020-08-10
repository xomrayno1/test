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

import com.tampro.model.Address;
import com.tampro.model.CartItem;
import com.tampro.service.AddressService;
import com.tampro.service.impl.AddressServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.PAYMENT)
public class UserPaymentServlet extends HttpServlet {
	
	AddressService addressService = new AddressServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		List<CartItem> listCartItem = (List<CartItem>) session.getAttribute("listCartItems");		
		request.setAttribute("listGioHang", listCartItem);
		Address address =  addressService.getAddressById(id);
		request.setAttribute("address", address);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/user/payment.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
