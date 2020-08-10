package com.tampro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Category;
import com.tampro.model.Users;
import com.tampro.service.CategoryService;
import com.tampro.service.impl.CategoryServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.CATEGORY_ADMIN)
public class ManageCategoryServlet  extends HttpServlet{
	
	CategoryService categoryService = new  CategoryServiceImpl();
	private static final int LIMIT = 5;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int pageCurrent = 1;
		if(request.getParameter("page") != null) {
			pageCurrent = Integer.parseInt(request.getParameter("page"));
		}
		int start = LIMIT * (pageCurrent - 1);
		int end =  LIMIT * pageCurrent;						
		List<Category> listCategory = categoryService.getAllCategory();
		List<Category> listCategoryPagi = categoryService.getAllCategory(start,end);
		
		int soPage = 0;
		if(listCategory.size() % LIMIT == 0) {
			soPage = listCategory.size() / LIMIT;
		}else {
			soPage = (listCategory.size() / LIMIT)+1;
		}
		request.setAttribute("listCategory", listCategoryPagi);
		request.setAttribute("pageCurrent", pageCurrent);
		request.setAttribute("soPage", soPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/admin/category.jsp");
		dispatcher.forward(request, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
