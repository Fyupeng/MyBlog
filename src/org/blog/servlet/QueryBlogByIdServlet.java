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
 * Servlet implementation class BlogInfoServlet
 */
@WebServlet("/Servlet/QueryBlogByIdServlet")
public class QueryBlogByIdServlet extends HttpServlet {
	public static BlogUtil blogUtil = new BlogUtil();
	public static UserUtil userUtil = new UserUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int blogid = Integer.parseInt(request.getParameter("blogid"));
		Blog blog = blogUtil.queryBlogById(blogid);
		
		request.setAttribute("Blog", blog);
		
		request.getRequestDispatcher("/view/bloginfo.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
