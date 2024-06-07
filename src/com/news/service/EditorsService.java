package com.news.service;

import java.util.List;
import java.util.Map;

import com.news.dao.EditorsDao;
import com.news.entity.Editors;

public class EditorsService {

	EditorsDao dao = new EditorsDao();
	public List<Editors> getEditorsPage(int pageNum, int pageSize,Map map) {
		// TODO Auto-generated method stub
		return dao.getEditorsPage(pageNum,pageSize,map);
	}
	
	public List<Editors> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	public int queryEditorsCount(Map map) {
		// TODO Auto-generated method stub
		return dao.queryEditorsCount(map);
	}

	public void addEditors(Editors ss) {
		// TODO Auto-generated method stub
		dao.addEditors(ss);
	}

	public Editors selectEditors(String id) {
		// TODO Auto-generated method stub
		return dao.selectEditors(id);
	}

	public void updateEditors(Editors Editors) {
		// TODO Auto-generated method stub
		dao.updateEditors(Editors);
	}

	public void deleteEditors(String id) {
		// TODO Auto-generated method stub
		dao.deleteEditors(id);
	}
}
