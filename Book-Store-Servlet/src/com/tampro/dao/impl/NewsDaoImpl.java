package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tampro.dao.NewsDao;
import com.tampro.dao.RootDao;
import com.tampro.model.Contact;
import com.tampro.model.News;

public class NewsDaoImpl extends RootDao implements NewsDao{

	@Override
	public List<News> getAll() {
		String sql = "select * from news";
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			List<News> listNews = new ArrayList<News>();
			while(set.next()) {
				News news = new News();
				news.setId(set.getInt("id"));
				news.setCreate(set.getDate("createdDate"));
				news.setTitle(set.getString("title"));
				news.setIdUser(set.getInt("idUser"));
				news.setImg(set.getString("img"));
				news.setContent(set.getString("content"));
				listNews.add(news);
			}
			return listNews;
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
	public List<News> getAll(int start, int end) {
		String sql = "select * from news order by id desc limit ?,?";
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, start);
			statement.setInt(2, end);
			ResultSet set = statement.executeQuery();
			List<News> listNews = new ArrayList<News>();
			while(set.next()) {
				News news = new News();
				news.setId(set.getInt("id"));
				news.setCreate(set.getDate("createdDate"));
				news.setTitle(set.getString("title"));
				news.setIdUser(set.getInt("idUser"));
				news.setImg(set.getString("img"));
				news.setContent(set.getString("content"));
				listNews.add(news);
			}
			return listNews;
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
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(News news) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(News news) {
		String sql = "insert into  news(title,content,createdDate,img,idUser) values(?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, news.getTitle());
			statement.setString(2, news.getContent());
			statement.setDate(3, news.getCreate());
			statement.setString(4, news.getImg());
			statement.setInt(5, news.getIdUser());
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

	
	
}
