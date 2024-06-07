package com.news.service;

import java.util.List;
import java.util.Map;

import com.news.dao.UserDao;
import com.news.entity.User;

public class UserService {

	UserDao dao = new UserDao();

	public List<User> getUserPage(int pageNum, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return dao.getUserPage(pageNum, pageSize, map);
	}

	public int queryUserCount(Map map) {
		// TODO Auto-generated method stub
		return dao.queryUserCount(map);
	}

	public User selectUserByStno(String stno) {
		// TODO Auto-generated method stub
		return dao.selectUserByStno(stno);
	}

	public void addUser(User ss) {
		// TODO Auto-generated method stub
		dao.addUser(ss);
	}

	public User selectUser(String id) {
		// TODO Auto-generated method stub
		return dao.selectUser(id);
	}

	public void updateUser(User User) {
		// TODO Auto-generated method stub
		dao.updateUser(User);
	}

	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		dao.deleteUser(id);
	}

	public void updateTx(User ss) {
		// TODO Auto-generated method stub
		dao.updateTx(ss);
	}

}
