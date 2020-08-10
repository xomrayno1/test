package com.tampro.service;

import java.util.List;

import com.tampro.model.Province;

public interface ProvinceService {
	
	List<Province> getAll();
	Province getProvinceById(int id);
	boolean delete(int id);
	boolean update(Province province);
	boolean add(Province province);
	
	
}
