package com.tampro.service;

import java.util.List;

import com.tampro.model.Address;

public interface AddressService {
	
	List<Address> getAddressByIdUser(int idUser);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	boolean deleteAddress(int idAddress);
	Address getAddressDefaultByIdUser(int idUser);
	Address getAddressById(int id);
	Address getAddressByIdAddressAndidUser(int id,int idUser);

}
