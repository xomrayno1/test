package com.tampro.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tampro.model.News;
import com.tampro.model.Users;
import com.tampro.service.NewsService;
import com.tampro.service.impl.NewsServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADD_NEWS)
public class AdminAddNewsServlet  extends HttpServlet{
	
	NewsService newsService = new NewsServiceImpl();
	private static final String imgUrl = "C:\\Users\\Admin\\eclipse-workspace\\Book-Store-Servlet\\WebContent\\images\\news\\";
	private static final String URL_SAVE_IMG_DB = "/images/news/";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Users users = (Users) session.getAttribute("users");
		
		System.out.println("Đã vào");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		News news = new News();
		news.setIdUser(users.getId());
		try {
			List<FileItem> listFileItem = fileUpload.parseRequest(req);
			for(FileItem item : listFileItem) {
				if(item.getFieldName().equals("images")) {
					File file  = new File(imgUrl+item.getName());
					item.write(file);
					news.setImg(URL_SAVE_IMG_DB + item.getName());
				}else if(item.getFieldName().equals("title")) {
					news.setTitle(item.getString("UTF-8"));
				}else if(item.getFieldName().equals("content")) {
					System.out.println(item.getString("UTF-8"));
					news.setContent(item.getString("UTF-8"));
				}
			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		newsService.add(news);
		
		response.sendRedirect(req.getContextPath() + PathRequest.NEWS_ADMIN);
	}
}
