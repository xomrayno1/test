package com.tampro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tampro.model.Users;
import com.tampro.service.UserService;
import com.tampro.service.impl.UserServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.LOGIN)
public class LoginServlet extends HttpServlet{
	
	UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("giaodien/login.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Users users = userService.getUserBylogin(username, password);
		if(users != null) {
			HttpSession session = request.getSession();
			session.setAttribute("users",users);
			if(users.getRole().equals("ROLE_USER")) {
				response.sendRedirect(request.getContextPath()+"/home");
			}else {
				response.sendRedirect(request.getContextPath()+PathRequest.HOME_ADMIN);
			}
			
		}else {
			request.setAttribute("error", "Vui lòng nhập mật khẩu khác , mật khẩu của bạn sai");
			RequestDispatcher dispatcher = request.getRequestDispatcher("giaodien/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
