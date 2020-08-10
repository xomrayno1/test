package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.ProvinceDao;
import com.tampro.dao.impl.ProvinceDaoImpl;
import com.tampro.model.Province;
import com.tampro.service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {

	ProvinceDao provinceDao = new ProvinceDaoImpl();
	
	@Override
	public List<Province> getAll() {
		// TODO Auto-generated method stub
		return provinceDao.getAll();
	}

	@Override
	public Province getProvinceById(int id) {
		// TODO Auto-generated method stub
		return provinceDao.getProvinceById(id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return provinceDao.delete(id);
	}

	@Override
	public boolean update(Province province) {
		// TODO Auto-generated method stub
		return provinceDao.update(province);
	}

	@Override
	public boolean add(Province province) {
		// TODO Auto-generated method stub
		return provinceDao.add(province);
	}

}
