package org.blog.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.FeedBackUtil;

/**
 * Servlet implementation class QueryAllFeedBacksServlet
 */
@WebServlet("/AddFeedBackServlet")
public class AddFeedBackServlet extends HttpServlet {
	public static FeedBackUtil faceBackUtil = new FeedBackUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		
		Random random = new Random();
		
		boolean result = true;
		int rn;
		
		do {
			
			rn = random.nextInt(9000) + 1000;
			
			result = faceBackUtil.queryFeedBackIsExistById(rn);//false即id没有重复可以跳出循环保存进数据库
			
			
		}while(result == true);
		
		faceBackUtil.addFeedBack(rn, message);
		request.setAttribute("msg", "msg:thank_you_for_faceback");
		
		request.getRequestDispatcher("/feedback.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
