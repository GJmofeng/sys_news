package com.news.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.news.entity.News;
import com.news.util.C3p0Utils;

public class NewsDao {
	
	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());


	public List<News> getNewsPage(int pageNum, int pageSize,Map map) {
		String sql="select * from News  where  1 = 1 ";
		if(map.get("names") != null && !map.get("names").toString().equals("")) {
			sql+=" and title like  '%"+map.get("names")+"%'";
		}
		
		sql += " ORDER BY times desc";
		sql += " limit ?,? ";
	
        int startNo=(pageNum-1)*pageSize;
        List<News> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<News>(News.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反�?
            return list;
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public int queryNewsCount(Map map) {
		String sql="select count(*) from News where 1 = 1 ";
		if(map.get("names") != null && !map.get("names").toString().equals("")) {
			sql+=" and title like  '%"+map.get("names")+"%'";
		}
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            return count.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}




	public void addNews(News ss) {
		// TODO Auto-generated method stub
		 try {
	            //执行插入sql
	            runner.update("insert into News(title,content,times,editor,img,category) values (?,?,?,?,?,?)",
	            		ss.getTitle(),ss.getContent(),ss.getTimes(),ss.getEditor(),ss.getImg(),ss.getCategory());
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }

	}


	public News selectNews(String id) {
		try {//
            return runner.query("select * from News where id=?", new BeanHandler<News>(News.class),Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public void updateNews(News ss) {
		// TODO Auto-generated method stub
		/*
		 * try { //执行插入sql
		 * runner.update("update News set stno=?,pwd=?,name=?,email=? where id=?",
		 * ss.getStno(),ss.getPwd(),ss.getName(),ss.getEmail(),ss.getId()); } catch
		 * (Exception e) { throw new RuntimeException(e); }
		 */
	}


	public void deleteNews(String id) {
		// TODO Auto-generated method stub
		try {
            //执行插入sql
            runner.update("delete from  News  where id=?",
            		Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}


	public List<News> selectList(Map map) {
		String sql="select * from News  where  state = '1' ";
		if(map.get("names") != null && !map.get("names").toString().equals("")) {
			sql+=" and title like  '%"+map.get("names")+"%'";
		}
		if(map.get("category") != null && !map.get("category").toString().equals("")) {
			sql+=" and category =  '"+map.get("category")+"'";
		}
		sql += " ORDER BY times desc";
        List<News> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<News>(News.class));//添加实体类的适配器进行类的反�?
            return list;
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public void updateCommentsCount(int i, Integer id) {
		// TODO Auto-generated method stub
		
		try { // 执行插入sql
			runner.update("update News set comment_count=? where id=?",  i,
					id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		 
	}


	public void updateSeeCount(int i, Integer id) {
		// TODO Auto-generated method stub
		try { // 执行插入sql
			runner.update("update News set see_count=? where id=?",  i,
					id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public void updateStatus(String id, String state) {
		// TODO Auto-generated method stub
		try { // 执行插入sql
			runner.update("update News set state=? where id=?",  state,
					Integer.parseInt(id));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}



}
