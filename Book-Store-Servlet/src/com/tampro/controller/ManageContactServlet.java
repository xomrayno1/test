package com.tampro.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet(PathRequest.CONTACT_ADMIN)
public class ManageContactServlet  extends HttpServlet{
	
	ContactService contactService = new ContactServiceImpl();
	
	private static final int LIMIT = 6;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int pageCurrent = 1;
		if(request.getParameter("page") != null) {
			pageCurrent = Integer.parseInt(request.getParameter("page"));
		}
		int start = LIMIT * (pageCurrent - 1);
		int end =  LIMIT * pageCurrent;						
		List<Contact> listContact = contactService.getAllContact();
		List<Contact> listContactPagi = contactService.getAllContact(start, end);
		
		int soPage = 0;
		if(listContact.size() % LIMIT == 0) {
			soPage = listContact.size() / LIMIT;
		}else {
			soPage = (listContact.size() / LIMIT ) + 1;
		}
		request.setAttribute("listContact", listContactPagi);
		request.setAttribute("pageCurrent", pageCurrent);
		request.setAttribute("soPage", soPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/admin/contact.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
