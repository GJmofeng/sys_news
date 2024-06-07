package com.news.service;

import java.util.List;
import java.util.Map;

import com.news.dao.CommentsDao;
import com.news.entity.Comments;

public class CommentsService {

	CommentsDao dao = new  CommentsDao();

	public List<Comments> getCommentsPage(int pageNum, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return dao.getCommentsPage(pageNum,pageSize,map);
	}

	public int queryCommentsCount(Map map) {
		// TODO Auto-generated method stub
		return dao.queryCommentsCount(map);
	}

	public void deleteComments(String id) {
		// TODO Auto-generated method stub
		dao.deleteComments(id);
	}

	public void addComments(Comments cc) {
		// TODO Auto-generated method stub
		dao.addComments(cc);
	}
	
	public List<Comments> selectListByNid(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectListByNid(id);
	}
}
