package com.tampro.dao;

import java.util.List;

import com.tampro.model.Province;

public interface ProvinceDao  {
	
	List<Province> getAll();
	Province getProvinceById(int id);
	boolean delete(int id);
	boolean update(Province province);
	boolean add(Province province);
	

}
