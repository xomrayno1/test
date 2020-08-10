package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.UsersDao;
import com.tampro.dao.impl.UsersDaoImpl;
import com.tampro.model.Users;
import com.tampro.service.UserService;

public class UserServiceImpl implements UserService{
	
	UsersDao userDao = new UsersDaoImpl();

	@Override
	public Users getUserBylogin(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.getUserBylogin(username, password);
	}

	@Override
	public Users getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsername(username);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteUserById(id);
	}

	@Override
	public boolean updateUser(Users users) {
		// TODO Auto-generated method stub
		return userDao.updateUser(users);
	}

	@Override
	public boolean addUser(Users users) {
		// TODO Auto-generated method stub
		return userDao.addUser(users);
	}

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public Users getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.getUserByEmail(email);
	}

	@Override
	public List<Users> getAllUsers(int start, int end) {
		// TODO Auto-generated method stub
		return userDao.getAllUsers(start, end);
	}

	@Override
	public List<Users> getAllUsersBySearch(String name,String role) {
		// TODO Auto-generated method stub
		return userDao.getAllUsersBySearch(name,role);
	}

	@Override
	public List<Users> getAllUsersBySearchPagi(String name,String role, int start, int end) {
		// TODO Auto-generated method stub
		return userDao.getAllUsersBySearchPagi(name,role,start, end);
	}

	

}
