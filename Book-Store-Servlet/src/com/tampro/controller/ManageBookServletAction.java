package com.tampro.controller;

import java.io.File;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tampro.model.Authors;
import com.tampro.model.Books;
import com.tampro.service.AuthorService;
import com.tampro.service.BookService;
import com.tampro.service.impl.AuthorServiceImpl;
import com.tampro.service.impl.BookServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.MANAGE_BOOK_ACTION)
public class ManageBookServletAction extends HttpServlet {
	
	private static final String URL_SAVE_IMG_DB = "/images/data/";
	
	
	BookService bookService = new BookServiceImpl();
	AuthorService authorService = new AuthorServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  // String action = req.getParameter("action");
//	   if(action.equalsIgnoreCase("search")) {
//		   
//		   
//		   
//	   }
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/admin/books.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		   if(action.equalsIgnoreCase("update")) {
			   
			   
			   
		   }else if(action.equalsIgnoreCase("remove")) {
			   
		   }else {
			   Books book = new Books();
				
				//add images 
				String urlFile = "C:\\Users\\Admin\\eclipse-workspace\\Book-Store-Servlet\\WebContent\\images\\data\\";
				FileItemFactory itemFactory = new DiskFileItemFactory(); // dùng để tạo  FileItem
				ServletFileUpload fileUpload = new ServletFileUpload(itemFactory); //sử dụng interface FileItemFactory  tạo filteItem  
				//Constructs an instance of this class which uses the supplied factory to create FileItem instances.																
				//Xây dựng một thể hiện của lớp này sử dụng factory được cung cấp để tạo các thể hiện FileItem
				fileUpload.setHeaderEncoding("UTF-8");			
				try {
					List<FileItem> items =  fileUpload.parseRequest(request); // xử lý luồng đa dữ liệu và trả về kiểu danh sách FileItem
					
					for(FileItem item : items) {

						if(item.getFieldName().equals("images")) {
							File file  = new File(urlFile+item.getName());
							item.write(file);
							book.setImages(URL_SAVE_IMG_DB + item.getName());
						}else if(item.getFieldName().equals("title")) {
							book.setTitle(item.getString("UTF-8"));
						}else if(item.getFieldName().equals("price")) {
							book.setPrice(Integer.parseInt(item.getString()));
						}else if(item.getFieldName().equals("publication")) {
							book.setPublication_date(Date.valueOf(LocalDate.parse(item.getString())));
						}else if(item.getFieldName().equals("isbn")) {
							book.setISBN(item.getString());
						}else if(item.getFieldName().equals("comment")) {
							book.setComments(item.getString("UTF-8"));
						}else if(item.getFieldName().equals("category")) {
							book.setCategory_Id(Integer.parseInt(item.getString()));
						}else if(item.getFieldName().equals("author")) {
							Authors author = authorService.getAuthorsById(Integer.parseInt(item.getString()));
							book.setAuthor(author);
						}			
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bookService.addBook(book);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/admin/books.jsp");
				dispatcher.forward(request, response);
		   
		   }
	}
}
