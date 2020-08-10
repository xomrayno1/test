package com.tampro.service;

import java.util.List;

import com.tampro.model.Users;

public interface UserService {
	Users getUserBylogin(String username,String password);
	Users getUserByUsername(String username);
	List<Users> getAllUsers();
	boolean deleteUserById(int id);
	boolean updateUser(Users users);
	boolean addUser(Users users);
	Users getUserById(int id);
	Users getUserByEmail(String email);
	List<Users> getAllUsers(int start, int end);
	
	List<Users> getAllUsersBySearch(String name,String role);
	List<Users> getAllUsersBySearchPagi(String name,String role,int start , int end);

}
