package com.news.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.news.entity.Category;
import com.news.util.C3p0Utils;

public class CategoryDao {
	
	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());


	public List<Category> getCategoryPage(int pageNum, int pageSize,Map map) {
		String sql="select * from Category  where  1 = 1 ";
		if(map.get("names") != null && !map.get("names").toString().equals("")) {
			sql+=" and cname like  '%"+map.get("names")+"%'";
		}
		sql += " limit ?,? ";
        int startNo=(pageNum-1)*pageSize;
        List<Category> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Category>(Category.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反�?
            return list;
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public int queryCategoryCount(Map map) {
		String sql="select count(*) from Category where 1 = 1 ";
		if(map.get("names") != null && !map.get("names").toString().equals("")) {
			sql+=" and cname like  '%"+map.get("names")+"%'";
		}
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            return count.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}


	public void addCategory(Category ss) {
		// TODO Auto-generated method stub
		 try {
	            //执行插入sql
	            runner.update("insert into Category(cname) values (?)",
	            		 ss.getCname());
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }

	}


	public Category selectCategory(String id) {
		try {//
            return runner.query("select * from Category where id=?", new BeanHandler<Category>(Category.class),Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public void updateCategory(Category ss) {
		// TODO Auto-generated method stub
		try {
            //执行插入sql
            runner.update("update Category set cname=? where id=?",
            		 ss.getCname(),ss.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}


	public void deleteCategory(String id) {
		// TODO Auto-generated method stub
		try {
            //执行插入sql
            runner.update("delete from  Category  where id=?",
            		Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}


	public List<Category> selectList() {
		String sql="select * from Category  ";
        List<Category> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Category>(Category.class));//添加实体类的适配器进行类的反�?
            return list;
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
	}

}
