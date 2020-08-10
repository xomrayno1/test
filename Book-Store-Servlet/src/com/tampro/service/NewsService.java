package com.tampro.service;

import java.util.List;

import com.tampro.model.News;

public interface NewsService {
	
	List<News> getAll();
	List<News> getAll(int start , int end);
	boolean delete(int id);
	boolean update(News news);
	boolean add(News news);

}
