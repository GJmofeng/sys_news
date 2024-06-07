package com.news.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.Admin;
import com.news.entity.Comments;
import com.news.entity.News;
import com.news.entity.User;
import com.news.service.CommentsService;
import com.news.service.NewsService;

public class CommentsServlet  extends BaseServlet{
	public CommentsServlet() {
        super();
    }
	CommentsService service = new CommentsService();
	
	NewsService ns = new NewsService();
	
	protected void CommentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {//跳转到添加用户界�?
		String p=request.getParameter("p");//接收页码
		String names=request.getParameter("names");//接收页码
        System.out.println(p);
        int pageSize=8;//每页显示5�?
        int pageNum=1; //默认第一�?
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        Map map = new HashMap();
        map.put("names", names);
        //调用分页查询
        List<Comments> list=service.getCommentsPage(pageNum,pageSize,map);
        request.setAttribute("list",list); //绑定参数
        int nums=service.queryCommentsCount(map); //查询总数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前�?
        request.setAttribute("tp",totalPage); //总页�?

        request.getRequestDispatcher("/WEB-INF/views/comments/list.jsp").forward(request,response); //页面转发
	}
	
	   
    protected void deleteComments(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
   	     String id=request.getParameter("id");
	     service.deleteComments(id);
	     response.sendRedirect(request.getContextPath()+"/CommentsServlet?action=CommentsList");//重定向防止重复提交哦
   }
    
    
    protected void addComments(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
        User user = (User)request.getSession().getAttribute("user");
        String nid = request.getParameter("nid");
        String comments = request.getParameter("comments");
        Comments cc= new Comments();
        cc.setComments(comments);
        cc.setNid(Integer.parseInt(nid));
        cc.setCreater(user.getName());
        cc.setImg(user.getImg());
        cc.setTimes(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        service.addComments(cc);
        News ss = ns.selectNews(nid);
        ns.updateCommentsCount(ss.getComment_count()+1,ss.getId());
        response.sendRedirect(request.getContextPath()+"/IndexServlet?action=toNews&nid="+nid);//重定向防止重复提交哦
       
    }
}
