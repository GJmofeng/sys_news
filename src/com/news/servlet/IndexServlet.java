package com.news.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.Category;
import com.news.entity.Comments;
import com.news.entity.News;
import com.news.entity.User;
import com.news.service.CategoryService;
import com.news.service.CommentsService;
import com.news.service.NewsService;


public class IndexServlet extends BaseServlet{
	
	
	
	CategoryService cs = new  CategoryService();
	
	
	
	NewsService ns = new NewsService();
	
	
	
	CommentsService coms = new CommentsService();
	

	 public IndexServlet() {
	        super();
	    }
	
	/**
	 * 去主页面
	 * @param request
	 * @param response
	 */
	 protected void toIndex(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String type = request.getParameter("type");
			String names = request.getParameter("names");
			Map map = new HashMap();
			map.put("type", type);
			map.put("names", names);
		
		
		
		
			
//			String p=request.getParameter("p");//接收页码
//	        int pageSize=6;//每页显示5条
//	        int pageNum=1; //默认第一页
//	        if(p!=null){
//	            pageNum= Integer.parseInt(p);
//	        }
//	        //调用分页查询
//	        List<Music> musicList=ms.getMusicPage(pageNum,pageSize,map);
//	        //携带参数到页面
//	        int nums=ms.queryMusicCount(map); //查询总数
//	        //计算总页数
//	        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
//	        request.setAttribute("cp",pageNum); //当前页
//	        request.setAttribute("tp",totalPage); //总页数
//	        request.setAttribute("musicList" ,musicList);
//	        request.setAttribute("names" ,names);
            request.getRequestDispatcher("/WEB-INF/views/index/index.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}  
	}
	 
	
		     
	
			
	 protected void toNews(HttpServletRequest request, HttpServletResponse response) {
		 // TODO Auto-generated method stub
		 try {
			 String nid = request.getParameter("nid");
			 String names = request.getParameter("names");
			 String type = request.getParameter("type");
			 String category = request.getParameter("category");
			 Map map = new HashMap();
			 map.put("type", type);
			 map.put("names", names);
			 map.put("category", category);
			 
			 List<Comments> commentsList = coms.selectListByNid(nid != null ?Integer.parseInt(nid) : 0);

			 List<Category> categoryList = cs.selectList();
			 List<News> newsList = ns.selectList(map);
			 
			 News nn = ns.selectNews(nid == null ? "0":nid );
			 
			 
			 
			 request.setAttribute("newsList", newsList);
			 request.setAttribute("names", names);
			 request.setAttribute("commentsList", commentsList);
			 request.setAttribute("categoryList", categoryList);
			 if( nn != null) {
				 News news = ns.selectNews(nid);
				 ns.updateSeeCount(news.getSee_count()+1, news.getId());
				 request.setAttribute("news", ns.selectNews(news.getId().toString()));
			 }
			 
			 String p=request.getParameter("p");//接收页码
			 int pageSize=6;//每页显示5条
			 int pageNum=1; //默认第一页
			 if(p!=null){
				 pageNum= Integer.parseInt(p);
			 }
			 
			 /*
			  * List<Music> musicList=ms.selectMusicList(map); request.setAttribute("names"
			  * ,names); request.setAttribute("musicList" ,musicList);
			  */
			 //调用分页查询
			 //List<Music> musicList=ms.getMusicPage(pageNum,pageSize,map);
			 //携带参数到页面
//		        int nums=ms.queryMusicCount(map); //查询总数
//		        //计算总页数
//		        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
//		        request.setAttribute("cp",pageNum); //当前页
//		        request.setAttribute("tp",totalPage); //总页数
//		        request.setAttribute("musicList" ,musicList);
			 request.getRequestDispatcher("/WEB-INF/views/index/news.jsp").forward(request, response);
		 }catch(Exception e){
			 e.printStackTrace();
		 }  
	 }
	 

}
