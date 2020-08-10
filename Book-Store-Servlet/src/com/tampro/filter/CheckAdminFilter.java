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
import com.tampro.utils.PathRequest;

public class CheckAdminFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {


		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		if(users == null) {
			response.sendRedirect(request.getContextPath()+PathRequest.LOGIN);
		}else {
			if(users.getRole().equals("ROLE_USER")) {
				response.sendRedirect(request.getContextPath()+PathRequest.HOME);
			}else {
				chain.doFilter(arg0, arg1);
			}	
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
