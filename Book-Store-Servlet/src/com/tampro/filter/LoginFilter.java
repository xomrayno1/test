package com.tampro.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tampro.model.Users;
import com.tampro.service.UserService;
import com.tampro.service.impl.UserServiceImpl;
import com.tampro.utils.PathRequest;

public class LoginFilter implements Filter {

	UserService userService = new UserServiceImpl();
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		Object object = (Object) session.getAttribute("users");
		Users user = (Users) object;
		if(user != null) {
			if(user.getRole().equalsIgnoreCase("ROLE_USER")) {
				response.sendRedirect(request.getContextPath()+"/home");
			}else {
				response.sendRedirect(request.getContextPath()+PathRequest.HOME_ADMIN);
			}
		}else {
			chain.doFilter(req, res);
		}
		
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
