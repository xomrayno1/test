package com.tampro.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

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
import com.tampro.utils.FormatUtils;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.EDIT_USER)
public class UserEditServlet extends HttpServlet {

	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		request.setAttribute("user", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/user/edit.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String passwordOld = request.getParameter("passwordold");
		String passwordNew = request.getParameter("passwordnew");
		String passwordRepeat = request.getParameter("passwordrepeat");
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");

		try {
			if (request.getParameter("checkb") == null) {
				if(FormatUtils.formatEditUserPart(name, phone, email)) {
					users.setName(name);
					users.setPhone(phone);
					users.setEmail(email);
					users.setModify_Date(Date.valueOf(LocalDate.now()));
					userService.updateUser(users);
				}else {
					System.out.println("Dữ liệu part format false");
				}
			} else {
				if (FormatUtils.formatEditUserFull(name, phone, email, passwordOld, passwordNew, passwordRepeat)) {
					if (users.getPassWord().equals(passwordOld)) {
						if (passwordNew.equals(passwordRepeat)) {
							users.setName(name);
							users.setPhone(phone);
							users.setEmail(email);
							users.setModify_Date(Date.valueOf(LocalDate.now()));
							users.setPassWord(passwordNew);
							userService.updateUser(users);
							request.setAttribute("error", "Cập nhật thành công !");
						} else {
							System.out.println("Mật khẩu nhập lại không đúng ");							
						}
					} else {
						System.out.println("Mật khẩu cũ không đúng ");
						request.setAttribute("error", "Mật khẩu cũ không đúng !");
					}
				}else {
					System.out.println("Dữ liệu full format false");
				}
			}
		}catch (Exception e) {
			request.setAttribute("error", "Thêm thất bại");
		}
		request.setAttribute("user", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/user/edit.jsp");
		dispatcher.forward(request, response);

	}
}
