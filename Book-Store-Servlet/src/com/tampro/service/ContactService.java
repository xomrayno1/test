package com.tampro.service;

import java.util.List;

import com.tampro.model.Contact;

public interface ContactService {
	
	List<Contact> getAllContact();
	List<Contact> getAllContact(int start , int end);
	Contact getContactById(int id);
	boolean addContact(Contact contact);
	void deleteContact(int id);
	

}
