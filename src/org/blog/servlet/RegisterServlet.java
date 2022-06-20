package org.blog.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.UserUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	public static UserUtil userUtil = new UserUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("register_username");
		String password = request.getParameter("register_password1");
		int sex = Integer.parseInt(request.getParameter("register_sex"));
		String nickname = request.getParameter("register_nickname");
		String motto = request.getParameter("register_motto");
		
		
		boolean result = true;
		
		Random random = new Random();
		
		int rn;
		
		do {
			
			rn = random.nextInt(9000) + 1000;
			
			result = userUtil.queryUserIsExistById(rn);//false即id没有重复可以跳出循环保存进数据库
			
		}while(result == true);
		
		userUtil.addUserInfo(rn, username, password, sex, nickname, motto);
		
		System.out.println("id:" + rn + "已注册成功！");
		
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
