package org.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.UserUtil;
import org.blog.entity.UserInfo;

/**
 * Servlet implementation class QueryUserServlet
 */
@WebServlet("/Servlet/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	public static UserUtil userUtil = new UserUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		UserInfo userInfo = userUtil.queryUserById(userid);
		request.setAttribute("UserInfo", userInfo); 
		
		request.getRequestDispatcher("/view/userinfo.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
