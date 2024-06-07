package com.news.service;

import com.news.dao.AdminDao;
import com.news.entity.Admin;

public class AdminService {
	
	AdminDao dao = new AdminDao();

	public Admin selectAdmin(String id) {
		// TODO Auto-generated method stub
		return dao.selectAdmin(id);
	}

	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		dao.updateAdmin(admin);
	}

}
