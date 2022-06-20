package org.blog.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.blog.Util.RouteUtil;
import org.blog.Util.UserUtil;
import org.blog.entity.Login;
import org.blog.entity.UserInfo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		HttpSession session = request.getSession();
		
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		
		UserUtil userUtil = new UserUtil();
		
		boolean result = userUtil.queryUserIsExistByUser(username, password);
		
		if(result == true) {
			
			UserInfo userInfo = userUtil.queryUserInfoByUsername(username);
			
			login.setUserid(userInfo.getuserid());
			
			session.setAttribute("Login", login);
			//windows配置
//			String path = "D:\\study\\software\\eclipse\\workspace\\MyBlog\\WebContent\\picture\\" + String.valueOf(userInfo.getuserid()) ;
			//迁移到lunux
			String path = RouteUtil.FILE_SPACE + "/" + "myblog_data" + "/" + "picture" + "/" + String.valueOf(userInfo.getuserid());
			File file = new File(path);
			
			if(!file.exists()) {
				file.mkdirs();
			}
			
			
			response.sendRedirect(request.getContextPath() + "/view/index.jsp");
			System.out.println("LoginServlet:login存在允许登录");
			
		}else {
			System.out.println("LoginServlet:login不存在");
			request.setAttribute("msg", "loginError");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
