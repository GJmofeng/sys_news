package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.Admin;
import com.news.service.AdminService;

public class AdminServlet extends HttpServlet{

	private AdminService service = new AdminService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		   String action=request.getParameter("action");//接受请求的参�?
		   if(action != null && action.equals("toUpdateAdmin")) {//去修改管理员数据页面
			   toUpdateAdmin(request, response);
			}else if(action != null && action.equals("updateAdmin")) {//修改管理�?
		    	updateAdmin(request, response);
			}else if(action != null && action.equals("detailAdmin")) {//详情
				detailAdmin(request, response);
			}
		}

	/**
	 * 个人信息
	 * @param request
	 * @param response
	 */
	private void detailAdmin(HttpServletRequest request, HttpServletResponse response) {
	    try {
	    	String id = request.getParameter("id");
			Admin admin = service.selectAdmin(id);
	    	request.setAttribute("adminDate", admin);
		    request.getRequestDispatcher("/WEB-INF/views/admin/detailAdmin.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改管理�?
	 * @param request
	 * @param response
	 */
	private void updateAdmin(HttpServletRequest request, HttpServletResponse response) {
    	String adminId = request.getParameter("adminId");
    	String username = request.getParameter("username");
    	String pwd = request.getParameter("pwd");
    	Admin admin = new Admin();
    	admin.setId(Integer.parseInt(adminId));
    	admin.setUsername(username);
    	admin.setPassword(pwd);
    	 try {
 			service.updateAdmin(admin);
	    	request.setAttribute("adminDate", admin);
 		    request.getRequestDispatcher("/WEB-INF/views/admin/updateAdmin.jsp").forward(request, response);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}

		
	}

	/**
	 * 去修改管理员页面
	 * @param request
	 * @param response
	 */
	private void toUpdateAdmin(HttpServletRequest request, HttpServletResponse response) {
	    try {
	    	String id = request.getParameter("id");
			Admin admin = service.selectAdmin(id);
	    	request.setAttribute("adminDate", admin);
		    request.getRequestDispatcher("/WEB-INF/views/admin/updateAdmin.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
