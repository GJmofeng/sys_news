package com.news.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.news.entity.Comments;
import com.news.entity.News;
import com.news.util.C3p0Utils;

public class CommentsDao {

	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());

	public List<Comments> getCommentsPage(int pageNum, int pageSize, Map map) {
		String sql="select * from Comments  where  1 = 1 ";
		if(map.get("names") != null && !map.get("names").toString().equals("")) {
			sql+=" and comments like  '%"+map.get("names")+"%'";
		}
		sql += " limit ?,? ";
        int startNo=(pageNum-1)*pageSize;
        List<Comments> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Comments>(Comments.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反�?
            return list;
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
	}

	public int queryCommentsCount(Map map) {
		String sql="select count(*) from Comments where 1 = 1 ";
		if(map.get("names") != null && !map.get("names").toString().equals("")) {
			sql+=" and comments like  '%"+map.get("names")+"%'";
		}
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            return count.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}

	public void deleteComments(String id) {
		// TODO Auto-generated method stub
		try {
            //执行插入sql
            runner.update("delete from  Comments  where id=?",
            		Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public void addComments(Comments cc) {
		// TODO Auto-generated method stub
		 try {
	            //执行插入sql
	            runner.update("insert into Comments(comments,times,creater,img,nid) values (?,?,?,?,?)",
	            		cc.getComments(),cc.getTimes(),cc.getCreater(),cc.getImg(),cc.getNid());
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }

	}

	public List<Comments> selectListByNid(Integer id) {
		// TODO Auto-generated method stub
		String sql="select * from Comments  where  nid = "+id;
        try {
        	return runner.query(sql, new BeanListHandler<Comments>(Comments.class));//添加实体类的适配器进行类的反�?
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
	}

}
