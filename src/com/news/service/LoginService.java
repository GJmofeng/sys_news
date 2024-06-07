package com.news.service;

import com.news.dao.LoginDao;
import com.news.entity.Admin;
import com.news.entity.Editors;
import com.news.entity.User;

public class LoginService {

	LoginDao dao = new LoginDao();

	public Admin selectAdmin(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.selectAdmin(userName,password);
	}

	public User selectUser(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.selectUser(userName,password);
	}

	public Editors selectEditors(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.selectEditors(userName,password);
	}
}
