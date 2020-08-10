package com.tampro.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tampro.model.Users;
import com.tampro.service.UserService;
import com.tampro.service.impl.UserServiceImpl;


@WebServlet("/admin/user/api")
public class UserAPI extends HttpServlet{

	UserService userService = new UserServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		Users user = userService.getUserById(id);
		Gson gson = new Gson();
		PrintWriter writer = resp.getWriter();
		writer.print(gson.toJson(user));
		
	}
}
