package com.news.servlet;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.news.entity.Admin;
import com.news.entity.Category;
import com.news.entity.Editors;
import com.news.entity.News;
import com.news.service.CategoryService;
import com.news.service.NewsService;
import com.news.util.WebUtils;

public class NewsServlet extends BaseServlet{
	
	private NewsService service =new NewsService();
	
	CategoryService cs = new CategoryService(); 

	 public NewsServlet() {
	        super();
	    }
	 
	//分页加模糊查询学生
	protected void NewsList(HttpServletRequest request, HttpServletResponse response) throws Exception {//跳转到添加用户界�?
		String p=request.getParameter("p");//接收页码
		String names=request.getParameter("names");//接收页码
        System.out.println(p);
        int pageSize=8;//每页显示5页?
        int pageNum=1; //默认第一页?
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        Map map = new HashMap();
        map.put("names", names);
        //调用分页查询
        List<News> list=service.getNewsPage(pageNum,pageSize,map);
        request.setAttribute("list",list); //绑定参数
        int nums=service.queryNewsCount(map); //查询总数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前�?
        request.setAttribute("tp",totalPage); //总页�?

        request.getRequestDispatcher("/WEB-INF/views/news/list.jsp").forward(request,response); //页面转发
	}
	

	
//	//模糊查询
//    protected void selectNewsLike(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
//        String name=request.getParameter("name");
//        List<News> list=service.selectNewsLike(name);
//        if(null == list || list.size() ==0 ){
//            request.setAttribute("msg" ,"无此信息");
//            request.getRequestDispatcher("/WEB-INF/views/news/News_list.jsp").forward(request,response); //页面转发
//        }else {
//            request.removeAttribute("msg");
//            request.setAttribute("list" ,list);
//            request.getRequestDispatcher("/WEB-INF/views/news/News_list.jsp").forward(request,response); //页面转发
//        }
//    }
    
    //去新增学生页
    protected void toAddNews(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
    	List<Category> categoryList = cs.selectList();
    	  request.setAttribute("categoryList" ,categoryList);
        request.getRequestDispatcher("/WEB-INF/views/news/add.jsp").forward(request,response); //页面转发
    }
    
    
    
    //新增学生
    protected void addNews(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
        Editors editors = (Editors)request.getSession().getAttribute("editors");
    	News ss = fileUpload(request);
    	ss.setEditor(editors.getEname());
    	ss.setTimes(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        service.addNews(ss);
        response.sendRedirect(request.getContextPath()+"/NewsServlet?action=NewsList");//重定向防止重复提交哦
       
    }
    
    private News fileUpload(HttpServletRequest request) {
    	News ss=new News();
		try {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> list = upload.parseRequest(request);
		for(FileItem item : list){
			if(item.isFormField()){
				String name = item.getFieldName();
				String value = item.getString("UTF-8");
				BeanUtils.setProperty(ss, name, value);
			}else{
				String filename = item.getName();
				String savefilename = makeFileName(filename);
				//String savepath="D:\\WorkspaceForZGN\\book_system\\WebContent\\img\\";
				String savepath="D:\\upload\\";
				InputStream in = item.getInputStream();
				FileOutputStream out = new FileOutputStream(savepath + "\\" + savefilename);
				int len = 0;
				byte buffer[] = new byte[1024];
				while((len = in.read(buffer)) > 0){
					out.write(buffer, 0, len);
				}
				in.close();
				out.close();
				item.delete();
				ss.setImg(savefilename);
				System.out.println(ss.getImg());
			}
				}
		        return ss;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
	}

	private String makeFileName(String filename) {
		String ext = filename.substring(filename.lastIndexOf(".") + 1);
		return UUID.randomUUID().toString() + "." + ext;
	}
    
    protected void toUpdateNews(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
//        String id=request.getParameter("id");
//        News News = service.selectNews(id);
//        request.removeAttribute("msg");
//        request.setAttribute("News" ,News);
//        request.getRequestDispatcher("/WEB-INF/views/news/update.jsp").forward(request,response); //页面转发

    }
    //修改学生信息
    protected void updateNews(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
//    	 Object type =request.getSession().getAttribute("flag");
//    	 String stno=request.getParameter("stno");
//    	 String pwd=request.getParameter("pwd");
//         String name=request.getParameter("name");
//         String email=request.getParameter("email");
//         String sums=request.getParameter("sums");
//         String id=request.getParameter("sid");
//
//         News News = new News();
//         News.setEmail(email);
//         News.setName(name);
//         News.setPwd(pwd);
//         News.setStno(stno);
//        // News.setSums(Double.parseDouble(sums));
//         News.setId(Integer.parseInt(id));
//        // News.setSums(sums != null ? Double.parseDouble(sums): 0);
//	     service.updateNews(News);
//	     if(type != null && type.toString().equals("1")){
//		     response.sendRedirect(request.getContextPath()+"/NewsServlet?action=NewsList");//重定向防止重复提交哦
//	     }else{
//	 			response.sendRedirect(request.getContextPath()+"/IndexServlet?action=toSet&id="+id);
//	     }
    }
    
    //删除学生
    protected void deleteNews(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
   	     String id=request.getParameter("id");
	     service.deleteNews(id);
	     response.sendRedirect(request.getContextPath()+"/NewsServlet?action=NewsList");//重定向防止重复提交哦
   }
    protected void updateStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
    	String id=request.getParameter("id");
    	String state=request.getParameter("state");
    	service.updateStatus(id,state);
    	response.sendRedirect(request.getContextPath()+"/NewsServlet?action=NewsList");//重定向防止重复提交哦
    }
    
    
    
}
