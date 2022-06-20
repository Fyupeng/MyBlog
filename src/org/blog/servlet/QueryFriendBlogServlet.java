package org.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.BlogUtil;
import org.blog.entity.Blog;


/**
 * Servlet implementation class QueryFriendBlogServlet
 */
@WebServlet("/Servlet/QueryFriendBlogServlet")
public class QueryFriendBlogServlet extends HttpServlet {
	public static BlogUtil blogUtil = new BlogUtil();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int frienduserid = Integer.parseInt(request.getParameter("frienduserid")) ;
		
		List<Blog> friendblogs = blogUtil.queryBlogByUserid(frienduserid);
		
		request.setAttribute("FriendBlogs", friendblogs);
		
		request.getRequestDispatcher("/view/friendblog.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
