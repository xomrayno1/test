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
import com.tampro.model.Users;
import com.tampro.service.AddressService;
import com.tampro.service.OrdersService;
import com.tampro.service.impl.AddressServiceImpl;
import com.tampro.service.impl.OrdersServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADDRESS_REMOVE)
public class UserRemoveAddressServlet extends HttpServlet {
	
	/**
	 * 
	 */
	AddressService addressService = new AddressServiceImpl();
	OrdersService ordersService = new OrdersServiceImpl();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		boolean check = ordersService.checkOrderIdAddress(id);
		if(!check) {
			addressService.deleteAddress(id);
		}else {
			request.setAttribute("error", "Địa chỉ này bạn đã sử dụng để đặt hàng nên không thể xóa");
		}
		//response.sendRedirect(request.getContextPath() + PathRequest.ADDRESS_USER);
		
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("users");
		List<Address> listAddress = addressService.getAddressByIdUser(user.getId());
		
		request.setAttribute("listAddress", listAddress);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/user/address.jsp");
				dispatcher.forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		addressService.deleteAddress(id);	
		response.sendRedirect(request.getContextPath() + PathRequest.SHIPPING);
	}
	

}
