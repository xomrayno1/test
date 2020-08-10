package com.tampro.service.impl;

import java.util.List;

import com.tampro.dao.NewsDao;
import com.tampro.dao.impl.NewsDaoImpl;
import com.tampro.model.News;
import com.tampro.service.NewsService;

public class NewsServiceImpl  implements NewsService{

	NewsDao newsDao = new NewsDaoImpl();
	
	@Override
	public List<News> getAll() {
		// TODO Auto-generated method stub
		return newsDao.getAll();
	}

	@Override
	public List<News> getAll(int start, int end) {
		// TODO Auto-generated method stub
		return newsDao.getAll(start, end);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return newsDao.delete(id);
	}

	@Override
	public boolean update(News news) {
		// TODO Auto-generated method stub
		return newsDao.update(news);
	}

	@Override
	public boolean add(News news) {
		// TODO Auto-generated method stub
		return newsDao.add(news);
	}

}
