package com.news.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.Category;
import com.news.service.CategoryService;

public class CategoryServlet extends BaseServlet{
	
	private CategoryService service =new CategoryService();

	 public CategoryServlet() {
	        super();
	    }
	 
	//分页加模糊查询类型
	protected void CategoryList(HttpServletRequest request, HttpServletResponse response) throws Exception {//跳转到添加用户界�?
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
        List<Category> list=service.getCategoryPage(pageNum,pageSize,map);
        request.setAttribute("list",list); //绑定参数
        int nums=service.queryCategoryCount(map); //查询总数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前�?
        request.setAttribute("tp",totalPage); //总页�?

        request.getRequestDispatcher("/WEB-INF/views/category/list.jsp").forward(request,response); //页面转发
	}
	

	
    
    //去新增
    protected void toAddCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
        request.getRequestDispatcher("/WEB-INF/views/category/add.jsp").forward(request,response); //页面转发
    }
    
    //新增类型
    protected void addCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
        String names = request.getParameter("cname");
    	Category ss = new  Category();
        ss.setCname(names);
    	service.addCategory(ss);
        response.sendRedirect(request.getContextPath()+"/CategoryServlet?action=CategoryList");//重定向防止重复提交哦
       
    }
    
    
    protected void toUpdateCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
        String id=request.getParameter("id");
        Category Category = service.selectCategory(id);
        request.removeAttribute("msg");
        request.setAttribute("Category" ,Category);
        request.getRequestDispatcher("/WEB-INF/views/category/update.jsp").forward(request,response); //页面转发

    }
    //修改类型信息
    protected void updateCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
    	 String names=request.getParameter("cname");
         String id=request.getParameter("tid");

         Category Category = new Category();
         Category.setCname(names);
         Category.setId(Integer.parseInt(id));
	     service.updateCategory(Category);
		 response.sendRedirect(request.getContextPath()+"/CategoryServlet?action=CategoryList");//重定向防止重复提交哦
    }
    
    //删除类型
    protected void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
   	     String id=request.getParameter("id");
	     service.deleteCategory(id);
	     response.sendRedirect(request.getContextPath()+"/CategoryServlet?action=CategoryList");//重定向防止重复提交哦
   }
    
    
    
}
