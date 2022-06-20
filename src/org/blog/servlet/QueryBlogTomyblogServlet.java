package org.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.BlogUtil;
import org.blog.Util.UserUtil;
import org.blog.entity.Blog;
import org.blog.entity.Login;
import org.blog.entity.UserInfo;

/**
 * Servlet implementation class ShowBlogMessageServlet
 */
@WebServlet("/Servlet/QueryBlogTomyblogServlet")
public class QueryBlogTomyblogServlet extends HttpServlet {
	public static BlogUtil blogUtil = new BlogUtil();
	public static UserUtil userUtil = new UserUtil();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Login login = (Login) request.getSession().getAttribute("Login");
		
		
		int userid = login.getUserid();
		List<Blog> blogs = blogUtil.queryBlogByUserid(userid);
		
		UserInfo userInfo = userUtil.queryUserInfoByUsername(login.getUsername());
		request.setAttribute("UserInfo", userInfo);
		
		
		request.setAttribute("Blog", blogs);
		
		
		request.getRequestDispatcher("/view/myblog.jsp").forward(request, response);
		
		
		
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
