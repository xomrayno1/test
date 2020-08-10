package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.WardDao;
import com.tampro.dao.impl.WardDaoImpl;
import com.tampro.model.Ward;
import com.tampro.service.WardService;

public class WardServiceImpl  implements WardService{

	WardDao wardDao = new WardDaoImpl();
	@Override
	public List<Ward> getAll() {
		// TODO Auto-generated method stub
		return wardDao.getAll();
	}

	@Override
	public List<Ward> getAllByIdProvince(int idProvince) {
		// TODO Auto-generated method stub
		return wardDao.getAllByIdProvince(idProvince);
	}

	@Override
	public List<Ward> getAllByIdDistrict(int idDistrict) {
		// TODO Auto-generated method stub
		return wardDao.getAllByIdDistrict(idDistrict);
	}

	@Override
	public List<Ward> getAllByIdDistrictAndIdProvince(int idProvince, int idDistrict) {
		// TODO Auto-generated method stub
		return wardDao.getAllByIdDistrictAndIdProvince(idProvince, idDistrict);
	}

	@Override
	public Ward getWardById(int id) {
		// TODO Auto-generated method stub
		return wardDao.getWardById(id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return wardDao.delete(id);
	}

	@Override
	public boolean update(Ward ward) {
		// TODO Auto-generated method stub
		return wardDao.update(ward);
	}

	@Override
	public boolean add(Ward ward) {
		// TODO Auto-generated method stub
		return wardDao.add(ward);
	}

}
