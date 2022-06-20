package org.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.UserUtil;
import org.blog.entity.Login;
import org.blog.entity.UserInfo;

/**
 * Servlet implementation class QueryAdminIdentityToRemarkmanagerServlet
 */
@WebServlet("/Servlet/QueryAdminIdentityToRemarkmanagerServlet")
public class QueryAdminIdentityToRemarkmanagerServlet extends HttpServlet {
	public static UserUtil userUtil = new UserUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminPwd1 = request.getParameter("adminPwd");//从页面usermanager.jsp获取
		String adminPwd2 = (String)request.getAttribute("adminPwd");//从控制器UpdateUpserServlet
		String adminPwd3 = ((Login) request.getSession().getAttribute("Login")).getPassword();
		
		UserInfo userInfo = userUtil.queryUserInfoByUsername("admin");
		
		if(userInfo.getPassword().equals(adminPwd1) || userInfo.getPassword().equals(adminPwd2) || userInfo.getPassword().equals(adminPwd3)) {
			request.setAttribute("msg", "success:you_are_permit_into_have_all_power");
			request.getRequestDispatcher("/Servlet/QueryAllRemarksServlet").forward(request, response);
		}else if(adminPwd1.equals(adminPwd3)) {
			request.setAttribute("msg", "success:you_are_permit_into_have_normal_power");
			request.getRequestDispatcher("/Servlet/QueryAllRemarksServlet").forward(request, response);
		}else {
			request.setAttribute("msg", "error:you_are_not_allow_into");
			request.getRequestDispatcher("/Servlet/QueryAllRemarksServlet").forward(request, response);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
