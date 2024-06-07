package com.news.service;

import java.util.List;
import java.util.Map;

import com.news.dao.CategoryDao;
import com.news.entity.Category;

public class CategoryService {
	
	CategoryDao dao = new CategoryDao();

	public List<Category> getCategoryPage(int pageNum, int pageSize,Map map) {
		// TODO Auto-generated method stub
		return dao.getCategoryPage(pageNum,pageSize,map);
	}
	
	public List<Category> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	public int queryCategoryCount(Map map) {
		// TODO Auto-generated method stub
		return dao.queryCategoryCount(map);
	}

	public void addCategory(Category ss) {
		// TODO Auto-generated method stub
		dao.addCategory(ss);
	}

	public Category selectCategory(String id) {
		// TODO Auto-generated method stub
		return dao.selectCategory(id);
	}

	public void updateCategory(Category Category) {
		// TODO Auto-generated method stub
		dao.updateCategory(Category);
	}

	public void deleteCategory(String id) {
		// TODO Auto-generated method stub
		dao.deleteCategory(id);
	}

}
