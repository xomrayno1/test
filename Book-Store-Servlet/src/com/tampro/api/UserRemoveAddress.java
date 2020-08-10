package com.tampro.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tampro.service.AddressService;
import com.tampro.service.impl.AddressServiceImpl;
@WebServlet("/user/api/address/remove")
public class UserRemoveAddress  extends HttpServlet{
	
	AddressService addressService = new AddressServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		PrintWriter writer = response.getWriter();
		
		Gson gson = new Gson();
		
		int id = Integer.parseInt(req.getParameter("id"));
		boolean check = addressService.deleteAddress(id);
		writer.print(gson.toJson(check));
	}
}
