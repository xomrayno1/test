package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.tampro.dao.ContactDao;
import com.tampro.dao.RootDao;
import com.tampro.model.Contact;

public class ContactDaoImpl  extends RootDao implements ContactDao {

	
	
	@Override
	public List<Contact> getAllContact() {
		// TODO Auto-generated method stub
		String sql = "select * from contact";
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			List<Contact> listContact = new ArrayList<Contact>();
			while(set.next()) {
				Contact contact = new Contact();
				contact.setId(set.getInt("id"));
				contact.setName(set.getString("name"));
				contact.setEmail(set.getString("email"));
				contact.setContent(set.getString("content"));
				listContact.add(contact);
			}
			return listContact;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public Contact getContactById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addContact(Contact contact) {
		String sql = "insert into  contact(name,email,content) values(?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, contact.getName());
			statement.setString(2, contact.getEmail());
			statement.setString(3, contact.getContent());
			statement.executeUpdate();
			return true;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
		
	}

	@Override
	public void deleteContact(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contact> getAllContact(int start, int end) {
		// TODO Auto-generated method stub
		String sql = "select * from contact  order by id desc limit ?,?";
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, start);
			statement.setInt(2, end);
			ResultSet set = statement.executeQuery();
			List<Contact> listContact = new ArrayList<Contact>();
			while(set.next()) {
				Contact contact = new Contact();
				contact.setId(set.getInt("id"));
				contact.setName(set.getString("name"));
				contact.setEmail(set.getString("email"));
				contact.setContent(set.getString("content"));
				listContact.add(contact);
			}
			return listContact;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

}
