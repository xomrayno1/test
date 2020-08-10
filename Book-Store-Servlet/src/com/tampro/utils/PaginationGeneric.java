package com.tampro.utils;

import java.util.List;

public class PaginationGeneric<T> {

	private int start;
	private int end;
	private int pageCurrent;
	private List<T> listWishList;
	private int soPage;
	private int limit;
	
	
	
	
	

	
	public PaginationGeneric(int start, int end, int pageCurrent, List<T> listWishList, int limit) {
	
		this.start = start;
		this.end = end;
		this.pageCurrent = pageCurrent;
		this.listWishList = listWishList;
		this.limit = limit;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getSoPage() {
		return soPage;
	}
	public List<T> getListWishList() {
		return listWishList;
	}
	public void setListWishList(List<T> listWishList) {
		this.listWishList = listWishList;
	}
	


	public void setTotalPage() {
		soPage =  0;
		if(listWishList.size() % limit == 0) {
			soPage = listWishList.size() / limit;
		}else{
			soPage = (listWishList.size() / limit) + 1;
		}
	}
	
	

	
	
	
	
	
	
	
}
