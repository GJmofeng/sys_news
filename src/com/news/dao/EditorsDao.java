package com.news.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.news.entity.Editors;
import com.news.util.C3p0Utils;

public class EditorsDao {

	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());


	public List<Editors> getEditorsPage(int pageNum, int pageSize,Map map) {
		String sql="select * from Editors  where  1 = 1 ";
		if(map.get("names") != null && !map.get("names").toString().equals("")) {
			sql+=" and ename like  '%"+map.get("names")+"%'";
		}
		if(map.get("eid") != null && !map.get("eid").toString().equals("")) {
			sql+=" and id =  "+map.get("eid");
		}
		sql += " limit ?,? ";
        int startNo=(pageNum-1)*pageSize;
        List<Editors> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Editors>(Editors.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反�?
            return list;
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public int queryEditorsCount(Map map) {
		String sql="select count(*) from Editors where 1 = 1 ";
		if(map.get("names") != null && !map.get("names").toString().equals("")) {
			sql+=" and ename like  '%"+map.get("names")+"%'";
		}
		if(map.get("eid") != null && !map.get("eid").toString().equals("")) {
			sql+=" and id =  "+map.get("eid");
		}
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            return count.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}


	public void addEditors(Editors ss) {
		// TODO Auto-generated method stub
		 try {
	            //执行插入sql
	            runner.update("insert into Editors(ename,pwd,phone,sex,email,times,eno) values (?,?,?,?,?,?,?)",
	            		ss.getEname(),ss.getPwd(),ss.getPhone(),ss.getSex(),ss.getEmail(),ss.getTimes(),ss.getEno());
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
		

	}


	public Editors selectEditors(String id) {
		try {//
            return runner.query("select * from Editors where id=?", new BeanHandler<Editors>(Editors.class),Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public void updateEditors(Editors ss) {
		// TODO Auto-generated method stub
		try {
            //执行插入sql
            runner.update("update Editors set ename=?,pwd=?,phone=?,sex=?,email=?,eno=? where id=?",
            		ss.getEname(),ss.getPwd(),ss.getPhone(),ss.getSex(),ss.getEmail(),ss.getEno(),ss.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}


	public void deleteEditors(String id) {
		// TODO Auto-generated method stub
		try {
            //执行插入sql
            runner.update("delete from  Editors  where id=?",
            		Integer.parseInt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}


	public List<Editors> selectList() {
		String sql="select * from Editors  ";
        List<Editors> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Editors>(Editors.class));//添加实体类的适配器进行类的反�?
            return list;
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
	}

}
