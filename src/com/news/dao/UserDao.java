package com.news.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.news.entity.User;
import com.news.util.C3p0Utils;

public class UserDao {
	
	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());


	public List<User> getUserPage(int pageNum, int pageSize,Map map) {
		String sql="select * from User  where  1 = 1 ";
		if(map.get("names") != null && !map.get("names").toString().equals("")) {
			sql+=" and name like  '%"+map.get("names")+"%'";
		}
		sql += " limit ?,? ";
        int startNo=(pageNum-1)*pageSize;
        List<User> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<User>(User.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反�?
            return list;
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public int queryUserCount(Map map) {
		String sql="select count(*) from User where 1 = 1 ";
		if(map.get("names") != null && !map.get("names").toString().equals("")) {
			sql+=" and name like  '%"+map.get("names")+"%'";
		}
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            return count.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}


	public User selectUserByStno(String stno) {
		try {//
            return runner.query("select * from User where stno=?", new BeanHandler<User>(User.class),stno);
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public void addUser(User ss) {
		// TODO Auto-generated method stub
		 try {
	            //执行插入sql
	            runner.update("insert into User(stno,pwd,name,email,time,sums,img) values (?,?,?,?,?,?,?)",
	            		ss.getStno(),ss.getPwd(),ss.getName(),ss.getEmail(),ss.getTime(),ss.getSums(),ss.getImg());
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }

	}


	public User selectUser(String id) {
		try {//
            return runner.query("select * from User where id=?", new BeanHandler<User>(User.class),Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public void updateUser(User ss) {
		// TODO Auto-generated method stub
		try {
            //执行插入sql
            runner.update("update User set stno=?,pwd=?,name=?,email=? where id=?",
            		ss.getStno(),ss.getPwd(),ss.getName(),ss.getEmail(),ss.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}


	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		try {
            //执行插入sql
            runner.update("delete from  User  where id=?",
            		Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}


	public void updateTx(User ss) {
		// TODO Auto-generated method stub
		try {
            //执行插入sql
            runner.update("update User set img=? where id=?",
            		ss.getImg(),ss.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

}
