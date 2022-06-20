package org.blog.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.BlogUtil;

/**
 * Servlet implementation class UpdateBlogServlet
 */
@WebServlet("/Servlet/UpdateBlogServlet")
public class UpdateBlogServlet extends HttpServlet {
	private static BlogUtil blogUtil = new BlogUtil();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int blogid = Integer.parseInt(request.getParameter("blogid"));
		String headline = request.getParameter("headline");
		String content = request.getParameter("content");
		blogUtil.updateBlogByBlogidWithoutcontent(blogid, headline);
		blogUtil.updateBlogByBlogidWithoutHeadline(blogid, content);
		
		Date date = new Date();
		
		blogUtil.updateBlogByBlogidWithUpdatedate(blogid, date);
		
		response.sendRedirect(request.getContextPath() + "/Servlet/QueryBlogToblogmanagerServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
