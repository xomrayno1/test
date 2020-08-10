package com.tampro.service;

import java.util.List;

import com.tampro.model.District;

public interface DistrictService {
	
	List<District> getAll();
	List<District> getAllByIdProvince(int idProvince);
	District getDistrictById(int id);
	boolean delete(int id);
	boolean update(District district);
	boolean add(District district);

}
