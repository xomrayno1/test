package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tampro.dao.AuthorDao;
import com.tampro.dao.RootDao;
import com.tampro.model.Authors;

public class AuthorDaoImpl extends RootDao implements AuthorDao{

	@Override
	public Authors getAuthorsById(int id) {
		PreparedStatement statement = null;
		Connection connection = null;
		String sql = " select * from authors where author_ID = ?";
		
		try {
			connection = RootDao.getConnection();
			 statement =  connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeQuery();
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()) {
				Authors authors = new Authors();
				authors.setId(resultSet.getInt("author_ID"));
				authors.setFirst_Name(resultSet.getString("author_First_Name"));
				authors.setLast_Name(resultSet.getString("author_Last_Name"));
				authors.setInitials(resultSet.getString("author_Initials"));
				return authors;
			}
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
	public List<Authors> getAllAuthors() {
		PreparedStatement statement = null;
		Connection connection = null;
		String sql = " select * from authors ";
		
		try {
			connection = RootDao.getConnection();
			 statement =  connection.prepareStatement(sql);
			
			statement.executeQuery();
			ResultSet resultSet = statement.getResultSet();
			List<Authors> list = new ArrayList<Authors>();
			while(resultSet.next()) {
				Authors authors = new Authors();
				authors.setId(resultSet.getInt("author_ID"));
				authors.setFirst_Name(resultSet.getString("author_First_Name"));
				authors.setLast_Name(resultSet.getString("author_Last_Name"));
				authors.setInitials(resultSet.getString("author_Initials"));
				list.add(authors);
			}
			return list;
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
	public boolean deleteAuthorsById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAuthors(Authors authors) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAuthors(Authors authors) {
		// TODO Auto-generated method stub
		return false;
	}

}
