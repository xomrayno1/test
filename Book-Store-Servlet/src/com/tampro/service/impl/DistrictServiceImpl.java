package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.DistrictDao;
import com.tampro.dao.impl.DistrictDaoImpl;
import com.tampro.model.District;
import com.tampro.service.DistrictService;

public class DistrictServiceImpl  implements DistrictService{
	
	DistrictDao districtDao = new DistrictDaoImpl();

	@Override
	public List<District> getAll() {
		// TODO Auto-generated method stub
		return districtDao.getAll();
	}

	@Override
	public List<District> getAllByIdProvince(int idProvince) {
		// TODO Auto-generated method stub
		return districtDao.getAllByIdProvince(idProvince);
	}

	@Override
	public District getDistrictById(int id) {
		// TODO Auto-generated method stub
		return districtDao.getDistrictById(id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return districtDao.delete(id);
	}

	@Override
	public boolean update(District district) {
		// TODO Auto-generated method stub
		return districtDao.update(district);
	}

	@Override
	public boolean add(District district) {
		// TODO Auto-generated method stub
		return districtDao.add(district);
	}

}
