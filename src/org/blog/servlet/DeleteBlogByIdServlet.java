package org.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.BlogUtil;

/**
 * Servlet implementation class DeleteBlogByIdServlet
 */
@WebServlet("/Servlet/DeleteBlogByIdServlet")
public class DeleteBlogByIdServlet extends HttpServlet {
	public static BlogUtil blogUtil = new BlogUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int blogid = Integer.parseInt(request.getParameter("blogid")) ;
		
		blogUtil.deleteBlogByBlogid(blogid);
		
		request.getRequestDispatcher("/Servlet/QueryAllRemarksServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
