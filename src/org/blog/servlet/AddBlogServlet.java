package org.blog.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.BlogUtil;
import org.blog.Util.UserUtil;
import org.blog.entity.Login;

/**
 * Servlet implementation class SaveBlogMessageServlet
 */
@WebServlet("/Servlet/AddBlogServlet")
public class AddBlogServlet extends HttpServlet {
	public static BlogUtil blogUtil = new BlogUtil();
	public static UserUtil userUtil = new UserUtil();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String headline = request.getParameter("textheadline");
		String content = request.getParameter("textcontent");
		
		
		
		if(headline != "" && content != "") {
			
			if(headline.length() >= 200) {
				System.out.println("文章标题内容过长");
				request.setAttribute("msg", "error:headline_is_longer_than_normal");
				request.getRequestDispatcher("/view/writeessay.jsp").forward(request, response);
			}else if(content.length() >= 4000) {
				System.out.println("正文内容过长");
				request.setAttribute("msg", "error:content_is_longer_than_normal");
				request.getRequestDispatcher("/view/writeessay.jsp").forward(request, response);
			}
			
			Login login = (Login)request.getSession().getAttribute("Login");
			
			int userid = 0;
			userid = login.getUserid();
			
			Random random = new Random();
			
			boolean result = true;
			int rn;
			
			do {
				
				rn = random.nextInt(9000) + 1000;
				
				result = blogUtil.queryBlogIsExistById(rn);//false即id没有重复可以跳出循环保存进数据库
				
				
			}while(result == true);
			
			Date date = new Date();
//			Calendar t = Calendar.getInstance();
//			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			blogUtil.addBlogWithoutUpdatedate(rn, userid, headline, content, date, 0);
			
			System.out.println("AddBlogServlet：文章保存成功！");
			
			response.sendRedirect(request.getContextPath() + "/Servlet/QueryBlogTomyblogServlet");
			
		}else {
			System.out.println("AddBlogServlet：文章保存失败！");
			request.setAttribute("msg", "error:5050_error");
			request.getRequestDispatcher("/view/writeessay.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
