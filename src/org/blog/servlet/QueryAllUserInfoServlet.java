package org.blog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;
import org.blog.Util.UserUtil;
import org.blog.entity.Login;
import org.blog.entity.UserInfo;

/**
 * Servlet implementation class QueryAllUserInfoServlet
 */
@WebServlet("/Servlet/QueryAllUserInfoServlet")
public class QueryAllUserInfoServlet extends HttpServlet {
	public static UserUtil userUtil = new UserUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = (String)request.getAttribute("msg");
		UserInfo userInfo = null;
		List<UserInfo> userInfos = null;
		
		if("error:you_are_not_allow_into".equals(msg)) 
			response.sendRedirect(request.getContextPath() + "/view/usermanager.jsp");
		else if("success:you_are_permit_into_have_all_power".equals(msg)) {
			userInfos = userUtil.queryAllUserInfos();
			request.setAttribute("UserInfos", userInfos); 
			
			request.getRequestDispatcher("/view/usermanager.jsp").forward(request, response);
		}else if("success:you_are_permit_into_have_normal_power".equals(msg)) {	
			int userid = ((Login)request.getSession().getAttribute("Login")).getUserid();
			userInfo = userUtil.queryUserById(userid);
			userInfos = new ArrayList<>();
			userInfos.add(userInfo);
			request.setAttribute("UserInfos", userInfos); 
			request.getRequestDispatcher("/view/usermanager.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/view/usermanager.jsp");
		}
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
