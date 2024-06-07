package com.news.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.Admin;
import com.news.entity.Editors;
import com.news.entity.User;
import com.news.service.LoginService;

public class LoginServlet extends BaseServlet{
	
	private LoginService service = new LoginService();

    public LoginServlet() {
        super();
    }
    
	protected void login(HttpServletRequest request, HttpServletResponse response) throws Exception {//璺宠浆鍒版坊鍔犵敤鎴风晫锟??
	    // 获取请求用户名、密码、类型、验证码
		String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
		String code = request.getParameter("code");

		// 2.获取生成的验证码
		String login_code=(String) request.getSession().getAttribute("check_code");
		request.getSession().removeAttribute("check_code");

		// 3.比较验证码
		if(login_code.equalsIgnoreCase(code)==true) {
	  if(type != null && type.equals("1")){//admin
	    	Admin admin = service.selectAdmin(userName,password);
	    	 if (admin == null) {
				  request.setAttribute("msg","管理员不存在或者密码错误?");
				  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
             } else {
          	    request.getSession().setAttribute("flag",1);
               request.getSession().setAttribute("admin",admin);
               request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);
           }
	    }else if(type != null && type.equals("2")){//user
	    	User ss = service.selectUser(userName,password);
	    	 if (ss == null) {
				  request.setAttribute("msg","用户不存在或者密码错误?");
				  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
            } else {
         	    request.getSession().setAttribute("flag",2);
                request.getSession().setAttribute("user",ss);
	 			response.sendRedirect(request.getContextPath()+"/IndexServlet?action=toIndex");
          }
	    }else if(type != null && type.equals("3")){//
	    	Editors ee = service.selectEditors(userName,password);
	    	 if (ee == null) {
				  request.setAttribute("msg","编辑者不存在或者密码错误?");
				  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
           } else {
        	    request.getSession().setAttribute("flag",3);
                request.getSession().setAttribute("editors",ee);
                request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);
           }
	    }else{
	    	 request.setAttribute("msg","账号或者密码错误");
			  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
	    }

	  }else{
		  request.setAttribute("msg","验证码错误");
		  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);

	  }

	}
 
	protected void toMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        request.getRequestDispatcher("/WEB-INF/views/menu.jsp").forward(request,response);
	}
	protected void toTop(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("/WEB-INF/views/top.jsp").forward(request,response);
	}
	
	protected void welcome(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("/WEB-INF/views/console.jsp").forward(request,response);
	}

	 protected void loginOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        request.getSession().invalidate();
	        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);

	  }
	 
	 protected void toRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request,response);
		}
	 
}
