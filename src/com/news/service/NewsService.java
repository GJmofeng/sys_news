package com.news.service;

import java.util.List;
import java.util.Map;

import com.news.dao.NewsDao;
import com.news.entity.News;

public class NewsService {

	NewsDao dao = new NewsDao();

	public List<News> getNewsPage(int pageNum, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return dao.getNewsPage(pageNum, pageSize, map);
	}

	public int queryNewsCount(Map map) {
		// TODO Auto-generated method stub
		return dao.queryNewsCount(map);
	}


	public void addNews(News ss) {
		// TODO Auto-generated method stub
		dao.addNews(ss);
	}

	public News selectNews(String id) {
		// TODO Auto-generated method stub
		return dao.selectNews(id);
	}

	public void updateNews(News News) {
		// TODO Auto-generated method stub
		dao.updateNews(News);
	}

	public void deleteNews(String id) {
		// TODO Auto-generated method stub
		dao.deleteNews(id);
	}

	public List<News> selectList(Map map) {
		// TODO Auto-generated method stub
		return dao.selectList(map);
	}

	public void updateCommentsCount(int i, Integer id) {
		// TODO Auto-generated method stub
		dao.updateCommentsCount(i,id);
	}
	public void updateSeeCount(int i, Integer id) {
		// TODO Auto-generated method stub
		dao.updateSeeCount(i,id);
	}

	public void updateStatus(String id, String state) {
		// TODO Auto-generated method stub
		dao.updateStatus(id,state);
	}

}
