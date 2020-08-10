package com.tampro.dao;

import java.util.List;

import com.tampro.model.WishList;

public interface WishListDao {
	List<WishList> getWishListByIdUsers(int idUsers);
	List<WishList> getWishListByIdUsersPagination(int idUsers,int start,int end);
	boolean deleteWishListByIdBookAndUsersId(int idBooks,int idUser);
	boolean updateWishList(WishList wishList);
	WishList getWishListByIdBookAndUsersId(int idBooks,int idUser);
	void addWishList(WishList wishList);

}
