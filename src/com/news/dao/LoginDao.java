package com.news.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.news.entity.Admin;
import com.news.entity.Editors;
import com.news.entity.User;
import com.news.util.C3p0Utils;

public class LoginDao {
	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());


	public Admin selectAdmin(String userName, String password) {
		try {//
            return runner.query("select * from admin where username=? and password =?", new BeanHandler<Admin>(Admin.class),userName,password);
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public User selectUser(String userName, String password) {
		try {//
            return runner.query("select * from User where stno=? and pwd =?", new BeanHandler<User>(User.class),userName,password);
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public Editors selectEditors(String userName, String password) {
		try {//
            return runner.query("select * from Editors where eno=? and pwd =?", new BeanHandler<Editors>(Editors.class),userName,password);
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}

}
