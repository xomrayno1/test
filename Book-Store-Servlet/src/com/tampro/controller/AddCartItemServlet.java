package com.tampro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tampro.model.Books;
import com.tampro.model.CartItem;
import com.tampro.service.BookService;
import com.tampro.service.impl.BookServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADD_CART_ITEM)
public class AddCartItemServlet extends HttpServlet {

	BookService booksService = new BookServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		Books books = booksService.getBookById(id);
		HttpSession session = req.getSession();
		List<CartItem> listCartItem = (List<CartItem>) session.getAttribute("listCartItems");

		if (listCartItem == null) {
			listCartItem = new ArrayList<CartItem>();
			CartItem cartItem = new CartItem();
			cartItem.setBooks(books);
			cartItem.setQuantity(1);
			cartItem.setTotal_Price(cartItem.getQuantity() * cartItem.getBooks().getPrice());
			listCartItem.add(cartItem);
		} else {
			boolean check = true;
			for (CartItem item : listCartItem) {
				if (item.getBooks().getId() == id) {
					item.setQuantity(item.getQuantity() + 1);
					item.setTotal_Price(item.getQuantity() * books.getPrice());
					check = false;
				}
			}
			if (check) {
				CartItem cartItem = new CartItem();
				cartItem.setBooks(books);
				cartItem.setQuantity(1);
				cartItem.setTotal_Price(cartItem.getQuantity() * books.getPrice());
				listCartItem.add(cartItem);
			}

		}
		session.setAttribute("listCartItems", listCartItem);
		resp.sendRedirect(req.getContextPath() + PathRequest.CART_ITEM);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		int sl = Integer.valueOf(req.getParameter("sl"));
		Books books = booksService.getBookById(id);
		HttpSession session = req.getSession();
		List<CartItem> listCartItem = (List<CartItem>) session.getAttribute("listCartItems");

		if (listCartItem == null) {
			listCartItem = new ArrayList<CartItem>();
			CartItem cartItem = new CartItem();
			cartItem.setBooks(books);
			cartItem.setQuantity(sl);
			cartItem.setTotal_Price(cartItem.getQuantity() * cartItem.getBooks().getPrice());
			listCartItem.add(cartItem);
		} else {
			boolean check = true;
			for (CartItem item : listCartItem) {
				if (item.getBooks().getId() == id) {
					item.setQuantity(item.getQuantity() + sl);
					item.setTotal_Price(item.getQuantity() * books.getPrice());
					check = false;
				}
			}
			if (check) {
				CartItem cartItem = new CartItem();
				cartItem.setBooks(books);
				cartItem.setQuantity(sl);
				cartItem.setTotal_Price(cartItem.getQuantity() * books.getPrice());
				listCartItem.add(cartItem);
			}

		}
		session.setAttribute("listCartItems", listCartItem);
		resp.sendRedirect(req.getContextPath() + PathRequest.CART_ITEM);
	}

}
