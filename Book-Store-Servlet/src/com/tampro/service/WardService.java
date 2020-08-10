package com.tampro.service;

import java.util.List;

import com.tampro.model.Ward;

public interface WardService {
	
	List<Ward> getAll();
	List<Ward> getAllByIdProvince(int idProvince);
	List<Ward> getAllByIdDistrict(int idDistrict);
	List<Ward> getAllByIdDistrictAndIdProvince(int idProvince,int idDistrict);
	Ward getWardById(int id);
	boolean delete(int id);
	boolean update(Ward ward);
	boolean add(Ward ward);

}
