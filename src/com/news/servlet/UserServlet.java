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
import com.news.entity.User;
import com.news.service.UserService;
import com.news.util.WebUtils;

public class UserServlet extends BaseServlet{
	
	private UserService service =new UserService();

	 public UserServlet() {
	        super();
	    }
	 
	//分页加模糊查询学生
	protected void UserList(HttpServletRequest request, HttpServletResponse response) throws Exception {//跳转到添加用户界�?
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
        List<User> list=service.getUserPage(pageNum,pageSize,map);
        request.setAttribute("list",list); //绑定参数
        int nums=service.queryUserCount(map); //查询总数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前�?
        request.setAttribute("tp",totalPage); //总页�?

        request.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(request,response); //页面转发
	}
	

	
//	//模糊查询
//    protected void selectUserLike(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
//        String name=request.getParameter("name");
//        List<User> list=service.selectUserLike(name);
//        if(null == list || list.size() ==0 ){
//            request.setAttribute("msg" ,"无此信息");
//            request.getRequestDispatcher("/WEB-INF/views/user/User_list.jsp").forward(request,response); //页面转发
//        }else {
//            request.removeAttribute("msg");
//            request.setAttribute("list" ,list);
//            request.getRequestDispatcher("/WEB-INF/views/user/User_list.jsp").forward(request,response); //页面转发
//        }
//    }
    
    //去新增学生页
    protected void toAddUser(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
        request.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(request,response); //页面转发
    }
    
    
    protected void updateTx(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
    	User ss = fileUpload(request);
    	try {
			service.updateTx(ss);
 			response.sendRedirect(request.getContextPath()+"/IndexServlet?action=toSet&id="+ss.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
       
    }
    
    //新增学生
    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
        Admin admin = (Admin)request.getSession().getAttribute("admin");
    	User ss = fileUpload(request);
    	ss.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        User sss = service.selectUserByStno(ss.getStno());
        if(sss != null){
        	if(admin == null){
        		 request.setAttribute("msg" ,"学号重复?");
     	        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request,response);
        	}else{
        		 request.setAttribute("msg" ,"学号重复?");
                 request.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(request,response); //页面转发
        	}
        }else{
        	 service.addUser(ss);
        	 if(admin == null){
      	        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
        	}else{
                response.sendRedirect(request.getContextPath()+"/UserServlet?action=UserList");//重定向防止重复提交哦
        	}
        }
       
    }
    
    private User fileUpload(HttpServletRequest request) {
    	User ss=new User();
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
    
    protected void toUpdateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
        String id=request.getParameter("id");
        User User = service.selectUser(id);
        request.removeAttribute("msg");
        request.setAttribute("User" ,User);
        request.getRequestDispatcher("/WEB-INF/views/user/update.jsp").forward(request,response); //页面转发

    }
    //修改学生信息
    protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
    	 Object type =request.getSession().getAttribute("flag");
    	 String stno=request.getParameter("stno");
    	 String pwd=request.getParameter("pwd");
         String name=request.getParameter("name");
         String email=request.getParameter("email");
         String sums=request.getParameter("sums");
         String id=request.getParameter("sid");

         User User = new User();
         User.setEmail(email);
         User.setName(name);
         User.setPwd(pwd);
         User.setStno(stno);
        // User.setSums(Double.parseDouble(sums));
         User.setId(Integer.parseInt(id));
        // User.setSums(sums != null ? Double.parseDouble(sums): 0);
	     service.updateUser(User);
	     if(type != null && type.toString().equals("1")){
		     response.sendRedirect(request.getContextPath()+"/UserServlet?action=UserList");//重定向防止重复提交哦
	     }else{
	 			response.sendRedirect(request.getContextPath()+"/IndexServlet?action=toSet&id="+id);
	     }
    }
    
    //删除学生
    protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {//条件查询
   	     String id=request.getParameter("id");
	     service.deleteUser(id);
	     response.sendRedirect(request.getContextPath()+"/UserServlet?action=UserList");//重定向防止重复提交哦
   }
    
    
    
}
