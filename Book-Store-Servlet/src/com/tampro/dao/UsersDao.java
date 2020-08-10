package com.tampro.dao;

import java.util.List;

import com.tampro.model.Users;

public interface UsersDao  {
	
	Users getUserBylogin(String username,String password);
	Users getUserByUsername(String username);
	Users getUserById(int id);
	List<Users> getAllUsers();
	boolean deleteUserById(int id);
	boolean updateUser(Users users);
	boolean addUser(Users users);
	Users getUserByEmail(String email);
	List<Users> getAllUsers(int start,int end);
	
	List<Users> getAllUsersBySearch(String name,String role);
	List<Users> getAllUsersBySearchPagi(String name,String role,int start , int end);

}
