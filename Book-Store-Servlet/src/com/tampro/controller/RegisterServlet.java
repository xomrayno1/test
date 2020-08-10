package com.tampro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Users;
import com.tampro.service.UserService;
import com.tampro.service.impl.UserServiceImpl;
import com.tampro.utils.FormatUtils;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.REGISTER)
public class RegisterServlet  extends HttpServlet{
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = req.getRequestDispatcher("giaodien/register.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		Users users = new Users(username,password,name,phone,email);
		if(FormatUtils.formatRegister(users)) { // check empty va check length
			if(userService.getUserByUsername(username) == null) {//check user
				if(userService.getUserByEmail(email)==null) {
					boolean check = userService.addUser(users);
					if(!check) {
						request.setAttribute("error", "Thêm bị lỗi");
					}else {
						request.setAttribute("error", "Thêm thành công");
					}
				}else {
					request.setAttribute("error", "Email đã tồn tại");
				}				
			}else{
				request.setAttribute("error", "Tài khoản đã tồn tại");
			}			
		}else {
			request.setAttribute("error", "Thêm bị lỗi");
		}		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("giaodien/register.jsp");
		dispatcher.forward(request, resp);
	}
}
