package org.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.Util.FriendUtil;
import org.blog.entity.Login;

/**
 * Servlet implementation class DeleFriendServlet
 */
@WebServlet("/Servlet/DeleteFriendServlet")
public class DeleteFriendServlet extends HttpServlet {
	public static FriendUtil friendUtil = new FriendUtil();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int friendid = Integer.parseInt(request.getParameter("friendid"));
		
		friendUtil.deleteFriendByFriendid(friendid);
		
		Login login = (Login) request.getSession().getAttribute("Login");
		System.out.println("DeleteFriendServlet:" + login.getUserid() + "删除了好友[id:" + friendid +"]");
		
		response.sendRedirect(request.getContextPath() + "/Servlet/QueryAllFriendsServlet");;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
