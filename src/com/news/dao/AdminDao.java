package com.news.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.news.entity.Admin;
import com.news.util.C3p0Utils;

public class AdminDao {
	
	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());


	public Admin selectAdmin(String id) {
		try {//
            return runner.query("select * from admin where id=?", new BeanHandler<Admin>(Admin.class),Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
            //执行插入sql
            runner.update("update admin set username=?,password=? where id=?",
            		admin.getUsername(),admin.getPassword(),admin.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

}
