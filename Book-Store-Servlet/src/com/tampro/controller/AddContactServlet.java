package com.tampro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Contact;
import com.tampro.service.ContactService;
import com.tampro.service.impl.ContactServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADD_CONTACT)
public class AddContactServlet extends HttpServlet {
	
	ContactService contactService = new ContactServiceImpl();

	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/contact.jsp");
		 dispatcher.forward(request, response);
	}
	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 request.setCharacterEncoding("UTF-8");
		 
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String email = request.getParameter("email");
		
		Contact contact = new Contact(name,email,content);
		contactService.addContact(contact);
		request.setAttribute("alert", "Send Thành Công");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/contact.jsp");
		dispatcher.forward(request, response);
		
	}
}

