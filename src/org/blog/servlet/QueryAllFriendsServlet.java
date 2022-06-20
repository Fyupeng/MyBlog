package org.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.BlogUtil;
import org.blog.Util.FriendUtil;
import org.blog.Util.UserUtil;
import org.blog.entity.Blog;
import org.blog.entity.Friend;
import org.blog.entity.Login;
import org.blog.entity.UserInfo;

/**
 * Servlet implementation class QueryAllFriendsServlet
 */
@WebServlet("/Servlet/QueryAllFriendsServlet")
public class QueryAllFriendsServlet extends HttpServlet {
	FriendUtil friendUtil = new FriendUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Login login = (Login) request.getSession().getAttribute("Login");
		int userid = login.getUserid();
		List<Friend> friends =  friendUtil.queryAllFriendsByUserid(userid);
		
		request.setAttribute("Friends", friends);
		
		request.getRequestDispatcher("/view/friendsmanager.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
