package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.AddressDao;
import com.tampro.dao.impl.AddressDaoImpl;
import com.tampro.model.Address;
import com.tampro.service.AddressService;

public class AddressServiceImpl  implements AddressService{

	AddressDao addressDao = new AddressDaoImpl();
	
	@Override
	public List<Address> getAddressByIdUser(int idUser) {
		// TODO Auto-generated method stub
		return addressDao.getAddressByIdUser(idUser);
	}

	@Override
	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		return addressDao.addAddress(address);
	}

	@Override
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		return addressDao.updateAddress(address);
	}

	@Override
	public Address getAddressDefaultByIdUser(int idUser) {
		// TODO Auto-generated method stub
		return addressDao.getAddressDefaultByIdUser(idUser);
	}

	@Override
	public boolean deleteAddress(int idAddress) {
		// TODO Auto-generated method stub
		return addressDao.deleteAddress(idAddress);
	}

	@Override
	public Address getAddressById(int id) {
		// TODO Auto-generated method stub
		return addressDao.getAddressById(id);
	}

	@Override
	public Address getAddressByIdAddressAndidUser(int id, int idUser) {
		// TODO Auto-generated method stub
		return addressDao.getAddressByIdAddressAndidUser(id, idUser);
	}

}
