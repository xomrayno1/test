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
import com.tampro.model.Users;
import com.tampro.service.AddressService;
import com.tampro.service.impl.AddressServiceImpl;
import com.tampro.utils.PathRequest;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet(PathRequest.SHIPPING)
public class UserShippingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AddressService addressService = new AddressServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		List<Address> listAddress = addressService.getAddressByIdUser(users.getId());
		request.setAttribute("listAddress",listAddress);
		List<CartItem> listCartItem = (List<CartItem>) session.getAttribute("listCartItems");		
		request.setAttribute("listGioHang", listCartItem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/user/shipping.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
