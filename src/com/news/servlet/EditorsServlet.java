package com.news.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.Editors;
import com.news.service.EditorsService;

public class EditorsServlet  extends BaseServlet{
	
	
	public EditorsServlet() {
        super();
    }
	
	EditorsService service = new EditorsService();

	
	protected void EditorsList(HttpServletRequest request, HttpServletResponse response) throws Exception {//跳转到添加用户界�?
		Editors editor = new Editors(); 
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
        map.put("eid", editor != null?editor.getId():null);
        //调用分页查询
        List<Editors> list=service.getEditorsPage(pageNum,pageSize,map);
        request.setAttribute("list",list); //绑定参数
        int nums=service.queryEditorsCount(map); //查询总数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前�?
        request.setAttribute("tp",totalPage); //总页�?

        request.getRequestDispatcher("/WEB-INF/views/editors/list.jsp").forward(request,response); //页面转发
	}
	

	
    
    protected void toAddEditors(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
        request.getRequestDispatcher("/WEB-INF/views/editors/add.jsp").forward(request,response); //页面转发
    }
    
    protected void addEditors(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
        String ename = request.getParameter("ename");
        String pwd = request.getParameter("pwd");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        String eno = request.getParameter("eno");

        Editors ss = new  Editors();
        ss.setEmail(email);
        ss.setEname(ename);
        ss.setPwd(pwd);
        ss.setPhone(phone);
        ss.setSex(sex);
        ss.setEno(eno);
    	ss.setTimes(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
    	service.addEditors(ss);
        response.sendRedirect(request.getContextPath()+"/EditorsServlet?action=EditorsList");//重定向防止重复提交哦
       
    }
    
    
    protected void toUpdateEditors(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
        String id=request.getParameter("id");
        Editors Editors = service.selectEditors(id);
        request.removeAttribute("msg");
        request.setAttribute("Editors" ,Editors);
        request.getRequestDispatcher("/WEB-INF/views/editors/update.jsp").forward(request,response); //页面转发

    }
    
    protected void updateEditors(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
         String id=request.getParameter("eid");
         String ename = request.getParameter("ename");
         String pwd = request.getParameter("pwd");
         String phone = request.getParameter("phone");
         String sex = request.getParameter("sex");
         String email = request.getParameter("email");
         String eno = request.getParameter("eno");

         Editors ss = new  Editors();
         ss.setEmail(email);
         ss.setEname(ename);
         ss.setPwd(pwd);
         ss.setPhone(phone);
         ss.setSex(sex);
         ss.setEno(eno);
         ss.setId(Integer.parseInt(id));
	     service.updateEditors(ss);
		 response.sendRedirect(request.getContextPath()+"/EditorsServlet?action=EditorsList");//重定向防止重复提交哦
    }
    
    protected void deleteEditors(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
   	     String id=request.getParameter("id");
	     service.deleteEditors(id);
	     response.sendRedirect(request.getContextPath()+"/EditorsServlet?action=EditorsList");//重定向防止重复提交哦
   }
	    
}
