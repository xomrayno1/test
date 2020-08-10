package com.tampro.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.tampro.dto.WishListDTO;
import com.tampro.model.Users;
import com.tampro.model.WishList;
import com.tampro.service.BookService;
import com.tampro.service.WishListService;
import com.tampro.service.impl.BookServiceImpl;
import com.tampro.service.impl.WishListServiceImpl;

@WebServlet("/user/wishlist/api")
public class GetWishListAPI  extends HttpServlet{
	
	BookService bookService = new BookServiceImpl();
	WishListService wishlistService = new WishListServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		Users users = (Users) session.getAttribute("users");
			Gson gson = new Gson();
			PrintWriter writer = resp.getWriter();
		if(req.getParameter("id") != null) {
			int id = Integer.parseInt(req.getParameter("id"));
			WishList wishList = wishlistService.getWishListByIdBookAndUsersId(id, users.getId());
			if(wishList !=null) {
				WishListDTO wishListDTO = new WishListDTO();
				wishListDTO.setBookId(wishList.getBooks().getId());
				wishListDTO.setUserId(wishList.getUsers().getId());
				writer.print(gson.toJson(wishListDTO));
			}else {
				writer.print(gson.toJson(null));
			}
			
		}else {
			List<WishList> listWishList = wishlistService.getWishListByIdUsers(users.getId());
			List<com.tampro.dto.WishListDTO> wishLists = new ArrayList<com.tampro.dto.WishListDTO>();
			for(WishList item : listWishList) {
				com.tampro.dto.WishListDTO wishList  = new com.tampro.dto.WishListDTO(item.getUsers().getId(),item.getBooks().getId());
				
				wishLists.add(wishList);
			}
			writer.print(gson.toJson(wishLists));
		}
		
		
	}
	
	

}
