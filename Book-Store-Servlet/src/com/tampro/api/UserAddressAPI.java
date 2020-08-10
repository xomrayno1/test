package com.tampro.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tampro.model.Address;
import com.tampro.service.AddressService;
import com.tampro.service.impl.AddressServiceImpl;
@WebServlet("/user/api/address")
public class UserAddressAPI extends HttpServlet {
	
	AddressService addressService = new AddressServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		PrintWriter writer = response.getWriter();
		
		Gson gson = new Gson();
		
		int id = Integer.parseInt(req.getParameter("id"));
		Address address = addressService.getAddressById(id);
		writer.print(gson.toJson(address));
		
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(req,response);
	}

}
