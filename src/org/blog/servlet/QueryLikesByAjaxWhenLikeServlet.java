package org.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.BlogUtil;
import org.blog.entity.Blog;
import org.blog.entity.Login;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class QueryFriendLikesByAjaxServlet
 */
@WebServlet("/Servlet/QueryLikesByAjaxWhenLikeServlet")
public class QueryLikesByAjaxWhenLikeServlet extends HttpServlet {
       public static BlogUtil blogUtil = new BlogUtil();	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int blogid = Integer.parseInt(request.getParameter("blogid")) ;
		
		System.out.println(blogid);
		
		PrintWriter out = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		
		blogUtil.updateBlogByBlogidForLikes(blogid);
		Blog blog = blogUtil.queryBlogById(blogid);
		
		jsonObject.put("Likes", blog.getLikes());
		
		out.print(jsonObject);
		out.flush();
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
