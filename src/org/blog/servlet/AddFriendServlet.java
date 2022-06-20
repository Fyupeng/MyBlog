package org.blog.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.FriendUtil;
import org.blog.entity.Login;

/**
 * Servlet implementation class AddFriendServlet
 */
@WebServlet("/Servlet/AddFriendServlet")
public class AddFriendServlet extends HttpServlet {
	public static FriendUtil friendUtil = new FriendUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random random = new Random();
		
		boolean result = true;
		int rn;
		
		do {
			
			rn = random.nextInt(900000) + 100000;
			
			result = friendUtil.queryFriendIsExistById(rn);//false即id没有重复可以跳出循环保存进数据库
			
			
		}while(result == true);
		
		
		int frienduserid = Integer.parseInt(request.getParameter("frienduserid")) ;
		String friendusername = request.getParameter("friendusername");
		int friendsex = Integer.parseInt(request.getParameter("friendsex")) ;
		String friendnickname = request.getParameter("friendnickname");
		String friendmotto = request.getParameter("friendmotto");
		int userid = Integer.parseInt(request.getParameter("userid")) ;
		
		Login login = (Login) request.getSession().getAttribute("Login");
		System.out.println("AddFriendServlet:" + login.getUserid() + "添加" + frienduserid + "为好友");
		
		friendUtil.addFriendByUserid(rn, frienduserid, friendusername, friendsex, friendnickname, friendmotto, userid);
		
		request.getRequestDispatcher("/Servlet/QueryAllFriendsServlet").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
