package com.tampro.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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

/**
 * Servlet implementation class ManageAccountServlet
 */
@WebServlet(PathRequest.ACCOUNT_ADMIN)
public class ManageAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		UserService userService = new UserServiceImpl();
       private static final int LIMIT = 10;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		int pageCurrent = 1;
		if(request.getParameter("page") != null) {
			pageCurrent = Integer.parseInt(request.getParameter("page"));
		}
		int start = LIMIT * (pageCurrent - 1);
		int end =  LIMIT * pageCurrent;						
		List<Users> listUserPagi = userService.getAllUsers(start,end);
		List<Users> listUser = userService.getAllUsers();
		request.setAttribute("listBook", listUserPagi);
		request.setAttribute("pageCurrent", pageCurrent);
		int soPage = 0;
		if(listUser.size() % LIMIT == 0) {
			soPage = listUser.size() / LIMIT;
		}else {
			soPage = (listUser.size() / LIMIT)+1;
		}
		
		request.setAttribute("listUser", listUserPagi);
		request.setAttribute("soPage", soPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/admin/account.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("create")) {
			System.out.println(action);
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String role = request.getParameter("role");
			Users users = new Users(username,password,name,phone,email);
			users.setRole(role);
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
			//userService.addUser(users);
			
		}else {
			
			System.out.println(action);
			
			int id = Integer.parseInt(request.getParameter("iduser"));
			Users users = userService.getUserById(id);
			users.setPassWord(request.getParameter("password"));
			users.setName(request.getParameter("name"));
			users.setPhone(request.getParameter("phone"));
			users.setRole(request.getParameter("role"));
			users.setStatus(Integer.parseInt(request.getParameter("status")));
			users.setModify_Date(Date.valueOf(LocalDate.now()));		
			userService.updateUser(users);
			request.setAttribute("error", "Sửa thành công");
			
		}
		
		doGet(request, response);
		
		//request.getRequestDispatcher("/giaodien/admin/account.jsp").forward(request, response);
		
	}

}
