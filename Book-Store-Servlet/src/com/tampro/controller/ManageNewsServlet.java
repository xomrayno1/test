package com.tampro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.News;
import com.tampro.service.NewsService;
import com.tampro.service.impl.NewsServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.NEWS_ADMIN)
public class ManageNewsServlet  extends HttpServlet{
	
	NewsService newService = new NewsServiceImpl();
	
	private static final int LIMIT = 5;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageCurrent = 1;
		if(request.getParameter("page") != null) {
			pageCurrent = Integer.parseInt(request.getParameter("page"));
		}
		int start = LIMIT * (pageCurrent - 1);
		int end =  LIMIT * pageCurrent;						
		List<News> listNews = newService.getAll();
		List<News> listNewsPagi = newService.getAll(start, end);
		
		int soPage = 0;
		if(listNews.size() % LIMIT == 0) {
			soPage = listNews.size() / LIMIT;
		}else {
			soPage = (listNews.size() / LIMIT ) + 1;
		}
		request.setAttribute("listNewsPagi", listNewsPagi);
		request.setAttribute("pageCurrent", pageCurrent);
		request.setAttribute("soPage", soPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/admin/news.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
