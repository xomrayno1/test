package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.ContactDao;
import com.tampro.dao.impl.ContactDaoImpl;
import com.tampro.model.Contact;
import com.tampro.service.ContactService;

public class ContactServiceImpl  implements ContactService{

	ContactDao contactDao = new ContactDaoImpl();
	
	@Override
	public List<Contact> getAllContact() {
		// TODO Auto-generated method stub
		return contactDao.getAllContact();
	}

	@Override
	public Contact getContactById(int id) {
		// TODO Auto-generated method stub
		return contactDao.getContactById(id);
	}

	@Override
	public boolean addContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactDao.addContact(contact);
	}

	@Override
	public void deleteContact(int id) {
		// TODO Auto-generated method stub
		contactDao.deleteContact(id);
	}

	@Override
	public List<Contact> getAllContact(int start, int end) {
		// TODO Auto-generated method stub
		return contactDao.getAllContact(start, end);
	}

}
