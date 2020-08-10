package com.tampro.service;

import java.util.List;

import com.tampro.model.WishList;

public interface WishListService {
	List<WishList> getWishListByIdUsers(int idUsers);
	boolean deleteWishListByIdBookAndUsersId(int idBooks,int idUser);
	boolean updateWishList(WishList wishList);
	WishList getWishListByIdBookAndUsersId(int idBooks,int idUser);
	boolean addWishList(WishList wishList);
	List<WishList> getWishListByIdUsersPagination(int idUsers,int start,int end);

}
