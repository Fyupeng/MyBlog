package org.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.UserUtil;
import org.blog.entity.UserInfo;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/Servlet/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	public static UserUtil userUtil = new UserUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		int sex = Integer.parseInt(request.getParameter("sex"));
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String motto = request.getParameter("motto");
		
		System.out.println("userid:" + userid +"sex:"+ sex +"password:"+ password +"nickname:"+ nickname +"motto:" + motto);
		
		
		userUtil.updateSexByUserid(userid, sex);
		userUtil.updatePwdByUserid(userid, password);
		userUtil.updateNicknameByUserid(userid, nickname);
		userUtil.updateMottoByUserid(userid, motto);
		
		UserInfo userInfo = userUtil.queryUserInfoByUsername("admin");
		String adminPwd = userInfo.getPassword();
		request.setAttribute("adminPwd", adminPwd);
		
		request.getRequestDispatcher("/Servlet/QueryAdminIdentityToUsermanagerServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
