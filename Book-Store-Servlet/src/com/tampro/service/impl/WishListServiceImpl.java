package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.WishListDao;
import com.tampro.dao.impl.WishListDaoImpl;
import com.tampro.model.WishList;
import com.tampro.service.WishListService;

public class WishListServiceImpl implements WishListService{
	
	WishListDao wishlist = new WishListDaoImpl();

	@Override
	public List<WishList> getWishListByIdUsers(int idUsers) {
		// TODO Auto-generated method stub
		return wishlist.getWishListByIdUsers(idUsers);
	}

	@Override
	public boolean deleteWishListByIdBookAndUsersId(int idBooks, int idUser) {
		// TODO Auto-generated method stub
		return wishlist.deleteWishListByIdBookAndUsersId(idBooks, idUser);
	}

	@Override
	public boolean updateWishList(WishList wishList) {
		// TODO Auto-generated method stub
		return wishlist.updateWishList(wishList);
	}

	@Override
	public WishList getWishListByIdBookAndUsersId(int idBooks, int idUser) {
		// TODO Auto-generated method stub
		return wishlist.getWishListByIdBookAndUsersId(idBooks, idUser);
	}

	@Override
	public boolean addWishList(WishList wishList) {
		
		for(WishList list : wishlist.getWishListByIdUsers(wishList.getUsers().getId())) {
			if(list.getBooks().getId() == wishList.getBooks().getId() ) {
				return false;
			}
		}
		
		wishlist.addWishList(wishList);
		return true;
		
	}

	@Override
	public List<WishList> getWishListByIdUsersPagination(int idUsers, int start, int end) {
		// TODO Auto-generated method stub
		return wishlist.getWishListByIdUsersPagination(idUsers, start, end);
	}

}
